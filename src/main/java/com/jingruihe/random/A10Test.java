package com.jingruihe.random;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 1-10题
 * @author: JingRui
 * @date: 2022/8/23
 **/
public class A10Test {

    public static void main(String[] args) {
        // 1
//        int[] nums = {2,7,11,15};
//        int target = 9;
//        int[] result = twoSum(nums, target);
//        System.out.println(Arrays.toString(result));

        // 2
//        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
//        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
//        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
//        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
//        ListNode l3 = addTwoNumbers(l1, l2);
//        System.out.println(l3);

        // 3
        System.out.println("无重复最长子串 = " + lengthOfLongestSubstring("abcabcbb"));
    }

    /**
     * https://leetcode.cn/problems/two-sum/
     * 输入: int[] nums = {2,7,11,15}  target = 9
     * 输出: [0,1]
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        //key是减之后的值, value是下标
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }

    /**
     * https://leetcode.cn/problems/add-two-numbers/
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     * 主要要学会链表遍历和链表添加方法, 其他很简单
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tmp = 0;
        ListNode head = null;
        ListNode tail = null;
        while (l1 != null || l2 != null){
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int total = val1 + val2 + tmp;
            if (head == null){
                head = tail = new ListNode(total%10);
            }else{
                // 这里是链表添加的重点, 第一次head = tail, 所以赋值tail.next就是赋值head, 然后把next赋值给tail, head这时候和tail不相等了
                tail.next = new ListNode(total%10);
                tail = tail.next;
            }
            tmp = total/10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (tmp > 0){
            tail.next = new ListNode(tmp);
        }
        return head;
    }

    /**
     * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (map.containsKey(key)){
                if (i > map.get(key)){
                    max = i;
                    map.put(key+"", max);
                }
            }else{
                map.put(key+"", i);
            }
        }
        return max;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
