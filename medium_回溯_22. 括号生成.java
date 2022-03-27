//link: https://leetcode-cn.com/problems/generate-parentheses/
//参考:https://leetcode-cn.com/problems/generate-parentheses/solution/shou-hua-tu-jie-gua-hao-sheng-cheng-hui-su-suan-fa/

/**
只要还有剩余（，就可以选（
当剩下的）比（多时，才可以选）
example
                ”“  [2],2 (左括号剩余个数，右括号剩余个数)
                |    
                (    [1],2
              /   \
     [0],2  ((    ()  [1],1
     [0],1   |     |  [0],1
            (()    ()(
     [0],0   |      |  [0],0
            (())   ()()
 */
class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        helper(n,n,"", n*2);
        return res;

    }
    //left:可用左括号个数 right:可用右括号个数
    //入口参数：路径，选择列表(左括号与右括号)
    public void helper(int lRemains, int rRemains, String str,int finalLen){
        //满足条件
        if(str.length()==finalLen) {
            res.add(str);
            return;
        }
        //做选择, 继续回溯
        if(lRemains >0) {
            helper(lRemains-1,rRemains,str + "(", finalLen);
        }
        if(rRemains > lRemains) {
            helper(lRemains,rRemains-1, str + ")",finalLen);
        }
       
       
    }
}