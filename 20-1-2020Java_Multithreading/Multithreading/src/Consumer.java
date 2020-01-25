
public class Consumer extends Thread{
	private Producer p;

	public Consumer(Producer p) {
		this.p = p;
	}
	@Override
	public void run()
	{
		try
		{
			while(true)
			{
				String data=p.consume();
				System.out.println("consumed by"+Thread.currentThread().getName()+" data:"+data);
				Thread.sleep(5000);
			}
		}catch(Exception e)
		{
			
		}
	}
	

}
