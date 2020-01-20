
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
//Product object should have Product id , Product Name, Quantity Available and rate
// Order should have order id, user name and list of products
 class Product {
	int Id,quantity;
	int rate;
	String name;
	public Product(int Id, String name, int quantity,int rate) {
		this.Id = Id;
		this.name = name;
		this.quantity = quantity;
		this.rate =rate ;
}	
}
 class Order {
		HashMap<Integer, Integer> order = new HashMap<>();
		String username;
		int id;
		public Order(int id,HashMap<Integer, Integer> order, String username) {
			for(Map.Entry m:order.entrySet())
			{ 
			int key=(int)m.getKey();
			  int value=(int)m.getValue();
				this.order.put(key,value);
			}
			this.id = id;
			this.username = username;
		}
	}	
public class view {
	
	HashMap<Integer, Order> orders = new HashMap<Integer, Order>();
	HashMap<Integer,Product> listofproducts = new HashMap<Integer,Product>();
	
	List<Order> ordered = new ArrayList<Order>();
	HashMap<Integer, Integer> cartinshop = new HashMap<Integer, Integer>();
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		view v1 = new view();	
		v1.listofproducts.put(1,new Product(1, "Book", 1000, 100));
		v1.listofproducts.put(2,new Product(2, "pen", 1000, 10));
		v1.listofproducts.put(3,new Product(3, "pencil", 1000, 5));
		v1.listofproducts.put(4,new Product(4, "notes", 1000, 30));
		v1.listofproducts.put(5,new Product(5, "eraser", 1000, 5));

		System.out.println("welcome to our shop");
		System.out.println("Enter Your Name please");
		String username = s.next();
		boolean k = true;
		while(k) {
			System.out.println("Enter Your choice: \n1.show list_of_products \n2.Add product to cart 3.Remove product from cart.\n4.View the Cart 5.Placing Order 6.Canceling Order 7.Exit");
			int c = Integer.parseInt(s.next());
			switch(c) {
			case 1:
				v1.printListofproducts(v1.listofproducts);
				System.out.println("-----------------------------------------------------------");
				break;	
			case 2: 
					v1.addProductToCart();
					System.out.println("-----------------------------------------------------------");
					break;
			case 3:
					System.out.println("For Deleting,enter some details: ");
					System.out.println("Enter productid : ");
					int d = s.nextInt();
					System.out.println("Enter productname : ");
					String pname1= s.next();
					v1.deleteProductFromCart(d,pname1);
					System.out.println("-----------------------------------------------------------");
					break;
                case 4:
				if(v1.cartinshop.isEmpty()) {
					System.out.println("Cart is Empty");
					System.out.println("-----------------------------------------------------------");
                   break;
				}
				else {
				System.out.println("Your Cart:");
				int k1=1;
				for(int list : v1.cartinshop.keySet()) {
				 int total_amount = v1.cartinshop.get(list)* v1.listofproducts.get(list).rate;
				
				 System.out.println("s.no:"+k1+" Id: " +list+ " quantity: " + v1.cartinshop.get(list) + " Total: " + total_amount);
		         k1++;
				}
				System.out.println("-----------------------------------------------------------");

				break;}
				
			case 5:
				int t=v1.placingorder(username);
				System.out.println("-----------------------------------------------------------");

                break;

			case 6:
				if(v1.orders.isEmpty()) {
                  System.out.println("No orders to Delete");
  				System.out.println("-----------------------------------------------------------");

					break;
				}
				for(int f : v1.orders.keySet()) {
					System.out.println("order_id: " + f);
					int k1=1;
					for(int list : v1.orders.get(f).order.keySet()) {
					 int total_amount = v1.orders.get(f).order.get(list)* v1.listofproducts.get(list).rate;
					
					 System.out.println("s.no:"+k1+" Id: " +list+ " quantity: " + v1.orders.get(f).order.get(list) + " Total: " + total_amount);
			         k1++;
					}
					}
				System.out.println("Enter OrderId To delete: ");
				int rt=s.nextInt();
				v1.deletingorder(rt);
				System.out.println("-----------------------------------------------------------");

				break;
			case 7:
				k = false;
				System.out.println("-----------------------------------------------------------");
				break;
}}}
			
void printListofproducts(HashMap<Integer,Product> c) {
System.out.println("The products in shop are ");
for(Map.Entry<Integer, Product> entry:c.entrySet()){    
       int key=entry.getKey();  
       Product b=entry.getValue();  
       System.out.print(key+" Product:");  
       System.out.println("id: "+b.Id+" "+" name:"+b.name+" "+" quantity:"+b.quantity+" rate:"+b.rate);   
   } 

}
	public void addProductToCart() {
		Scanner s1=new Scanner(System.in);
		System.out.println("For Adding,enter some details: ");
		System.out.println("Enter productid : ");
		int Id = s1.nextInt();
		System.out.println("Enter productname : ");
		String pname= s1.next();
		System.out.println("Enter quantity : ");
		int q= s1.nextInt();
        if(!this.listofproducts.containsKey(Id)) {
			System.out.println("No Item is there");
			return;
		}
        else if(this.cartinshop.containsKey(Id)) {
			this.cartinshop.put(Id, q + this.cartinshop.get(Id));
			return;
		}
		this.cartinshop.put(Id, q);
		
	}

	
	public void deleteProductFromCart(int y,String p1) { 
		   if(this.cartinshop.isEmpty()) {
		    System.out.println("Your Cart is Empty");
				return;
			   }
		   else if(!(this.cartinshop.containsKey(y))) {
           System.out.println("No Item your Cart!");
			return;
		    }this.cartinshop.remove(y);
	}

	public int placingorder(String username) { 
		
		if(this.cartinshop.isEmpty()) {
			System.out.println("Your Cart is Empty");
		}
		else {
             for(int i : cartinshop.keySet()) {
				listofproducts.get(i).quantity -= cartinshop.get(i);
			}
			this.ordered.add(new Order(ordered.size() + 1,cartinshop,username));
			this.orders.put(this.ordered.size(), new Order(ordered.size() + 1,cartinshop,username));
			System.out.println("placed Your Order ");
		}return ordered.size();
	}
	public int deletingorder(int orderId) {    
		if(this.orders.containsKey(orderId))
		{
			for (int filter: orders.get(orderId).order.keySet()) {
				listofproducts.get(filter).quantity += orders.get(orderId).order.get(filter);
			}
			System.out.println("order Deleted");
			orders.remove(orderId);	
		}
		else {
			System.out.println("No Such Order is there");
		}return 0;
	}		
	}
