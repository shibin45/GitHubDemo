package Pojo.Response;

public class Status {
	
	private int status_code;
	private String status_message;
	private String status_type;
	private String total_count;
	
	public int getstatus_code() {
		return status_code;
	}
	public void setstatus_code(int status_code) {
		this.status_code = status_code;
	}
	public String getstatus_message() {
		return status_message;
	}
	public void setstatus_message(String status_message) {
		this.status_message = status_message;
	}
	public String getStatus_type() {
		return status_type;
	}
	public void setStatus_type(String status_type) {
		this.status_type = status_type;
	}
	public String getTotal_count() {
		return total_count;
	}
	public void setTotal_count(String total_count) {
		this.total_count = total_count;
	}
	
	

}