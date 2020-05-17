package com.mashibing;

public class BinarySearch {

	public static void main(String[] args) {
		swap();
	}

	/***
	 * 异或运算满足交换律和结合律(同一匹数异或起来的结果一样的)
	 * 异或就是无进位的相加
	 */
	private static void swap(){
		int a=1;
		int b=2;
		a=a^b;
		b=a^b;
		a=a^b;
		System.out.println("a="+a);
		System.out.println("b="+b);

	}

	/***
	 * 局部最小值，极小值
	 * @param arr
	 * @return
	 */
	private  static  int lessIndex(int[] arr){
		if (arr[0]<arr[1]){
			return 0;
		}
		if (arr[arr.length-1]<arr[arr.length-2]){
			return arr.length-1;
		}
		int left=1;
		int right=arr.length-2;
		int mid =0;
		while (left<right){
			mid=(left+right)>>1; /**带符号右移=除以2**/
			if (arr[mid]>arr[mid-1]){ //继续二分
				right=mid-1;
			}else if(arr[mid]>arr[mid+1]){//继续二分
				left=mid+1;
			}else{ //即比左边小 又比右边小
				return mid;
			}
		}
		return left;
	}

	/***
	 * 在arr上 找满足>=value的最左位置
	 */
	public static int nearestIndex(int[] arr,int value){
		int l=0;
		int r=arr.length-1;
		int index =-1;
		while (l<=r){
			int mid = (l+r)/2;
			if (arr[mid]>=value){
				index=mid;
				r=mid-1;
			}else {
				l=mid+1;
			}
		}
		return index;
	}
	public static int find(int[] arr,int value){
		int l=0;
		int r=arr.length-1;
		int index =-1;
		while (l<=r){
			int mid = (l+r)/2;
			if (arr[mid]>value){
				r=mid-1;
			}else if (arr[mid]<value){
				l=mid+1;
			}else{
				index=mid;
				break;
			}
		}
		return index;
	}

	/**
	 * arr中 有两种数，出现奇数次
	 */
	private  static void printOddTimesNum2(int[] arr){
		int eor=0;
		for(int i=0;i<arr.length;i++){
			eor^=arr[i];
		}
		//eor = a^b
		//eor !=0
		//eor必有一个位置上是1
		int rightOne=eor &(-eor+1); //提取最右的1
	}

}
