package com.dmlab;

import com.dmlab.interfaces.Queue;
import com.dmlab.util.EmptyQueueException;
import com.dmlab.util.MyQueue;
import com.dmlab.util.MyStack;

public class StackCalculator {

	private MyStack<String> mStack;
	private MyQueue<String> mQueue;
	private MyStack<Integer> mStackCalc;

	private static final int TYPE_OPERATOR = 0;
	private static final int TYPE_BRACE = 1;
	private static final int TYPE_NUMBER = 2;

	public StackCalculator() {
		mStack = new MyStack<String>();
		mQueue = new MyQueue<String>();
		mStackCalc = new MyStack<Integer>();
	}

	/**
	 * Solve the given infix form of equation
	 * @param infix
	 * 			the infix form of an equation
	 * 			e.g. 1 + 2 - ( 3 - 4 )
	 * @return
	 * 			the result from the calculation of given equation
	 */
	public int solve(String infix) {
		/* Code Here */
		//스택과 큐에 넣는 과정
		String[] items = infix.split(" ");
		for(int i=0; i<items.length; i++)
		{
			if(typeOf(items[i])==0)
			{
				while(!mStack.empty() && !mStack.peek().equals("("))
				{
					if(prior(items[i]) <= prior(mStack.peek())) mQueue.add(mStack.pop());
					else break;
				}
				mStack.push(items[i]);
			}
			else if(typeOf(items[i])==1)
			{
				if(items[i].equals("(")) mStack.push(items[i]);
				else if(items[i].equals(")"))
				{
					//try-catch 시도
					//while(true) {
						try {
							while(!mStack.empty() && !mStack.peek().equals("(")) mQueue.add(mStack.pop());
							if(mStack.peek().equals("(")) mStack.pop();
						} catch (Exception EmptyStackException) {
							//break;
						}
						//while(!mStack.empty() && mStack.peek()!="(") mQueue.add(mStack.pop());
						//if(mStack.peek()=="(") mStack.pop(); // 의문 (이 top에 있다는 건가
						//System.out.println(mStack.peek());
					//}
				}
			}
			else if(typeOf(items[i])==2) mQueue.add(items[i]);
		}
		//큐에 정리하는 과정
		while (!mStack.empty()) mQueue.add(mStack.pop());
		//계산하는 과정
		/*System.out.println("요소 : ");
		while(!mQueue.empty()){
			try{
				System.out.println(mQueue.poll());
			}catch (Exception EmptyQueueException)
			{
				break;
			}
		}*/
		//
		while (true)//!mQueue.empty())  //왜 try-catch를 쓰는지
		{
			try{
				String item = mQueue.poll();
				if(typeOf(item)==0)
                {
                    int sc1 = mStackCalc.pop();
                    int sc2 = mStackCalc.pop();
                    if(item.equals("+")) mStackCalc.push(sc2+sc1);
                    else if(item.equals("-")) mStackCalc.push(sc2-sc1);
                    else if(item.equals("*")) mStackCalc.push(sc2*sc1);
                    else if(item.equals("/")) mStackCalc.push(sc2/sc1);
                }
				else if(typeOf(item)==2)
                {
				    int int_item = Integer.parseInt(item);
                    mStackCalc.push(int_item);
                }
			}catch(Exception EmptyQueueException){
				//System.out.println(mQueue.empty());
				break;//이 부분에서 잘못해서 그냥 끝 숫자가 출력되는듯 mStackCalc에 들어가는건 맞는데....
			}
		}
        return mStackCalc.pop();
	}

	private int typeOf(String entry) {
		if (entry.equals("+") || entry.equals("-") || entry.equals("*") || entry.equals("/")) {
			return TYPE_OPERATOR;
		} else if (entry.equals("(") || entry.equals(")")) {
			return TYPE_BRACE;
		} else {
			return TYPE_NUMBER;
		}
	}

	private int prior(String item) {
		if (item.equals("+") || item.equals("-")) {
			return 0;
		}
		return 1;
	}
}
