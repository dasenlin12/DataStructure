package cn.util.List.seqList;

import cn.util.List.JList;

public class SeqList<E> implements JList<E> {
	
	private Object[] table;
	private int n;
	
	public SeqList(int capacity){
		this.table = new Object[Math.abs(capacity)];
		this.n = 0;
	}
	
	public SeqList(){
		this.table  = new Object[16];
	}

	@Override
	public boolean isEmpty() {
		return this.n==0;
	}

	@Override
	public int lenght() {
		return this.n;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		if(index>=0 && index <= this.n)
			return (E)this.table[index];
		return null;
	}

	@Override
	public E set(int index, E element) {
		if(index>=0&&index<this.n&&element!=null){
			@SuppressWarnings("unchecked")
			E old = (E)this.table[index];
			this.table[index] = element;
			return old;
		}
		return null;
	}

	@Override
	public boolean add(int index, E element) {
		if(element == null)
			return false;
		if(this.n==table.length){
			Object[] temp = this.table;
			this.table = new Object[temp.length*2];
			for(int i=0;i<temp.length;i++)
				this.table[i] = temp[i];
		}
		
		if(index<0)
			index=0;
		if(index>this.n)
			index = this.n;
		for(int j=this.n-1;j>=index;j--){
			this.table[j+1] = this.table[j];
		}
		table[index] = element;
		this.n++;
		return true;
	}

	@Override
	public boolean add(E element) {
		return this.add(this.n, element);
	}

	@Override
	public E remove(int index) {
		if(index>=0&&index<this.n){
			@SuppressWarnings("unchecked")
			E old = (E)this.table[index];
			for(int j=index;j<=this.n-1;j++)
				this.table[j]=this.table[j+1];
			this.table[n-1] = null;
			this.n--;
			return old;
		}
		return null;
	}

	@Override
	public void clear() {
		if(this.n!=0){
			for(int i=0;i<this.n;i++)
				this.table[i] = null;
			this.n = 0;
		}
		
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("(");
		if(this.n!=0)
			for(int i=0;i<this.n-1;i++)
				sb.append(this.table[i].toString()+",");
		sb.append(this.table[n-1].toString()+")");
		return sb.toString();
		
	}

}
