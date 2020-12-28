package Pojo.Response;

import java.util.List;

public class Boq {
	
	private List<Groups> Groups;
	private Status status;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Groups> getGroups() {
		return Groups;
	}
	public void setGroups(List<Groups> Groups) {
		this.Groups = Groups;
	}


}
