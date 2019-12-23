package main.Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;

import main.Staff.AddCar_GUI;
import main.Staff.AddListCars_GUI;
import main.Staff.CalcRevenue_GUI;
import main.Staff.PrintCars_GUI;
import main.Staff.SearchCars_GUI;
import main.Staff.SellCar_GUI;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
/**
 * Creates the home page of Admin GUI
 * creates GUI to implement user credentials
 * @author tenusha
 *
 */
public class Admin_GUI extends Admin {

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
					Admin_GUI window = new Admin_GUI();
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
	public Admin_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setForeground(new Color(204, 204, 153));
		frame.getContentPane().setForeground(new Color(204, 204, 153));
		frame.setBounds(0, 0, 685, 406);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeBackUser = new JLabel("Welcome back User ! Please use the menu bar to navigate the program");
		lblWelcomeBackUser.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		lblWelcomeBackUser.setBounds(28, 77, 634, 29);
		frame.getContentPane().add(lblWelcomeBackUser);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		frame.setJMenuBar(menuBar);
		
		JMenu mnAddcar = new JMenu("Add car");
		mnAddcar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				AddCar_GUI.main("admin",null);
			}
		});
		mnAddcar.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		menuBar.add(mnAddcar);
		
		JMenu mnAddlistcar = new JMenu("Add list of cars");
		mnAddlistcar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				AddListCars_GUI.main("admin",null);
			}
		});
		mnAddlistcar.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		menuBar.add(mnAddlistcar);
		
		JMenu SearchCars = new JMenu("Search Cars");
		SearchCars.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				SearchCars_GUI.main("admin",null);
			}
		});
		SearchCars.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		menuBar.add(SearchCars);
		
		JMenu CalcRevenue = new JMenu("Calculate Revenue");
		CalcRevenue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				CalcRevenue_GUI.main("admin",null);
			}
		});
		CalcRevenue.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		menuBar.add(CalcRevenue);
		
		JMenu Sellcars = new JMenu("Sell cars");
		Sellcars.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				SellCar_GUI.main("admin",null);
			}
		});
		Sellcars.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		menuBar.add(Sellcars);
		
		JMenu printCars = new JMenu("Print Cars");
		printCars.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				PrintCars_GUI.main("admin",null);
			}
		});
		printCars.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		menuBar.add(printCars);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(6, 6, 326, 35);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Car dealership System: Admin");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 17));
		panel.add(lblNewLabel);
		
		JLabel lblCreateLoginCredentials = new JLabel("Create Login Credentials ");
		lblCreateLoginCredentials.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblCreateLoginCredentials.setBounds(21, 151, 195, 16);
		frame.getContentPane().add(lblCreateLoginCredentials);
		
		JLabel lblNewLabel_1 = new JLabel("User Type:");
		lblNewLabel_1.setBounds(21, 179, 71, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JRadioButton rdbtnAdmin = new JRadioButton("Admin");
		rdbtnAdmin.setBounds(21, 207, 141, 23);
		frame.getContentPane().add(rdbtnAdmin);
		
		JRadioButton rdbtnStaff = new JRadioButton("Staff");
		rdbtnStaff.setBounds(21, 230, 141, 23);
		frame.getContentPane().add(rdbtnStaff);
		
		JRadioButton rdbtnCustomer = new JRadioButton("Customer");
		rdbtnCustomer.setBounds(21, 254, 141, 23);
		frame.getContentPane().add(rdbtnCustomer);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(21, 289, 71, 16);
		frame.getContentPane().add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(88, 284, 130, 26);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(21, 317, 71, 16);
		frame.getContentPane().add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(88, 312, 130, 26);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.setToolTipText("Add the entered user to the system");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addUsers(txtUsername, txtPassword,  rdbtnCustomer, rdbtnStaff, rdbtnAdmin); 
			}
		});
		btnAddUser.setBounds(237, 276, 117, 29);
		frame.getContentPane().add(btnAddUser);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frame,"Confirm if you want to exit","Car dealership System ",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		btnExit.setBounds(563, 6, 117, 29);
		frame.getContentPane().add(btnExit);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			main.Loginsys.Loginsystem.main(null);
			}
		});
		btnLogout.setBounds(409, 6, 117, 29);
		frame.getContentPane().add(btnLogout);
		
		JButton btnResetlogin = new JButton("Reset");
		btnResetlogin.setToolTipText("Reset values in section");
		btnResetlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsername.setText(null);
				txtPassword.setText(null);
				rdbtnCustomer.setSelected(false);
				rdbtnStaff.setSelected(false);
				rdbtnAdmin.setSelected(false);
				
			}
		});
		btnResetlogin.setBounds(254, 312, 78, 29);
		frame.getContentPane().add(btnResetlogin);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(28, 114, 654, 12);
		frame.getContentPane().add(separator);
	}
}
