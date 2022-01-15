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
        int valid = 0;

        //out of bounds

        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character, Integer> windows = new HashMap<>();
        
        for (i=0;i<t.length();i++){
            needs.put(t.charAt(i), needs.getOrDefault(t.charAt(i),0) +1);
            
        }

        
        i=0;
        while (i<s.length()) {
            
            char c = s.charAt(i);
           
            if (needs.containsKey(c)) {
                windows.put(c,windows.getOrDefault(c,0) + 1);
                 if (windows.get(c).equals(needs.get(c))) {
                    valid++;
                }
            
            }
            //update min length
            while (valid == needs.size()) {
                if (i-left + 1 <len) {
                    start = left;
                    len = i- left + 1;
                }
                
                char d = s.charAt(left ++ );

                if (windows.containsKey(d) ) {
                    if (windows.get(d).equals(needs.get(d))) {
                        valid--;
                    }
                    windows.put(d, windows.get(d) - 1);
                }
            }

            i ++;
            
        }
        /** 
        System.out.printf("windows.size = %d\n",windows.size());
         // 输出 key 和 value
        for (Character j : windows.keySet()) {
            System.out.println("key: " + j+ " value: " + windows.get(i));
        }
        */
        return len == Integer.MAX_VALUE? "":s.substring(start,start + len);
    }
}