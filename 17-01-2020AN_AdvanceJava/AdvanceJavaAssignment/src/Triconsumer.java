import java.util.Scanner;

public class Triconsumer {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter three integer for multiplication:");
		int i=s.nextInt();
		int j=s.nextInt();
		int k=s.nextInt();
		triconsumerinterface<Integer, Integer,Integer> multiplication = (x,y,z)  -> System.out.println("multiplication result:"+(x*y*z));
		multiplication.accept(i,j,k); 
		}

}
