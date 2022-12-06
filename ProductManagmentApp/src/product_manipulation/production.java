package product_manipulation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.product.connection.CP;
import java.util.*;

import profile.product;
import java.util.*;

public class production {

	public static void entry(int id) {
			
		
			System.out.println();
			
			Scanner sc=new Scanner(System.in);
			
			System.out.println();
			
			System.out.print("Enter the name of product - ");
			String name=sc.nextLine();
			System.out.println();
			

			System.out.print("Enter the price of product - ");
			int price=sc.nextInt();
			System.out.println();
			

			System.out.print("Enter the name of quantity - ");
			int quantity=sc.nextInt();
			System.out.println();
			
			product pt=new product(name,id,price,quantity);
			
			try {
				
				Connection con=CP.createC();
				String q="insert into product(product_name,rid,price,quantity) values('"+pt.getProduct_name()+"',"+id+","+pt.getPrice()+","+pt.getQuantity()+")";
				
				
				//Prepare_Statement
				
				PreparedStatement pstmt=con.prepareStatement(q);
				
				//execute
				pstmt.executeUpdate();
				
				System.out.println("--------------");
				
				String t="SELECT * FROM product WHERE id=(SELECT max(id) FROM product);";
				con=CP.createC();
				Statement stmt=con.createStatement();
				
				ResultSet set=stmt.executeQuery(t);
				while(set.next()) {
					System.out.println("Your id is : "+set.getInt(1));
					
				}
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
//			return f;
		
			sc.close();
		
		
	}

	public static void details() {

//		boolean f=false;
		try {
			
			Connection con=CP.createC();
//			String q="select "+emp.getPosition()+".name,"+head+".name from "+emp.getPosition()+","+head+" where "+emp.getPosition()+".rid="+head+".id;";
			String q="select * from product";
			
			Statement stmt=con.createStatement();
			
			ResultSet set=stmt.executeQuery(q);
			
			System.out.println("All the details are : ");
			while(set.next()) {
				int id=set.getInt(1);
				String product_name=set.getString(2);
				int price=set.getInt(4);
				int quantity=set.getInt(5);
//				String header=set.getString(3);//rid
				
				System.out.println("Id is "+id+" Product name "+product_name+" price - "+price+" Quantity - "+quantity );
//				break;
//				System.out.println("--------------------");
			}


//			f=true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
//		return true;
		
	}

	public static void update(int id,int quantity) {


		try {
			
			Connection con=CP.createC();
			String q="update product set quantity='"+quantity+"' where id="+id+"";
			
			//Prepare_Statement
			
			PreparedStatement pstmt=con.prepareStatement(q);

			//execute
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public static int[] get(int id) {
		
		int arr[]=new int[2];
		//0 index price
		//1 index quantity
		
		try {
			
				Connection con=CP.createC();
	//			String q="select "+emp.getPosition()+".name,"+head+".name from "+emp.getPosition()+","+head+" where "+emp.getPosition()+".rid="+head+".id;";
				String q="select * from product where id="+id;
				
				Statement stmt=con.createStatement();
				
				ResultSet set=stmt.executeQuery(q);
				
				System.out.println("All the details are : ");
				while(set.next()) {
					int price=set.getInt(4);
					int quantity=set.getInt(5);
	//				String header=set.getString(3);//rid
					
					arr[0]=price;
					arr[1]=quantity;
					
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		
		return arr;
		
	}

	public static void billing() {
		
		System.out.println("Press Enter to continue and any thing to see the total.");
		
		Scanner sc=new Scanner(System.in);
		
		HashMap<Integer,Integer> map=new HashMap<>();
		int sum=0;
		
		while(true) {
			
			String ch=sc.nextLine();
			
			if(ch.length()!=0)break;
			
			updated_details(map);

			System.out.print("Enter id - ");
			int id=sc.nextInt();
			System.out.println();
			
			System.out.print("Enter quantity - ");
			int quantity=sc.nextInt();
			System.out.println();
			
			
			int arr[]=get(id);
			
			if(arr[1]<quantity) {
				System.out.println("Quantity Entered less than availability");
				continue;
			}

			map.put(id, map.getOrDefault(id, arr[1])-quantity);
			
			sum+=arr[0]*quantity;
			sc.nextLine();
		}
		
		for(int key:map.keySet())
			update(key,map.get(key));
		
		
		System.out.print("Total sum is - "+sum);
		
	}
	
	public static void updated_details(HashMap<Integer,Integer> map) {
		
try {
			
			Connection con=CP.createC();
//			String q="select "+emp.getPosition()+".name,"+head+".name from "+emp.getPosition()+","+head+" where "+emp.getPosition()+".rid="+head+".id;";
			String q="select * from product";
			
			Statement stmt=con.createStatement();
			
			ResultSet set=stmt.executeQuery(q);
			
			System.out.println("All the details are : ");
			while(set.next()) {
				int id=set.getInt(1);
				String product_name=set.getString(2);
				int price=set.getInt(4);
				int quantity=set.getInt(5);
//				String header=set.getString(3);//rid
				
				if(map.containsKey(id))quantity=map.get(id);
				
				
				System.out.println("Id is "+id+" Product name "+product_name+" price - "+price+" Quantity - "+quantity );
//				break;
//				System.out.println("--------------------");
			}


//			f=true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	