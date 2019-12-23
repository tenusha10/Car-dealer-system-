package main.Staff;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import main.Admin.Admin_GUI;
/**
 * implements the GUI to let user to calculate revenue 
 * @author tenusha
 *
 */
public class CalcRevenue_GUI  extends Staff{
	private static String type=null;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String caller,String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalcRevenue_GUI window = new CalcRevenue_GUI();
					window.frame.setVisible(true);
					type=caller;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalcRevenue_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 699, 275);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
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
		btnExit.setBounds(607, 6, 87, 26);
		frame.getContentPane().add(btnExit);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			main.Loginsys.Loginsystem.main(null);
			}
		});
		btnLogout.setBounds(521, 6, 87, 26);
		frame.getContentPane().add(btnLogout);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		frame.setJMenuBar(menuBar);
		
		JMenu mnMain = new JMenu("Main Menu");
		mnMain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(type.contains("admin")) {
					frame.setVisible(false);
					Admin_GUI.main(null);
				}else {
				frame.setVisible(false);
				Staff_GUI.main(null);
				}
			}
		});
		mnMain.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		menuBar.add(mnMain);
		
		JMenu mnAddcar = new JMenu("Add Car");
		mnAddcar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				AddCar_GUI.main("",null);
			}
		});
		mnAddcar.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		menuBar.add(mnAddcar);
		
		JMenu Addlistcar = new JMenu("Add list of cars");
		Addlistcar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				AddListCars_GUI.main("",null);
			}
		});
		Addlistcar.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		menuBar.add(Addlistcar);
		
		JMenu SearchCars = new JMenu("Search Cars");
		SearchCars.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				SearchCars_GUI.main("",null);
			}
		});
		SearchCars.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		menuBar.add(SearchCars);
		
		JMenu Sellcars = new JMenu("Sell cars");
		Sellcars.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				SellCar_GUI.main("",null);
			}
		});
		Sellcars.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		menuBar.add(Sellcars);
		
		JMenu printCars = new JMenu("Print Cars");
		printCars.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				PrintCars_GUI.main("",null);
			}
		});
		printCars.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		menuBar.add(printCars);
		frame.getContentPane().setLayout(null);
		
		JLabel label_25 = new JLabel("Calculate Revenue");
		label_25.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		label_25.setBounds(8, 27, 158, 16);
		frame.getContentPane().add(label_25);
		
		JLabel label_26 = new JLabel("Enter Day(YYYY-MM-DD)");
		label_26.setBounds(18, 60, 203, 16);
		frame.getContentPane().add(label_26);
		
		JTextField txtDateofRevenue = new JTextField();
		txtDateofRevenue.setToolTipText("Format: YYYY-MM-DD example (2019-04-24)");
		txtDateofRevenue.setColumns(10);
		txtDateofRevenue.setBounds(246, 55, 130, 26);
		frame.getContentPane().add(txtDateofRevenue);
		
		JButton button_2 = new JButton("Calculate  revenue for day");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculateRevenueForDay(txtDateofRevenue);
			}
		});
		button_2.setBounds(388, 55, 205, 29);
		frame.getContentPane().add(button_2);
		
		JLabel label_27 = new JLabel("Enter month(YYYY-MM)");
		label_27.setBounds(20, 116, 201, 16);
		frame.getContentPane().add(label_27);
		
		JTextField txtTxtmonth = new JTextField();
		txtTxtmonth.setToolTipText("Format: YYYY-MM Example(2019-04)");
		txtTxtmonth.setColumns(10);
		txtTxtmonth.setBounds(246, 111, 130, 26);
		frame.getContentPane().add(txtTxtmonth);
		
		JButton button_4 = new JButton("Calculate revenue for month");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculateRevenueForMonth(txtTxtmonth);
			}
		});
		button_4.setBounds(388, 111, 205, 29);
		frame.getContentPane().add(button_4);
	}

}
