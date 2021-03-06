package leetcode.string.palindrome_pairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/6/7 16:30
 */
public class Solution {

    /**
     * Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given list,
     * so that the concatenation of the two words words[i] + words[j] is a palindrome.
     *
     * Input: words = ["abcd","dcba","lls","s","sssll"]
     * Output: [[0,1],[1,0],[3,2],[2,4]]
     * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
     *
     * Input: words = ["bat","tab","cat"]
     * Output: [[0,1],[1,0]]
     * Explanation: The palindromes are ["battab","tabbat"]
     *
     * Input: words = ["a",""]
     * Output: [[0,1],[1,0]]
     *
     * @param words
     * @return
     */
    public List<List<Integer>> palindromePairs(String[] words) {

        // Brute force

//        List<List<Integer>> ans = new ArrayList<>();
//        int n = words.length;
//        for(int i=0; i< n; i++)
//        {
//            for(int j=0; j<n; j++)
//            {
//                if(i == j ) continue;
//                if(!check(words[i] + words[j]))
//                    continue;
//                List<Integer> temp = new ArrayList<>();
//                temp.add(i);
//                temp.add(j);
//                ans.add(temp);
//            }
//        }
//
//        return ans;

        // use trie .for each string, we save it trie in reverse order
        List<List<Integer>> res = new ArrayList<>();

        TrieNode root = new TrieNode();

        for(int i=0; i<words.length;i++)
        {
            addWord(root,words[i],i);
        }

        for (int i=0; i<words.length; i++)
        {
            search(words,i,root,res);
        }

        return res;
    }

    private void addWord(TrieNode root, String word, int index)
    {
        for(int i = word.length() - 1;i >=0; i--)
        {
            int j = word.charAt(i) - 'a';

            if(root.next[j] == null)
            {
                root.next[j] = new TrieNode();
            }

            if(isPalindrome(word,0,i))
            {
                root.list.add(index);
            }
            root = root.next[j];
        }
        root.list.add(index);
        root.index = index;
    }

    private void search(String[] words, int i, TrieNode root, List<List<Integer>> res)
    {
        for(int j=0; j<words[i].length(); j++)
        {
            if(root.index >=0 && root.index != i && isPalindrome(words[i],j,words[i].length() - 1))
            {
                res.add(Arrays.asList(i,root.index));
            }

            root = root.next[words[i].charAt(j) - 'a'];
            if (root == null)
                return;
        }

        for (int j: root.list)
        {
            if(i == j)
                continue;
            res.add(Arrays.asList(i,j));
        }
    }

    private boolean isPalindrome(String word, int i, int j)
    {
        while (i< j)
        {
            if(word.charAt(i++) != word.charAt(j--))
                return false;
        }
        return true;
    }

    private static class TrieNode
    {
        TrieNode[] next;
        int index;
        List<Integer> list;

        TrieNode()
        {
            next = new TrieNode[26];
            index = -1;
            list = new ArrayList<>();
        }
    }

    private boolean check(String s)
    {
        int i = 0, j = s.length()-1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}
