package main.Staff;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import main.Admin.Admin_GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * implements the GUI to let user to add a car to database
 * @author tenusha
 *
 */
public class AddCar_GUI extends Staff {
	private static String type=null;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String caller,String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCar_GUI window = new AddCar_GUI();
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
	public AddCar_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 706, 444);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(607, 6, 87, 26);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frame,"Confirm if you want to exit","Car dealership System ",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnExit);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(521, 6, 87, 26);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			main.Loginsys.Loginsystem.main(null);
			}
		});
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
				frame.setVisible(false);;
				Staff_GUI.main(null);
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(type.contains("admin")) {
					frame.setVisible(false);
					Admin_GUI.main(null);
				}else {
				frame.setVisible(false);;
				Staff_GUI.main(null);
				}
			}
		});
		mnMain.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		menuBar.add(mnMain);
		
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
		
		JLabel label = new JLabel("Number Plate:");
		label.setBounds(52, 36, 101, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Model:");
		label_1.setBounds(101, 64, 42, 16);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Car Type:");
		label_2.setBounds(86, 97, 61, 16);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Size(if type is van):");
		label_3.setBounds(31, 137, 122, 16);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Colour:");
		label_4.setBounds(101, 170, 46, 16);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Mileage:");
		label_5.setBounds(100, 203, 53, 16);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("Accident History:");
		label_6.setBounds(36, 231, 117, 16);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("Transmission:");
		label_7.setBounds(62, 264, 101, 16);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("Price in £:");
		label_8.setBounds(86, 292, 78, 16);
		frame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("Arrival Date (optional):");
		label_9.setBounds(6, 320, 143, 16);
		frame.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("Sell Date (optional):");
		label_10.setBounds(21, 354, 133, 16);
		frame.getContentPane().add(label_10);
		
		JTextField txtNumberPlate = new JTextField();
		txtNumberPlate.setBounds(152, 31, 130, 26);
		txtNumberPlate.setColumns(10);
		frame.getContentPane().add(txtNumberPlate);
		
		JTextField txtModel = new JTextField();
		txtModel.setBounds(152, 59, 130, 26);
		txtModel.setColumns(10);
		frame.getContentPane().add(txtModel);
		
		JComboBox comboBoxCarType = new JComboBox();
		comboBoxCarType.setBounds(152, 88, 130, 27);
		comboBoxCarType.setModel(new DefaultComboBoxModel(new String[] {"SUV", "MPV", "Van", "Coupe", "Saloon", "Hatchback"}));
		frame.getContentPane().add(comboBoxCarType);
		
		JTextField textVanSize = new JTextField();
		textVanSize.setBounds(158, 127, 124, 26);
		textVanSize.setColumns(10);
		frame.getContentPane().add(textVanSize);
		
		JTextField txtColour = new JTextField();
		txtColour.setBounds(152, 160, 130, 26);
		txtColour.setColumns(10);
		frame.getContentPane().add(txtColour);
		
		JTextField txtMileage = new JTextField();
		txtMileage.setBounds(152, 198, 130, 26);
		txtMileage.setColumns(10);
		frame.getContentPane().add(txtMileage);
		
		JTextField txtAccHistory = new JTextField();
		txtAccHistory.setBounds(152, 226, 130, 26);
		txtAccHistory.setColumns(10);
		frame.getContentPane().add(txtAccHistory);
		
		JComboBox comboBoxTransmission = new JComboBox();
		comboBoxTransmission.setBounds(152, 255, 131, 27);
		comboBoxTransmission.setModel(new DefaultComboBoxModel(new String[] {"Automatic", "Manual"}));
		frame.getContentPane().add(comboBoxTransmission);
		
		JTextField txtPrice = new JTextField();
		txtPrice.setBounds(152, 282, 130, 26);
		txtPrice.setColumns(10);
		frame.getContentPane().add(txtPrice);
		
		JTextField txtArrivalD = new JTextField();
		txtArrivalD.setBounds(153, 315, 130, 26);
		txtArrivalD.setColumns(10);
		frame.getContentPane().add(txtArrivalD);
		
		JTextField txtSellD = new JTextField();
		txtSellD.setBounds(153, 349, 130, 26);
		txtSellD.setColumns(10);
		frame.getContentPane().add(txtSellD);
		
		JButton button = new JButton("Add Car ");
		button.setBounds(334, 301, 133, 69);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCar(txtNumberPlate,txtModel,textVanSize,txtColour,txtAccHistory,txtArrivalD,txtSellD,txtMileage,txtPrice,comboBoxCarType,comboBoxTransmission);
			}
		});
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Reset ");
		button_1.setBounds(334, 203, 133, 69);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNumberPlate.setText(null);
				txtModel.setText(null);
				textVanSize.setText(null);
				txtColour.setText(null);
				txtAccHistory.setText(null);
				txtArrivalD.setText(null);
				txtSellD.setText(null);
				txtMileage.setText(null);
				txtPrice.setText(null);
			}
		});
		frame.getContentPane().add(button_1);
		
		JLabel label_11 = new JLabel("Add a Single Car:");
		label_11.setBounds(8, 6, 141, 23);
		label_11.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		frame.getContentPane().add(label_11);
	}

}
