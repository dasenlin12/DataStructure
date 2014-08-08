package cn.util.queue.test;

import cn.util.queue.LinkedQueue;
import cn.util.queue.Queue;
import cn.util.queue.SeqQueue;

public class QueueTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue<String> q;
		//q = new SeqQueue<String>();
		q = new LinkedQueue<String>();
		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("C");
		System.out.println(q.toString());
		System.out.println(q.dequeue());
		q.enqueue("D");
		System.out.println(q.toString());

	}

}
