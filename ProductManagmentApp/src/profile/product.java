package profile;

public class product {

	private int id;
	private String product_name;
	private int rid;
	private int price;
	private int quantity;
	
	public product(int id, String product_name, int rid, int price, int quantity) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.rid = rid;
		this.price = price;
		this.quantity = quantity;
	}

	public product(String product_name, int rid, int price, int quantity) {
		super();
		this.product_name = product_name;
		this.rid = rid;
		this.price = price;
		this.quantity = quantity;
	}

	public product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "product [id=" + id + ", product_name=" + product_name + ", rid=" + rid + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}
	
	
	
}
