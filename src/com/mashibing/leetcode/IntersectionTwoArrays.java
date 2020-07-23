package com.mashibing.leetcode;

import java.util.HashSet;
import java.util.Set;
//349. 两个数组的交集
public class IntersectionTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
           if (set1.contains(i)){
               set2.add(i);
           }
        }
        int[] arr = new int[set2.size()];
        int j=0;
        for (int i: set2){
            arr[j]=i;
            j++;
        }
        return arr;
    }

    public static void main(String[] args) {
        IntersectionTwoArrays intersectionTwoArrays = new IntersectionTwoArrays();
        intersectionTwoArrays.intersection(new int[]{1,2,2,1},new int[]{2,2});
    }

}
