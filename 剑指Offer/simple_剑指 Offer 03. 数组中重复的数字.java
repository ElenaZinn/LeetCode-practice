//https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/submissions/

/**
法一：排序
class Solution {
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++) {
            if(nums[i+1]==nums[i]){
                return nums[i];
            }
        }
        return 0;
    }
}
 */
/**
法二 HashSet
class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(set.contains(num)) return num;
            set.add(num);
        }
        return -1;
    }
}
 */
 /**
 法三：原地置换,时间复杂度最小
*/
/**example
nums = [2, 3, 1, 0, 2, 5, 3]
i=0, nums[i]=2, nums = [1, 3, 【2】, 0, 2, 5, 3]
i=0, nums[i]=1, nums = [3, 【1】, 2, 0, 2, 5, 3]
i=0, nums[i]=3, nums = [0, 1, 2, 【3】, 2, 5, 3]
i=0, nums[i]=0, continue,
i=1, nums[i]=1, continue,
i=2, nums[i]=2, continue,
i=3, nums[i]=3, continue,
i=4, nums[i]=2, 2 repeat, return 2
 */
class Solution {
    public int findRepeatNumber(int[] nums) {
        int i=0;
        while (i<nums.length) {
            System.out.println("i = " + i + " nums[i] = " + nums[i]); 
            if(nums[i]==i) {
                i++;
                System.out.println("continue the while loop"); 
                continue;
            }
            if(nums[nums[i]]== nums[i]) return nums[i];
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
            for( int j=0;j<nums.length;j++){
                System.out.print(nums[j] + "\t"); 
            }
            System.out.print("\n"); 

        }
        return -1;
    }
}

