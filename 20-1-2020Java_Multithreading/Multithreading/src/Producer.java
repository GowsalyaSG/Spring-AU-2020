
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
public class Producer extends Thread {
	private static final int max=4;
    String[] arr={"apple","mango","orange","watermelon"};
    Random r=new Random();
    private final List<String> m =new ArrayList<String>(max);
	 @Override
	 public void run() {
		 try {
			 while(true)
			 {
				 int randomNumber=r.nextInt(arr.length);
				 produce(arr[randomNumber]);	
			 }
		 }catch(Exception e)
		 {
			 
		 }
	 }
	 private synchronized void produce(String data) throws Exception
	 {
		 if(m.size()!=max) {
		 m.add(data);
		 System.out.println(Thread.currentThread().getName()+" produced data:"+data);
		 }
		 while(m.size()==max)
		 {
			 System.out.println("queue is filled,waiting for consumer");
			 wait();
			 //Thread.sleep(1000);
			 System.out.println("producer got notification from consumer");
		 }

		 notify();
	 }
	 public synchronized String consume() throws Exception
	 {
		 notify();
		 while(m.isEmpty())
		 {
			 wait();
			 
		 }
		 //System.out.println(Thread.currentThread().getName()+" wants to enter item");
		 //Scanner s=new Scanner(System.in);
		 //String data =s.next();
		 int randomNumber1=r.nextInt(arr.length);
		 String data=arr[randomNumber1];
		if(m.contains(data)) {
			m.remove(new String(data));
		  return data;
		} 
		else
		 return data+" - no item is there,please wait";
		/*
			 * else { System.out.println("no item is there"); } return data;
			 */
	 }
}
