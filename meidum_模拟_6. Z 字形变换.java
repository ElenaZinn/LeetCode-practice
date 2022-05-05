//https://leetcode-cn.com/problems/zigzag-conversion/

class Solution {
    public String convert(String s, int numRows) {
        char[] ch = s.toCharArray();
        String[] str = new String[numRows];
        // init str
        for(int j=0;j<str.length;j++) {
            str[j] = "";
        }
        int index = 0; // 倾斜的位置上数字的index
        //当numRows==1
        if(numRows==1 ||s.length()==1 ) {
            return s;
        }
        //当numRows>=1个元素
        for(int i=0;i<ch.length;i++) {
            //让pos 始终在[0,2*numRows-2)内循环
            int pos = 0;
            //数字形状间隔2*numRows-2呈现规律
            pos = i % (2*numRows-2);
            if(pos >=numRows) { //z中的倾斜位置
                index++;
                str[numRows-index-1] = str[numRows-index-1] + ch[i];
            }else{ //竖直位置
                index = 0;
                str[pos] = str[pos] + ch[i];           
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String ss: str) {
            sb.append(ss);
        }
        return sb.toString();
    }
}