/**
 */
/**
 * https://leetcode.cn/problems/largest-merge-of-two-strings/
 */
class Solution {
    public String largestMerge(String word1, String word2) {
        // int len1 = word1.length();
        // int len2 = word2.length();
        // int len = len1 < len2 ? len1 : len2;
        // StringBuilder sb = new StringBuilder("");
        // String w1 = word1;
        // String w2 = word2;
        // for ( int i=0;i<len;i++) {
        //     String[] strs = giveMergeString(w1,w2);
        //     w1 = strs[0];
        //     w2 = strs[1];
        //     sb.append(strs[2]);
        // }
        // if (w1 != null) {
        //     sb.append(w1);
        // }
        // if (w2 !=null) {
        //     sb.append(w2);
        // }
        // return sb.toString();
        StringBuilder sb = new StringBuilder("");
        while(w1.length() + w2.length() >0) {
            if (w1.compareTo(w2) > 0) {
                sb.append(w1.charAt(0));
                w1 = w1.substring(1);
            }else {
                sb.append(w2.charAt(0));
                w2 = w2.substring(1);
            }
        }
        return sb.toString();

    }

    public String[] giveMergeString(String a, String b) { //posible problem: 没考虑到整体最大，只考虑了局部最大，局部最大不能表示整体最大，即当a.charAt(0) >= b.charAt(0)， 有可能b > a, 需要返回b[0]而不是a[0]
        if (a== null  && b== null) {
            return new String[] {"", "",""};
        }
        if (a==null) {
            return new String[] {"", b,"" + b};
        }
        if (b == null) {
            return new String[] {a, "",a};
        }
        if (a.charAt(0) >= b.charAt(0)) {
            return new String[] {a.substring(1),b, "" + a.charAt(0)};
        }else {
            return new String[] {a, b.substring(1), "" + b.charAt(0)};
        }
        
        

    }
}