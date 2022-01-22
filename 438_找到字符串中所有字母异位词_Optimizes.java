//https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
//hint: sliding window
/**
example
s = "cbaebabacd", p = "abc"
charNeeded = {a:1,b:1,c:1}
right = 0, charFound = {c:1}, numValid = 1, right = 1;
right = 1, charFoound = {c:1,b:1}, numValiad = 2,right = 2;
right = 2, charFound = {c:1,b:1,a:1}, numValid = 3, right = 3;
    right -left = 3-0>=p.length() = 3
        numValid = 3 = charNeeded.size() = 3
            res.add(left) = res.add(0);
        move out s[left = "c"], charFound = {b:1,a:1}, numValid = 2, left = 1;
right = 3, charFound = {b:1,a:1}, right = 4
    right -left = 4-1>=p.length() = 3
        move out s[left = "b"], charFound = {a:1}, numValid = 1, left = 2;
right = 4, charFound = {a:1,b:1}, right = 5,numValid = 2
    right -left = 5-2>=p.length() = 3
        move out s[left = "a"], charFound = {b:1}, numValid = 1, left = 3;
right = 5, charFound = {a:1,b:1}, right = 6,numValid = 2
    right -left = 6-3=3
        left = 4
right = 6, charFound = {a:1,b:2}, right = 7,numValid = 2,
    right -left = 7-4=3
        move out s[left = "b"], charFound = {a:1,b:1}, numValid = 1,left =5
right = 7, charFound = {a:2,b:1},right = 8, numValid = 2
    right -left = 8-5=3
        move out s[left = "a"], charFound = {a:1,b:1} , numValid = 1,left = 6;
right = 8, charFound = {a:1,b:1,c:1},numValid= 3, right = 9
    right -left = 9-6=3
        numValid = charNeeded.size()=3
            res.add(left) = res.add(6);
        move out s[left = "b"], charFound = {a:1,c:1} , numValid = 2,left = 7;
right = 9, charFound = {a:1,c:1}
         move out s[left = "a"], charFound = {c:1} right = 10, numValid = 1,left = 8;
return res;


 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> charNeeded = new HashMap<>();
        HashMap<Character,Integer> charFound = new HashMap<>();
        int right =0, left = 0;
        int numValid = 0;
        List<Integer> res = new ArrayList<Integer>();
        for (int i=0;i<p.length();i++) {
            charNeeded.put(p.charAt(i), charNeeded .getOrDefault(p.charAt(i),0)+1);
        }

        while (right < s.length()) { 
            char charAtRight  = s.charAt(right++);
            if (charNeeded.containsKey(charAtRight)){
                charFound.put(charAtRight,charFound.getOrDefault(charAtRight,0)+1);
                if (charNeeded.get(charAtRight).equals(charFound.get(charAtRight))) {
                    numValid ++;
                }
            }else{ 
                /** 优化：左侧字符不再符合异位词条件，全部移出滑动窗口;结果时间空间开销变大
                while(left< right && left < s.length()) {
                    if(charNeeded.containsKey(s.charAt(left))) {
                        charFound.put(s.charAt(left), charFound.get(s.charAt(left) )- 1);
                    }
                    left++;
                }
                numValid = 0;
                */
               
            }
            
            while(right - left >= p.length()) {
                if (numValid == charNeeded.size()) {
                    res.add(left);
                }
                char charAtLeft = s.charAt(left++);
                if (charNeeded.containsKey(charAtLeft)) {
            
                    if (charNeeded.get(charAtLeft).equals(charFound.get(charAtLeft))) {
                        numValid --;
                    }
                    charFound.put(charAtLeft, charFound.get(charAtLeft) - 1);
                }

            }
        }
        return res;
      
    }
}