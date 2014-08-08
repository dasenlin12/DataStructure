package cn.util.List.linkList;

import cn.util.List.JList;

public class SinglyLinkedList<E> implements JList<E> {
	
	protected Node<E> head;
    	
	protected int n;

	@Override
	public boolean isEmpty() {
		return this.head==null;
	}

	@Override
	public int lenght() {
		return n;
	}

	@Override
	public E get(int index) {
		if(this.head!=null&&index>=0){
			int i=0;
			Node<E> p = this.head;
			while(p!=null&&i<index){
				p = p.next;
				i++;
			}
			if(p!=null)
				return p.data;
		}
			
		return null;
	}

	@Override
	public E set(int index, E element) {
		if(this.head!=null&&index>=0&&element!=null){
			int i = 0;
			Node<E> p = this.head;
			while(p!=null&&i<index){
				p = p.next;
				i++;
			}
			if(p!=null){
				E old = p.data;
				p.data = element;
				return old;
			}
		}
		return null;
	}

	@Override
	public boolean add(int index, E element) {
		if(element==null)
			return false;
		if(this.head==null || index<=0){
		    //Node<E> temp = new Node<E>(element);
		    //temp.next = this.head;
		    //this.head = temp;
		    this.head = new Node<E>(element,this.head);
		}else{
			int i=0;
			Node<E> p = this.head;
			while(p.next!=null&&i<index-1){
				p = p.next;
				i++;
			}
			Node<E> q = new Node<E>(element,p.next);
			p.next = q;
		}
		n++;
		return true;
	}

	@Override
	public boolean add(E element) {
		/*if(element==null)
			return false;
		if(this.head==null)
		  this.head = new Node<E>(element,this.head);
		else{
			Node<E> q = this.head;
			while(q.next!=null){
				q = q.next;
			}
			q.next = new Node<E>(element);
		}
		return true;*/
		return this.add(Integer.MAX_VALUE, element);
	}

	@Override
	public E remove(int index) {
		if(index>=0&&this.head!=null){
			E old = null;
			if(index==0){
				old = this.head.data;
				this.head = this.head.next;
			}else{
				Node<E> q = this.head;
				int i = 0;
				while(q.next!=null&&i<index-1){
					q = q.next;
					i++;
				}
				if(q.next!=null){
				    old = q.next.data;
					q.next=q.next.next;
				}
			}
			n--;
			return old;
		}
			
		return null;
	}

	@Override
	public void clear() {
		this.head = null;
		
	}

	public String toString(){
		StringBuffer sb = new StringBuffer("(");
		Node<E> q = this.head;
		while(q.next!=null){
			sb.append(" "+q.data+",");
			q = q.next;
		}
		sb.append(q.data+")");
		return sb.toString();
		
	}
	
	public void reverse(){
		Node<E> p = this.head,q=null,front=null;
		while(p!=null){
			q = p.next;
			p.next = front;
			front = p;
			p = q;
		}
		this.head=front;
	}
}
