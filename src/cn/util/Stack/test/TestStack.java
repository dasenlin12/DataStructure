package cn.util.Stack.test;

import cn.util.Stack.LinkedStack;
import cn.util.Stack.SeqStack;
import cn.util.Stack.Stack;

public class TestStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack<String> s = null;
		//s = new SeqStack<String>();
		s = new LinkedStack<String>();
		for(int i=0;i<5;i++){
			s.push(new String((char)('A'+i)+""));
		}
        System.out.println(s.toString());
        System.out.println(s.pop());
        s.push("Q");
        System.out.println(s.toString());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
	}

}
