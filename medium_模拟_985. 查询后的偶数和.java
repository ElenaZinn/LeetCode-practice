//https://leetcode-cn.com/problems/sum-of-even-numbers-after-queries/

/**
sum +=num[i];
num[i] = odd1, query = odd2,  sum += odd1 + odd2;
num[i] = odd, query = even, sum = sum;
num[i] = even, query = odd, sum = sum-even;
num[i] = even, query = even2, sum += even2;
 */
class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {

        int[] res = new int[nums.length+1];
        int sum = evenSum(nums);
        res[0] = sum;
        int[] ans = new int[nums.length];
        for(int i=0;i<queries.length;i++) {
            if(queries[i][0] %2==0) {//添加一个偶数
                if(nums[queries[i][1]] %2==0) { //原位置是偶数
                    res[i+1] = res[i] + queries[i][0];
                    ans[i] = res[i+1];
                    nums[queries[i][1]] = nums[queries[i][1]] + queries[i][0];
                }else{ //原位置是奇数
                    res[i+1] = res[i];
                    ans[i] = res[i+1];
                    nums[queries[i][1]] = nums[queries[i][1]] + queries[i][0];
                }

            }else { //添加一个奇数
                if(nums[queries[i][1]] %2==0) { //原位置是偶数
                    res[i+1] =  res[i] - nums[queries[i][1]];
                    nums[queries[i][1]] = nums[queries[i][1]] + queries[i][0];
                    ans[i] = res[i+1];

                }else{ //原位置是奇数
                    res[i+1] =  res[i] + queries[i][0] +nums[queries[i][1]];
                    nums[queries[i][1]] = nums[queries[i][1]] + queries[i][0];
                    ans[i] = res[i+1];
                }
            }     
        }
        return ans;
    }
    public int evenSum(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0) {
                sum +=nums[i];
            }
        }
        return sum;
    }
}