import org.junit.jupiter.api.Test;

public class Array {

    /*

     * */
    @Test
    public void binarySearch704() {
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


    @Test
    public void removeElement27() {
        removeElement27(new int[]{2, 2, 3}, 2);

    }

    public int removeElement27(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;

        //        int left = 0;
//        int right = nums.length -1;
//
//        while(left <= right){
//            while(right>=0&&nums[right]==val ){
//                right--;
//            }
//
//            if(right<0){
//                return 0;
//            }else if(left > right){
//                break;
//            }
//
//            if(nums[left]==val){
//                nums[left]= nums[right];
//                nums[right]= val;
//                right--;
//            }
//            left ++;
//        }
//        return right + 1;
    }


}
