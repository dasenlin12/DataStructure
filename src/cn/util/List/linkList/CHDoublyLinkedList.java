package cn.util.List.linkList;

import cn.util.List.JList;

public class CHDoublyLinkedList<E> implements JList<E> {
	
	protected DNode<E> head;
	protected int n;

	@Override
	public boolean isEmpty() {
		return n==0;
	}

	@Override
	public int lenght() {
		return n;
	}

	@Override
	public E get(int index) {
        if(this.head==null || index<0)
		   return null;
        int i = 0;
        DNode<E> p = this.head;
        while(p!=null&&i<index){
        	p = p.next;
        	i++;
        }
        if(p!=null)
        	return p.data;
        else
        	return null;
	}

	@Override
	public E set(int index, E element) {
		if(element!=null&&index>=0){
			int i=0;
			DNode<E> p = this.head;
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
		if(element!=null){
			if(this.head==null || index < 0){
				this.head = new DNode<E>(element,this.head,this.head);
				n++;
				return true;
			}
			int i = 0;
			DNode<E> p = this.head;
			while(p.next!=null&&i<index-1){
				p = p.next;
				i++;
			}
			p.next = new DNode<E>(element,p,p.next);
			this.n++;
			return true;
		}
		return false;
	}

	@Override
	public boolean add(E element) {
		return this.add(Integer.MAX_VALUE,element);
	}

	@Override
	public E remove(int index) {
		if(this.head!=null&&index>=0&&index<n){
			if(index==0){
				DNode<E> q = this.head;
				this.head = this.head.next;
				n--;
				return q.data;
			}
			int i=0;
			DNode<E> p = this.head;
			while(p!=null&&i<index){
				p = p.next;
				i++;
			}
			if(p!=null){
				p.prev.next = p.next;
				if(p.next!=null)
				  p.next.prev = p.prev;
				this.n--;
				return p.data;
			}
		}
		return null;
	}

	@Override
	public void clear() {
		this.head = null;
		
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer("(");
		sb.append(this.toString(this.head)+")");
		return sb.toString();
	}
	
	public String toString(DNode<E> element){
		StringBuffer s = new StringBuffer("");
		if(element!=null)
			s.append(element.data+","+this.toString(element.next));
		return s.toString();
	}

}
