package main.Staff;

import java.awt.EventQueue;

import javax.swing.JFrame;


import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Creates the home page of staff user
 * @author tenusha
 *
 */
public class Staff_GUI extends Staff {

	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staff_GUI window = new Staff_GUI();
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
	public Staff_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 685, 206);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCarDealershipSystem = new JLabel("Car Dealership System: Staff");
		lblCarDealershipSystem.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblCarDealershipSystem.setBounds(17, 17, 305, 22);
		frame.getContentPane().add(lblCarDealershipSystem);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(6, 6, 280, 39);
		frame.getContentPane().add(panel);
		
		
		
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
		btnExit.setBounds(525, 6, 117, 29);
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
				AddCar_GUI.main("",null);
			}
		});
		mnAddcar.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		menuBar.add(mnAddcar);
		
		JMenu mnAddlistcar = new JMenu("Add list of cars");
		mnAddlistcar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				AddListCars_GUI.main("",null);
			}
		});
		mnAddlistcar.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		menuBar.add(mnAddlistcar);
		
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
		
		JMenu CalcRevenue = new JMenu("Calculate Revenue");
		CalcRevenue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				CalcRevenue_GUI.main("",null);
			}
		});
		CalcRevenue.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		menuBar.add(CalcRevenue);
		
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
		
		
	}
}
