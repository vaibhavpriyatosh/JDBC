package front;
import java.io.*;
import java.util.*;
//import profile.*;
import com.product.connection.check_password;

import product_manipulation.production;


public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		System.out.println("*******************************************");
		System.out.println("*    Welcome To The Project Managment App   *");
		System.out.println("* Please Select profile from below to login *");
		System.out.println("*  1 Login Admin !                          *");
		System.out.println("*  2 Login Manager !                        *");
		System.out.println("*  3 Login Shopkeeper !                     *");
		System.out.println("*  4 testing                                *");
		System.out.println("*******************************************");
		
		int choice=Integer.parseInt(br.readLine());
		
		if(choice==4) {
			
			//testing
			
			System.out.println(Arrays.toString(production.get(1)));
			//ending
			return;
			
		}
		
		System.out.print("Enter your Id - ");
		int id=Integer.parseInt(br.readLine());
		
		System.out.println();
		
		System.out.print("Enter your password - ");
		String password=br.readLine();
		
		System.out.println("-------------------------------------------");
		System.out.println("");
		
		check_password.password_matching(choice,id,password);
		
		br.close();
		
		
	}

}





















