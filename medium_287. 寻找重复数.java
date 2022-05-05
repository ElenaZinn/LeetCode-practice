//https://leetcode-cn.com/problems/find-the-duplicate-number/

/**
要求：不修改 数组 nums 且只用常量级 O(1) 的额外空间。

因为范围是[1,n] 让序号与数值一一对应起来： 只使用了o(1)的空间，但是修改数组了

example

[1,3,4,2,2]
index = 0: 1 = index +1, index++;
index =1: 
    3 !=index +1, swap (nums[nums[index]-1],nums[index]) -->[1,4,3,2,2]
    4!= index+1, swap(nums[nums[index]-1],nums[index]) --> [1,2,3,4,2], 
    nums[index]= 2 = index+1, index++;
index = 2:
    nums[index]= 3 = index+1, index++;
index = 3:
    nums[index]= 4 = index+1, index++;
index = 4:
    nums[nums[index]-1]== nums[index], 找到相等的元素了
    
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int res=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == i+1) {
                continue;
            }
            while(nums[i] != i+1) {
                if(nums[i] == nums[nums[i]-1]) {
                    res = nums[i];
                    return res;
                }
                int tmp = nums[i];
                nums[i]=  nums[tmp-1];
                nums[tmp-1] = tmp;
            }
        }
    
        return res;
    }
}