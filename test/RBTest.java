package test;
//import src.v1.RingBuffer;
import src.v4.*;

public class RBTest {
	public static void main(String argv[]) {
		RingBuffer<String> rb = new RingBuffer<String>(String.class, 15);
		rb.set("11");
		rb.set("aa");
		rb.set("33");
		rb.set("bb");
		System.out.println(rb.get());
		System.out.println(rb.get());
		System.out.println(rb.get());
		System.out.println(rb.get());
		System.out.println(rb.get());
	}	
}
