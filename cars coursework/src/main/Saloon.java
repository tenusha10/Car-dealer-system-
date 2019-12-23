package main;
/**
 * creates objects of type Saloon
 * @author tenusha
 *
 */
public class Saloon extends Car {
	//class saloon inherits superclass Car
	public static int numofDoors=5, numofSeats=5;
	public Saloon(String regnumber,String model,String carType  ,String colour, String accHistory, String trans,int mileage, int price, String aDate, String sDate) {
		super(regnumber,model,carType ,colour, accHistory, trans, mileage, price, aDate, sDate);
	}
}
