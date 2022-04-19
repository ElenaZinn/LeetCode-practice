
//https://leetcode-cn.com/problems/sort-an-array/
/**
快速排序是先将一个元素排好序，然后再将剩下的元素排好序
lo.           hi.        partion      lo.      p      hi.
[4] 1 <6> 3 2 <5>.       ---->         3 1 2  [4] <6> <5>
pivot可以理解为二叉树的父节点，最后将得倒二叉搜索树


 */
class Solution {
    public int[] sortArray(int[] nums) {
       sort(0,nums.length-1,nums);
        return nums;
    }
    public void sort(int lo, int high, int[] nums) {
        if(lo >=high){ //条件是>=
            return;
        }
        int pivot = partion(lo, high, nums);
        //对pivot左侧快速排序
        sort(lo,pivot-1,nums);
        //对pivot右侧快速排序
        sort(pivot +1, high,nums);
    }
    public int partion(int lo, int high, int[] nums){
        int pivot = nums[lo];
        int i = lo+1, j = high;
        //注意等号
        while(i<=j){ //当i>j时才退出循环
                //小于pivot的值放在pivot左侧，从左开始遍历，直到出现>pivot的值
            while(i<high && nums[i] <=pivot ) { //！！！i<high而不是i<j
                i++;
            }
            //大于pivot的值放在pivot右侧，从右侧开始遍历，直到出现<pivot的值
            while(lo<j && nums[j] > pivot) { ////！！！lo<j 而不是i<j
                j--;
            }
            if (i >= j) {//我漏写了,不加会超出时间限制
                break;
            }
            //交换左右大小相反的值
            swap(nums, i,j);
        }
       
        //将pivot放在它自己的位置上
        swap(nums, lo,j);
        return j;
    }
    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b]=tmp;
    }
}