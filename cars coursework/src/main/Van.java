package main;
//class inherited from superclass Car
/**
 * creates objects of type Van
 * @author tenusha
 *
 */
public class Van extends Car {
	//class attributes
	public String size;
	public static int numofDoors=5, numofSeats=3;
	public Van(String regnumber,String model, String carType ,String colour, String accHistory, String trans, String size,int mileage, int price,String aDate, String sDate) {
		super(regnumber,model,carType,colour, accHistory, trans, mileage, price, aDate, sDate);
		//contains extra attribute size
		this.size=size;
	}
	public static void main(String[] args) {
		
	}
}
