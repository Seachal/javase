package com.cn.javase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangquanit
 */
public class Test {

	public static void main(String[] args) {
		// int[] A = new int[9];
		// A[0] = -1;
		// A[1] = 1;
		// A[2] = 3;
		// A[3] = 3;
		// A[4] = 3;
		// A[5] = 2;
		// A[6] = 1;
		// A[7] = 0;
		// A[8] = -1;
		//
		// int count=test2(A);
		// System.out.println(count);

		int[] A = new int[6];
		A[0] = 4;
		A[1] = 3;
		A[2] = 2;
		A[3] = 5;
		A[4] = -1;
		A[5] = 10;
		int max = max3(A);
		System.out.println(max);
	}

	public static int test(int[] A) {
		if (null == A || A.length < 3)
			return 0;
		int len = A.length;
		for (int i = 0; i < len; i++) {

		}

		return 0;
	}

	public static void sub(int start, int[] A) {
		int len = A.length;
		int begin = start;
		int diff = A[start + 1] - A[start];
		begin = start + 1;
		while (begin < len - 1) {

		}
	}

	public static int test2(int[] A) {
		if (A.length < 3)
			return 0;
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			if (i + 2 > A.length) {
				return count;
			}

			for (int j = i + 2; j < A.length; j++) {
				if (A[i + 1] - A[i] == A[j] - A[j - 1]) {
					count++;
				}
			}
		}
		return count;
	}

	public static int max3(int[] A){
		if (A.length < 3)
			return 0;
		int max1 = A[0]; //第一位元素
		int len = A.length;
		int max2 = A[len-1];
		for(int i=1;i<len-1;i++){
			if(A[i]>max1)max1=A[i];
		}
		
		
		return max1-max2;
	}
	public static int max(int[] A) {
		if (A.length < 3)
			return 0;
		int max1 = A[0]; //第一位元素
		int len = A.length;
		int max2 = A[len-1];
		// 最后一个元素为负数,则直接求max1
		if (max2 < 0) {
			len = len - 2; //少循环1位
			for (int i = 1; i < len; i++) {
				if (A[i] > max1) {
					max1 = A[i];
				}
			}
		} else {
			for(int i=len-2;i>0;i--){
				if(A[i]>max2){
					
				}
			}
		}
		return max1 - max2;
	}
	
	
	public static int max2(int[] is){
		if(is.length<3)
			return 0;
		
		int max1=is[0];
		int max2=0;
		for (int i = 0; i < is.length; i++) {
			if(max1<=is[i]){
				max1=is[i];
				if(i+1>is.length-1){
					return 0;
				}
				max2=is[i+1];
			}else{
				if(max2<is[i]){
					max2=is[i];	
				}
			}
				
		}
		return max1-max2;

	}
}
