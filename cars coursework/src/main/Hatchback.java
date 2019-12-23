package main;
// class extends superclass Car
/**
 * creates objects of type hatchback
 * @author tenusha
 *
 */
public class Hatchback extends Car {
	//subclass constructor 
	public static int numofDoors=5, numofSeats=4;
	public Hatchback(String regnumber,String model,String carType  ,String colour, String accHistory, String trans,int mileage, int price, String aDate, String sDate) {
		super(regnumber,model,carType ,colour, accHistory, trans, mileage, price,aDate, sDate);
	}

}
