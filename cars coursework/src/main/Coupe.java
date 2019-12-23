package main;
//class inherits the super class Car
/**
 * allows to create objects of type coupe
 * @author tenusha
 *
 */
public class Coupe extends Car {
	//class constants 
	public static int numofDoors=2;
	public static int numofSeats=2;
	//subclass constructor
	public Coupe(String regnumber,String model ,String carType ,String colour, String accHistory, String trans,int mileage, int price, String aDate, String sDate) {
		super(regnumber, model,carType,colour, accHistory, trans, mileage, price,aDate, sDate);
	}
}
