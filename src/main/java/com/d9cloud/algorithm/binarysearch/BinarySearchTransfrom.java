package com.d9cloud.algorithm.binarysearch;

/**
 * Description:
 *
 * @author: litianyi
 * @date: Created on 2022/03/21
 */
public class BinarySearchTransfrom {

    /**
     * 查找第一个等于给定值的下标
     * @param nums
     * @param target
     * @return
     */
    public int findFirstTarget(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (target > nums[middle]) {
                high = middle - 1;
            } else if (target < nums[middle]){
                low = middle + 1;
            } else {
                if (middle == 0 || nums[middle - 1] != target) {
                    return middle;
                }
                high = middle - 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个等于给定值的下标
     * @param nums
     * @param target
     */
    public int findLastTarget(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (target > nums[middle]) {
                high = middle - 1;
            } else if (target < nums[middle]){
                low = middle + 1;
            } else {
                if (middle == high || nums[middle + 1] != target) {
                    return middle;
                }
                low = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的下标
     * @param nums
     * @param target
     */
    public int findFirstGeTarget(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (target <= nums[middle]) {
                return -1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的下标
     * @param nums
     * @param target
     */
    public int findLastLeTarget(int[] nums, int target) {
        return -1;
    }

    public static void main(String[] args) {
        BinarySearchTransfrom binarySearch = new BinarySearchTransfrom();
        int[] nums = {2,5,6,8,12,59,69,69,69,69,69,89,95,102};

        int firstTarget = binarySearch.findFirstTarget(nums, 69);
        System.out.println("第一个等于给定值的下标: " + firstTarget);

        int lastTarget = binarySearch.findLastTarget(nums, 69);
        System.out.println("最后一个等于给定值的下标: " + lastTarget);

    }

}
