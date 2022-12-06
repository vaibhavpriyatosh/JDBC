package profile;

public class Employee {
	
//	private Employee() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

	private int id;
	private String name;
	private int rid;
	private String password;
	private String position;
	
	public String getName() {
		return name;
	}

	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", rid=" + rid + ", password=" + password + "]";
	}	
	
}
//class manager extends Employee{
//
//	public manager(String name,int rid,String password) {
//		setName(name);
//		setRid(rid);
//		setPassword(password);
//		// TODO Auto-generated constructor stub
//	}
//	
//}
