package cn.util.queue;

public class SeqQueue<E> implements Queue<E> {
	
	private Object[] value;
	private int front,rear;
	
	public SeqQueue(int capacity){
		this.value = new Object[capacity];
		front=rear=0;
	}
	
	public SeqQueue(){
		this(16);
	}

	@Override
	public boolean isEmpty() {
		return this.front==this.rear;
	}

	@Override
	public boolean enqueue(E element) {
		if(element!=null){
			if(this.front==((this.rear+1)%this.value.length)){
				Object[] temp = this.value;
				this.value = new Object[this.value.length*2];
				int i=this.front,j=0;
				while(i!=this.rear){
					this.value[j] = temp[i];
					i = (i+1)%temp.length;
					j++;
				}
				this.front=0;
				this.rear=j;
			}
			this.value[this.rear] = element;
			this.rear = (this.rear+1)%this.value.length;
			return true;
		}
		return false;
	}

	@Override
	public E dequeue() {
		if(this.front!=this.rear){
			@SuppressWarnings("unchecked")
			E data = (E) this.value[this.front];
			this.front = (this.front+1)%this.value.length;
			return data;
		}
		return null;
	}
	
	public String toString(){
		StringBuffer s = new StringBuffer("(");
		int i = this.front;
		while(i!=this.rear){
			s.append(this.value[i]+",");
			i = (i+1)%this.value.length;
		}
		return s.toString();
	}

}
