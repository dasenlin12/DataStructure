package cn.util.List;

public interface JList<E> {
    /**
     * 
     * @return
     */
	boolean isEmpty();
	int lenght();
	E get(int index);
	E set(int index,E element);
    boolean add(int index,E element);
    boolean add(E element);
	E remove(int index);
	void clear();
}
