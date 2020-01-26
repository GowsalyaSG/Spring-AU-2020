package ShoppingCart;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Customers {
 @Id
 private int cust_id;
 private String cust_name;
 private int phone;


 @Embedded
 
 @AttributeOverrides({ 
 @AttributeOverride(name="street",column=@Column(name="HOME_STREET_NAME")),
 @AttributeOverride(name="city",column=@Column(name="HOME_city_NAME")),
 @AttributeOverride(name="pincode",column=@Column(name="HOME_PINCODE"))})
 private Address homeaddress;
 
 @Embedded
 
 @AttributeOverrides({
 
 @AttributeOverride(name="street",column=@Column(name="OFFICE_STREET_NAME")),
 
 @AttributeOverride(name="city",column=@Column(name="OFFICE_city_NAME")),
 @AttributeOverride(name="pincode",column=@Column(name="OFFICE_PINCODE"))})
 private Address officeaddress;

 
 
public Address getHomeaddress() {
	return homeaddress;
}
public void setHomeaddress(Address homeaddress) {
	this.homeaddress = homeaddress;
}
public Address getOfficeaddress() {
	return officeaddress;
}
public void setOfficeaddress(Address officeaddress) {
	this.officeaddress = officeaddress;
}
public int getCust_id() {
	return cust_id;
}
public void setCust_id(int cust_id) {
	this.cust_id = cust_id;
}
public String getCust_name() {
	return cust_name;
}
public void setCust_name(String cust_name) {
	this.cust_name = cust_name;
}
public int getPhone() {
	return phone;
}
public void setPhone(int phone) {
	this.phone = phone;
}

 
}
@Entity
 class Feedback extends Customers {
    @Column
	private String feed;

	public Feedback(String feed) {
		super();
		this.feed = feed;
	}

	public String getFeed() {
		return feed;
	}

	public void setFeed(String feed) {
		this.feed = feed;
	}

}