package com.tnb.collections;

import java.util.Stack;

public class UseStacks {
	public static void main(String[] args) {
		Stack<String> stack1= new Stack<String>();
		stack1.push("top");
		printStack(stack1);
		stack1.push("middle");
		printStack(stack1);
		stack1.push("last");
		printStack(stack1);
		
		stack1.pop();
		printStack(stack1);
		stack1.pop(); 
		printStack(stack1);
		stack1.pop();
		printStack(stack1);
	}
	
	public static void printStack(Stack<String> st1){
		if(st1.isEmpty()){
			System.out.println("Stack is Empty");
		}else{
			System.out.printf("%s Top \n ",st1);
		}
	}
	
}
