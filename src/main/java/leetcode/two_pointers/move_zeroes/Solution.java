package leetcode.two_pointers.move_zeroes;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/7/1 19:47
 */
public class Solution {

    /**
     * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     *
     * Note that you must do this in-place without making a copy of the array.
     *
     * Input: nums = [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     *
     * Input: nums = [0]
     * Output: [0]
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        // Shift non-zero values as far forward as possible
        // Fill remaining space with zeros
        if(nums == null || nums.length == 0)
        {
            return;
        }

        int insertPos = 0;
        for (int num: nums)
        {
            if(num != 0)
            {
                nums[insertPos++] = num;
            }
        }

        while (insertPos < nums.length)
        {
            nums[insertPos++] = 0;
        }
    }
}
