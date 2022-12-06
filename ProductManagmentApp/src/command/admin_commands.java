package command;

import java.util.*;

import product_manipulation.production;
import profile.*;

public class admin_commands {

	public static void display(int id) {
		
		System.out.println("Choose from the following options");
		System.out.println("1 Update your password");
		System.out.println("2 Enter a new Manager");
		System.out.println("3 Show All the Managers");
		System.out.println("4 Delete Manager");
		System.out.println("5 Show All the Shopkeeper");
		System.out.println("6 Delete Shopkeeper");
		System.out.println("7 Enter product details");
		System.out.println("8 Show all the product details");
		System.out.println("9 Update the products quantity");
		
		
		Scanner sc=new Scanner(System.in);


		int choice=sc.nextInt();
		sc.nextLine();
		
		System.out.println();

		if(choice==1) {
			System.out.println("Please Enter the new password.");
			
			String password=sc.nextLine();
			commands.update_password("admin", password, id);
		}else if(choice==2) {
			System.out.println("Enter Manager's name and password");
			
			String name=sc.nextLine();
			String password=sc.nextLine();
			Employee mng=new manager(name,password,id);
			commands.update_pepole(mng);
		}
		else if(choice==3) {
			
			commands.show_table(new manager());
			
		}
		else if(choice==4) {
			

			commands.show_table(new manager());
			System.out.println();
			
			System.out.print("Enter Manager's Id to be deleted - ");
			int mid =sc.nextInt();
		
			commands.delete_pepole(new manager(),mid);
		
		}else if(choice==5) {
			
			commands.show_table(new shopkeeper());
			
		}else if(choice==6) {
			

			commands.show_table(new shopkeeper());
			System.out.println();
			
			System.out.print("Enter Manager's Id to be deleted - ");
			int mid =sc.nextInt();
		
			commands.delete_pepole(new shopkeeper(),mid);
		
		}else if(choice==7) {
			
			System.out.println("Please Enter to continue, anything to exit");
			
			while(true) {
				String ch=sc.nextLine();
			
				if(ch.length()!=0)break;
				production.entry(id);
			}
		}else if(choice==8) {
			
			production.details();
			
		}
		else if(choice==9) {
			
			production.details();
			
			System.out.print("Enter the id - ");
			int uid=sc.nextInt();
			System.out.println();
			
			System.out.print("Enter the quantity - ");
			int quantity=sc.nextInt();
			System.out.println();
			
			int arr[]=production.get(uid);
			production.update(uid, arr[1]+quantity);
			
		}
		
		sc.close();
	}

}
















