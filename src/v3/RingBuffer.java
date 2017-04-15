/*
 * 通过Object来支持任意类型的队列。
 * 
 * 
 */

package src.v3;

public class RingBuffer {
	private Object rbuf[];
	private long head;
	private long tail;
	private long size;	
	public RingBuffer(long size) {
		this.size = size;
		head = 0;
		tail = 0;
		rbuf = new Object[(int) size];
	}
	public Boolean set(Object a) {
		if ((head-tail)==size) {
			return false;
		} else {
			rbuf[(int) (head&(size-1))]=a;
			head++;
			return true;
		}
	}
	public Object get() {
		if (head==tail)
			return -1;
		Object a = rbuf[(int) (tail&(size-1))];
		tail++;
		return a;
	}
}
