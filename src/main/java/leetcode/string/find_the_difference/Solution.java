package leetcode.string.find_the_difference;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/6/27 19:31
 */
public class Solution {

    /**
     * You are given two strings s and t.
     *
     * String t is generated by random shuffling string s and then add one more letter at a random position.
     *
     * Return the letter that was added to t.
     *
     * Input: s = "abcd", t = "abcde"
     * Output: "e"
     * Explanation: 'e' is the letter that was added.
     *
     * Input: s = "", t = "y"
     * Output: "y"
     *
     * Input: s = "a", t = "aa"
     * Output: "a"
     *
     * Input: s = "ae", t = "aea"
     * Output: "a"
     *
     * 我们可以根据 交换律、 结合律 将相同的数字优先两两进行异或运算。
     * 此时根据 归零率 ，每两个相同的数字都变成了 0，再根据 恒等率 ，把式子里所有的 0 去了，此时就只剩下只出现一次的那个数了！
     *
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t)
    {
//        char c = 0;
//        for(int i=0; i<s.length(); ++i)
//        {
//            c ^= s.charAt(i);
//        }
//        for(int i=0; i<t.length();++i)
//        {
//            c ^= t.charAt(i); // c = (char) ( (int) c ^  (int) s.charAt(i));
//        }
//        return c;

//        3 ^ 5 = 6 , 6 ^ 5 = 3
//        int n = t.length();
//        char c = t.charAt(n - 1);
//
//        for(int i=0; i<n-1; ++i)
//        {
//            c ^= s.charAt(i);
//            c ^= t.charAt(i);
//        }
//
//        return c;


        char[] chs = s.toCharArray(), cht = t.toCharArray();
        int sums = 0, sumt = 0;
        for(char c : chs)
            sums += (int)c;
        for(char c : cht)
            sumt += (int)c;
        return (char)(sumt-sums);
    }

}
