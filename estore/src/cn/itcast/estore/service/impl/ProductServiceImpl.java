package cn.itcast.estore.service.impl;

import java.util.List;

import cn.itcast.estore.domain.PageBean;
import cn.itcast.estore.domain.Product;
import cn.itcast.estore.service.BaseService;
import cn.itcast.estore.service.ProductService;

public class ProductServiceImpl extends BaseService implements ProductService {

	@Override
	public List<Product> findHots() {
		List<Product> list = null;
		try {
			list = productDao.findHots();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Product> findNews() {
		List<Product> list = null;
		try {
			list = productDao.findNews();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Product get(String pid) {
		Product product = null;
		try {
			product = productDao.get(pid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}

	//根据指定的商品ID和页号页大小得到相关信息并封装到PageBean对象
	@Override
	public PageBean<Product> findByCategoryByPage(String cid, int pageNum, int pageSize) {

		PageBean<Product> bean = new PageBean<Product>();
		
		bean.setPageNum(pageNum);
		bean.setPageSize(pageSize);
		
		//调用Dao层方法
		try {
			List<Product> list = productDao.findByCategoryByPage(cid, bean.getStartIndex(), pageSize);
			long count = productDao.getCountByCategory(cid);
			
			//封装进pageBean中
			bean.setData(list);
			bean.setRecordCount(count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}

}
