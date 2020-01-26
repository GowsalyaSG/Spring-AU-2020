package ShoppingCart;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Payment {
private long phoneId;
private String phoneType;

public Payment() {
}
public Payment(String phoneType) {
this.phoneType = phoneType;

}
@Id
@GeneratedValue
@Column(name = "PHONE_ID")
public long getPhoneId() {
return this.phoneId;
}
public void setPhoneId(long phoneId) {
this.phoneId = phoneId;
}
@Column(name = "PHONE_TYPE", nullable = false, length=10)
public String getPhoneType() {
return this.phoneType;
}
public void setPhoneType(String phoneType) {
this.phoneType = phoneType;
}

}