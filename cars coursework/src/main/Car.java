package main;
import java.time.LocalDate;
/**
 * this class allows to create objects of type car
 * @author tenusha
 *
 */
public class Car extends Vehicle {
	//attributes to create a class 
	public String regnumber;
	public String model;
	public  String carType;
	public String colour;
	public String accidentHistory;
	public String transmission;
	public LocalDate arrivalDate ;
	public LocalDate sellDate;
	public int mileage, price;
//Constructor to create a Car;
public  Car(String regnumber, String model, String carType ,String colour, String accHistory, String trans, int mileage, int price, String aDate, String sDate ) {
	this.regnumber=regnumber;
	this.model=model;
	this.carType=carType;
	this.colour=colour;
	this.accidentHistory=accHistory;
	this.transmission=trans;
	this.mileage=mileage;
	this.price=price;
	LocalDate arrivalDate = LocalDate.parse(aDate);
	this.arrivalDate=arrivalDate;
	if(sDate=="") {
		sellDate=LocalDate.now();
	}else {
	LocalDate sellDate = LocalDate.parse(sDate);
	this.sellDate=sellDate;
	}
	
	
}

}
