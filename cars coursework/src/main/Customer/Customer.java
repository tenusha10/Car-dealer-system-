package main.Customer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

import main.Coupe;
import main.Hatchback;
import main.MPV;
import main.SUV;
import main.Saloon;
import main.Van;
import main.Staff.Staff;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
/**
 * Class is GUI class and implements a car search 
 * allows user to search for cars without accident history being visible
 * methods are implemeneted inside the button
 * @author tenusha
 *
 */
public class Customer extends Staff{

	private JFrame frame;
	private JTextField textModel;
	private JTextField txtSearchColour;
	private JTextField txtMin;
	private JTextField txtMax;
	private JTextField txtVanSize;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer window = new Customer();
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
	public Customer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1000, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCarDealership = new JLabel("Car Dealership System: Customer");
		lblCarDealership.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblCarDealership.setBounds(22, 17, 339, 36);
		frame.getContentPane().add(lblCarDealership);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(6, 19, 339, 36);
		frame.getContentPane().add(panel);
		
		JLabel lblCarSearchPlease = new JLabel("Car Search: Please Select a Criteria below and execute a search");
		lblCarSearchPlease.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblCarSearchPlease.setBounds(6, 80, 493, 16);
		frame.getContentPane().add(lblCarSearchPlease);
		
		JLabel lblCriteria = new JLabel("Criteria 1: Search by model and transmission ");
		lblCriteria.setBounds(6, 108, 302, 16);
		frame.getContentPane().add(lblCriteria);
		
		JLabel lblModel = new JLabel("Model:");
		lblModel.setBounds(6, 127, 61, 16);
		frame.getContentPane().add(lblModel);
		
		JLabel lblTransmission = new JLabel("Transmission:");
		lblTransmission.setBounds(6, 155, 89, 16);
		frame.getContentPane().add(lblTransmission);
		
		textModel = new JTextField();
		textModel.setBounds(50, 122, 160, 26);
		frame.getContentPane().add(textModel);
		textModel.setColumns(10);
		
		JList list = new JList();
		list.setBounds(124, 155, -16, 21);
		frame.getContentPane().add(list);
		
		JComboBox comboBoxTrans = new JComboBox();
		comboBoxTrans.setModel(new DefaultComboBoxModel(new String[] {"Manual", "Automatic"}));
		comboBoxTrans.setBounds(94, 151, 115, 27);
		frame.getContentPane().add(comboBoxTrans);
		
		JLabel lblCriteria_1 = new JLabel("Criteria 2: Search by colour");
		lblCriteria_1.setBounds(6, 196, 204, 16);
		frame.getContentPane().add(lblCriteria_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 183, 464, 12);
		frame.getContentPane().add(separator);
		
		JTextArea textAreaSearch = new JTextArea();
		//textAreaSearch.setBounds(493, 81, 497, 325);
		JScrollPane scrollPaneSearch = new JScrollPane(textAreaSearch);
		scrollPaneSearch.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneSearch.setBounds(493, 81, 497, 325);
		frame.getContentPane().add(scrollPaneSearch);
		
		JButton btnSearchCriteria = new JButton("Search Criteria 1");
		btnSearchCriteria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaSearch.selectAll();
				textAreaSearch.replaceSelection("");
				boolean found=false;
				
