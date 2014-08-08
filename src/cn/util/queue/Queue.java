package cn.util.queue;

public interface Queue<E> {
	
	boolean isEmpty();
    boolean enqueue(E element);
    E dequeue();

}
