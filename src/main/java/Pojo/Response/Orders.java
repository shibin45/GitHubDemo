package Pojo.Response;

import Pojo.Response.Boq_items;

import java.util.List;

public class Orders {
	
	private String order_type;
	private List<Boq_items> boq_items;
	public String getOrder_type() {
		return order_type;
	}
	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}
	public List<Boq_items> getBoq_items() {
		return boq_items;
	}
	public void setBoq_items(List<Boq_items> boq_items) {
		this.boq_items = boq_items;
	}
	

}
