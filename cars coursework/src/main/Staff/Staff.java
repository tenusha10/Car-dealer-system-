package main.Staff;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import main.Car;
import main.Coupe;
import main.Hatchback;
import main.MPV;
import main.SUV;
import main.Saloon;
import main.Van;

import main.Car;
import main.Coupe;
import main.Hatchback;
import main.MPV;
import main.SUV;
import main.Saloon;
import main.Van;
import main.Admin.Admin_GUI;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Class contains all the methods used to implement the functionality of admin and staff on the program
 * @author tenusha
 */

public  abstract class Staff {
	/**
	 * method returns contents of the given file name
	 * @param filename
	 * @return List<String> containing contents of given file
	 */
	public final List<String> readfile(String name) {
		List<String> filecpy = new ArrayList<String>();
		String filename=name; //passed parameter
		try {
		      File myObj = new File(".//txtfiles//"+filename+".txt"); //define file source and create new file object
		      Scanner myReader = new Scanner(myObj); 
		      while (myReader.hasNextLine()) { //reads file line by line 
		        String line = myReader.nextLine();
		        filecpy.add(line); //add data into an array list
		      }
		      myReader.close();
		    } catch (FileNotFoundException l) { //catches file not found exception
		      System.out.println("An error occurred.");
		      l.printStackTrace();
		    }
		return filecpy; //returns array list
	}
	/**
	 * Method gets the users inputs and create a Car object and add it the file car-database
	 * @param txtNumberPlate
	 * @param txtModel
	 * @param textVanSize
	 * @param txtColour
	 * @param txtAccHistory
	 * @param txtArrivalD
	 * @param txtSellD
	 * @param txtMileage
	 * @param txtPrice
	 * @param comboBoxCarType
	 * @param comboBoxTransmission
	 */
	public final void addCar(JTextField txtNumberPlate, JTextField txtModel,JTextField textVanSize, JTextField txtColour,JTextField txtAccHistory,JTextField txtArrivalD,JTextField txtSellD,JTextField txtMileage
			,JTextField txtPrice,JComboBox comboBoxCarType, JComboBox comboBoxTransmission ) {
		String numberplate= null, model= null, carType = null, vansize= null,colour= null, accHistory= null,transmission= null, arrivaldate= null, selldate= null;
		int mileage=0, price=0;
		boolean notsold=false;
		boolean valid=false;
		// statement validates all the necessary inputs are entered by the user
		if(txtNumberPlate.getText().isEmpty() || txtModel.getText().isEmpty()|| txtColour.getText().isEmpty()||txtAccHistory.getText().isEmpty()
				|| txtPrice.getText().isEmpty() ||txtMileage.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Please enter text to all fields applicable");
		}else {
			numberplate=txtNumberPlate.getText();
			model=txtModel.getText();
			vansize=textVanSize.getText();
			colour=txtColour.getText();
			accHistory=txtAccHistory.getText();
			//if arrival date is blank current date is set;
			if (txtArrivalD.getText().isEmpty()){
				LocalDate ldObj = LocalDate.now();
				arrivaldate=ldObj.toString();
			} else {arrivaldate=(String)txtArrivalD.getText();}
			//the program handles case when sell date is left blank as it assumes car is not sold yet
			if(txtSellD.getText().isEmpty()) {
				selldate="";
				notsold=true;
			}else {selldate=(String)txtSellD.getText();}
			mileage=Integer.parseInt(txtMileage.getText());
			price=Integer.parseInt(txtPrice.getText());
			carType=(String) comboBoxCarType.getSelectedItem();
			transmission=(String)comboBoxTransmission.getSelectedItem();
			transmission=transmission.toLowerCase();
			valid=true;
		}
		//reads the cars database file to check the number plate already exists-validation
		List<String> Car_check_List = new ArrayList<String>();
		Car_check_List=readfile("cars-database");
		for(String line:Car_check_List) {
			String[] arr=line.split(",");
			if(arr[0].contains(numberplate)) {
				valid=false;
				JOptionPane.showMessageDialog(null,"Car already exists!");
				break;
			}
		}
		// if all validation checks pass then the function executes
		if(valid==true) {
			List<String> Car_List = new ArrayList<String>();
			String written;
			Car_List=readfile("cars-database");//calls function to read a file and return a string array-list
			if(carType=="Van") { //checks car type and creates the appropriate object
				//van class constructor called
				Van van1= new Van(numberplate,model,carType,colour,accHistory,transmission,vansize,mileage,price,arrivaldate,selldate);
				if(notsold==true) {
					//creates the string to be written to file
					written = String.join(",",van1.regnumber,van1.model,van1.carType,van1.size,van1.colour,Integer.toString(van1.mileage),van1.accidentHistory,van1.transmission,Integer.toString(van1.price),(van1.arrivalDate).toString(),"");	
				}else {
				 written = String.join(",",van1.regnumber,van1.model,van1.carType,van1.size,van1.colour,Integer.toString(van1.mileage),van1.accidentHistory,van1.transmission,Integer.toString(van1.price),(van1.arrivalDate).toString(),(van1.sellDate).toString());		
				}
				Car_List.add(written);//adds to the existing data list 
				BufferedWriter bw = null; 
				try {
					bw = new BufferedWriter(new FileWriter(".//txtfiles//cars-database.txt"));
					for(String u : Car_List) {
						bw.write(u+"\n"); // each line in array list is written back to the file
					}
				}catch(FileNotFoundException e1) { //handles file not found exception
					System.err.println(e1.getMessage()); 
					e1.printStackTrace();
				} catch(IOException e1) { 
					System.err.println(e1.getMessage()); 
					e1.printStackTrace();
				}finally{
					try {
				    	if(bw != null) { 
				    		bw.close();
				    	      }
				    	    }catch(IOException e1) {
				    	    	System.err.println(e1.getMessage( ));
				    	    	e1.printStackTrace();
				    	    }
				    	} 
				JOptionPane.showMessageDialog(null,"Car added to database"); 
			/* same approach done for all other type of cars */
			}else if (carType=="SUV") {
				SUV suv1= new SUV(numberplate,model,carType,colour,accHistory,transmission,mileage,price,arrivaldate,selldate);
				if(notsold==true) {
					written = String.join(",",suv1.regnumber,suv1.model,suv1.carType,suv1.colour,Integer.toString(suv1.mileage),suv1.accidentHistory,suv1.transmission,Integer.toString(suv1.price),(suv1.arrivalDate).toString(),"");	
				}else {
				 written = String.join(",",suv1.regnumber,suv1.model,suv1.carType,suv1.colour,Integer.toString(suv1.mileage),suv1.accidentHistory,suv1.transmission,Integer.toString(suv1.price),(suv1.arrivalDate).toString(),(suv1.sellDate).toString());		
				}
				Car_List.add(written);
				BufferedWriter bw = null; 
				try {
					bw = new BufferedWriter(new FileWriter(".//txtfiles//cars-database.txt"));
					for(String u : Car_List) {
						bw.write(u+"\n");
					}
				}catch(FileNotFoundException e1) { 
					System.err.println(e1.getMessage()); e1.printStackTrace();
				} catch(IOException e1) { 
					System.err.println(e1.getMessage()); 
					e1.printStackTrace();
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
				    	} 
				JOptionPane.showMessageDialog(null,"Car added to database");
			}else if (carType=="MPV") {
				MPV mpv1= new MPV(numberplate,model,carType,colour,accHistory,transmission,mileage,price,arrivaldate,selldate);
				if(notsold==true) {
					written = String.join(",",mpv1.regnumber,mpv1.model,mpv1.carType,mpv1.colour,Integer.toString(mpv1.mileage),mpv1.accidentHistory,mpv1.transmission,Integer.toString(mpv1.price),(mpv1.arrivalDate).toString(),"");	
				}else {
				 written = String.join(",",mpv1.regnumber,mpv1.model,mpv1.carType,mpv1.colour,Integer.toString(mpv1.mileage),mpv1.accidentHistory,mpv1.transmission,Integer.toString(mpv1.price),(mpv1.arrivalDate).toString(),(mpv1.sellDate).toString());		
				}
				Car_List.add(written);
				BufferedWriter bw = null; 
				try {
					bw = new BufferedWriter(new FileWriter(".//txtfiles//cars-database.txt"));
					for(String u : Car_List) {
						bw.write(u+"\n");
					}
				}catch(FileNotFoundException e1) { 
					System.err.println(e1.getMessage()); e1.printStackTrace();
				} catch(IOException e1) { 
					System.err.println(e1.getMessage()); 
					e1.printStackTrace();
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
				    	} 
				JOptionPane.showMessageDialog(null,"Car added to database");
			}else if (carType=="Saloon") {
				Saloon saloon1= new Saloon(numberplate,model,carType,colour,accHistory,transmission,mileage,price,arrivaldate,selldate);
				if(notsold==true) {
					written = String.join(",",saloon1.regnumber,saloon1.model,saloon1.carType,saloon1.colour,Integer.toString(saloon1.mileage),saloon1.accidentHistory,saloon1.transmission,Integer.toString(saloon1.price),(saloon1.arrivalDate).toString(),"");	
				}else {
				 written = String.join(",",saloon1.regnumber,saloon1.model,saloon1.carType,saloon1.colour,Integer.toString(saloon1.mileage),saloon1.accidentHistory,saloon1.transmission,Integer.toString(saloon1.price),(saloon1.arrivalDate).toString(),(saloon1.sellDate).toString());		
				}
				Car_List.add(written);
				BufferedWriter bw = null; 
				try {
					bw = new BufferedWriter(new FileWriter(".//txtfiles//cars-database.txt"));
					for(String u : Car_List) {
						bw.write(u+"\n");
					}
				}catch(FileNotFoundException e1) { 
					System.err.println(e1.getMessage()); e1.printStackTrace();
				} catch(IOException e1) { 
					System.err.println(e1.getMessage()); 
					e1.printStackTrace();
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
				    	} 
				JOptionPane.showMessageDialog(null,"Car added to database");
			}else if(carType=="Coupe") {
				Coupe coupe1=new Coupe(numberplate,model,carType,colour,accHistory,transmission,mileage,price,arrivaldate,selldate);
				if(notsold==true) {
					written = String.join(",",coupe1.regnumber,coupe1.model,coupe1.carType,coupe1.colour,Integer.toString(coupe1.mileage),coupe1.accidentHistory,coupe1.transmission,Integer.toString(coupe1.price),(coupe1.arrivalDate).toString(),"");	
				}else {
				 written = String.join(",",coupe1.regnumber,coupe1.model,coupe1.carType,coupe1.colour,Integer.toString(coupe1.mileage),coupe1.accidentHistory,coupe1.transmission,Integer.toString(coupe1.price),(coupe1.arrivalDate).toString(),(coupe1.sellDate).toString());		
				}
				Car_List.add(written);
				BufferedWriter bw = null; 
				try {
					bw = new BufferedWriter(new FileWriter(".//txtfiles//cars-database.txt"));
					for(String u : Car_List) {
						bw.write(u+"\n");
					}
				}catch(FileNotFoundException e1) { 
					System.err.println(e1.getMessage()); e1.printStackTrace();
				} catch(IOException e1) { 
					System.err.println(e1.getMessage()); 
					e1.printStackTrace();
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
				    	} 
				JOptionPane.showMessageDialog(null,"Car added to database");
			}else {
				Hatchback hatch1=new Hatchback(numberplate,model,carType,colour,accHistory,transmission,mileage,price,arrivaldate,selldate);
				if(notsold==true) {
					written = String.join(",",hatch1.regnumber,hatch1.model,hatch1.carType.toString(),hatch1.colour,Integer.toString(hatch1.mileage),hatch1.accidentHistory,hatch1.transmission.toString(),Integer.toString(hatch1.price),(hatch1.arrivalDate).toString(),"");	
				}else {
				 written = String.join(",",hatch1.regnumber,hatch1.model,hatch1.carType.toString(),hatch1.colour,Integer.toString(hatch1.mileage),hatch1.accidentHistory,hatch1.transmission.toString(),Integer.toString(hatch1.price),(hatch1.arrivalDate).toString(),(hatch1.sellDate).toString());		
				}
				Car_List.add(written);
				BufferedWriter bw = null; 
				try {
					bw = new BufferedWriter(new FileWriter(".//txtfiles//cars-database.txt"));
					for(String u : Car_List) {
						bw.write(u+"\n");
					}
				}catch(FileNotFoundException e1) { 
					System.err.println(e1.getMessage()); e1.printStackTrace();
				} catch(IOException e1) { 
					System.err.println(e1.getMessage()); 
					e1.printStackTrace();
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
				    	} 
				JOptionPane.showMessageDialog(null,"Car added to database");
			}
		
	}
	}
	/**
	 * opens a file chooser for user to browse and select a file to import cars onto database
	 * @param txtSelectedFile
	 * @return adds contents on file to database
	 */
	public final void add_List_Of_Cars( JTextField txtSelectedFile) {
		String name=null;
		boolean Duplicates=false;
		boolean fileselected=false;
		JFileChooser jfc = new JFileChooser();
		int returnValue = jfc.showOpenDialog(null); // Show up the dialog box 
		if (returnValue == JFileChooser.APPROVE_OPTION) { // Check if the user selects a file or not
			fileselected=true;
		File selectedFile = jfc.getSelectedFile(); // Pick up the selected file
		txtSelectedFile.setText(selectedFile.getAbsolutePath()); //outputs file path
		name=selectedFile.getAbsolutePath();
		}
		if(fileselected==true) {
			List<String> Data_List = new ArrayList<String>();
			List<String> Database_List = new ArrayList<String>();
			Database_List=readfile("cars-database");
			/* reads the imported files contents into an array list */
			BufferedReader br = null;
			try {
			br = new BufferedReader(new FileReader(name));
			String line = null;
			String[] arr=new String[11];
			String written = null;
			while((line = br.readLine()) != null){
				/* section of code add an arrival date  if there isn't one */
				arr= line.split(",");
				if(!(arr[2].contains("Van"))) { //checks type does not equal van
					// code compensate for the fact that van has an extra attribute and other types doesn't
					if(arr.length<10) {
						if(arr[8].isBlank()) {
							LocalDate ldObj = LocalDate.now();
							// if arrival date is empty current date is set instead
							arr[8]=ldObj.toString();
							written=String.join(",",arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7],arr[8],"");
						}else {
							written=line;
						}
					}else {
						written=line;
					}
				}else { //when type is van 
					if(arr.length<11) {
						if(arr[9].isBlank()) {
						LocalDate ldObj = LocalDate.now();
						arr[9]=ldObj.toString();
						written=String.join(",",arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7],arr[8],arr[9],"");
						}else {written=line;}
					}else {
						written=line;
					}
				}
				Data_List.add(written); //data added to a array list
			}
			} catch(FileNotFoundException e1) {
			    System.err.println(e1.getMessage());
			e1.printStackTrace();
			} catch(IOException e1) {
			    System.err.println(e1.getMessage());
			    e1.printStackTrace();
			} finally { 
				try {
			      if(br != null) {
			    	  br.close();
			    	  }
			    	  } catch(IOException e1) {
			    	  System.err.println(e1.getMessage());
			    	        e1.printStackTrace();
			    	  } }
			
