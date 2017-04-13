/*
 * 简单的int环形队列。
 */
 
 public class RingBuffer {
	public static final int MAX=32;
	private int rbuf[];
	private int head;
	private int tail;
	private int size;	
	
	RingBuffer(int size) {
		this.size = size;
		head = 0;
		tail = 0;
		rbuf = new int[size];
	}
	public int set(int a) {
		if ((head-tail)>=size) {
			return -1;
		} else {
			rbuf[head%size]=a;
			head++;
			return 0;
		}
	}
	public int get() {
		if (tail<head) {
			return rbuf[(tail++)%size];
		} else {
			return -1;
		}
	}
}
 
 
