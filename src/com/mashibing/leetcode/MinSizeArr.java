package com.mashibing.leetcode;

/***
 * 长度最小子数组
 */
public class MinSizeArr {

    public int minSubArrayLen(int s, int[] nums) {
        int start=0,end=0,sum=0;
        int ans=Integer.MAX_VALUE;
        while(end<nums.length){
            sum=sum+nums[end];
            while (sum>=s){//TODO 是while而不是if
                ans=Math.min(ans,end-start+1);
                sum=sum-nums[start];
                start++;
            }
                end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        MinSizeArr minSizeArr=new MinSizeArr();
        int[] arr={1,1,1,2};
        int s=3;
        System.out.println(minSizeArr.minSubArrayLen(s,arr));
    }

}
