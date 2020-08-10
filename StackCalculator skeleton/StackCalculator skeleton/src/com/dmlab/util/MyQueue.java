package com.dmlab.util;

import com.dmlab.interfaces.Queue;

/**
 * Array-based Queue
 * The size of the internal array should be 128
 */
public class MyQueue<E> implements Queue<E>{

	private E[] mData;
	private int mCursor, mHead;//front == mhead
	
	public MyQueue() {
		clear();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		/* Code Here */
		mData = (E[])new Object[128];
		mCursor = mHead = 0;
	}

	@Override
	public void add(E item) throws RuntimeException {
		/* Code Here */
		mData[mCursor++] = item;
		//mCursor++;
	}

	@Override
	public E poll() throws EmptyQueueException {
		/* Code Here */
		if(mCursor==mHead)
			throw new EmptyQueueException();
		E poll_item = mData[mHead++];
		/*for(int i=0; i<mCursor-1; i++)
		{
			mData[i] = mData[i+1];
		}
		mData[--mCursor] = null;
		//mCursor--;*/
		return poll_item;
	}

	@Override
	public E peek() throws EmptyQueueException {
		/* Code Here */
		if(mCursor <= 0)
			throw new EmptyQueueException();
		//return mData[mCursor-1];
		return mData[mHead];
	}

	@Override
	public boolean empty() {
		/* Code Here */
		return (mCursor==mHead);
	}

}
