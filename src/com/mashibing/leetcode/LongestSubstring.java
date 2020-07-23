package com.mashibing.leetcode;

import java.util.HashMap;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int start=0,end=0,ans=0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();//key值为的字符 value字符位置 +1    加 1 表示从字符位置后一个才开始不重复
        while (end<s.length()){
            char alpha=s.charAt(end);
            if (map.containsKey(alpha)){
                start=Math.max(map.get(alpha),start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
            end++;
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        int ans =longestSubstring.lengthOfLongestSubstring("abcabcd");
        System.out.println(ans);
    }

}
