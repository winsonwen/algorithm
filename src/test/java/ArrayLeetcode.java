import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayLeetcode {

    /*
     * */
    @Test
    public void binarySearch704() {
    }

    @Test
    public void removeElement27() {
        removeElement27(new int[]{2, 2, 3}, 2);

    }

    @Test
    public void sortedSquares977() {
        int[] ints = sortedSquares977(new int[]{-5, -3, -2, -1});
    }


    @Test
    public void minSubArrayLen209() {

        Assertions.assertEquals(2, minSubArrayLen209(7, new int[]{2, 3, 1, 2, 4, 3}));

    }

    @Test
    public void generateMatrix59() {
        generateMatrix59(4);
    }


    public int binarySearch704(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return index;

    }



    public int removeElement27(int[] nums, int val) {
        /*
         * 初步思路       双指针
         *  ->  设置一个左指针和右指针进行比较移动
         *
         * 优化思路：没必要从左右开始，只需要设置一个块指针和一个慢指针，快指针进行找值，慢指针进行放值
         *
         * */
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;

        /*
         * 优化写法
         *
         * */
//        int leftIndex = 0;
//        int rightIndex = nums.size() - 1;
//        while (leftIndex <= rightIndex) {
//            // 找左边等于val的元素
//            while (leftIndex <= rightIndex && nums[leftIndex] != val){
//                ++leftIndex;
//            }
//            // 找右边不等于val的元素
//            while (leftIndex <= rightIndex && nums[rightIndex] == val) {
//                -- rightIndex;
//            }
//            // 将右边不等于val的元素覆盖左边等于val的元素
//            if (leftIndex < rightIndex) {
//                nums[leftIndex++] = nums[rightIndex--];
//            }
//        }
//        return leftIndex;

        /*
         *
         * 原始写法： 以为一定要  order
         * */
//        int left = 0;
//        int right = nums.length -1;
//        while(left <= right){
//            while(right>=0&&nums[right]==val ){
//                right--;
//            }
//            if(right<0){
//                return 0;
//            }else if(left > right){
//                break;
//            }
//            if(nums[left]==val){
//                nums[left]= nums[right];
//                nums[right]= val;
//                right--;
//            }
//            left ++;
//        }
//        return right + 1;
    }


    public int[] sortedSquares977(int[] nums) {
        /*
         * 初步思路       双指针
         * 先找到平方最小值确定中间值 ->  以中间值为中点双指针向左右取得相对最小平方值放入新数组中
         * 优化：没必要找中间值，直接从从最左点最右点开始
         *
         * */
        int right = nums.length - 1;
        int left = 0;
        int[] result = new int[nums.length];
        int index = result.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[index--] = nums[left] * nums[left];
                ++left;
            } else {
                result[index--] = nums[right] * nums[right];
                --right;
            }
        }
        return result;

//        int minIndex = 0;
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            if (Math.abs(nums[i]) < min) {
//                minIndex = i;
//                min = Math.abs(nums[i]);
//            }
//        }
//
//        int[] result = new int[nums.length];
//        result[0] = (int) Math.pow(nums[minIndex], 2);
//        int leftIndex = minIndex - 1, rightIndex = minIndex + 1;
//
//        for (int i = 1; i < nums.length; ) {
//            int left = -1, right = -1;
//
//            if (leftIndex >= 0) {
//                left = (int) Math.pow(nums[leftIndex], 2);
//            }
//            if (rightIndex < nums.length) {
//                right = (int) Math.pow(nums[rightIndex], 2);
//            }
//
//            if (left != -1 && right != -1) {
//                if (left <= right) {
//                    result[i] = left;
//                    leftIndex--;
//                } else {
//                    result[i] = right;
//                    rightIndex++;
//                }
//                i++;
//            } else if (left != -1) {
//                result[i] = left;
//                leftIndex--;
//                i++;
//            } else if (right != -1) {
//                result[i] = right;
//                rightIndex++;
//                i++;
//            }
//        }
//        return result;
    }



    public int minSubArrayLen209(int target, int[] nums) {

        /*
         * 时间复杂度是O(n)
         *  时间复杂度是O(n)
         *   窗口内是什么？
         *   如何移动窗口的起始位置？
         *   如何移动窗口的结束位置？
         *   窗口就是 满足其和 ≥ s 的长度最小的 连续 子数组。
         *   窗口的起始位置如何移动：如果当前窗口的值大于s了，窗口就要向前移动了（也就是该缩小了）。
         *   窗口的结束位置如何移动：窗口的结束位置就是遍历数组的指针，也就是for循环里的索引。
         *
         * */
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
//
//        int leftIndex = 0;
//        int sum = 0;
//        int result = Integer.MAX_VALUE;
//        for (int rightIndex = 0; rightIndex < nums.length; rightIndex++) {
//            sum += nums[rightIndex];
//            while (leftIndex < rightIndex && target <= sum - nums[leftIndex]) {
//                sum -= nums[leftIndex];
//                leftIndex++;
//            }
//            if (sum >= target) {
//                result = Math.min(result, rightIndex - leftIndex + 1);
//            }
//        }
//        return result == Integer.MAX_VALUE ? 0 : result;

    }


    /*
     * 思路   注意开闭区间即可
     *
     *  优化：每个循环初始点其实都是 0,0    1,1   2,2
     * */
    public int[][] generateMatrix59(int n) {

        int[][] result = new int[n][n];
        int loop = n-1;   // how many number will be filled in a round
        int num = 1;

        int start = 0;
        int rowIndex;
        int columIndex;
        while (loop>0) {
            for (columIndex = start; columIndex < loop+start ; columIndex++) {
                result[start][columIndex] = num;
                num++;
            }
            for (rowIndex = start; rowIndex < loop+start ; rowIndex++) {
                result[rowIndex][columIndex] = num;
                num++;
            }
            for (; columIndex > start; columIndex--) {
                result[rowIndex][columIndex] = num;
                num++;
            }
            for (; rowIndex > start; rowIndex--) {
                result[rowIndex][columIndex] = num;
                num++;
            }
            loop -= 2;
            start++;
        }

        if (n % 2 == 1) {
            result[start][start] = num;
        }

        return result;


//        int[][] result = new int[n][n];
//        int finalNumber = n * n;
//        int loop = n;
//        int num = 1;
//
//        int rowIndex = 0;
//        int columIndex = 0;
//
//        while (num <= finalNumber) {
//            for (int i = 0; i < loop; i++) {
//                result[rowIndex][columIndex++] = num;
//                num++;
//            }
//            columIndex--;
//            rowIndex++;
//
//            for (int i = 0; i < loop - 1; i++) {
//                result[rowIndex++][columIndex] = num;
//                num++;
//            }
//            rowIndex--;
//            columIndex--;
//
//            for (int i = 0; i < loop - 1; i++) {
//                result[rowIndex][columIndex--] = num;
//                num++;
//            }
//            rowIndex--;
//            columIndex++;
//            for (int i = 0; i < loop - 2; i++) {
//                result[rowIndex--][columIndex] = num;
//                num++;
//            }
//            columIndex++;
//            rowIndex++;
//            loop -= 2;
//        }
//
//
//        return result;
    }

}
