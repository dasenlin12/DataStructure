package cn.util.List.test;

import cn.util.List.JList;
import cn.util.List.linkList.CHDoublyLinkedList;
import cn.util.List.linkList.SinglyLinkedList;

public class Josephus {
	
	private JList<String> list;
	
	public Josephus(int number,int start,int distance){
		//this.list = new SeqList<String>();
		//this.list = new SinglyLinkedList<String>();
		this.list = new CHDoublyLinkedList<String>();
		for(int i=0;i<number;i++)
			this.list.add(new String((char)('A'+i)+""));
		System.out.println(list.toString());
		//SinglyLinkedList<String> l = (SinglyLinkedList<String>) this.list;
		//l.reverse();
		//System.out.println(l.toString());
		int index = start-1;
		while(this.list.lenght()>1){
			index = (index+distance-1)%this.list.lenght();
			System.out.print("remove:"+this.list.remove(index)+",");
			System.out.println(this.list.toString());
		}
		System.out.println("the winner is:"+list.get(0));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Josephus(5,1,2);

	}

}
