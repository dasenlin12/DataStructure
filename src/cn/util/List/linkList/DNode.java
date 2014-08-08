package cn.util.List.linkList;

public class DNode<E> {
	
	public E data;
	public DNode<E> prev,next;
	
	public DNode(E element,DNode<E> prev,DNode<E> next){
		this.data = element;
		this.prev = prev;
		this.next = next;
	}
	
	public DNode(E data){
		this(data,null,null);
	}
	
	public DNode(){
		this(null,null,null);
	}

}
