package src.v2;

public class RingBuffer {
	private int rbuf[];
	private long head;
	private long tail;
	private long size;	
	public RingBuffer(long size) {
		this.size = size;
		head = 0;
		tail = 0;
		rbuf = new int[(int) size];
	}
	public int set(int a) {
		if ((head-tail)==size) {
			return -1;
		} else {
			rbuf[(int) (head&(size-1))]=a;
			head++;
			return 0;
		}
	}
	public int get() {
		if (head==tail)
			return -1;
		int ret = rbuf[(int) (tail&(size-1))];
		tail++;
		return ret;
	}
}
