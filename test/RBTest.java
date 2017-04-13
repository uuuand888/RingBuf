package test;
import src.v1.RingBuffer;

public class RBTest {
public static void main(String argv[]) {
	RingBuffer rb = new RingBuffer(16);
	rb.set(11);
	rb.set(2);
	rb.set(33);
	rb.set(4);
	System.out.println(rb.get());
	System.out.println(rb.get());
	System.out.println(rb.get());
	System.out.println(rb.get());
	System.out.println(rb.get());
}
}
