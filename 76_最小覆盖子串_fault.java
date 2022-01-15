// https://leetcode-cn.com/problems/minimum-window-substring/
/** test example 1
    "MABCEHIJKCABD" "ABE"
    s = "MABCEHIJKCABD" ,t = "ABE"   
    needs = {A:1,B:1,E:1}
    左侧先遍历到第一个needs left = 1; res  = s.substring(left,right) = "A"
    [ABCEHIJKC]   windows = {A:1,B:1,E:1}   get temp length =4 
    [ABCEHIJKCA]  windows = {A:2,B:1,E:1}, 此时符合要求的最小串是"ABCE"，windows.get(right)>needs.get(right),左边预先shrink，结果长度比较大，回退
    [ABCEHIJKCAB]  windows = {A:2,B:2,E:1}  此时符合要求的最小串是"ABCE",windows.get(right)>needs.get(right),左边预先shrink，结果长度比较大，回退
    [ABCEHIJKCABD]  windows = {A:2,B:2,E:1}  此时符合要求的最小串是"ABCE",遍历到最后，右侧也合理shrink一下
    test example 2
    "DBACKJIHECBAM""ABE"  
    s = "DBACKJIHECBAM", t = "ABE"   
    左侧先遍历到第一个needs left = 1; res  = s.substring(left,right) = "B"
    [BACKJIHE]   windows = {A:1,B:1,E:1}   此时符合要求的最小串是"BACKJIHE", get temp min = 8
    [BACKJIHECB]  windows = {A:1,B:2,E:1}, 此时符合要求的最小串是"BACKJIHE"  Windows.get(right)>needs.get(right)左边预先shrink，结果长度比较大，回退
    [BACKJIHECBA]  windows = {A:2,B:2,E:1}  此时符合要求的最小串是"ECBA" windows.get(right)>needs.get(right),左边预先shrink，结果长度比较小，start = left
    [BACKJIHECBAM]  windows = {A:2,B:2,E:1}  此时符合要求的最小串是"ECBA",遍历到最后，右侧也合理shrink一下

 */
