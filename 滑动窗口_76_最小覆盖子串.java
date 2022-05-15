// https://leetcode-cn.com/problems/minimum-window-substring/
/**
hint: shrinking window，只有当valid==needs.size() && 当出现needs中包含的元素时,才从左侧缩小窗口，同时更新长度，移动窗口到出现needs中包含的元素停止
test example 1
    s = "MABCEHIJKCABD" ,t = "ABE" , needs = {A:1,B:1,E:1}
    [MABCE],  windows = {A:1,B:1,E:1}, valid = 3 = needs.size(),start = left = 0, len = 6
        d =M, shrink window by moving out M, get [ABCE], len = 4
        d = A, valid = 2, windows = {A:0,B:1,E:1} 

    [ABCEHIJKCA], windows = {A:1,B:1,E:1}, valid = 3, i-left>len
        d = B, valid = 2, windows = {A:1,B:0,E:1}
    [ABCEHIJKCAB], windows = {A:1,B:1,E:1},  valid = 3, i-left>len
        d = C , i-left>len
        d = E,  valid = 2, windows = {A:1,B:1,E:0}
    res = s.substring(start, start + len) = s.substring(0, 4)

test example 2
    s = "DBACKJIHECBAM", t = "ABE",  needs = {A:1,B:1,E:1}
    [DBACKJIHE],  windows = {A:1,B:1,E:1}, valid = 3 = needs.size(),start = left = 0, len = 9
        d = D,shrink window by moving out D, get [BACKJIHE], ,start = 1, len = 8
        d = B, valid = 2, windows = {A:1,B:0,E:1}
    [BACKJIHECB],  windows = {A:1,B:1,E:1}, valid = 3 = needs.size() 
        d = A, valid = 2, windows = {A:0,B:1,E:1} 
    [DBACKJIHECBA], windows = {A:1,B:1,E:1}, valid = 3 = needs.size() 
        d = C, i-left>len
        d = K, start = 5, len = 7, [JIHECBA]
        d = J, start = 6, len = 6, [IHECBA]
        d = I, start = 7, len = 5, [HECBA]
        d = H, start = 8, len = 4, [ECBA]
        d = E, valid = 2, windows = {A:1,B:1,E:0}
    res = s.substring(start, start + len) = s.substring(8,12)


 */
class Solution {
    //hint: sliding window
    public String minWindow(String s, String t) {
        int i =0, left = 0,start = 0,len = Integer.MAX_VALUE;
        int isValid = 0;

        //out of bounds

        HashMap<Character, Integer> charsToMatch = new HashMap<>();
        HashMap<Character, Integer> charsFound = new HashMap<>();
        
        for (i=0;i<t.length();i++){
            charsToMatch.put(t.charAt(i), charsToMatch.getOrDefault(t.charAt(i),0) +1);
            
        }

        
        i=0;
        while (i<s.length()) {
            
            char c = s.charAt(i);
           
            if (charsToMatch.containsKey(c)) {
                charsFound.put(c,charsFound.getOrDefault(c,0) + 1);
                 if (charsFound.get(c).equals(charsToMatch.get(c))) {
                    isValid++;
                }
            
            }
            //update min length
            while (isValid == charsToMatch.size()) {
                if (i-left + 1 <len) {
                    start = left;
                    len = i- left + 1;
                }
                
                char d = s.charAt(left ++ );

                if (charsFound.containsKey(d) ) {
                    if (charsFound.get(d).equals(charsToMatch.get(d))) {
                        isValid--;
                    }
                    charsFound.put(d, charsFound.get(d) - 1);
                }
            }

            i ++;
            
        }
        /** 
        System.out.printf("charsFound.size = %d\n",charsFound.size());
         // 输出 key 和 value
        for (Character j : charsFound.keySet()) {
            System.out.println("key: " + j+ " value: " + charsFound.get(j));
        }
        */
        return len == Integer.MAX_VALUE? "":s.substring(start,start + len);
    }
}

//滑动窗口+ 字典 题解https://leetcode-cn.com/problems/permutation-in-string/solution/zhu-shi-chao-xiang-xi-de-hua-dong-chuang-rc7d/