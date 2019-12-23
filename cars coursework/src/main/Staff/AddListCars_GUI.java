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
 * implements the GUI to let user to add a list of cars from selected file
 * @author tenusha
 *
 */
public class AddListCars_GUI extends Staff {
	private static String type=null;
	private JFrame frame;
	private JTextField txtSelectedFile;

	/**
	 * Launch the application.
	 */
	public static void main(String caller,String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddListCars_GUI window = new AddListCars_GUI();
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
	public AddListCars_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 698, 212);
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
		
		JMenu mnAddlcar = new JMenu("Add Car");
		mnAddlcar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				AddCar_GUI.main("",null);
			}
		});
		mnAddlcar.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		menuBar.add(mnAddlcar);
		
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
		frame.getContentPane().setLayout(null);
		
		
		JLabel label_12 = new JLabel("Add a list of Cars:");
		label_12.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		label_12.setBounds(24, 59, 141, 23);
		frame.getContentPane().add(label_12);
		
		JButton btnChoosefile = new JButton("Choose File");
		btnChoosefile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_List_Of_Cars(txtSelectedFile);
			}
		});
		btnChoosefile.setBounds(164, 49, 101, 47);
		frame.getContentPane().add(btnChoosefile);
		
		txtSelectedFile = new JTextField();
		txtSelectedFile.setBounds(29, 116, 652, 26);
		frame.getContentPane().add(txtSelectedFile);
		txtSelectedFile.setColumns(10);
		
		JLabel lblPleaseNaviagetTo = new JLabel("Please navigate to cars-import text file");
		lblPleaseNaviagetTo.setBounds(295, 80, 337, 16);
		frame.getContentPane().add(lblPleaseNaviagetTo);
		
	}
}
