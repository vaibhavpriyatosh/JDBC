package profile;

public class shopkeeper extends Employee{

	public shopkeeper(String name,String password,int rid) {
		setName(name);
		setRid(rid);
		setPassword(password);
		setPosition("shopkeeper");
	}

	public shopkeeper() {
//		super();
		setPosition("shopkeeper");
	}
	
}

