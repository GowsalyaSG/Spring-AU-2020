package ShoppingCart;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




public class HibernateTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		boolean retry = true;
		List<Products> productList = new ArrayList<>();
		
		   
		     

		  
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		
		 session.beginTransaction();
         Customers c1 =new Customers();
         c1.setCust_id(11);
         c1.setCust_name("gowsalya");
         c1.setPhone(12345);
         Feedback f= new Feedback("good");
		 Address add2=new Address(); add2.setStreet("1st street"); add2.setCity("tn");add2.setPincode(623721);
		 Address add1=new Address(); add1.setStreet("2nd street"); add1.setCity("tn");add1.setPincode(623701);
		 c1.setHomeaddress(add1);c1.setOfficeaddress(add2);
		  Suppliers sup1 =new Suppliers(14,"s_1");
		  Supplier_details sup2=new Supplier_details("c_1",12345);

		 Collection<Payment> phoneNumbers = new HashSet<Payment>();
		 Payment p111=new Payment("debit");
		 Payment p112= new Payment("credit");
		 phoneNumbers.add(p111);
		 phoneNumbers.add(p112);
		 Orders student = new Orders(123, phoneNumbers);
		 
		 


		 session.save(student);	
		 session.save(sup2);
		 session.save(sup1); 
		 session.save(c1);
         session.save(f);
		  session.getTransaction().commit();
		  Query q =session.createQuery("from Customers");
			List<Customers> u3=(List<Customers>)((org.hibernate.query.Query) q).list();
			
			for(Customers list: u3)
			{
				System.out.println("Customer Name :"+list.getCust_name());
			}
		
		do {


			//curd opertion using product Class
			System.out.println("Product Details");
			System.out.println("---------------------------------------------------");
			System.out.println("1. Adding a product");
			System.out.println("2. List of Products");
			System.out.println("3. Update a product");
			System.out.println("4. Delete a product");
			System.out.println("5. Exit");
			System.out.print("\n Enter your choice: ");
			int c = s.nextInt();
			switch (c) {
			
			case 1:
				Products p1= new Products();
				p1.setProd_id(1);
				p1.setProd_name("product_1");
				p1.setQuantity(2);
				p1.setPrice(50);
				Products p2= new Products();
				p2.setProd_id(2);
				p2.setProd_name("product_2");
				p2.setQuantity(4);
				p2.setPrice(10);
				productList.add(p1);
				productList.add(p2);
				
				session.beginTransaction();
				session.save(p1);
				session.save(p2);
				session.getTransaction().commit();
				break;
				
			case 2:
				
				session.beginTransaction();
				productList = session.createNamedQuery("Products").getResultList();
                for (Products p : productList) {
				 System.out.println(p.toString());}
				session.getTransaction().commit();
				break;

			case 3:
				
				session.beginTransaction();
				System.out.println("please enter the product id");
				int p_id = s.nextInt();
				try {
					Products u = session.load(Products.class, p_id);
					u.setProd_name("updated product");
					u.setPrice(30);
					System.out.println(u.toString());
				} catch (Exception e) {
					System.out.println(e);
				}
				session.getTransaction().commit();
				break;

			case 4:

				session.beginTransaction();
				System.out.println("please enter the product id");
				int p_id1 = s.nextInt();
				try {
					Products d = session.load(Products.class, p_id1);
					session.delete(d);
					System.out.println(d.toString());
				} catch (Exception e) {
					System.out.println(e);
				}
				session.getTransaction().commit();
				break;

			case 5:
                retry = false;
				session.close();
				break;

			default:
				System.out.println("enter a correct choice");
			}
		} while (retry);
		
	}

}

