package com.mashibing.leetcode;

import java.util.Arrays;
//350
public class IntersectionTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[Math.min(length1, length2)];//返回结果
        int index1 = 0, index2 = 0, index = 0;
        while (index1<length1&&index2<length2){ //较小的右移，相等的放进去
            if (nums1[index1]==nums2[index2]){
                intersection[index]=nums1[index1];
                index++;index1++;index2++;
            }else if(nums1[index1]<nums2[index2]){
                index1++;
            }else{
                index2++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    public static void main(String[] args) {
        IntersectionTwoArraysII intersectionTwoArraysII = new IntersectionTwoArraysII();
        int[] end =intersectionTwoArraysII.intersect(new int[]{1,2,3},new int[]{4,5,6,1,2,1});
        for (int i : end) {
            System.out.println(i);
        }
    }


}
