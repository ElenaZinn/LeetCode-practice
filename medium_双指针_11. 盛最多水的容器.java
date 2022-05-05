//https://leetcode-cn.com/problems/container-with-most-water/
/**
最好是长宽都足够大，面积= min（height[i],height[j]) * (j-i);
使用双指针。面积取决于短板，只有移动短板面积才可能变大

当遇到更短的板子，面积变小
当遇到更长的板子，面积仍然变小（因为容器面积取决于短板，长板变长没有用）
当长板子长度不变，面积还是变小
移动短板有可能使得面积变大或变小。 选择改变短板，才有可能使面积变大重点：面积取决于短板，
 */
class Solution {
    int max = 0;
    public int maxArea(int[] height) {
        int i=0, j=height.length-1;
        while(i<j) {
             max = height[i] < height[j] ?
                    Math.max(max, (j-i)* height[i++]) : 
                    Math.max(max, (j-i)* height[j--]);
        }
        
        return max;
    }
}