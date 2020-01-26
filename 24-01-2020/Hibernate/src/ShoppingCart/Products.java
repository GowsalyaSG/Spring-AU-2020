package ShoppingCart;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "Products", query = "SELECT * FROM Products", resultClass=Products.class)

public class Products {
@Id	
private int prod_id;
private String prod_name;
private int quantity;
@Override
public String toString() {
	return "Products [prod_id=" + prod_id + ", prod_name=" + prod_name + ", quantity=" + quantity + ", price=" + price
			+ "]";
}
private int price;


public int getProd_id() {
	return prod_id;
}
public void setProd_id(int prod_id) {
	this.prod_id = prod_id;
}
public String getProd_name() {
	return prod_name;
}
public void setProd_name(String prod_name) {
	this.prod_name = prod_name;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}

}
