package com.itheima.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.itheima.domain.Products;
import com.itheima.service.ProductService;

public class TestApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("��������������");
			System.out.println("C:������U:�޸ġ� D:ɾ�� �� DA:ɾ������ �� QI:����ID��ѯ �� FA:��ѯ���� �� Q:�˳�");
			// �����û����ܲ˵�������
			String choose = sc.nextLine();
			switch (choose.toUpperCase()) {
			case "C":
				System.out.println("ѡ�񴴽�����");
				addProducts();
				break;
			case "U":
				System.out.println("ѡ���޸Ĺ���");
				editProducts();
				break;
			case "D":
				System.out.println("ѡ��ɾ������");
				delete();
				break;
			case "DA":
				System.out.println("ѡ��ɾ�����й���");
				deleteAll();
				break;
			case "QI":
				System.out.println("ѡ�����ID��ѯ");
				findById();
				break;
			case "FA":
				System.out.println("ѡ���ѯ���й���");
				findAll();
				break;
			case "Q":
				System.exit(0);
			default:
				System.out.println("�޴����");
			}
		}
	}

	/*
	 * ����deleteAll, ����ɾ�� ����ҵ��㷽��,�������������idֵ
	 */
	public static void deleteAll() {
		Scanner sc = new Scanner(System.in);
		findAll();
		List<Integer> deleteId = new ArrayList<Integer>();
		ProductService service = new ProductService();
		System.out.println("������Ҫɾ����idֵ,��-1����");
		while (true) {
			int pid = Integer.parseInt(sc.nextLine());
			if (pid == -1) {
				break;
			}
			List<Products> list = service.findById(pid);
			if (list.size() == 0) {
				System.out.println("û�д�����");
			} else {
				deleteId.add(pid);
				printProducts(list);
			}
		}
		if (deleteId.size() == 0) {
			System.out.println("û�п���ɾ����������");
		}
		System.out.println("ȷ��ɾ����" + deleteId.size() + "�������� y/n");
		String confirm = sc.nextLine();
		if ("y".equalsIgnoreCase(confirm)) {
			service.deleteAll(deleteId);
			System.out.println("ɾ�����ݳɹ�");
			findAll();
		}
	}

	/*
	 * ����delete ,idɾ������ ����ҵ���,���������id
	 */
	public static void delete() {
		Scanner sc = new Scanner(System.in);
		findAll();
		System.out.println("��������Ҫɾ����Ʒ��ID");
		int pid = Integer.parseInt(sc.nextLine());
		ProductService service = new ProductService();
		List<Products> list = service.findById(pid);
		if (list.size() == 0) {
			System.out.println("û�д���Ʒ");
			return;
		}
		printProducts(list);
		System.out.println("���Ҫɾ����y/n" + pid);
		String confirm = sc.nextLine();
		if ("y".equalsIgnoreCase(confirm)) {
			service.delete(pid);
			findAll();
		}
	}

	/*
	 * ����editProduct �޸���Ʒ��Ϣ���� ����ҵ���,����Products���� ��������Ʒ�ı��,��ѯ����Ʒ ��������������
	 */
	public static void editProducts() {
		Scanner sc = new Scanner(System.in);
		findAll();
		System.out.println("��������Ҫ�޸���Ʒ��ID");
		int pid = Integer.parseInt(sc.nextLine());
		ProductService service = new ProductService();
		List<Products> list = service.findById(pid);
		if (list.size() == 0) {
			System.out.println("û�д���Ʒ");
			return;
		}
		printProducts(list);
		System.out.println("�������µ���Ʒ����");
		String pname = sc.nextLine();
		System.out.println("�������µ���Ʒ�۸�");
		int price = Integer.parseInt(sc.nextLine());
		System.out.println("�������Ƿ��ϼ� 1���ϼ�,0���¼�");
		String flag = sc.nextLine();
		// ��������Ʒ�ķ���
		System.out.println("���µ��������");
		String category_id = sc.nextLine();
		Products p = new Products(0, pname, price, flag, category_id);
		service.editProducts(p);
		System.out.println("�޸����ݳɹ� ");
		findById();
	}

	/*
	 * ���巽��,ʵ�ִ�������,����addProducts ����ҵ���addProducts������ȥ��ѯ���
	 */
	public static void addProducts() {
		Scanner sc = new Scanner(System.in);
		System.out.println("��������Ʒ����");
		String pname = sc.nextLine();
		System.out.println("��������Ʒ�۸�");
		int price = Integer.parseInt(sc.nextLine());
		System.out.println("�������Ƿ��ϼ� 1���ϼ�,0���¼�");
		String flag = sc.nextLine();
		// ��������Ʒ�ķ���
		System.out.println("���������");
		String category_id = sc.nextLine();
		Products p = new Products(0, pname, price, flag, category_id);
		ProductService service = new ProductService();
		service.addProducts(p);
		System.out.println("������ݳɹ� ");
		findAll();
	}

	/*
	 * ���巽��,ʵ��ͨ��ID��ѯ����,����find ����ҵ���find������ȡ��ѯ���
	 */
	public static void findById() {
		Scanner sc = new Scanner(System.in);
		System.out.println("��������Ҫ��ѯ��Ʒ��ID");
		int pid = sc.nextInt();
		ProductService service = new ProductService();
		List<Products> list = service.findById(pid);
		printProducts(list);
	}

	/*
	 * ���巽��,ʵ�ֲ�ѯ�������� ����findAll, ����ҵ���findAll������ȡ��ѯ��� ����list����,�洢��JavaBean
	 */
	public static void findAll() {
		ProductService service = new ProductService();
		List<Products> list = service.findAll();
		printProducts(list);
	}

	/*
	 * ��������,�������� ���ݲ���
	 */
	public static void printProducts(List<Products> list) {
		if (list.size() == 0) {
			System.out.println("û�в�ѯ������");
			return;
		}
		for (Products p : list) {
			System.out.println(p);
		}
		System.out.println();
	}

}
