package src.v4;

import java.lang.reflect.Array;

public class RingBuffer<T> {
	private T[] rbuf;
	private long head;
	private long tail;
	private int size;
	
	private int Find2N(int size) {
		int	i=0;
		int	n=1;
		if (size<=4) {
			n = 4;
			return n;
		}
		while((size>>1)>0) {
			size=size>>1;
			i++;
		}
		return n<<(i+1);
	}
	@SuppressWarnings("unchecked")
	public RingBuffer(Class<T> type, int size) {
		this.size = Find2N(size);
//		System.out.println("RingBuffer length is:"+this.size);
		head = 0;
		tail = 0;
		rbuf = (T[]) Array.newInstance(type, size);  
	}
	public Boolean set(T a) {
		if ((head-tail)==size) {
			return false;
		} else {
			rbuf[(int) (head&(size-1))]=a;
			head++;
			return true;
		}
	}
	public T get() {
		if (head==tail)
			return null;
		T a = rbuf[(int) (tail&(size-1))];
		tail++;
		return a;
	}
}