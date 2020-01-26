package ShoppingCart;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "ORDERS")
public class Orders {
private int O_Id;
private int O_no;
private Collection<Payment> pays = new HashSet<Payment>(0);
public Orders() {
}
public Orders(int O_no,Collection<Payment> pays) {
this.O_no=O_no;
this.pays=pays;
}
@Id
@GeneratedValue
@Column(name = "ORDER_ID")
public int getO_Id() {
	return O_Id;
}
public void setO_Id(int o_Id) {
	O_Id = o_Id;
}

@Column(name = "Order_NO")
public int getO_no() {
	return O_no;
}
public void setO_no(int o_no) {
	O_no = o_no;
}

@OneToMany(cascade = CascadeType.ALL)
@JoinTable(name = "ORDER_PAYMENT", joinColumns = { @JoinColumn(name = "ORDER_ID") }, inverseJoinColumns = { @JoinColumn(name = "PAYMENT_ID") })
public Collection<Payment> getPays() {
	return pays;
}
public void setPays(Collection<Payment> pays) {
	this.pays = pays;
}

}
