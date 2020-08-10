package com.sort;


public class HybridSorter<K extends Comparable<? super K>> {
	InsertionSorter<K> insertionSort = new InsertionSorter<K>();
	private final int RUN = 32;
	/**
	 * Sorts the elements in given array from `left` to `right in lexicographic order
	 * using the hybrid sorting algorithm.
	 */

	public Pair<K, ?> search(Pair<K,?>[] array, int k, String sortType) {//하이브리드 이용
		// Fill your code to sort the elements in `array`.
		return array[k];
	}
	
	public void sort(Pair<K, ?>[] array, int left, int right, String sortType) {
		// Fill your code to sort the elements in `array`.
		if(right - left <= 31) {
			InsertionSorter insertionSort = new InsertionSorter();
			insertionSort.sort(array, left, right, sortType);
		}
		else {
			int pivotIndex = findpivot(array, left, right);
			swap(array, pivotIndex, right);
			int k = partition(array, left-1, right, array[right], sortType);
			swap(array, k, right);
			if((k-left) > 1) sort(array, left, k-1, sortType);
			if((right-k) > 1) sort(array, k+1, right, sortType);
		}
	}

	// Hint: Maybe you need to create the helper methods such as partitioning.
	public int findpivot(Pair<K, ?>[] array, int i, int j)
	{
		return (i+j)/2;
	}

	public int partition(Pair<K, ?>[] array, int l, int r, Pair<K, ?> pivot, String sortType)
	{
		if(sortType.equals("keys"))
		{
            /*
            System.out.println("search");
            System.out.println(search(array, 1, sortType));
            */

            do{
				while (array[++l].getKey().compareTo(pivot.getKey()) < 0);
				while ((r!=0) && (array[--r].getKey().compareTo(pivot.getKey()) > 0));
				Pair temp = array[l];
				array[l] = array[r];
				array[r] = temp;
			} while (l<r);
			Pair temp = array[l];
			array[l] = array[r];
			array[r] = temp;
			return l;
		}
		else if(sortType.equals("values"))
		{
            /*
		    System.out.println("search");
            System.out.println(search(array, 1, sortType));
            */

			do {
				while (array[++l].getValue() < pivot.getValue()) ;
				while ((r != 0) && (array[--r].getValue() > pivot.getValue())) ;
				Pair temp = array[l];
				array[l] = array[r];
				array[r] = temp;
			} while (l < r);
			Pair temp = array[l];
			array[l] = array[r];
			array[r] = temp;
			return l;
		}
		return 0;
	}

	private void swap(Pair<K, ?>[] array, int i, int j)
	{
		Pair temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/* sample input
	n 3
append hello 5
append data 4
append structure 1
sort keys
print
sort values
print
	 */
}
