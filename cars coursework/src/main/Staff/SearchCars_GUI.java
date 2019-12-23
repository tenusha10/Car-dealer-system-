package main.Staff;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import main.Admin.Admin_GUI;
/**
 * implements the GUI to let user to perform a car search
 * @author tenusha
 *
 */
public class SearchCars_GUI extends Staff {
	private static String type=null;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String caller,String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchCars_GUI window = new SearchCars_GUI();
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
	public SearchCars_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 832, 486);
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
		
		JLabel label_13 = new JLabel("Search Cars");
		label_13.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		label_13.setBounds(17, 23, 141, 23);
		frame.getContentPane().add(label_13);
		
		JLabel label_14 = new JLabel("Transmission:");
		label_14.setBounds(28, 157, 89, 16);
		frame.getContentPane().add(label_14);
		
		JComboBox comboBoxSearchTransmission = new JComboBox();
		comboBoxSearchTransmission.setModel(new DefaultComboBoxModel(new String[] {"Manual", "Automatic "}));
		comboBoxSearchTransmission.setBounds(114, 153, 141, 27);
		frame.getContentPane().add(comboBoxSearchTransmission);
		
		JLabel label_15 = new JLabel("   Colour:");
		label_15.setBounds(17, 227, 89, 16);
		frame.getContentPane().add(label_15);
		
		JTextField txtSearchColour = new JTextField();
		txtSearchColour.setColumns(10);
		txtSearchColour.setBounds(82, 222, 154, 26);
		frame.getContentPane().add(txtSearchColour);
		
		JLabel label_16 = new JLabel("Number of seats ");
		label_16.setBounds(28, 295, 117, 16);
		frame.getContentPane().add(label_16);
		
		JLabel label_17 = new JLabel("Min");
		label_17.setBounds(28, 323, 23, 16);
		frame.getContentPane().add(label_17);
		
		JLabel label_18 = new JLabel("Max");
		label_18.setBounds(146, 323, 61, 16);
		frame.getContentPane().add(label_18);
		
		JTextField txtMin = new JTextField();
		txtMin.setColumns(10);
		txtMin.setBounds(56, 318, 33, 26);
		frame.getContentPane().add(txtMin);
		
		JTextField txtMax = new JTextField();
		txtMax.setColumns(10);
		txtMax.setBounds(184, 318, 33, 26);
		frame.getContentPane().add(txtMax);
		
		JLabel label_19 = new JLabel("Vans With size:");
		label_19.setBounds(28, 383, 105, 16);
		frame.getContentPane().add(label_19);
		
		JTextField txtVanSizeSearch = new JTextField();
		txtVanSizeSearch.setColumns(10);
		txtVanSizeSearch.setBounds(125, 378, 101, 26);
		frame.getContentPane().add(txtVanSizeSearch);
		
		JTextField txtSearchModel = new JTextField();
		txtSearchModel.setColumns(10);
		txtSearchModel.setBounds(77, 122, 190, 26);
		frame.getContentPane().add(txtSearchModel);
		
		JTextArea textAreaSearch = new JTextArea();
		JScrollPane scrollPaneSearch = new JScrollPane(textAreaSearch);
		scrollPaneSearch.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneSearch.setBounds(400, 44, 426, 363);
		frame.getContentPane().add(scrollPaneSearch);
		
		
		JButton btnSearchCriteria = new JButton("Search criteria 1");
		btnSearchCriteria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchcarModelandTransmission(textAreaSearch,txtSearchModel,comboBoxSearchTransmission);
			}
		});
		btnSearchCriteria.setToolTipText("enter a model and select the transmission and click button");
		btnSearchCriteria.setBounds(248, 152, 133, 29);
		frame.getContentPane().add(btnSearchCriteria);
		
		JLabel label_20 = new JLabel("Model");
		label_20.setBounds(28, 127, 46, 16);
		frame.getContentPane().add(label_20);
		
		
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(6, 188, 375, 12);
		frame.getContentPane().add(separator_2);
		
		JButton btnSearchCriteria_1 = new JButton("Search criteria 2");
		btnSearchCriteria_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchColour(textAreaSearch,txtSearchColour);
			}
		});
		btnSearchCriteria_1.setToolTipText("enter a colur and click this button");
		btnSearchCriteria_1.setBounds(247, 216, 133, 29);
		frame.getContentPane().add(btnSearchCriteria_1);
		
		JButton btnSearchCrteria = new JButton("Search crteria 3");
		btnSearchCrteria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchMinMaxSeats(textAreaSearch,txtMin,txtMax);
			}
		});
		btnSearchCrteria.setToolTipText("enter a min and max number of seats and click this button");
		btnSearchCrteria.setBounds(247, 318, 133, 29);
		frame.getContentPane().add(btnSearchCrteria);
		
		JButton btnSearchCriteria_2 = new JButton("Search criteria 4");
		btnSearchCriteria_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchVanSize(textAreaSearch,txtVanSizeSearch);
			}
		});
		btnSearchCriteria_2.setToolTipText("enter a size and click this button");
		btnSearchCriteria_2.setBounds(247, 378, 133, 29);
		frame.getContentPane().add(btnSearchCriteria_2);
		
		JLabel label_21 = new JLabel("Select a criteria below ");
		label_21.setBounds(17, 69, 148, 16);
		frame.getContentPane().add(label_21);
		
		JLabel lblCriteriasearchByModel = new JLabel("Criteria1:Search by model and transmission ");
		lblCriteriasearchByModel.setBounds(17, 97, 340, 16);
		frame.getContentPane().add(lblCriteriasearchByModel);
		
		JLabel lblCriteriasearchByColour = new JLabel("Criteria2:Search by colour");
		lblCriteriasearchByColour.setBounds(28, 199, 239, 16);
		frame.getContentPane().add(lblCriteriasearchByColour);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(6, 249, 375, 12);
		frame.getContentPane().add(separator_3);
		
		JLabel lblCriteriaSearch = new JLabel("Criteria 3: Search by min and max number of seats");
		lblCriteriaSearch.setBounds(28, 272, 460, 16);
		frame.getContentPane().add(lblCriteriaSearch);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(6, 342, 375, 12);
		frame.getContentPane().add(separator_4);
		
		JLabel lblCriteriaSearch_1 = new JLabel("Criteria 4: Search by van Size");
		lblCriteriaSearch_1.setBounds(28, 355, 239, 16);
		frame.getContentPane().add(lblCriteriaSearch_1);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(17, 416, 378, 12);
		frame.getContentPane().add(separator_5);
	}

}
