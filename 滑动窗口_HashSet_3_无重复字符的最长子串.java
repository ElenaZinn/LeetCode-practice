//https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
/**
example: s = "abcabcbb"
right = -1, left = 0，满足while循环条件
    appearChar = [a], right = 0
    appearChar = [a,b],right = 1
    appeaerChar = [a,b,c],right = 2, appearChar.contains(s[3] = a),不满足循环条件，跳出循环, resLength =right -left +1 = 3
left = 1 !=0, appearChar.remove(s[0] = a), appearChar = [b,c], right = 2, 满足while条件
    in while: appearChar = [b,c,a],right = 3, appearChar.contains(s[4] = b),不满足循环条件，跳出循环, resLength =right -left +1 = 3-1+1 = 3
left = 2,  appearChar.remove(s[1] = b), appearChar = [c,a],right =3, 满足while条件
    in while: appearChar = [c,a,b],right = 4, appearChar.contains(s[5] = c),不满足循环条件，跳出循环, resLength =right -left +1 = 4-2+1 = 3
left = 3,  appearChar.remove(s[2] = c), appearChar = [a,b],right = 4,满足while条件
    in while: appearChar = [a,b,c],right = 5, appearChar.contains(s[6] = b),不满足循环条件，跳出循环, resLength =right -left +1 = 5-3+1 = 3
left = 4,  appearChar.remove(s[3] = a), appearChar = [b,c],right = 5, appearChar.contains(s[6] = b),不满足循环条件,不进入循环, resLength =resLength = 3
left = 5,   appearChar.remove(s[4] = b), appearChar = [c],right = 5, 满足循环
    in while: appearChar = [b,c],right = 6, resLength = resLength = 3
left = 6,   appearChar.remove(s[5] = c), appearChar = [b],right = 6,appearChar.contains(s[7] = b),不满足循环条件，不进入循环, resLength =resLength = 3
left = 7,   appearChar.remove(s[6] = b), appearChar = [],right = 6, 满足条件
    in while: appearChar = [b], right = 7 resLength =resLength = 3
 */
import java.util.HashSet;//引入HashSet类
class Solution {
    //hint：sliding window
    public int lengthOfLongestSubstring(String s){
        //哈希集合，记录每个字符是否出现过
        Set<Character> appearChar = new HashSet<Character>();
        int sLength = s.length();
        //right:右指针，初始值为-1，相当于我们在字符串的 左边界的左侧，还没有开始移动
        //resLength: 记录字串长度
        int right = -1, resLength = 0;
        for (int left = 0; left < sLength; left++) {
            if(left != 0){
                //左指针一次递增，直至把重复字符之前的元素全部删除掉
                System.out.println("before remove, left = " + left + " s.charAt(left-1)" + s.charAt(left-1) );
                appearChar.remove(s.charAt(left-1));
                System.out.println("after remove, appearChar = " + appearChar);
            }
            System.out.println("brefore while, right = " + right);
            while(right + 1 < sLength && !appearChar.contains(s.charAt(right+1))) {
                //不包含重复的元素，不断的移动右指针
                appearChar.add(s.charAt(right+1));
                ++right;
                System.out.println("during while, right = " + right + " appearChar = " + appearChar);
            }
            //此时，第i到right个字符是一个极长的无重复字符串
            resLength = Math.max(resLength, right-left +1);
            System.out.println("out while, resLength = " + resLength + " right = " + right + " left = " + left);
        }
        return resLength;
    }
}
/**
HashSet的基本用法：https://m.runoob.com/java/java-hashset.html?ivk_sa=1024320u
 */