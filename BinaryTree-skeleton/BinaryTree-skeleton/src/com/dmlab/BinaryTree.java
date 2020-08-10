package com.dmlab;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<Key extends Comparable<? super Key>, E> {

	class Node {
		private Key mKey;
		private E mValue;

		private Node mLeft;
		private Node mRight;

		public Node(Key key, E value) {
			mKey = key;
			mValue = value;
			mLeft = null;
			mRight = null;
		}

		public Key getKey() {
			return mKey;
		}

		public E getValue() {
			return mValue;
		}

		/**
		 * Insert a node to the subtree, the root of which is this node.
		 * If the subtree already has node with the given key in the param,
		 * 		replace the value of the node in the subtree.
		 * Please compare keys using compareTo method.
		 * e.g. when "int compare = KEY0.compareTo(KEY1)"
		 * 		if compare == 0, this means KEY0 is equal to KEY1
		 * 		if compare > 0, KEY0 > KEY1
		 * 		if compare < 0, KEY0 < KEY1
		 * @param key
		 * @param value
		 * @return
		 * 			None
		 */
		public void insert(Key key, E value) {
			// TODO: Fill this function
			int compare = mKey.compareTo(key);

			if(compare==0)
			{
				mValue=value;
				return;
			}
			else if(compare>0)
			{
				if(mLeft==null)
				{
					mLeft = new Node(key, value);
				}
				else
				{
					mLeft.insert(key, value);
				}
			}
			else
			{
				if(mRight==null)
				{
					mRight = new Node(key, value);
				}
				else
				{
					mRight.insert(key, value);
				}
			}
		}

		/**
		 * Find the value of item by the key in the subtree, the root of which is this node.
		 * @param key
		 * @return
		 * 			the value of item matched with the given key.
		 * 			null, if there is no matching node in this subtree.
		 */
		public E find(Key key) {
			// TODO: Fill this function
			Node n = mRoot;
			int compare = mKey.compareTo(key);
			while (n!=null)
			{
				if(compare==0)
				{
					return mValue;
				}
				else if(compare>0)
				{
					n = n.mLeft;
				}
				else if(compare<0)
				{
					n = n.mRight;
				}
			}
			return null;
		}

		@Override
		public String toString() {
			return "[" + String.valueOf(mKey) + ":" + String.valueOf(mValue) + "]";
		}

		/**
		 * Traverse with the preorder in this subtree.
		 * @return
		 * 			The String to be printed-out which contains series of nodes as the preorder traversal.
		 */
		public String preorder() { //error
			// TODO: Fill this function
			if(mLeft==null&&mRight==null)
				return this.toString();
			else if(mLeft==null)
				return this.toString()+mRight.preorder();
			else if(mRight==null)
				return this.toString()+mLeft.preorder();
			return this.toString()+mLeft.preorder()+mRight.preorder();
			//return null;
		}

		/**
		 * Traverse with the inorder in this subtree.
		 * @return
		 * 			The String to be printed-out which contains series of nodes as the inorder traversal.
		 */
		public String inorder() {
			// TODO: Fill this function
			if(mLeft==null&&mRight==null)
				return this.toString();
			else if(mLeft==null)
				return this.toString()+mRight.inorder();
			else if(mRight==null)
				return mLeft.inorder()+this.toString();
			return mLeft.inorder()+this.toString()+mRight.inorder();
			//return null;
		}

		/**
		 * Traverse with the postorder in this subtree.
		 * @return
		 * 			The String to be printed-out which contains series of nodes as the postorder traversal.
		 */
		public String postorder() { //error
			// TODO: Fill this function
			if(mLeft==null&&mRight==null)
				return this.toString();
			else if(mLeft==null)
				return mRight.postorder()+this.toString();
			else if(mRight==null)
				return mLeft.postorder()+this.toString();
			return mLeft.postorder()+mRight.postorder()+this.toString();
			//return null;
		}

		/**
		 * Find the height of this subtree
		 * @return
		 * 			height
		 */
		public boolean iscomplete(Node root) {
            // TODO: Fill this function
			if(mLeft==null&&mRight==null)
				return true;
			else if(mLeft==null)
				return false;
			else if(mRight==null)
				return false;
			return mLeft.iscomplete(mLeft)&&mRight.iscomplete(mRight);
			//return true;
		}

		/**
		 * Find the height of this subtree
		 * @return
		 * 			height
		 */
		public int height() {
			// TODO: Fill this function
			if(mLeft==null&&mRight==null)
				return 1;
			else if(mLeft==null)
				return 1+mRight.height();
			else if(mRight==null)
				return 1+mLeft.height();
			int h;
			if(mLeft.height()>=mRight.height())
				h=mLeft.height();
			else
				h=mRight.height();
			return 1+h;
			//return 0;

		}

		public Node findMin() {
			if (mLeft == null)
				return this;
			else
				return mLeft.findMin();
		}

		/**
		 * Delete a node,the key of which match with the key given as param, from this subtree.
		 * You may need to define new method to find minimum of the subtree.
		 * @return
		 * 			the node of which parent needs to point after the deletion.
		 */
		public Node delete(Key key) {
			// TODO: Fill this function
			int compare = mKey.compareTo(key);

			if(compare==0)
            {
                if(mLeft!=null && mRight!=null)
                {
                    Node exchange = mRight.findMin();
                    mKey = exchange.getKey();
                    mValue = exchange.getValue();
                    mRight.delete(exchange.getKey());
                    return this;
                }
                else if(mLeft!=null)
                {
                    return mLeft;
                }
                else
                {
                    return mRight;
                }
            }
			else if(compare>0)
            {
                if(mLeft!=null)
                {
                    mLeft = mLeft.delete(key);
                }
                return this;
            }
			else
            {
                if(mRight!=null)
                {
                    mRight = mRight.delete(key);
                }
                return this;
            }
            /*int compare = mKey.compareTo(key);
			if(compare==0)
			{
				//단말노드
				if(mLeft==null&&mRight==null)
					return null;
				//차수1
				else if(mLeft==null)
					return mRight;
				else if(mRight==null)
					return mLeft;
				//차수2

			}
			else if(compare>0)
			{
				mLeft.delete(key);
			}
			else if(compare<0)
			{
				mRight.delete(key);
			}
			return null;*/
		}

	}

	private Node mRoot;
	public BinaryTree() {
		mRoot = null;
	}

	public void insert(Key key, E value) {
		if (mRoot == null) {
			mRoot = new Node(key, value);
		} else {
			mRoot.insert(key, value);
		}
	}

	public void delete(Key key) {
		if (mRoot == null)
			return;
		mRoot = mRoot.delete(key);
	}

	public E find(Key key) {
		if (mRoot == null)
			return null;
		return mRoot.find(key);
	}

	public void preorder() {
		System.out.print("preorder : ");
		if (mRoot == null) {
			System.out.println("None");
			return;
		}
		System.out.println(mRoot.preorder());
	}

	public void inorder() {
		System.out.print("inorder : ");
		if (mRoot == null) {
			System.out.println("None");
			return;
		}
		System.out.println(mRoot.inorder());

	}

	public void postorder() {
		System.out.print("postorder : ");
		if (mRoot == null) {
			System.out.println("None");
			return;
		}
		System.out.println(mRoot.postorder());
	}

	public int height() {
		if (mRoot == null)
			return 0;
		return mRoot.height();
	}

	public void iscomplete()
	{	boolean flag = mRoot.iscomplete(mRoot);
		if (flag)
			System.out.println("The tree is complete binary tree.");
		else
			System.out.println("The tree is not complete.");
	}

}
