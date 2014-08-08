package cn.util.queue;

import cn.util.Node;

public class LinkedQueue<E> implements Queue<E> {
	
	private Node<E> front,rear;
	
	public LinkedQueue(){
		this.front=this.rear=null;
	}

	@Override
	public boolean isEmpty() {
		return (this.front==null&&this.rear==null);
	}

	@Override
	public boolean enqueue(E element) {
		if(element==null)
		   return false;
		else{
			Node<E> q = new Node<E>(element);
			if(!isEmpty())
				this.rear.next = q;
			else
				this.front = q;
			this.rear = q;
		}
			return true;
	}

	@Override
	public E dequeue() {
		if(!isEmpty()){
			E data = this.front.data;
			this.front = this.front.next;
			return data;
		}
		return null;
	}
	
	public String toString(){
		StringBuffer s = new StringBuffer("(");
		if(!isEmpty()){
			Node<E> q = this.front;
			while(q!=null){
				s.append(" "+q.data.toString()+",");
				q = q.next;
			}
		}
		s.append(")");
		return s.toString();
	}

}
