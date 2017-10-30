package cn.itcast.day43.demo01.service.impl;

import java.util.List;

import cn.itcast.day43.demo01.dao.ProductDao;
import cn.itcast.day43.demo01.dao.impl.ProductDaoImpl;
import cn.itcast.day43.demo01.domain.PageBean;
import cn.itcast.day43.demo01.domain.Product;
import cn.itcast.day43.demo01.service.ProductService;

public class ProductServiceImpl implements ProductService {

	private ProductDao productDao = new ProductDaoImpl();
	
	//获得指定页数据并封装成PageBean对象
	@Override
	public PageBean<Product> findByPage(int pageNum, int pageSize) {
		PageBean<Product> pageBean = new PageBean<Product>();
		
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		
		//调用Dao层方法,得到本页数据和总条数
		try {
			long count = productDao.getCount();
			List<Product> list = productDao.findByPage(pageBean.getStartIndex(), pageSize);
			
			//封装到pageBean中
			pageBean.setRecordCount(count);
			pageBean.setData(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageBean;
	}

	//根据条件查询商品的业务逻辑方法
	@Override
	public List<Product> findAllCondition(Product condition) {
		List<Product> list = null;
		try {
			list = productDao.findByCondition(condition);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
