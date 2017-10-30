package cn.itcast.estore.domain;

import java.util.HashMap;
import java.util.Map;

//购物车信息的JavaBean
public class Cart {

	private Map<String,CartItem> items = new HashMap<String,CartItem>();   //购物商品
	private double total;   //总计
	
	//添加购物项到购物车中(相同的商品添加到购物车时,数量累加)
	public void add(CartItem item){
		String key = item.getProduct().getPid();
		
		if(items.containsKey(key)){
			//已存在
			int c = items.get(key).getCount();//先得到原有数量
			items.get(key).setCount(c + item.getCount());//把Map中的当前购物项数量累加(原有的数量加上添加的数量)
		}else{
			//不存在
			items.put(key, item);
		}
	}
	
	//删除购物项
	public void remove(String pid){
		//根据商品ID删除Map中的指定购物项
		items.remove(pid);
	}
	
	//清空购物车
	public void clear(){
		//清空Map集合
		items.clear();
	}
	public Map<String, CartItem> getItems() {
		return items;
	}
	public void setItems(Map<String, CartItem> items) {
		this.items = items;
	}
	public double getTotal() {
		//先把总计属性值置为0
		this.total = 0;
		//遍历所有的购物项,累加每个购物项的小计,得到总计
		for (String pid : items.keySet()) {
			this.total += items.get(pid).getSubtotal();
		}
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
