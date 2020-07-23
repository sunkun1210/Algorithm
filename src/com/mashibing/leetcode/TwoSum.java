package com.mashibing.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] arr,int sum){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int target =sum-arr[i];
            if (map.containsKey(target)){
                return new int[]{map.get(target),i};
            }
            map.put(arr[i],i);
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] arr={1,2,3,4,7};
        int[] arrIndex = twoSum.twoSum(arr,111);
        for (int index : arrIndex) {
            System.out.println(index);
        }
    }

}
