package cn.util.Stack;

public class SeqStack<E> implements Stack<E> {
	
	private Object[] value;
	private int top = -1;
	
	public SeqStack(){
		value = new Object[16];
	}
	
	public SeqStack(int capacity){
		value = new Object[capacity];
	}

	@Override
	public boolean isEmpty() {
		return top==-1;
	}

	@Override
	public boolean push(E element) {
		if(element!=null){
			if(top==this.value.length-1){
				Object[] temp = this.value;
				this.value = new Object[this.value.length*2];
				for(int i=0;i<this.top;i++)
					this.value[i] = temp[i];
			}
			this.value[++top] = element;
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E pop() {
		if(this.top!=-1){
			return (E) this.value[this.top--];
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get() {
		if(this.top!=-1){
			return (E) this.value[this.top];
		}
		return null;
	}
	
	public String toString(){
		StringBuffer s = new StringBuffer("(");
		int i = this.top;
		while(i!=-1){
			s.append(" "+this.value[i--]+",");
		}
		s.append(")");
		return s.toString();
	}

}
