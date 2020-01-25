
import java.util.ArrayList;
import java.util.List;

public class Parts {

}


interface Component {
	public String getName();
    public int getArea();
	public int getPrice();
}



class Leaf implements Component
{
	private String name;
	private int area;
	private int price;
	
	public Leaf(String name, int area, int price) {
		this.name = name;
		this.area = area;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Leaf [name=" + name + ", area=" + area + ", price=" + price + "]";
	}
}
class Flat implements Component
{
	 String name;
	 int no;

	public Flat(String name, int no) {
		super();
		this.name = name;
		this.no = no;
	
	}
	List<Component> l =new ArrayList<Component>();
	public void add(Component str)
	{
		l.add(str);
	}
	public void totalCost()
	{
		System.out.println("Flat name :"+this.name+" Flat no :"+this.no);
		System.out.println("--------------------------------------------------------------");
		int total=0,total1=0;
		for(Component l1:l)
		{

		total+=l1.getPrice();
		total1+=l1.getArea();
		System.out.println("Name :"+l1.getName()+ " area sq_feet :"+l1.getArea());
		}
		System.out.println("Total price :"+total+"\nTotal Area :"+total1 +" sq_feet");
	    System.out.println("--------------------------------------------------------------");
	}
	

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getArea() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
class Worker{
	
	private String name;
	private String job;
	private int id;
	private int age;
	public Worker() {}
	public Worker(String name, int id, int age,String job) {

		this.name = name;
		this.id = id;
		this.age = age;
		this.job=job;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Worker [name=" + name + ", job=" + job + ", id=" + id + ", age=" + age + "]";
	}	
	
	
}
class Floor {
	List<Flat> flats = new ArrayList<Flat>();
	private String name;
	public Floor(){}
	public Floor(String name,List<Flat> flats) {
		super();
		this.flats = flats;
		this.name = name;
	}
	
	public List<Flat> getFlats() {
		return flats;
	}
	public void setFlats(List<Flat> flats) {
		this.flats = flats;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void display()
	{
		for(Flat l1:flats)
		{

		System.out.println("name :"+l1.getName());
		}

		
	}

}


