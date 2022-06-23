package cn.anton.sort;

import java.util.Arrays;

public class MergeSort {
	
	public static void merge(int arr[]) {
		if (arr == null || arr.length < 2) return;
		process(arr, 0, arr.length-1);
	}
	
	private static void process(int[] arr, int L, int R) {
		if (R == L) return;
		int mid = L + ((R - L) >> 1);
		process(arr, L, mid);
		process(arr, mid + 1, R);
		merge(arr, L, mid, R);
	}
	
	private static void merge(int[] arr, int L, int M, int R) {
		int[] help = new int[(R - L) + 1];
		int i = 0;
		int p1 = L;
		int p2 = M + 1;
		
		
		while (p1 <= M && p2 <= R) 
			help[i++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
		
		while (p1 <= M) 
			help[i++] = arr[p1++];
		
		while (p2 <= R)
			help[i++] = arr[p2++];
		
		for (i=0; i<help.length; i++) 
			arr[L + i] = help[i];
			
	}
	
	public static void main(String[] args) {
		int[] arr = {8, 8, 4, 99, 44, 2, 7, 9, 1, 5, 7, 23, 34, 57, 43};
		MergeSort.merge(arr);
		System.out.println(Arrays.toString(arr));
	}
	
}
