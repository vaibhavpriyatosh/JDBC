package command;

import profile.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.product.connection.*;

//import com.product.connection.*;

//import com.product.connection.CP;

public class commands {
	
	public static boolean update_password(String position,String password,int id) {
		
		boolean f=false;
		try {
			
			Connection con=CP.createC();
			String q="update "+position+" set password='"+password+"' where id="+id+"";
			
			//Prepare_Statement
			
			PreparedStatement pstmt=con.prepareStatement(q);

			//execute
			pstmt.executeUpdate();
			f=true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public static boolean update_pepole(Employee emp) {
		
		System.out.println();
		
		boolean f=false;
		try {
			
			Connection con=CP.createC();
			String q="insert into "+emp.getPosition()+"(name,password,rid) values('"+emp.getName()+"',"+emp.getPassword()+","+emp.getRid()+")";
			
			
			//Prepare_Statement
			
			PreparedStatement pstmt=con.prepareStatement(q);
			
			//execute
			pstmt.executeUpdate();
			
			System.out.println("--------------");
			
			String t="SELECT * FROM "+emp.getPosition()+" WHERE id=(SELECT max(id) FROM "+emp.getPosition()+");";
			con=CP.createC();
			Statement stmt=con.createStatement();
			
			ResultSet set=stmt.executeQuery(t);
			while(set.next()) {
				System.out.println("Your id is : "+set.getInt(1));
				
			}
			
			f=true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public static boolean delete_pepole(Employee emp,int id) {
		
		boolean f=false;
		try {
			
			Connection con=CP.createC();
			String q="delete from "+emp.getPosition()+" where id="+id+"";
			
			
			//Prepare_Statement
			
			PreparedStatement pstmt=con.prepareStatement(q);
			
			//set values of parameter
//			pstmt.setInt(1, sId);
			
			//execute
			pstmt.executeUpdate();
			f=true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}

	public static void show_table(Employee emp) {

//		boolean f=false;
		try {
			
			Connection con=CP.createC();
//			String q="select "+emp.getPosition()+".name,"+head+".name from "+emp.getPosition()+","+head+" where "+emp.getPosition()+".rid="+head+".id;";
			String q="select * from "+emp.getPosition()+"";
			
			Statement stmt=con.createStatement();
			
			ResultSet set=stmt.executeQuery(q);
			
			System.out.println("All the details are : ");
			while(set.next()) {
				int id=set.getInt(1);
				String name=set.getString(2);
//				String header=set.getString(3);//rid
				
				System.out.print("Id is "+id+" Manager's name "+name);
//				break;
//				System.out.println("--------------------");
			}


//			f=true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
//		return true;
		
	}

	public static boolean matching_pepole(String str,int id,String password) {
		
		boolean b=false;
		
		Connection con;
		
		try {
			con=CP.createC();
			String q="select * from "+str+" where id="+id+";";
			
			Statement stmt=con.createStatement();
			
			ResultSet set=stmt.executeQuery(q);
			String pass="";
			
			while(set.next()) {
				pass=set.getString("password");
			}
			
			b= pass.compareTo(password)==0;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return b;
		
	}
}


















