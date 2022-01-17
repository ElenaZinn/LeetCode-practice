//https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
//hint: sliding window
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> charNeed = new HashMap<>();
        HashMap<Character,Integer> charFound = new HashMap<>();
        int right =0, left = 0;
        int valid = 0;
        List<Integer> res = new ArrayList<Integer>();
        for (int i=0;i<p.length();i++) {
            charNeed.put(p.charAt(i), charNeed.getOrDefault(p.charAt(i),0)+1);
        }

        while (right < s.length()) {
            char c  = s.charAt(right++);
            if (charNeed.containsKey(c)){
                charFound.put(c,charFound.getOrDefault(c,0)+1);
                if (charNeed.get(c).equals(charFound.get(c))) {
                    valid ++;
                    // System.out.println("before shrink, valid =  " + valid);
                }
            }
            //  System.out.println("before shrink, s.charAt(right) =  " + c);
            
            
            while(right - left >= p.length()) {
                if (valid == charNeed.size()) {
                    res.add(left);
                }
                char d = s.charAt(left++);
                System.out.println("before shrink, s.charAt(left++) = " + d);
                if (charNeed.containsKey(d)) {
            
                    if (charNeed.get(d).equals(charFound.get(d))) {
                        valid --;
                        // System.out.println("after shrink, valid =  " + valid);
                    }
                    charFound.put(d, charFound.get(d) - 1);
                    // System.out.println("after shrink, d = " +d + " charFound.get(d) =  " + charFound.get(d));
                }

            }
        }
        return res;
      
    }
}