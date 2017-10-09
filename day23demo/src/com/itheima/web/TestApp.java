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
			System.out.println("请输入以下命令");
			System.out.println("C:创建、U:修改、 D:删除 、 DA:删除所有 、 QI:根据ID查询 、 FA:查询所有 、 Q:退出");
			// 创建用户接受菜单的输入
			String choose = sc.nextLine();
			switch (choose.toUpperCase()) {
			case "C":
				System.out.println("选择创建功能");
				addProducts();
				break;
			case "U":
				System.out.println("选择修改功能");
				editProducts();
				break;
			case "D":
				System.out.println("选择删除功能");
				delete();
				break;
			case "DA":
				System.out.println("选择删除所有功能");
				deleteAll();
				break;
			case "QI":
				System.out.println("选择根据ID查询");
				findById();
				break;
			case "FA":
				System.out.println("选择查询所有功能");
				findAll();
				break;
			case "Q":
				System.exit(0);
			default:
				System.out.println("无此项功能");
			}
		}
	}

	/*
	 * 方法deleteAll, 批量删除 调用业务层方法,传递输入的所有id值
	 */
	public static void deleteAll() {
		Scanner sc = new Scanner(System.in);
		findAll();
		List<Integer> deleteId = new ArrayList<Integer>();
		ProductService service = new ProductService();
		System.out.println("请输入要删除的id值,以-1结束");
		while (true) {
			int pid = Integer.parseInt(sc.nextLine());
			if (pid == -1) {
				break;
			}
			List<Products> list = service.findById(pid);
			if (list.size() == 0) {
				System.out.println("没有此数据");
			} else {
				deleteId.add(pid);
				printProducts(list);
			}
		}
		if (deleteId.size() == 0) {
			System.out.println("没有可以删除的数据啦");
		}
		System.out.println("确定删除这" + deleteId.size() + "个数据吗 y/n");
		String confirm = sc.nextLine();
		if ("y".equalsIgnoreCase(confirm)) {
			service.deleteAll(deleteId);
			System.out.println("删除数据成功");
			findAll();
		}
	}

	/*
	 * 方法delete ,id删除功能 调用业务层,传递输入的id
	 */
	public static void delete() {
		Scanner sc = new Scanner(System.in);
		findAll();
		System.out.println("请输入你要删除商品的ID");
		int pid = Integer.parseInt(sc.nextLine());
		ProductService service = new ProductService();
		List<Products> list = service.findById(pid);
		if (list.size() == 0) {
			System.out.println("没有此商品");
			return;
		}
		printProducts(list);
		System.out.println("真的要删除吗y/n" + pid);
		String confirm = sc.nextLine();
		if ("y".equalsIgnoreCase(confirm)) {
			service.delete(pid);
			findAll();
		}
	}

	/*
	 * 方法editProduct 修改商品信息方法 调用业务层,传递Products对象 先输入商品的编号,查询此商品 输入其他的数据
	 */
	public static void editProducts() {
		Scanner sc = new Scanner(System.in);
		findAll();
		System.out.println("请输入你要修改商品的ID");
		int pid = Integer.parseInt(sc.nextLine());
		ProductService service = new ProductService();
		List<Products> list = service.findById(pid);
		if (list.size() == 0) {
			System.out.println("没有此商品");
			return;
		}
		printProducts(list);
		System.out.println("请输入新的商品名称");
		String pname = sc.nextLine();
		System.out.println("请输入新的商品价格");
		int price = Integer.parseInt(sc.nextLine());
		System.out.println("请输入是否上架 1是上架,0是下架");
		String flag = sc.nextLine();
		// 请输入商品的分类
		System.out.println("请新的输入分类");
		String category_id = sc.nextLine();
		Products p = new Products(0, pname, price, flag, category_id);
		service.editProducts(p);
		System.out.println("修改数据成功 ");
		findById();
	}

	/*
	 * 定义方法,实现创建功能,名字addProducts 调用业务层addProducts方法回去查询结果
	 */
	public static void addProducts() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入商品名称");
		String pname = sc.nextLine();
		System.out.println("请输入商品价格");
		int price = Integer.parseInt(sc.nextLine());
		System.out.println("请输入是否上架 1是上架,0是下架");
		String flag = sc.nextLine();
		// 请输入商品的分类
		System.out.println("请输入分类");
		String category_id = sc.nextLine();
		Products p = new Products(0, pname, price, flag, category_id);
		ProductService service = new ProductService();
		service.addProducts(p);
		System.out.println("添加数据成功 ");
		findAll();
	}

	/*
	 * 定义方法,实现通过ID查询数据,名字find 调用业务层find方法获取查询结果
	 */
	public static void findById() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入你要查询商品的ID");
		int pid = sc.nextInt();
		ProductService service = new ProductService();
		List<Products> list = service.findById(pid);
		printProducts(list);
	}

	/*
	 * 定义方法,实现查询所有数据 名字findAll, 调用业务层findAll方法获取查询结果 返回list集合,存储到JavaBean
	 */
	public static void findAll() {
		ProductService service = new ProductService();
		List<Products> list = service.findAll();
		printProducts(list);
	}

	/*
	 * 创建方法,遍历集合 传递参数
	 */
	public static void printProducts(List<Products> list) {
		if (list.size() == 0) {
			System.out.println("没有查询到数据");
			return;
		}
		for (Products p : list) {
			System.out.println(p);
		}
		System.out.println();
	}

}
