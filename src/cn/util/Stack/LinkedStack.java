package cn.util.Stack;

public class LinkedStack<E> implements Stack<E> {
	
	private Node<E> top;
	
	public LinkedStack(){
		top=null;
	}

	@Override
	public boolean isEmpty() {
		return (top==null);
	}

	@Override
	public boolean push(E element) {
		if(element!=null){
			if(top==null){
				top = new Node<E>(element);
				return true;
			}else{
				this.top = new Node<E>(element,this.top);
				return true;
			}
		}
		return false;
	}

	@Override
	public E pop() {
		if(top!=null){
			E data = this.top.data;
			this.top = this.top.next;
			return data;
		}
		return null;
	}

	@Override
	public E get() {
		if(top!=null){
			return this.top.data;
		}
		return null;
	}

	public String toString(){
		return "("+this.toString(this.top)+")";
	}
	
	public String toString(Node<E> e){
		if(e!=null){
			return " "+e.data+","+this.toString(e.next);
		}
		return "";
	}

}
