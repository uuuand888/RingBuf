package test;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//import src.v1.RingBuffer;
import src.v4.*;

class PoolSet implements Runnable {
	RingBuffer<Integer> rb;
	int n;
	PoolSet(RingBuffer<Integer> rb, int n) {
		this.rb = rb;
		this.n = n;
	}

	@Override
	public void run() {
		for (int i=0; i<20; i=i+n) {
			rb.set(i);
			System.out.println(Thread.currentThread().getName()+" set for:"+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class PoolGet implements Runnable {
	RingBuffer<Integer> rb;
	int n;
	PoolGet(RingBuffer<Integer> rb) {
		this.rb = rb;
	}

	@Override
	public void run() {
		while(true) {
			Integer i = rb.get();
			if (i == null) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println(Thread.currentThread().getName()+" get for:"+i);
			}
			
		}
	}
}

public class RBTest {
	public static void main(String argv[]) {
		RingBuffer<Integer> rb = new RingBuffer<Integer>(Integer.class, 15);
		ExecutorService poolset = Executors.newFixedThreadPool(1);
		ExecutorService poolget = Executors.newFixedThreadPool(2);
		poolset.execute(new PoolSet(rb,1));
		poolget.execute(new PoolGet(rb));
	}	
}
