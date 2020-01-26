package ShoppingCart;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
  private String street;
  private String city;
  private int pincode;

public int getPincode() {
	return pincode;
}
public void setPincode(int pincode) {
	this.pincode = pincode;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
}
