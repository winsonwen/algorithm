import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HashTableLeetCode {

    @Test
    public void isAnagram242() {
    }

    @Test
    public void intersection349() {
        int[] progress = new int[101];


    }

    @Test
    public void isHappy202() {
    }
    @Test
    public void twoSum1() {
    }




    /*
     * 初始思路：使用map记录char的数量，然后比较即可
     *
     * 优化：由于String里只包含小写字母，所以没必要使用map,用数组记录即可
     * */
    public boolean isAnagram242(String s, String t) {
        int[] record = new int[26];
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }
        for (int count : record) {
            if (count != 0) {
                return false;
            }
        }
        return true;

//        HashMap<Character, Integer> sMap = new HashMap<>();
//        HashMap<Character, Integer> tMap = new HashMap<>();
//        for (char c : s.toCharArray()) {
//            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
//        }
//        for (char c : t.toCharArray()) {
//            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
//        }
//        if (tMap.size() != sMap.size())
//            return false;
//
//        for (char c : sMap.keySet()) {
//            if (!Objects.equals(sMap.get(c), tMap.get(c)))
//                return false;
//        }
//        return true;
    }



    /*
    * 初始思路： 由于 nums1[n] 范围在1-1000之间，所以是小数字用array保存即可，如果是大数字，需要用两个set作保存
    *           统计交集再作返回
    *
    * */
    public int[] intersection349(int[] nums1, int[] nums2) {
        int[] progress = new int[1001];
        int resultSize = 0;
        for (int num : nums1) {
            if (progress[num] == 0) {
                progress[num] = 1;
            }
        }
        for (int num : nums2) {
            if (progress[num] == 1) {
                progress[num] = 2;
                resultSize++;
            }
        }

        int[] result = new int[resultSize];
        int resultIndex=0;
        for(int i=0;i<progress.length;i++){
            if(progress[i] ==2){
                result[resultIndex] = i;
                resultIndex++;
            }
        }
        return result;
    }



    /*
    * 初始思路，用一个for循环统计n的 sum of the squares of its digits
    * 然后把结果存在set里防止有无限循环（n的出现重复）
    * 最后在得出结果
    *
    * */
    public boolean isHappy202(int n) {
        Set<Integer> repeatNumber = new HashSet<>();
        while(n>1 && !repeatNumber.contains(n)){
            repeatNumber.add(n);
            int temp=0;
            for(;n!=0;n/=10){
                int i=n%10;
                temp += i*i;
            }
            n=temp;
        }
        return n==1;
    }

    /*
    * 思路：运用Hashmap来存储已经遍历过的值
    *   找到第二个值的时候只需要判断map中是否有自己所需的第一个值即可。
    *   并不会重复得查找同一个值，所以Map的key记录目标值即可，value用来存储index
    *
    * */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> recordMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
          if(recordMap.containsKey(target -nums[i])){
              return new int[]{i,recordMap.get(nums[i])};
          }
          recordMap.put(nums[i],i );

        }
        throw new IllegalArgumentException();
    }
}
















