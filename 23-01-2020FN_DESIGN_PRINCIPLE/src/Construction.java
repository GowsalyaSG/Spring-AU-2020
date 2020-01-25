

import java.util.ArrayList;
import java.util.List;
public class Construction {
	
	public static void main(String args[]) {
		
		
 		Component hall1 = new Leaf( "Hall1",200,50000);
		Component kitchen1 = new Leaf( "Kitchen1", 130,50000);
		Component bedroom1 = new Leaf( "Bedroom1", 200,100000);
		Component Bathroom1 = new Leaf( "Bathroom1", 100,30000);
		Component Balcony1 = new Leaf( "Balcony1 ", 100,20000);
		
		Flat Flat1= new Flat("Flat1",101);
		Flat1.add(hall1);
		Flat1.add(kitchen1);
		Flat1.add(bedroom1);
		Flat1.add(Bathroom1);
		Flat1.add(Balcony1);
		
 		Component hall2 = new Leaf( "Hall2",200,50000);
		Component kitchen2 = new Leaf( "Kitchen2", 100,5000);
		Component bedroom2 = new Leaf( "Bedroom2", 200,100000);
		Component Bathroom2 = new Leaf( "Bathroom2", 200,30000);
		Component Balcony2 = new Leaf( "Balcony2 ", 200,20000);
		
		Flat Flat2= new Flat("Flat2",102);
		Flat2.add(hall2);
		Flat2.add(kitchen2);
		Flat2.add(bedroom2);
		Flat2.add(Bathroom2);
		Flat2.add(Balcony2);
		

		 List<Flat> flats = new ArrayList<Flat>();
		 flats.add(Flat1);
		 flats.add(Flat2);
		 
		 
		 Floor groundFloor = new Floor("GroundFloor",flats);
		 Floor FirstFloor = new Floor("FirstFloor",flats);
		 Floor secondFloor = new Floor("secondFloor",flats);
		 
		 List<Floor> floors = new ArrayList<Floor>();
		 floors.add(groundFloor);
		 floors.add(FirstFloor);
		 floors.add(secondFloor);
		 
         Floor  f= new Floor();
         Worker w1= new Worker("john",4,25,"cleaner");
         Worker w2= new Worker("mohan",2,45,"security");
         Worker w3= new Worker("ram",3,34,"plumber");
         Worker w4= new Worker("sivan",1,26,"construction_manager");
         
         
		System.out.println("*********************************************************");
		System.out.println("Welcome Our 'Golden Abode' Building");
        System.out.println("*********************************************************");
        System.out.println("No.of Floor in our Building ::"+floors.size());
        System.out.println("No.of Flats in each Floor in our Building ::"+flats.size());
        System.out.println("--------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------");
		System.out.println(groundFloor.getName()+":");
		Flat1.totalCost();Flat2.totalCost();
		 System.out.println("--------------------------------------------------------------");
		System.out.println(FirstFloor.getName()+":");
		Flat1.totalCost();Flat2.totalCost();
		 System.out.println("--------------------------------------------------------------");
		System.out.println(secondFloor.getName()+":");
		Flat1.totalCost();Flat2.totalCost();
		 System.out.println("--------------------------------------------------------------");
		System.out.println("worker Details ::"+"\n"+w4+"\n"+w2+"\n"+w3+"\n"+w1);
		
	
}

}
