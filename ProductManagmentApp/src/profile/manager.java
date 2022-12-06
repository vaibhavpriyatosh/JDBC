package profile;

public class manager extends Employee {
	
	public manager(String name,String password,int rid) {
		setName(name);
		setRid(rid);
		setPassword(password);
		setPosition("manager");
	}

	public manager() {
//		super();

		setPosition("manager");
	}
}
