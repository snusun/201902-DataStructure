package com.sort;

public class InsertionSorter<K extends Comparable<? super K>> {

	/**
	 * Sorts the elements in given array from `left` to `right` in lexicograph order using insertion sort algorithm.
	 */
	
	public void sort(Pair<K, ?>[] array, int left, int right, String sortType) { //왜 left랑 right가 필요한지
		// Fill your code to sort the elements in `array`.
		if(sortType.equals("keys")) // key sort
		{
			//array[i].getKey 이런식으로 쓸 수 있다.
			for(int i=1; i<array.length; i++)
			{
				for(int j=i; (j>0) && (array[j].getKey().compareTo(array[j-1].getKey()) <0); j--)
				{
					swap(array, j, j-1);
				}
			}
		}
		else if(sortType.equals("values")) // value sort
		{
			for(int i=1; i<array.length; i++)
			{
				for(int j=i; (j>0) && (array[j].getValue() < array[j-1].getValue()); j--)
				{
					swap(array, j, j-1);
				}
			}
		}
	}

	// Hint: Maybe you need to create the helper methods.
	private void swap(Pair<K, ?>[] array, int i, int j)
	{
		Pair temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}