			/* adds the contents of the imported file into the array that already contains the data of the database */
			for(String newline:Data_List) {
				String[] newDataArr=newline.split(",");
				for(String existingline:Database_List) {
					String[] existingDataArr=existingline.split(",");
					if(existingDataArr[0].contains(newDataArr[0])) {
						String outputmessage=String.format("A car with  %s already exists, therefore car not added",newDataArr[0]);
						JOptionPane.showMessageDialog(null,outputmessage);
						Duplicates=true;
					}
				}
				Database_List.add(newline);
			}
			
			/* writes the contents of the databse_list into the file */
			if(Duplicates==true) {
				JOptionPane.showMessageDialog(null,"Please edit file!","Duplicate numberplates Found!",JOptionPane.ERROR_MESSAGE);
			}else {
			BufferedWriter bw = null; 
			try {
				bw = new BufferedWriter(new FileWriter(".//txtfiles//cars-database.txt"));
				for(String u : Database_List) {
					bw.write(u+"\n");
				}
			}catch(FileNotFoundException e1) { 
				System.err.println(e1.getMessage()); 
				e1.printStackTrace();
			} catch(IOException e1) { 
				System.err.println(e1.getMessage()); 
				e1.printStackTrace();
			}finally{
				try {
			    	if(bw != null) { 
			    		bw.close();
			    	      }
			    	    }catch(IOException e1) {
			    	    	System.err.println(e1.getMessage( ));
			    	    	e1.printStackTrace();
			    	    }
			    	} 
			JOptionPane.showMessageDialog(null,"Car list added to database");
			    	  }
	
		}
	}
	/**
	 * Method searches for the given number plate and mark the cars sell date as the given sell date  
	 * @param txtSellCarREG
	 * @param txtSellDate
	 */
	public final void sellCar(JTextField txtSellCarREG, JTextField txtSellDate ) {
		if(txtSellCarREG.getText().isEmpty() || txtSellDate.getText().isEmpty() ) { //validation to fields are not empty
			JOptionPane.showMessageDialog(null,"Please enter a Reg number and a sell date in correct formats \"YY-MM-DD","ERROR!",JOptionPane.ERROR_MESSAGE);
		}else{String searched_Regnumber=txtSellCarREG.getText();
		boolean found=false;
		String sellDate=txtSellDate.getText();
		List<String> Data_List = new ArrayList<String>();
		Data_List=readfile("cars-database");
		String newline = null;
		int i=0 ,cpyi=0; //index variables
		for(String line:Data_List) {
			String[] arr =line.split(",");
			   if(searched_Regnumber.contains(arr[0])) { //searches for the numberplate 
				   if(!(arr[2].contains("Van"))) {
				   LocalDate ld1 = LocalDate.parse(sellDate); //parses string to date
				   LocalDate ld2 = LocalDate.parse(arr[8]); 
				   int comparison = ld1.compareTo(ld2);// validation check to see if sell date is before arrival date
				   if(comparison>=0) {
		        	if(arr.length<10) { //validation check to see if given car i already sold
		        	newline=String.join(",",arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7],arr[8],sellDate);
		        	cpyi=i; // variable stores the index in array of the record to be edited
		        	found=true; //flag set to true
		        	}
		        	else {
		        		JOptionPane.showMessageDialog(null,"Car already sold !","Warning!",JOptionPane.WARNING_MESSAGE); //warning  message 
		        	}
				   }else {
					   JOptionPane.showMessageDialog(null,"sale date cannot be before purchase date!","Warning!",JOptionPane.WARNING_MESSAGE);//validation fail error message
				   }
				}else { //when car type is van 
					  LocalDate ld1 = LocalDate.parse(sellDate); 
					   LocalDate ld2 = LocalDate.parse(arr[9]); 
					   int comparison = ld1.compareTo(ld2);
					   if(comparison>=0) {
			        	if(arr.length<11) {
			        	newline=String.join(",",arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7],arr[8],arr[9],sellDate);
			        	cpyi=i;
			        	found=true;
			        	}
			        	else {
			        		JOptionPane.showMessageDialog(null,"Car already sold !","Warning!",JOptionPane.WARNING_MESSAGE);
			        	}
					   }else {
						   JOptionPane.showMessageDialog(null,"sale date cannot be before purchase date!","Warning!",JOptionPane.WARNING_MESSAGE);
					   }
				   }
		        }
			   i++; //index incremented 
		}
		if(found==true) {
			Data_List.remove(cpyi); // old record at found index is removed
			Data_List.add(cpyi,newline);; //old record is replaced with new record with the sell date indicating car is sold 
			JOptionPane.showMessageDialog(null," plate found and marked as sold");
			BufferedWriter bw = null; //data written back to file
			try {
				bw = new BufferedWriter(new FileWriter(".//txtfiles//cars-database.txt"));
				for(String u : Data_List) {
					bw.write(u+"\n");
				}
			}catch(FileNotFoundException e1) { 
				System.err.println(e1.getMessage()); 
				e1.printStackTrace();
			} catch(IOException e1) { 
				System.err.println(e1.getMessage()); 
				e1.printStackTrace();
			}finally{
				try {
			    	if(bw != null) { 
			    		bw.close();
			    	      }
			    	    }catch(IOException e1) {
			    	    	System.err.println(e1.getMessage( ));
			    	    	e1.printStackTrace();
			    	    }
			    	}
			
		}else {
			JOptionPane.showMessageDialog(null,"Number plate not found","ERROR!",JOptionPane.ERROR_MESSAGE); //if flag was never changed indicates plate was not found another validation check
			}
	}
	}
	/**
	 * Calculates the total revenue for the given date
	 * @param txtDateofRevenue
	 * @return message of total revenue 
	 */
	public final void calculateRevenueForDay(JTextField txtDateofRevenue) {
		if(txtDateofRevenue.getText().isEmpty()) { //validation check empty text fields 
			JOptionPane.showMessageDialog(null,"Please enter a specific day  in correct format YY-MM-DD","ERROR!",JOptionPane.ERROR_MESSAGE);
		}else {
			String date=txtDateofRevenue.getText();
			LocalDate ld = LocalDate.parse(date); //parse string to date 
			String[] linearr=new String[11];
			List<String> Data_List = new ArrayList<String>();
			Data_List=readfile("cars-database");
			int revenue=0;
			for(String line:Data_List) {
				linearr =line.split(",");
				if(!(linearr[2].contains("Van"))) { //same construct as before to check if type is van or any other 
						if(linearr.length==10) {// checks if car is sold
						LocalDate dateinfile =LocalDate.parse(linearr[9]);
						int comparison = dateinfile.compareTo(ld); // checks if dates are same 
						if(comparison==0) {
							revenue+=Integer.parseInt(linearr[7]); //selling price added to total 
						}
						}
				}else {
					if(linearr.length==11) {
						LocalDate dateinfile =LocalDate.parse(linearr[10]);
						int comparison = dateinfile.compareTo(ld);
						if(comparison==0) {
							revenue+=Integer.parseInt(linearr[8]);
						}
					}
				}
	}
			String message= String.format("The Total Revenue for %s is: £%d",date,revenue); // total outputted 
			JOptionPane.showMessageDialog(null,message);
			}
	}
	/**
	 * Calculates the total revenue for the given month 
	 * @param txtTxtmonth
	 * @return message box stating the total revenue
	 */
	
	public final void calculateRevenueForMonth(JTextField txtTxtmonth) {
		if(txtTxtmonth.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Please enter a month YYYY-MM","ERROR!",JOptionPane.ERROR_MESSAGE);
		}else {
			/* code below gets users inputed month and get the first date of the month then executes a search +1 month between(upper and lower bound of the given month ) */
			String input_date =txtTxtmonth.getText();
			String MINday="-01";
			String dateMIN=input_date+MINday;
			LocalDate searchdateMIN = LocalDate.parse(dateMIN);
			LocalDate tempDate = LocalDate.parse(dateMIN);
			LocalDate searchdateMAX=tempDate.plusMonths(1);
			String[] linearr=new String[11];
			List<String> Data_List = new ArrayList<String>();
			Data_List=readfile("cars-database");
			int revenue=0;
			for(String line:Data_List) {
				linearr =line.split(",");
				if(!(linearr[2].contains("Van"))) {
						if(linearr.length==10) {
						LocalDate dateinfile =LocalDate.parse(linearr[9]);
						int comparisonMIN = dateinfile.compareTo(searchdateMIN); 
						int comparisonMAX = dateinfile.compareTo(searchdateMAX);
						if(comparisonMIN>=1 && comparisonMAX<=0) { // true if selldate falls between min and max possible date 
							revenue+=Integer.parseInt(linearr[7]);
						}
						}
				}else {
					if(linearr.length==11) {
						LocalDate dateinfile =LocalDate.parse(linearr[10]);
						int comparisonMIN = dateinfile.compareTo(searchdateMIN);
						int comparisonMAX = dateinfile.compareTo(searchdateMAX);
						if(comparisonMIN>=1 && comparisonMAX<=0) {
							revenue+=Integer.parseInt(linearr[8]);
						}
					}
				}
	}
			String message= String.format("The Total Revenue for %s is: £%d",input_date,revenue);
			JOptionPane.showMessageDialog(null,message);
			
			
		}
	}
	/**
	 * writes contents of database into cars-output file by splitting cars into sold and unsold list and sort former by arrival date and latter by selldate 
	 */
	public final void printcars() {
		List<Car> sold_carlist = new ArrayList<Car>();
		List<Car> unsold_carlist = new ArrayList<Car>();
		List<String> Data_List = new ArrayList<String>();
		Data_List=readfile("cars-database");
		String[] linearr=new String[11];
		for (String line:Data_List) {
			/* loops through all data in database file and adds sold cars into an array and unsold cars into a different array */
			linearr =line.split(",");
			if((linearr[2].contains("SUV"))) {
					if(linearr.length==10) {
						SUV suv = new SUV(linearr[0],linearr[1],linearr[2],linearr[3],linearr[5],linearr[7],Integer.parseInt(linearr[4]),Integer.parseInt(linearr[7]),linearr[8],linearr[9]);
						Car car = (Car) suv;
						sold_carlist.add(car);
					}else {
						SUV suv = new SUV(linearr[0],linearr[1],linearr[2],linearr[3],linearr[5],linearr[7],Integer.parseInt(linearr[4]),Integer.parseInt(linearr[7]),linearr[8],"");
						Car car = (Car) suv;
						unsold_carlist.add(car);
					}
			}else if(linearr[2].contains("MPV")){
				if(linearr.length==10) {
					MPV MPV = new MPV(linearr[0],linearr[1],linearr[2],linearr[3],linearr[5],linearr[7],Integer.parseInt(linearr[4]),Integer.parseInt(linearr[7]),linearr[8],linearr[9]);
					Car car = (Car) MPV;
					sold_carlist.add(car);
				}else {
					MPV MPV = new MPV(linearr[0],linearr[1],linearr[2],linearr[3],linearr[5],linearr[7],Integer.parseInt(linearr[4]),Integer.parseInt(linearr[7]),linearr[8],"");
					Car car = (Car) MPV;
					unsold_carlist.add(car);
				}
			}else if(linearr[2].contains("Saloon")){
				if(linearr.length==10) {
					Saloon Saloon = new Saloon(linearr[0],linearr[1],linearr[2],linearr[3],linearr[5],linearr[7],Integer.parseInt(linearr[4]),Integer.parseInt(linearr[7]),linearr[8],linearr[9]);
					Car car = (Car) Saloon;
					sold_carlist.add(car);
				}else {
					Saloon Saloon = new Saloon(linearr[0],linearr[1],linearr[2],linearr[3],linearr[5],linearr[7],Integer.parseInt(linearr[4]),Integer.parseInt(linearr[7]),linearr[8],"");
					Car car = (Car) Saloon;
					unsold_carlist.add(car);
				}
			}else if(linearr[2].contains("Coupe")){
				if(linearr.length==10) {
					Coupe Coupe = new Coupe(linearr[0],linearr[1],linearr[2],linearr[3],linearr[5],linearr[7],Integer.parseInt(linearr[4]),Integer.parseInt(linearr[7]),linearr[8],linearr[9]);
					Car car = (Car) Coupe;
					sold_carlist.add(car);
				}else {
					Coupe Coupe = new Coupe(linearr[0],linearr[1],linearr[2],linearr[3],linearr[5],linearr[7],Integer.parseInt(linearr[4]),Integer.parseInt(linearr[7]),linearr[8],"");
					Car car = (Car) Coupe;
					unsold_carlist.add(car);
				}
			}else if(linearr[2].contains("Hatchback")) {
				if(linearr.length==10) {
					Hatchback Hatchback = new Hatchback(linearr[0],linearr[1],linearr[2],linearr[3],linearr[5],linearr[7],Integer.parseInt(linearr[4]),Integer.parseInt(linearr[7]),linearr[8],linearr[9]);
					Car car = (Car) Hatchback;
					sold_carlist.add(car);
				}else {
					Hatchback Hatchback = new Hatchback(linearr[0],linearr[1],linearr[2],linearr[3],linearr[5],linearr[7],Integer.parseInt(linearr[4]),Integer.parseInt(linearr[7]),linearr[8],"");
					Car car = (Car) Hatchback;
					unsold_carlist.add(car);
				}
			}else {
				if (linearr.length==11){
					Van Van =new Van(linearr[0],linearr[1],linearr[2],linearr[4],linearr[6],linearr[7],linearr[3],Integer.parseInt(linearr[5]),Integer.parseInt(linearr[8]),linearr[9],linearr[10]);
					//               numberplate, model,    carType,   colour,    accHistory,transmission,vansize,mileage,price,arrivaldate,selldate
					Car car = (Car) Van;
					sold_carlist.add(car);
				}else {
					Van Van =new Van(linearr[0],linearr[1],linearr[2],linearr[4],linearr[6],linearr[7],linearr[3],Integer.parseInt(linearr[5]),Integer.parseInt(linearr[8]),linearr[9],"");
					Car car = (Car) Van;
					unsold_carlist.add(car); 
				}
			}
			
	}
		  /* Sorts the array list by arrival date and sell date */
	       Collections.sort(sold_carlist, new Comparator<Car>() {
	            public int compare(Car car1, Car car2) { //sorting function
	               return (car1.sellDate.compareTo(car2.sellDate));
	            }
	        });
	       Collections.sort(unsold_carlist, new Comparator<Car>() {
	            public int compare(Car car1, Car car2) {
	            	return (car1.arrivalDate.compareTo(car2.arrivalDate));
	            }
	        });
	       
	       BufferedWriter bw = null; 
	       String comma=","; //writes sorted arrays into a cars-output file
	       try {
				bw = new BufferedWriter(new FileWriter(".//txtfiles//cars-output.txt"));
				bw.write("Sold Cars: Sell date ascending orders"+"\n");
				bw.write(""+"\n");
				for(Car car : sold_carlist) {
					bw.write(car.regnumber+comma+car.model+comma+car.carType+comma+car.colour+comma+car.mileage+comma+car.accidentHistory+comma+car.transmission+comma+car.price+comma+car.arrivalDate+comma+car.sellDate+"\n");
				}
				bw.write(""+"\n");
				bw.write("Unsold Cars: Arrival date ascending orders"+"\n");
				bw.write(""+"\n");
				for(Car car : unsold_carlist) {
					bw.write(car.regnumber+comma+car.model+comma+car.carType+comma+car.colour+comma+car.mileage+comma+car.accidentHistory+comma+car.transmission+comma+car.price+comma+car.arrivalDate+"\n");
				}
				
			}catch(FileNotFoundException e1) { 
				System.err.println(e1.getMessage()); 
				e1.printStackTrace();
			} catch(IOException e1) { 
				System.err.println(e1.getMessage()); 
				e1.printStackTrace();
			}finally{
				try {
			    	if(bw != null) { 
			    		bw.close();
			    	      }
			    	    }catch(IOException e1) {
			    	    	System.err.println(e1.getMessage( ));
			    	    	e1.printStackTrace();
			    	    }
			    	} 
			JOptionPane.showMessageDialog(null,"Cars printed to cars-output file");
	      
	}
	/**
	 * searches for an unsold car that matches the data given by the user
	 * @param textAreaSearch
	 * @param txtSearchModel
	 * @param comboBoxSearchTransmission
	 */
	public final void searchcarModelandTransmission(JTextArea textAreaSearch,JTextField txtSearchModel, JComboBox comboBoxSearchTransmission) {
		textAreaSearch.selectAll();
		textAreaSearch.replaceSelection(""); //clears text area 
		boolean found=false;
		if(txtSearchModel.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Please enter Car model","ERROR!",JOptionPane.ERROR_MESSAGE);
		}else{
		final String newline = "\n";
		String[] linearr=new String[11];
		List<String> Data_List = new ArrayList<String>();
		Data_List=readfile("cars-database");
		String search_Model=(txtSearchModel.getText()).toLowerCase();
		String transmission=(((String) comboBoxSearchTransmission.getSelectedItem()).toLowerCase());
		for (String line:Data_List) {
			linearr =line.split(",");
			if(!(linearr[2].contains("Van"))) {
				//checks if there are unsold cars that matches the model and the given transmission
				if (search_Model.contains(linearr[1].toLowerCase()) && transmission.contains(linearr[6].toLowerCase())) { 
					if(linearr.length<10) {
					//adds data into text area 
					textAreaSearch.append("Number Plate:"+linearr[0]+newline+"Model:"+linearr[1]+newline+"Car Type:"+linearr[2]+newline+"Colour:"+linearr[3]+newline+"Mileage:"+linearr[4]+newline+"Accident History:"+linearr[5]+newline+"Transmission:"+linearr[6]+newline+"Price:£"+linearr[7]+newline+"Arrival Date:"+linearr[8]+newline);
					found=true;
				}
			}
			}else {
				if (search_Model.contains(linearr[1].toLowerCase()) && transmission.contains(linearr[7].toLowerCase())){
					if(linearr.length<11) {
						textAreaSearch.append("Number Plate:"+linearr[0]+newline+"Model:"+linearr[1]+newline+"Car Type:"+linearr[2]+newline+"Size:"+linearr[3]+newline+"Colour:"+linearr[4]+newline+"Mileage:"+linearr[5]+newline+"Accident History:"+linearr[6]+newline+"Transmission:"+linearr[7]+newline+"Price:£"+linearr[8]+newline+"Arrival Date:"+linearr[9]+newline);	
					    found=true;
					}
					
				}
			}
			
		}
	}
		if(found==false) {JOptionPane.showMessageDialog(null,"Car not found or no longer available","Not Found!",JOptionPane.ERROR_MESSAGE);}
	}
	/**
	 * searches for an unsold car that matches the given colour 
	 * @param textAreaSearch
	 * @param txtSearchColour
	 */
	public final void searchColour(JTextArea textAreaSearch,JTextField txtSearchColour) {
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
					if (linearr[3].toLowerCase().contains(colour)) { //same as before but checks colour
						if(linearr.length<10) {
						textAreaSearch.append("Number Plate:"+linearr[0]+newline+"Model:"+linearr[1]+newline+"Car Type:"+linearr[2]+newline+"Colour:"+linearr[3]+newline+"Mileage:"+linearr[4]+newline+"Accident History:"+linearr[5]+newline+"Transmission:"+linearr[6]+newline+"Price:£"+linearr[7]+newline+"Arrival Date:"+linearr[8]+newline);
						textAreaSearch.append(newline);
						found=true;
					}
				}
				}else {
					if (colour.contains(linearr[4].toLowerCase())){
						if(linearr.length<11) {
							textAreaSearch.append("Number Plate:"+linearr[0]+newline+"Model:"+linearr[1]+newline+"Car Type:"+linearr[2]+newline+"Size:"+linearr[3]+newline+"Colour:"+linearr[4]+newline+"Mileage:"+linearr[5]+newline+"Accident History:"+linearr[6]+newline+"Transmission:"+linearr[7]+newline+"Price:£"+linearr[8]+newline+"Arrival Date:"+linearr[9]+newline);
							textAreaSearch.append(newline);
							found=true;
						}
					}
				}
			}
			if(found==false) {JOptionPane.showMessageDialog(null,"Car colour not found or no longer available","Colour not Found!",JOptionPane.ERROR_MESSAGE);}
		}
	}
	/**
	 * searches for unsold cars that have number of seats between(included) the min and max provided by user
	 * @param textAreaSearch
	 * @param txtMin
	 * @param txtMax
	 */
	public final void searchMinMaxSeats(JTextArea textAreaSearch,JTextField txtMin,JTextField txtMax) {
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
				linearr =line.split(","); //each car type has a set number of seats
				//checks if any unsold cars exists between minimum and maximum number of seats 
				if((linearr[2].contains("Coupe")) && Coupe.numofSeats>=min && Coupe.numofSeats<=max) {
					if(linearr.length<10) { //checks if car is not sold
						textAreaSearch.append("Number Plate:"+linearr[0]+newline+"Model:"+linearr[1]+newline+"Car Type:"+linearr[2]+newline+"Colour:"+linearr[3]+newline+"Mileage:"+linearr[4]+newline+"Accident History:"+linearr[5]+newline+"Transmission:"+linearr[6]+newline+"Price:£"+linearr[7]+newline+"Arrival Date:"+linearr[8]+newline);
						textAreaSearch.append(newline);
						found=true;
					
				    }
			}else if((linearr[2].contains("Hatchback")) && Hatchback.numofSeats>=min && Hatchback.numofSeats<=max) {
				if(linearr.length<10) {
					textAreaSearch.append("Number Plate:"+linearr[0]+newline+"Model:"+linearr[1]+newline+"Car Type:"+linearr[2]+newline+"Colour:"+linearr[3]+newline+"Mileage:"+linearr[4]+newline+"Accident History:"+linearr[5]+newline+"Transmission:"+linearr[6]+newline+"Price:£"+linearr[7]+newline+"Arrival Date:"+linearr[8]+newline);
					textAreaSearch.append(newline);
					found=true;
				
			    }
			} else if((linearr[2].contains("MPV")) && MPV.numofSeats>=min && MPV.numofSeats<=max) {
				if(linearr.length<10) {
					textAreaSearch.append("Number Plate:"+linearr[0]+newline+"Model:"+linearr[1]+newline+"Car Type:"+linearr[2]+newline+"Colour:"+linearr[3]+newline+"Mileage:"+linearr[4]+newline+"Accident History:"+linearr[5]+newline+"Transmission:"+linearr[6]+newline+"Price:£"+linearr[7]+newline+"Arrival Date:"+linearr[8]+newline);
					textAreaSearch.append(newline);
					found=true;
			    }
			}else if((linearr[2].contains("SUV")) && SUV.numofSeats>=min && SUV.numofSeats<=max) {
				if(linearr.length<10) {
					textAreaSearch.append("Number Plate:"+linearr[0]+newline+"Model:"+linearr[1]+newline+"Car Type:"+linearr[2]+newline+"Colour:"+linearr[3]+newline+"Mileage:"+linearr[4]+newline+"Accident History:"+linearr[5]+newline+"Transmission:"+linearr[6]+newline+"Price:£"+linearr[7]+newline+"Arrival Date:"+linearr[8]+newline);
					textAreaSearch.append(newline);
					found=true;
			    }
			}else if((linearr[2].contains("Saloon")) && Saloon.numofSeats>=min && Saloon.numofSeats<=max) {
				if(linearr.length<10) {
					textAreaSearch.append("Number Plate:"+linearr[0]+newline+"Model:"+linearr[1]+newline+"Car Type:"+linearr[2]+newline+"Colour:"+linearr[3]+newline+"Mileage:"+linearr[4]+newline+"Accident History:"+linearr[5]+newline+"Transmission:"+linearr[6]+newline+"Price:£"+linearr[7]+newline+"Arrival Date:"+linearr[8]+newline);
					textAreaSearch.append(newline);
					found=true;
			    }
			}else if((linearr[2].contains("Van")) && Van.numofSeats>=min && Van.numofSeats<=max) {
				if(linearr.length<11) {
					textAreaSearch.append("Number Plate:"+linearr[0]+newline+"Model:"+linearr[1]+newline+"Car Type:"+linearr[2]+newline+"Size:"+linearr[3]+newline+"Colour:"+linearr[4]+newline+"Mileage:"+linearr[5]+newline+"Accident History:"+linearr[6]+newline+"Transmission:"+linearr[7]+newline+"Price:£"+linearr[8]+newline+"Arrival Date:"+linearr[9]+newline);
					textAreaSearch.append(newline);
					found=true;
				}
			}
			}
				
		}
		if(found==false) {JOptionPane.showMessageDialog(null,"Invalid number of seats or no cars available","Car not Found!",JOptionPane.ERROR_MESSAGE);}
	}
	/**
	 * searches for unsold vans that matches the given size
	 * @param textAreaSearch
	 * @param txtVanSizeSearch
	 */
	public final void searchVanSize(JTextArea textAreaSearch,JTextField txtVanSizeSearch) {
		textAreaSearch.selectAll();
		textAreaSearch.replaceSelection("");
		if(txtVanSizeSearch.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Please enter Van size","ERROR!",JOptionPane.ERROR_MESSAGE);
		}else {
			List<String> Data_List = new ArrayList<String>();
			Data_List=readfile("cars-database");
			final String newline = "\n";
			boolean found=false;
			String[] linearr=new String[11];
			String size=txtVanSizeSearch.getText().toLowerCase();
			for (String line:Data_List) {
				linearr =line.split(",");
				if((linearr[2].contains("Van"))) { //searches only for fans with given size 
					if (linearr[3].toLowerCase().contains(size)) {
						if(linearr.length<11) {
							textAreaSearch.append("Number Plate:"+linearr[0]+newline+"Model:"+linearr[1]+newline+"Car Type:"+linearr[2]+newline+"Size:"+linearr[3]+newline+"Colour:"+linearr[4]+newline+"Mileage:"+linearr[5]+newline+"Accident History:"+linearr[6]+newline+"Transmission:"+linearr[7]+newline+"Price:£"+linearr[8]+newline+"Arrival Date:"+linearr[9]+newline);
							textAreaSearch.append(newline);
							found=true;
						}	
						}
				}
			}
	
		if(found==false) {JOptionPane.showMessageDialog(null,"Van size not found or vans with serached size no longer available","Vans not Found!",JOptionPane.ERROR_MESSAGE);}
		}
	}

}
