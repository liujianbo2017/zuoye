package cn.itcast.estore.service.impl;

import cn.itcast.estore.domain.Cart;
import cn.itcast.estore.domain.CartItem;
import cn.itcast.estore.service.BaseService;
import cn.itcast.estore.service.CartService;

public class CartServiceImpl extends BaseService implements CartService {

	//把传入的商品和数量封装进CartItem,加入到购物车逻辑
	@Override
	public Cart add(Cart cart, String pid, int count) {
		try {
			//把传入的pid和count封装成购物项对象
			CartItem cartItem = new CartItem();
			cartItem.setCount(count);
			cartItem.setProduct(productDao.get(pid));
			
			//把CartItem保存进购物车
			if(cart == null){
				cart = new Cart();
			}
			//调用购物车对象自身的add方法将购物项对象保存到购物车中(没有则添加,有则累加)
			cart.add(cartItem);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cart;
	}

	//从购物车中删除商品
	@Override
	public void remove(Cart cart, String pid) {
		cart.remove(pid);
	}

}
