package user.controller;

import java.util.Scanner;

import user.dao.UserDao;
import user.dto.User;

public class UserControl {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
System.out.println("***************************");
		System.out.println("Welcome to user application");
		System.out.println("***************************");
		System.out.println("Select an Option to perform task\n");
		System.out.println("Enter 1 to save data");
		System.out.println("Enter 2 to update data");
		System.out.println("Enter 3 to find data");
		System.out.println("Enter 4 to delete data");
		System.out.println("Enter 5 to find all ");
		System.out.println("Enter 6 to Exit");
		int choice=sc.nextInt();

		UserDao dao=new UserDao();
		switch(choice) {
		case 1:{
			
			System.out.println("Enter the name");
			String name=sc.next();
			System.out.println("Enter the address");
			String adr=sc.next();

			User us=new User();
			
			us.setName(name);
			us.setAddress(adr);
			dao.saveuser(us);
			System.out.println("Data Saved successfully");
		}	break;
	
		case 2:{
			System.out.println("Enter the id");
			int id=sc.nextInt();
			System.out.println("Enter the name");
			String name=sc.next();
			System.out.println("Enter the address");
			String adr=sc.next();

			User us=new User();
			us.setName(name);
			us.setAddress(adr);

			dao.update(id, us);
			System.out.println("Data Upadated successfully");
		}break;
		
		case 3:{
			System.out.println("Enter the Id");
			int id=sc.nextInt();			
			dao.finduser(id);
			System.out.println("data fetched successfully");
		}break;
		case 4:{
			System.out.println("Enter the Id");
			int id=sc.nextInt();			
			dao.deleteuser(id);
			System.out.println("data deleted");

		}break;
		case 5:{
			dao.findall();
			System.out.println("Data OF Every Person Fetched Successfully");
		}
		
		case 6:{
			System.out.println("Thank you");
		}
		}

	}

}
