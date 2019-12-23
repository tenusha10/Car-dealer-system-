package main;
//class inherits superclass Car
/**
 * creates objects of type SUV
 * @author tenusha
 *
 */
public class SUV extends Car {
	public static int numofDoors=5, numofSeats=5;
	public SUV(String regnumber,String model,String carType  ,String colour, String accHistory, String trans,int mileage, int price, String aDate, String sDate) {
		super(regnumber, model,carType,colour, accHistory, trans, mileage, price, aDate, sDate);
	}
}
