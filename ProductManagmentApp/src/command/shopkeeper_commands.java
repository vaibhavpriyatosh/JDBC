package command;

import java.util.Scanner;

import product_manipulation.production;

public class shopkeeper_commands {

	public static void display(int id) {
			
			System.out.println("Choose from the following options");
			System.out.println("1 Update your password");
			System.out.println("2 Show the details");
			System.out.println("3 Calculate the bill");
			System.out.println("4 Update the products quantity");
			
			Scanner sc=new Scanner(System.in);
	
	
			int choice=sc.nextInt();
			sc.nextLine();
			
			System.out.println();
	
			if(choice==1) {
				System.out.println("Please Enter the new password.");
				
				String password=sc.nextLine();
				commands.update_password("shopkeeper", password, id);
			}else if(choice==2) {
				production.details();
			}else if(choice==3) {
				production.billing();
			}else if(choice==4) {
				
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
