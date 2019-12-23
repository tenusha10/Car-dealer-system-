package main;
//user class 
/**
 * Class creates users for the system
 * @author tenusha
 *
 */
public class Users {
	public String Username;
	public String Password;
	public String Type;
	//class constructor;
	public Users(String username, String password, String type) {
		this.Username=username;
		this.Password=password;
		this.Type=type;
	}
}
