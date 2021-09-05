package webapp.PersonalShopper.git;

public class Customer {
	protected String name;
	protected String password;
	protected String dob;
	protected String address;
	protected String email;
	protected String phone;
	
	public Customer() {}
	
	public Customer(String name, String password, String dob, String address, String email, String phone) {
		super();
		this.name = name;
		this.password = password;
		this.dob = dob;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}
	
	public String getName() {
	return name;
	}
	
	public void setName(String name) {
	this.name = name;
	}
	
	public String getPassword() {
	return password;
	}
	
	public void setPassword(String password) {
	this.password = password;
	}
	
	public String getDob() {
		return dob;
		}
	public void setDob(String dob) {
	this.dob = dob;
	}
	
	public String getAddress() {
		return address;
		}
		
	public void setAddress(String address) {
	this.address = address;
	}
	
	public String getEmail() {
	return email;
	}
	public void setEmail(String email) {
	this.email = email;
	}
	
	public String getPhone() {
	return phone;
	}
	public void setPhone(String phone) {
	this.phone = phone;
	}
	}
