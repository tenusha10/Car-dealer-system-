package main.Admin;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import main.Users;
import main.Staff.Staff;

public abstract class Admin extends Staff {
	/**
	 * Method adds user into cars-users and allow new users acces to system by creating login credentials
	 * @param txtUsername
	 * @param txtPassword
	 * @param rdbtnCustomer
	 * @param rdbtnStaff
	 * @param rdbtnAdmin
	 */
	public final void addUsers(JTextField txtUsername,JTextField txtPassword, JRadioButton rdbtnCustomer,JRadioButton rdbtnStaff,JRadioButton rdbtnAdmin) {
		//method allows to create new users 
		String username = null, password = null;
		boolean valid=false;
		String encodedPassword = null;
		if(txtUsername.getText().isEmpty() || txtPassword.getText().isEmpty()) { //validation 
			JOptionPane.showMessageDialog(null,"Please enter text to username and password");
		}else{
		 username =txtUsername.getText();
		password=txtPassword.getText();
		encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
		valid=true;
		}
		
		String type = null;
		if(rdbtnCustomer.isSelected()) {  //radio button validation
			type="customer";
			valid=true;
		}else if (rdbtnStaff.isSelected()) {
			type="staff";
			valid=true;
		}else if(rdbtnAdmin.isSelected()) {
			type="admin";
			valid=true;
		}else {
			JOptionPane.showMessageDialog(null,"Please select a type");
			 valid = false;
		}
		List<String> User_check = new ArrayList<String>();
		User_check=readfile("cars-users"); //reads the existing users into an array to check if the user already exists
		for(String line:User_check) {
			String[] arr=line.split(",");
			if(arr[0].contains(username)) {
				valid=false;
				JOptionPane.showMessageDialog(null,"User already exists!"); //checks if the user already exists 
				break;
			}
		}
		
		if(valid==true) {
		List<String> User_List = new ArrayList<String>();
		User_List=readfile("cars-users");
		Users user1 = new Users(username,encodedPassword,type);
		String written_U = String.join(",", user1.Username,user1.Password, user1.Type);
		User_List.add(written_U); //new user added to the array list containing the previous user
		BufferedWriter bw = null;  // array list is written back to the file;
		try {
			bw = new BufferedWriter(new FileWriter(".//txtfiles//cars-users.txt"));
			for(String u : User_List) {
				bw.write(u+"\n");
			}
	}catch(FileNotFoundException e1) 
		{ System.err.println(e1.getMessage()); e1.printStackTrace();
	} catch(IOException e1) 
		{ System.err.println(e1.getMessage()); e1.printStackTrace();
		}
		finally {
		    try {
		    	if(bw != null) { 
		    		bw.close();
		    	      }
		    	    } catch(IOException e1) {
		    	System.err.println(e1.getMessage( ));
		    	      e1.printStackTrace();
		    	    }
		    	} JOptionPane.showMessageDialog(null,"User Added");}
	}
}
