//https://leetcode-cn.com/problems/goat-latin/
class Solution {
    public String toGoatLatin(String sentence) {
         String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<words.length;i++) {
            if(words[i].toLowerCase().charAt(0)=='a'|| words[i].toLowerCase().charAt(0)=='e'||words[i].toLowerCase().charAt(0)=='i'||words[i].toLowerCase().charAt(0)=='o'||words[i].toLowerCase().charAt(0)=='u') {
                //元音字母开头
                words[i] = words[i] + "ma";

            }else {
                //非元音字母开头
                char tail = words[i].charAt(0);
                words[i] = words[i].substring(1) +  tail +"ma";

            }
            //索引从1开始
            for(int j=0;j<=i;j++){
                words[i] = words[i] + "a";
            }
            
            if(i==words.length-1) {
                sb.append(words[i] );
            }else{
                sb.append(words[i] + " ");
            }
        }
        return sb.toString();
    }
}