//https://leetcode-cn.com/problems/permutation-in-string/
/**
test example
s1 = "ab", s2 = "eidbaooo"
need = {a:1,b,1}
[eid] right-left = 2-0 >=s1.length, valid=0<need.size(), 什么都不做
[eidb] window = {b:1}, right-left = 3-0 >=s1.length, valid = 1, <need.size()
    d = e  [idb]
    d = i  [db]
    d = d  [b]  right-left = 3-1 <s1.length
[ba] window = {a:1,b:1},right-left  = 4-1=2 >=s1.length, valid = 2 = need.size(), return true;
 */
class Solution {
    //hint: sliding window
    public boolean checkInclusion(String s1, String s2) {
        int right = 0,left = 0;
        int valid = 0;
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        //generate need 
        int p=0;
        while (p<s1.length()) {
            need.put(s1.charAt(p), need.getOrDefault(s1.charAt(p),0) + 1);
            p++;
        }
        
        while (right <s2.length()){
            //generate window
            char c  = s2.charAt(right ++ );
            if(need.containsKey(c)) {
                window.put(c, window.getOrDefault(c,0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            
            while(right -left >= s1.length()) {
                if(valid == need.size()) {
                    return true;
                }

                char d = s2.charAt(left++);
                if(need.containsKey(d)) {
                    if(window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d,window.get(d) - 1);
                }

            }
        }
        return false;
    }
   
}