package ds;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.lang.reflect.Array;

public class HashTable<Key extends Comparable<? super Key>, E> {
	private int M; // Size of the table
	private KVpair<Key, E>[] T; // Array of the elements

	@SuppressWarnings("unchecked") // Allow the generic array allocation
	public HashTable(int m) {
		M = m;
		T = (KVpair<Key, E>[]) Array.newInstance(KVpair.class, M);
	}

	/** Insert record r into T */
	public void hashInsert(Key k, E r) {
		// Fill in your codes
		/*int home;
		int pos = home = hash(k);
		T[pos] = new KVpair<Key, E>(k, r);
		*/
		KVpair<Key, E> obj = new KVpair<>(k, r);
		int hash = hash(k);

		if(T[hash] != null)
		{
			KVpair<Key, E> curr = T[hash];
			while (curr.next() != null)
			{
				curr = curr.next();
			}
			curr.set_next(obj);
		}
		else
		{
			T[hash] = obj;
			return;
		}
	}

	/** Search for the record with key k */
	public E hashSearch(Key k) {
		// Fill in your codes
		int hash = hash(k);
		if(T[hash] != null)
		{
			KVpair<Key, E> curr = T[hash];
			while (curr != null)
			{
				if(curr.key().equals(k)) return curr.value();
				curr = curr.next();
			}
		}
		return null;
		// 없는 상황은 고려하지 않는다.
	}

	/** Remove a record with key value k from the hash table */
	public E hashRemove(Key k) {
		// Fill in your codes
		int hash = hash(k);
		KVpair<Key, E> pre = new KVpair<>();
		KVpair<Key, E> curr = T[hash];

		if(T[hash] != null)
		{
			while (curr != null)
			{
				if(curr.key().equals(k)) break;
				pre = curr;
				curr = curr.next();
			}
			if(curr != null)
			{
				pre.set_next(curr.next());
			}
			else pre.set_next(null);

			if(curr != null)
				return curr.value();
		}
		return null;
	}

	/** Change the open hashing to the closed hashing */
	public void changeToClosed(){
		// Fill in your codes
		for(int i=0; i<M; i++)
		{
			KVpair<Key, E> curr = T[i];
			if(T[i] != null)
			{
				while(curr != null)
				{
					//table에 넣어주기
					for(int j=i+1; j%M!=i; j++)
					{
						if(T[j%M] == null)
						{
							T[j%M] = curr.next();
							break;
						}
					}
					//remove
					hashRemove(curr.key());
					curr = curr.next();
				}
			}
		}
	}

	/** Print the entire elements with keys and values in order */
	public void hashPrint(){
		// Fill in your codes
		for(int i=0; i<10; i++)
		{
			KVpair<Key, E> curr = T[i];
			if(T[i] != null)
			{
				while(curr != null)
				{
					System.out.print("("+curr.key()+", "+curr.value()+")");
					System.out.print(" ");
					curr = curr.next();
				}
				System.out.println(" ");
			}
		}
	}

	/**
	 * If the key is an Integer, then use a simple mod function for the hash
	 * function. If the key is a String, then use folding.
	 */
	private int hash(Key k) {
		Object keyO = k;
		if (keyO.getClass() == Integer.class) {
			return Integer.parseInt(k.toString()) % M;
		} else {
			return k.hashCode() % M;
		}
	}


}

