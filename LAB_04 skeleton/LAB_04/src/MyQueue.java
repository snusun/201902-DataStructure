
public class MyQueue<E> implements Queue<E> {

	private Node<E> first = null;
	private Node<E> last = null;
	private int size = 0;

	@Override
	public void enqueue(E item) {
		// TODO Auto-generated method stub
		Node<E> newNode = new Node<E>(item, null);
		if(isEmpty()) //last가 null일때
		{
			first= newNode;
			last = newNode;
			size++;
		}
		else
		{
			last.setNext(newNode);
			last = last.getNext();
			size++;
		}
	}

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub

		if(isEmpty()){
			return null;
		}
		else if(first == last) {
			E item = first.getItem();
			first=last=null;
			size=0;
			return item;
		}
		else {
			E item = first.getItem();
			first = first.getNext();
			return item;
		}
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		if(isEmpty()){
			return null;
		}
		else if(first == last) {
			E item = last.getItem();
			first=last=null;
			size=0;
			return item;
		}
		else {
			E item = last.getItem();
			Node<E> curr = first;
			while(curr.getNext() != last){
				curr=curr.getNext();
			}
			curr.setNext(null);
			last=curr;
			size--;
			return item;
		}
	}

	@Override
	public void clear() {
		first=last=null;
		size = 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public String toString() {
		Node<E> cursor = first;
		StringBuffer sb = new StringBuffer("(");
		while (cursor != null) {
			sb.append(cursor.getItem());
			if (cursor != last) {
				sb.append(' ');
			}
			cursor = cursor.getNext();
		}
		sb.append(")");
		return sb.toString();
	}

}
