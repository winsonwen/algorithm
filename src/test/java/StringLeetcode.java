import org.junit.jupiter.api.Test;

public class StringLeetcode {

    @Test
    public void reverseString344() {


    }

    @Test
    public void reverseStr541() {
        System.out.println(reverseStr541("abcdefgi", 3));
    }

    @Test
    public void reverseWords151() {

    }

    /*
     * 不用脑子的题
     *
     *
     * */
    public void reverseString344(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char dump = s[left];
            s[left] = s[right];
            s[right] = dump;
            left++;
            right--;
        }
    }

    public String reverseStr541(String s, int k) {


        /*
         * 思路：根据不同的区间来循环，
         * 如果是0-k范围内则直接天界，
         * 否则reverse后再添加
         *
         *
         *
         * */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i += k) {
            int endIndex = Math.min(i + k, s.length());
            if (i % (2 * k) >= k) {
                sb.append(s, i, endIndex);
            } else {
                StringBuilder temp = new StringBuilder();
                temp.append(s, i, endIndex);
                sb.append(temp.reverse());
            }
        }
        return sb.toString();
    }


    public String reverseWords151(String s) {
        /*
         * 困难版： 空间复杂度要求为O(1)
         *
         * 优化请看 reverseWordsBetter
         * */
        StringBuilder res = new StringBuilder();
        char[] chars = s.toCharArray();
        StringBuilder temp = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                if (!temp.isEmpty()) {
                    res.append(temp).append(" ");
                    temp = new StringBuilder();
                }
            } else {
                temp.insert(0,chars[i]);
            }
        }
        if (!temp.isEmpty()) {
            res.append(temp);
        }
        return res.toString();
//        StringBuilder sb = new StringBuilder();
//        String[] split = s.split(" ");
//        sb.append(split[split.length-1]);
//        for(int i=split.length-2;i>=0;i--){
//            if(!Objects.equals(split[i], "")){
//                sb.append(" ").append(split[i]);
//            }
//        }
//        return sb.toString();
    }


    public String reverseWordsBetter(String s) {
        // System.out.println("ReverseWords.reverseWords2() called with: s = [" + s + "]");
        // 1.去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s);
        // 2.反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 3.反转各个单词
        reverseEachWord(sb);
        return sb.toString();
    }

    private StringBuilder removeSpace(String s) {
        System.out.println("ReverseWords.removeSpace() called with: s = [" + s + "]");
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        System.out.println("ReverseWords.removeSpace returned: sb = [" + sb + "]");
        return sb;
    }

    /**
     * 反转字符串指定区间[start, end]的字符
     */
    public void reverseString(StringBuilder sb, int start, int end) {
        // System.out.println("ReverseWords.reverseString() called with: sb = [" + sb + "], start = [" + start + "], end = [" + end + "]");
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
        // System.out.println("ReverseWords.reverseString returned: sb = [" + sb + "]");
    }

    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }
}
















