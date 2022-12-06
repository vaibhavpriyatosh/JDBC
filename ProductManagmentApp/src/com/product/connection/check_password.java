package com.product.connection;

import command.*;
//import com.student.manage.CP;

public class check_password {

	public static boolean password_matching(int position,int id,String password){
		
		if(position==1) {
			//check admin
			if (commands.matching_pepole("admin",id,password)) {
				
				 admin_commands.display(id);
//				admin_commands.display(id);
				// truth
				return true;
			}
			else {
				return false;
			}
		}else if(position==2) {
			//check manager
			if (commands.matching_pepole("manager",id,password)) {
				
				manager_commands.display(id);
				// truth
				return true;
			}
			else {
				return false;
			}
		}
		else if(position==3) {
			//check shopkeeper
			if (commands.matching_pepole("shopkeeper",id,password)) {
				
				shopkeeper_commands.display(id);
				// truth
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	
	
	
}


















