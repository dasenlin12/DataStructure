package cn.util;

public class Node<E> {

	public E data;
	public Node<E> next;
	
	public Node(E data,Node<E> n){
		this.data = data;
		this.next = n;
	}
	
	public Node(E data){
		this(data,null);
	}
	
	public Node(){
		this(null,null);
	}

}
