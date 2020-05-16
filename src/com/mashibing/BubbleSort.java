package com.mashibing;

public class BubbleSort {
	public static void main(String[] args) {
		int[] a = { 9, 3, 1, 4, 6, 8, 1, 5, 2};
		sort3(a);
		print(a);
	}
	static void sort2(int[] arr) {
		for(int i=0;i<arr.length;i++){
			for (int j=0;j<arr.length-i-1;j++){
				if (arr[j]>arr[j+1]){
					swap(arr,j+1,j);
				}
			}
		}
	}
	static void sort3(int[] arr) {
		for(int i=arr.length-1;i>0;i--){
			for (int j=0;j<i;j++){
				if (arr[j]>arr[j+1]){
					swap(arr,j+1,j);
				}
			}
		}
	}
	static void sort(int[] a) {
		for(int i=a.length-1; i>0; i--)
			findMax(a, i);
	}
	
	static void findMax(int[] a, int n) {
		for(int j=0; j<n; j++) {
			if(a[j] > a[j+1]) swap(a, j, j+1);
		}
	}

	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static void print(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
