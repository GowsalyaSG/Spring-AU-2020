
public class Main {
public static void main(String[] args)
{
	Producer p1=new Producer();
	p1.setName("producer_1");
	p1.start();
	Producer p2=new Producer();
	p2.setName("producer_2");
	p2.start();
	Consumer c1=new Consumer(p1);
	c1.setName("Consumer_1");
	c1.start();
	Consumer c2=new Consumer(p1);
	c2.setName("Consumer_2");
	c2.start();
	Consumer c3=new Consumer(p1);
	c3.setName("Consumer_3");
	c3.start();
	Consumer c4=new Consumer(p1);
	c4.setName("Consumer_4");
	c4.start();
}
}
