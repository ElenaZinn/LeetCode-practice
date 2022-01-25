//https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/submissions/
class Solution {
    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char tmp = s.charAt(i);
            if(tmp == ' ') {
                res.append("%20");
            }else{
                res.append(tmp);
            }
        }
        return res.toString();
    }
}