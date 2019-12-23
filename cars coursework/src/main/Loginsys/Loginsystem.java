package main.Loginsys;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import main.Admin.Admin_GUI;
import main.Customer.Customer;
import main.Staff.Staff_GUI;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

import java.io.BufferedReader;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;
import java.util.Scanner;
import java.awt.Font; // Import the Scanner class to read text files
/**
 * Creates the GUI to for the login system
 * implements the login system as it verifies user credentials
 * @author tenusha
 *
 */
public class Loginsystem {

	private JFrame frame;
	private JTextField txtUsername;
	private JTextField txtPassword;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginsystem window = new Loginsystem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Loginsystem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHeader = new JLabel("Car dealer Login System");
		lblHeader.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lblHeader.setBounds(120, 6, 222, 27);
		frame.getContentPane().add(lblHeader);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(115, 65, 149, 26);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(24, 70, 79, 16);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(24, 116, 79, 16);
		frame.getContentPane().add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(115, 111, 149, 26);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = txtPassword.getText();
				String decodedPassword;
				String Username =txtUsername.getText();
				boolean valid=false;
				try {
				      File myObj = new File(".//txtfiles//cars-users.txt"); //read users file with stored passwords 
				      Scanner myReader = new Scanner(myObj); 
				      while (myReader.hasNextLine()) {
				        String line = myReader.nextLine();
				        String[] details = line.split(",");
				        byte[] decodedBytes = Base64.getDecoder().decode(details[1]);//decode from Base64
				        decodedPassword = new String(decodedBytes);//gets original password and store
				        if(Username.contains(details[0]) && password.contains(decodedPassword)) { //checks if passwords match
				        	valid=true; //flag set to true
				        	if(details[2].contains("admin")) {
				        		frame.setVisible(false); //loads frame of matched user
				        		Admin_GUI.main(null);;
				        	}
				        	if(details[2].contains("customer")) {
				        		frame.setVisible(false);
				        		Customer.main(null);;
				        	}
				        	if(details[2].contains("staff")) {
				        		frame.setVisible(false);
				        		Staff_GUI.main(null);;
				        	}
				        }
				      }
				      myReader.close();
				    } catch (FileNotFoundException l) {
				      System.out.println("An error occurred.");
				      l.printStackTrace();
				    } 
				if(valid==true) {
					txtPassword.setText(null);
					txtUsername.setText(null);
				}else {
					JOptionPane.showMessageDialog(null,"Invalid Login Details","Login Error",JOptionPane.ERROR_MESSAGE); //error message
				}
			}
		});
		btnLogin.setBounds(324, 65, 156, 29);
		frame.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsername.setText(null);
				txtPassword.setText(null); //clears text boxes
			}
		});
		btnReset.setBounds(324, 111, 156, 29);
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame = new JFrame("Exit"); // quits the program
				if (JOptionPane.showConfirmDialog(frame,"Confirm if you want to exit","Login Systems ",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
				
			}
		});
		btnExit.setBounds(377, 214, 117, 58);
		frame.getContentPane().add(btnExit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 195, 488, 7);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(6, 39, 488, 7);
		frame.getContentPane().add(separator_1);
	}
}