/**
通过测试
"MABCEHIJKCABD" 
"ABE"

"a"
"b"

"DBACKJIHECBAM"
"ABE"

"bba"
"ab"


"ADOBECODEBANC"
"ABC"

"cabeca"
"cae"

"cabefgecdaecf"
"cae"

"ab"
"b"
*/
/**
未通过
"cabwefgewcwaefgcf"
"cae"
*/
class Solution {
    //hint: sliding window
    HashMap<Character, Integer> needs = new HashMap<>();
    HashMap<Character, Integer> windows = new HashMap<>();
    int valid = 0,left =0;
    public String minWindow(String s, String t) {
        int right =0;
        int temp_min  = 0;
        int final_left = 0;
       
        //t的长度大于s
        if (t.length() > s.length()){
            return "";
        }
        //生成needs散列表
        for (int i=0;i<t.length();i++){
            needs.put(t.charAt(i), needs.getOrDefault(t.charAt(i),0) +1);
        }

        // 先缩小一波范围：遍历到遇到第一个needs停止，舍弃左侧没有用的字母
        int p=0;
        for (p=0;p<s.length();p++){
            if (needs.containsKey(s.charAt(p))){
                    break;
            }  
        }
        left = p;

        //s 不包含t
        if(p == s.length()){
            return "";
        }
        

        //扩展窗口
        right =0;
        boolean change_min = true;
        while (right <s.length()){
            
            char c = s.charAt(right);
           
            if (needs.containsKey(c)) {
                windows.put(c,windows.getOrDefault(c,0) + 1);
                if (windows.get(c).equals(needs.get(c))) {
                    valid++;
                }
            }
            //获取暂时最小长度,最小长度= valid第一次等于needs.size()时的长度
            if(valid ==needs.size()){
                if (change_min){
                    temp_min = right -left + 1;
                    System.out.println("right is " + right + " temp_min is "+ temp_min);
                    change_min = false;
                }
               
            }
           if (needs.containsKey(c)){
               //右侧遍历到window.value>needs.value,若出现temp_len < temp_min, 缩小左侧窗口
                // final_left = Pre_shrink_left(s,needs,windows,final_left,right,temp_min)<left?;
                final_left = Math.max(Pre_shrink_left(s,needs,windows,final_left,right,temp_min),left);
           }
            System.out.println("final_left = " + final_left);

           right ++;
        }
      
        if( final_left == left){
            //在Pre_shrink_left已经缩小左侧窗口了,不需要再缩小左侧窗口了
        }else{
               //Pre_shrink_left并未做真正的运算，因此长度小于在[left,final_left]之间，每遍历到needs.   containsLey(c),windows.get(c)--;
             shrink_left(s,needs,windows,left,final_left);
        }
       
        System.out.println("Before shrink right, right = " + right);
        return shrink_right(s,needs,windows,final_left,right);
    }
     public int Pre_shrink_left(String s, HashMap<Character, Integer> needs,HashMap<Character, Integer> windows,int left, int right,int temp_min){
             int temp_len =0;
             int p=left;
             char c =  s.charAt(p);
            System.out.println("Brfore left shrink, right = " + right  + " left = " + p + " c = s.charAt(left) = " + c  + " s.charAt(right) = " + s.charAt(right));
              System.out.println("Before left shrink, " + " windows.get(c) = " + windows.get(c) + " needs.get(c)) = " + needs.get(c));
            boolean flag  = false;
            while(p<right){
                c = s.charAt(p);
                temp_len = right-p + 1;
                System.out.println("temp_len = " + temp_len + " temp_min = " + temp_min);
                if (temp_len < temp_min){
                    flag = true;
                    //更新windows
                    shrink_left(s,needs,windows,right-p,p-1);  
                }
                if (needs.containsKey(c)){
                    System.out.println("During shrink, " +  " c = " + c + " windows.get(c) = " + windows.get(c) + " needs.get(c)) = " + needs.get(c));
                    if( windows.get(c) -1 <needs.get(c) ){
                        //若窗口已经缩小到不能再缩小了，退出循环
                        break;
                    }else{
                        //缩小窗口
                        windows.replace(c, windows.get(c)-1 );
                        if ( right-p < temp_min){
                            flag = true;
                            
                        }else {
                            //回退windows.get(c)的值
                            windows.put(c,windows.getOrDefault(c,0) + 1 );
                        }
                        
                    }
                }
                p++;
                
            }
            //如果长度变小了，说明偏右边的长度更小，否则就是偏左边的长度更小
            return temp_len <= temp_min ? p : left;

        } 
        public void shrink_left(String s, HashMap<Character, Integer> needs,HashMap<Character, Integer> windows,int left,int right){
            //遍历所有的Windows直到出现Windows.get(key)不满足>=needs.get(key);
            //遍历停止条件，pos <= right
            int pos = left;
            char c = s.charAt(pos);
            while (pos <= right){
                c = s.charAt(pos);
                if (needs.containsKey(c)){
                    windows.put(c,windows.getOrDefault(c,0) -1 );                    
                }
                pos ++ ;
            }
        }
        public String shrink_right(String s, HashMap<Character, Integer> needs,HashMap<Character, Integer> windows,int left, int right){
            //遍历所有的Windows直到出现Windows.get(key)不满足>=needs.get(key);
            //遍历停止条件，有windows.get(key) < needs.get(key)
            int p = right -1 ;
            System.out.println("right = " + p + " left = " + left);
            char c =  s.charAt(p);
            while(p>left){
                c = s.charAt(p);
                if (needs.containsKey(c)){
                     System.out.println("c is" + c + " windows.get(c) = " + windows.get(c) + " needs.get(c)) = " + needs.get(c));
                    if(windows.get(c)- 1 < needs.get(c) ){
                       break;
                     }else{
                        windows.put(c,windows.getOrDefault(c,0) -1 );
                     }
                }
                p--;
            }
            System.out.println("After right shrink, right = " + p  + " left = " + left);
            return s.substring(left,p + 1);
        }      


}
/** 
    System.out.printf("windows.size = %d\n",windows.size());
        // 输出 key 和 value
    for (Character j : windows.keySet()) {
        System.out.println("key: " + j+ " value: " + windows.get(i));
    }
*/