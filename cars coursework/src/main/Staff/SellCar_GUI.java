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
 * implements the GUI to let user to Sell cars
 * @author tenusha
 *
 */
public class SellCar_GUI extends Staff{
	private static String type=null;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String caller,String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SellCar_GUI window = new SellCar_GUI();
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
	public SellCar_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 717, 267);
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
				}else{
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
		
		JMenu Searchcars = new JMenu("Search Cars");
		Searchcars.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				SearchCars_GUI.main("",null);
			}
		});
		Searchcars.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		menuBar.add(Searchcars);
		
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
		
		JLabel label_22 = new JLabel("Sell Cars");
		label_22.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		label_22.setBounds(22, 40, 195, 16);
		frame.getContentPane().add(label_22);
		
		JLabel label_23 = new JLabel("Enter  Number plate to sell Car");
		label_23.setBounds(22, 69, 205, 16);
		frame.getContentPane().add(label_23);
		
		JTextField txtSellCarREG = new JTextField();
		txtSellCarREG.setColumns(10);
		txtSellCarREG.setBounds(32, 92, 195, 26);
		frame.getContentPane().add(txtSellCarREG);
		

		JTextField txtSellDate = new JTextField();
		txtSellDate.setColumns(10);
		txtSellDate.setBounds(32, 140, 195, 26);
		frame.getContentPane().add(txtSellDate);
		
		
		JButton button_3 = new JButton("Sell Car");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellCar(txtSellCarREG,txtSellDate);
			}
		});
		button_3.setBounds(284, 92, 124, 59);
		frame.getContentPane().add(button_3);
		
		JLabel label_24 = new JLabel("Sell Date");
		label_24.setBounds(22, 117, 61, 16);
		frame.getContentPane().add(label_24);
		
	}

}
