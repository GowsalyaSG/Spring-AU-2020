package ShoppingCart;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorType;

@SuppressWarnings("serial") 
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Supplierwithdetails", discriminatorType = DiscriminatorType.STRING)
public class Suppliers implements Serializable{
    @Id
    private int sup_id;
    private String sup_name;
	public Suppliers() {}
	public Suppliers(int sup_id, String sup_name) {
		super();
		this.sup_id = sup_id;
		this.sup_name = sup_name;
		
	}
	public int getSup_id() {
		return sup_id;
	}
	public void setSup_id(int sup_id) {
		this.sup_id = sup_id;
	}
	public String getSup_name() {
		return sup_name;
	}
	public void setSup_name(String sup_name) {
		this.sup_name = sup_name;
	}
	
}
@Entity
class Supplier_details extends Suppliers{
	@Column
	private String company_name;
	private int phone;
	public Supplier_details() {}
	public Supplier_details( String company_name,int phone) {
		super();
		this.phone=phone;
		this.company_name = company_name;
		
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
}