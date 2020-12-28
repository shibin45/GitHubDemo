package Pojo.Response;

import java.util.List;

public class Groups {
	
	private String md5_hash;
	private String group_id;
	private int handling_fee_percentage;
	private List<Orders> Orders;


	public int getHandling_fee_percentage() {
		return handling_fee_percentage;
	}

	public void setHandling_fee_percentage(int handling_fee_percentage) {
		this.handling_fee_percentage = handling_fee_percentage;
	}
	public String getMd5_hash() {
		return md5_hash;
	}
	public void setMd5_hash(String md5_hash) {
		this.md5_hash = md5_hash;
	}
	public String getGroup_id() {
		return group_id;
	}
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	public List<Orders> getOrders() {
		return Orders;
	}
	public void setOrders(List<Orders> orders) {
		this.Orders = orders;
	}
	
	
	

}
