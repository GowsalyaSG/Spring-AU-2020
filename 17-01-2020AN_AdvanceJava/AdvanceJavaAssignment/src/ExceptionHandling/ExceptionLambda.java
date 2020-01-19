package ExceptionHandling;

import java.util.function.BiConsumer;

@FunctionalInterface
interface MineInterface{
    int calculate(int i, int j);
}
public class ExceptionLambda {
        public static void main(String[] args) {
    	int arr1[]= {1,2,3,4},key=0;
    	 calculate(arr1,key,(v,k)->{  try {
           System.out.println(v/k);
        }catch(ArithmeticException e) {
            System.out.println("Exception :" + e.getMessage());
        }});
    	 System.out.println("finished");
        }
        static void calculate(int[] arr,int key,BiConsumer<Integer,Integer> consumer) {
        	 for (int i:arr)
        	     consumer.accept(i,key);
        }
} 	
     