//https://leetcode-cn.com/problems/find-the-town-judge/
class Solution {
    /**
    wrong case
    intput:
    4
    [[1,3],[1,4],[2,3],[2,4],[4,3]]
    output: 3
    原因：还存在另一个人被较多人信任的情况，所以应当抓住法官被n-1人信任，且法官不位于trust[i][0]的位置
    分析：若信任别人，信任值-1, 若被别人信任，信任值+1; 如果一个人被所有人信任同时也信任别人，信任值<n-1,法官的信任值是n-1
     */
    public int findJudge_1stTemp(int n, int[][] trust) {
        int maybe_judge = trust[0][1];
        for(int i=1;i<trust.length;i++) {
            if(trust[i][0] == maybe_judge) {
                System.out.println("------");
                return -1;
            }
            if(trust[i][1] != trust[i-1][1]) {
                System.out.println("???");
                return -1;
            }
        }
        return  trust[0][1];
    }
    public int findJudge(int n, int[][] trust) {
        int[] trustValues = new int[n+1]; //编号从1开始
        for(int i = 0;i<trust.length;i++) {
            trustValues[trust[i][0]] --;
            trustValues[trust[i][1]] ++;
        }
        for(int i=1;i<=n;i++) {  //从1开始
            if(trustValues[i] == n-1) {
                return i;
            }
        }
        return -1;
    }
    

}