				if(textModel.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"Please enter Car model","ERROR!",JOptionPane.ERROR_MESSAGE);
				}else{
				final String newline = "\n";
				String[] linearr=new String[11];
				List<String> Data_List = new ArrayList<String>();
				Data_List=readfile("cars-database");
				String search_Model=(textModel.getText()).toLowerCase();
				String transmission=(((String) comboBoxTrans.getSelectedItem()).toLowerCase());
				String Searchcolour=txtSearchColour.getText();
				for (String line:Data_List) {
					linearr =line.split(",");
					if(!(linearr[2].contains("Van"))) {
						if (search_Model.contains(linearr[1].toLowerCase()) && transmission.contains(linearr[6].toLowerCase())) {
							if(linearr.length<10) {
							textAreaSearch.append("Number Plate:"+linearr[0]+newline+"Model:"+linearr[1]+newline+"Car Type:"+linearr[2]+newline+"Colour:"+linearr[3]+newline+"Mileage:"+linearr[4]+newline+"Transmission:"+linearr[6]+newline+"Price:£"+linearr[7]+newline+"Arrival Date:"+linearr[8]+newline);
							found=true;
						}
					}
					}else {
						if (search_Model.contains(linearr[1].toLowerCase()) && transmission.contains(linearr[7].toLowerCase())){
							if(linearr.length<11) {
								textAreaSearch.append("Number Plate:"+linearr[0]+newline+"Model:"+linearr[1]+newline+"Car Type:"+linearr[2]+newline+"Size:"+linearr[3]+newline+"Colour:"+linearr[4]+newline+"Mileage:"+linearr[5]+newline+"Transmission:"+linearr[7]+newline+"Price:£"+linearr[8]+newline+"Arrival Date:"+linearr[9]+newline);	
							    found=true;
							}
							
						}
					}
					//
				}
				
				
			}
				if(found==false) {JOptionPane.showMessageDialog(null,"Car not found or no longer available","Not Found!",JOptionPane.ERROR_MESSAGE);}
			}
		});
		btnSearchCriteria.setBounds(214, 142, 147, 29);
		frame.getContentPane().add(btnSearchCriteria);
		
		JLabel lblColour = new JLabel("Colour:");
		lblColour.setBounds(6, 224, 61, 16);
		frame.getContentPane().add(lblColour);
		
		txtSearchColour = new JTextField();
		txtSearchColour.setBounds(58, 219, 130, 26);
		frame.getContentPane().add(txtSearchColour);
		txtSearchColour.setColumns(10);
		
		JButton btnSearchCriteria_1 = new JButton("Search Criteria 2");
		btnSearchCriteria_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaSearch.selectAll();
				textAreaSearch.replaceSelection("");
				boolean found=false;
				if((txtSearchColour.getText().isEmpty())) {
					JOptionPane.showMessageDialog(null,"Please enter Car colour","ERROR!",JOptionPane.ERROR_MESSAGE);
				}else{
					List<String> Data_List = new ArrayList<String>();
					Data_List=readfile("cars-database");
					final String newline = "\n";
					String[] linearr=new String[11];
					String colour=(txtSearchColour.getText()).toLowerCase();
					for (String line:Data_List) {
						linearr =line.split(",");
						if(!(linearr[2].contains("Van"))) {
							if (linearr[3].toLowerCase().contains(colour)) {
								found=true;
								if(linearr.length<10) {
								textAreaSearch.append("Number Plate:"+linearr[0]+newline+"Model:"+linearr[1]+newline+"Car Type:"+linearr[2]+newline+"Colour:"+linearr[3]+newline+"Mileage:"+linearr[4]+newline+"Transmission:"+linearr[6]+newline+"Price:£"+linearr[7]+newline+"Arrival Date:"+linearr[8]+newline);
								textAreaSearch.append(newline);
							}
						}
						}else {
							if (colour.contains(linearr[4].toLowerCase())){
								found=true;
								if(linearr.length<11) {
									textAreaSearch.append("Number Plate:"+linearr[0]+newline+"Model:"+linearr[1]+newline+"Car Type:"+linearr[2]+newline+"Size:"+linearr[3]+newline+"Colour:"+linearr[4]+newline+"Mileage:"+linearr[5]+newline+"Transmission:"+linearr[7]+newline+"Price:£"+linearr[8]+newline+"Arrival Date:"+linearr[9]+newline);
									textAreaSearch.append(newline);
								}
							}
						}
					}
					if(found==false) {JOptionPane.showMessageDialog(null,"Car colour not found or no longer available","Colour not Found!",JOptionPane.ERROR_MESSAGE);}
				}
			}
		});
		btnSearchCriteria_1.setBounds(198, 219, 147, 29);
		frame.getContentPane().add(btnSearchCriteria_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(6, 252, 475, 12);
		frame.getContentPane().add(separator_1);
		
		JLabel lblCriteria_2 = new JLabel("Criteria 3: Search by minimum and maximum number of seats");
		lblCriteria_2.setBounds(6, 263, 454, 16);
		frame.getContentPane().add(lblCriteria_2);
		
		JLabel lblMin = new JLabel("Min:");
		lblMin.setBounds(6, 291, 61, 16);
		frame.getContentPane().add(lblMin);
		
		JLabel lblMax = new JLabel("Max:");
		lblMax.setBounds(94, 291, 35, 16);
		frame.getContentPane().add(lblMax);
		
		txtMin = new JTextField();
		txtMin.setBounds(39, 286, 35, 26);
		frame.getContentPane().add(txtMin);
		txtMin.setColumns(10);
		
		txtMax = new JTextField();
		txtMax.setBounds(124, 286, 35, 26);
		frame.getContentPane().add(txtMax);
		txtMax.setColumns(10);
		
		JButton btnSearchCriteria_2 = new JButton("Search Criteria 3");
		btnSearchCriteria_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaSearch.selectAll();
				textAreaSearch.replaceSelection("");
				boolean found=false;
				if(txtMin.getText().isEmpty() || txtMax.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Please enter Car model and transmission OR enter a colours","ERROR!",JOptionPane.ERROR_MESSAGE);
					found=true;
				}else {
					List<String> Data_List = new ArrayList<String>();
					Data_List=readfile("cars-database");
					final String newline = "\n";
					String[] linearr=new String[11];
					int min=Integer.parseInt(txtMin.getText());
					int max=Integer.parseInt(txtMax.getText());
					for (String line:Data_List) {
						linearr =line.split(",");
						if((linearr[2].contains("Coupe")) && Coupe.numofSeats>=min && Coupe.numofSeats<=max) {
							if(linearr.length<10) {
								textAreaSearch.append("Number Plate:"+linearr[0]+newline+"Model:"+linearr[1]+newline+"Car Type:"+linearr[2]+newline+"Colour:"+linearr[3]+newline+"Mileage:"+linearr[4]+newline+"Transmission:"+linearr[6]+newline+"Price:£"+linearr[7]+newline+"Arrival Date:"+linearr[8]+newline);
								textAreaSearch.append(newline);
								found=true;
							
						    }
					}else if((linearr[2].contains("Hatchback")) && Hatchback.numofSeats>=min && Hatchback.numofSeats<=max) {
						if(linearr.length<10) {
							textAreaSearch.append("Number Plate:"+linearr[0]+newline+"Model:"+linearr[1]+newline+"Car Type:"+linearr[2]+newline+"Colour:"+linearr[3]+newline+"Mileage:"+linearr[4]+newline+"Transmission:"+linearr[6]+newline+"Price:£"+linearr[7]+newline+"Arrival Date:"+linearr[8]+newline);
							textAreaSearch.append(newline);
							found=true;
						
					    }
					} else if((linearr[2].contains("MPV")) && MPV.numofSeats>=min && MPV.numofSeats<=max) {
						if(linearr.length<10) {
							textAreaSearch.append("Number Plate:"+linearr[0]+newline+"Model:"+linearr[1]+newline+"Car Type:"+linearr[2]+newline+"Colour:"+linearr[3]+newline+"Mileage:"+linearr[4]+newline+"Transmission:"+linearr[6]+newline+"Price:£"+linearr[7]+newline+"Arrival Date:"+linearr[8]+newline);
							textAreaSearch.append(newline);
							found=true;
					    }
					}else if((linearr[2].contains("SUV")) && SUV.numofSeats>=min && SUV.numofSeats<=max) {
						if(linearr.length<10) {
							textAreaSearch.append("Number Plate:"+linearr[0]+newline+"Model:"+linearr[1]+newline+"Car Type:"+linearr[2]+newline+"Colour:"+linearr[3]+newline+"Mileage:"+linearr[4]+newline+"Transmission:"+linearr[6]+newline+"Price:£"+linearr[7]+newline+"Arrival Date:"+linearr[8]+newline);
							textAreaSearch.append(newline);
							found=true;
					    }
					}else if((linearr[2].contains("Saloon")) && Saloon.numofSeats>=min && Saloon.numofSeats<=max) {
						if(linearr.length<10) {
							textAreaSearch.append("Number Plate:"+linearr[0]+newline+"Model:"+linearr[1]+newline+"Car Type:"+linearr[2]+newline+"Colour:"+linearr[3]+newline+"Mileage:"+linearr[4]+newline+"Transmission:"+linearr[6]+newline+"Price:£"+linearr[7]+newline+"Arrival Date:"+linearr[8]+newline);
							textAreaSearch.append(newline);
							found=true;
					    }
					}else if((linearr[2].contains("Van")) && Van.numofSeats>=min && Van.numofSeats<=max) {
						if(linearr.length<11) {
							textAreaSearch.append("Number Plate:"+linearr[0]+newline+"Model:"+linearr[1]+newline+"Car Type:"+linearr[2]+newline+"Size:"+linearr[3]+newline+"Colour:"+linearr[4]+newline+"Mileage:"+linearr[5]+newline+"Transmission:"+linearr[7]+newline+"Price:£"+linearr[8]+newline+"Arrival Date:"+linearr[9]+newline);
							textAreaSearch.append(newline);
							found=true;
						}
					}
					}
						
				}
				if(found==false) {JOptionPane.showMessageDialog(null,"Invalid number of seats or no cars available","Car not Found!",JOptionPane.ERROR_MESSAGE);}
			}
		});
		btnSearchCriteria_2.setBounds(191, 286, 147, 29);
		frame.getContentPane().add(btnSearchCriteria_2);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(6, 319, 480, 12);
		frame.getContentPane().add(separator_2);
		
		JLabel lblCriteria_3 = new JLabel("Criteria 4: Search by van size");
		lblCriteria_3.setBounds(6, 333, 283, 16);
		frame.getContentPane().add(lblCriteria_3);
		
		JLabel lblVanSize = new JLabel("Van Size:");
		lblVanSize.setBounds(6, 357, 61, 16);
		frame.getContentPane().add(lblVanSize);
		
		txtVanSize = new JTextField();
		txtVanSize.setBounds(68, 352, 130, 26);
		frame.getContentPane().add(txtVanSize);
		txtVanSize.setColumns(10);
		
		JButton btnSearchCriteria_3 = new JButton("Search Criteria 4");
		btnSearchCriteria_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaSearch.selectAll();
				textAreaSearch.replaceSelection("");
				if(txtVanSize.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Please enter Van size","ERROR!",JOptionPane.ERROR_MESSAGE);
				}else {
					List<String> Data_List = new ArrayList<String>();
					Data_List=readfile("cars-database");
					final String newline = "\n";
					boolean found=false;
					String[] linearr=new String[11];
					String size=txtVanSize.getText().toLowerCase();
					for (String line:Data_List) {
						linearr =line.split(",");
						if((linearr[2].contains("Van"))) {
							if (linearr[3].toLowerCase().contains(size)) {
								found=true;
								if(linearr.length<11) {
									textAreaSearch.append("Number Plate:"+linearr[0]+newline+"Model:"+linearr[1]+newline+"Car Type:"+linearr[2]+newline+"Size:"+linearr[3]+newline+"Colour:"+linearr[4]+newline+"Mileage:"+linearr[5]+newline+"Transmission:"+linearr[7]+newline+"Price:£"+linearr[8]+newline+"Arrival Date:"+linearr[9]+newline);
									textAreaSearch.append(newline);
								}	
								}
						}
					}
			
				if(found==false) {JOptionPane.showMessageDialog(null,"Van size not found or vans with serached size no longer available","Vans not Found!",JOptionPane.ERROR_MESSAGE);}
				}
			}
		});
		btnSearchCriteria_3.setBounds(198, 352, 147, 29);
		frame.getContentPane().add(btnSearchCriteria_3);
		
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
		btnExit.setBounds(877, 0, 117, 29);
		frame.getContentPane().add(btnExit);
		
		JButton btnLogout = new JButton("Logout ");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				main.Loginsys.Loginsystem.main(null);
			}
		});
		btnLogout.setBounds(765, 0, 117, 29);
		frame.getContentPane().add(btnLogout);
		
		JButton btnClear = new JButton("Clear ");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaSearch.selectAll();
				textAreaSearch.replaceSelection("");
			}
		});
		btnClear.setBounds(877, 51, 117, 29);
		frame.getContentPane().add(btnClear);
		
	}
}
