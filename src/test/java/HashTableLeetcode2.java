import org.junit.jupiter.api.Test;

import java.util.*;

public class HashTableLeetcode2 {

    @Test
    public void fourSumCount454() {
    }

    @Test
    public void canConstruct383() {

    }

    @Test
    public void threeSum15() {
        threeSum15(new int[]{1,0,-1,0,-2,2});
        threeSum15(new int[]{0, 0, 0});
    }

    @Test
    public void fourSum18() {
//        fourSum18(new int[]{1,0,-1,0,-2,2},0);
        fourSum18(new int[]{2,2,2,2,2},8);

    }

    /*
     * 思路： 两两统计总数即可，复杂度为O(n^2)
     *
     * */
    public int fourSumCount454(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        Map<Integer, Integer> record = new HashMap<>();

        for (int num : nums1) {
            for (int num2 : nums2) {
                record.put(num2 + num, record.getOrDefault(num + num2, 0) + 1);
            }
        }

        for (int num : nums3) {
            for (int num2 : nums4) {
                res += record.getOrDefault(-(num + num2), 0);
            }
        }
        return res;
    }

    public boolean canConstruct383(String ransomNote, String magazine) {
        int[] record = new int[26];
        int count = 0;
        for (char c : ransomNote.toCharArray()) {
            record[c - 'a']++;
            count++;
        }

        for (char c : magazine.toCharArray()) {
            if (record[c - 'a']-- > 0) {
                count--;
            }
            if (count == 0) {
                return true;
            }
        }
        return false;
    }


    /*
     * 思路： 3指针操作 -》 有总合为0的则存起来，下一个循环直接跳过有一样的数值
     * 问题：运行时间过久，O(n^3)
     * 原因，没必要把left都循环起来，因为会重复已经查过的元素，只需要得出值的基础上的left  right进行循环即可，只需要继续查找left和right间的部分
     *
     * 优化完成：直接编程了O(n^2)
     *
     * */
    public List<List<Integer>> threeSum15(int[] nums) {
        Arrays.sort(nums);
        LinkedList<List<Integer>> res = new LinkedList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                    left++;
                    right--;
                }

            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }


//        for (int i = 0; i < nums.length-2; i++) {
//            if(nums[i]>0){
//                break;
//            }
//            for(int left=i+1;left<nums.length-1;left++) {
//                int right = nums.length - 1;
//                while (left < right) {
//                    int sum = nums[i] + nums[left] + nums[right];
//                    if (sum < 0) {
//                        left++;
//                    } else if (sum > 0) {
//                        right--;
//                    } else {
//                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
//                        break;
//                    }
//
//                }
//                while(left<nums.length-1 && nums[left]==nums[left+1]){
//                    left++;
//                }
//            }
//            while(i<nums.length-2 && nums[i]==nums[i+1]){
//                i++;
//            }
//        }

        return res;
    }


    /*
     * 思路： 思路跟sum3一致三指针，只需再外面套多一层
     * 注意点，数值总和有可能超过Integer.MAX_VALUE，需用Long处理
     * long sum = (long)nums[i] + nums[left] + nums[right] +nums[j];
     * */

    public List<List<Integer>> fourSum18(int[] nums, int target) {
        Arrays.sort(nums);
        LinkedList<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 3; i++) {
             for (int j = i+1; j < nums.length - 2; j++) {
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long)nums[i] + nums[left] + nums[right] +nums[j];
                    if (sum < (long) target) {
                        left++;
                    } else if (sum > (long) target) {
                        right--;
                    } else {
                        res.add(Arrays.asList(nums[i],nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
                while (j < nums.length - 2 && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            while (i < nums.length - 3 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }


}






















