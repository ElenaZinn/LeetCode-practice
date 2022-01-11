class Solution {
    //code-link: https://leetcode-cn.com/problems/car-pooling/
    /**未下车来了新客人,且超出capacity
        trips = [[2,1,5],[3,3,7]], capacity = 4
        location:  1  2  3  4  5  6  7  8  ...
        pos     0  1  2  3  4  5  6  7  8  ...
        diff    0  0  0  0  0  0  0  0  0  ...
        diff       2           -2
        diff       2  0  3  0  -2 0  -3
        recovery   2  2  5
        res = false
     */
    /**下车后来了新客人
        trips = [[2,1,5],[3,5,7]], capacity = 3
        location:  1  2  3  4  5     6  7
        passenger  2  2  2  2  -2+3  3  3
        diff       2  0  0  0   -1   2
        res = true
     */
     //因为是单向通行，所以下一个trips[i]只会增加loc上的座位
    public boolean carPooling(int[][] trips, int capacity) {


        //最大值不好确定 (参考题目给的trips[i][2]<=1000，length= 1001)
        int[] nums = new int[1001];
        boolean flag = true;
        Difference diff  = new Difference(nums);

        for (int[] passenger : trips) {
          int val = passenger[0];
          int left = passenger[1];
          int right = passenger[2]-1;
          diff.increase(left,right,val);
        }
        int[] res = diff.recovery();
        for (int i : res){
          if (i > capacity){
            flag = false;
            break;
          }
        }

        return flag;
    }
}

class Difference{
    private int[] diff;
    public Difference(int[] nums) {
        //nums = [3,4,6,2,4],diff = [3,1,2,-4,2]
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i=1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[0];
        }
    }
    public void increase(int left, int right, int val) {
        // num[1...3] 全部加3: nums = [3, 4+3, 6+3, 2+3 ,4 ], diff = [3, 1+3, 2, -4, 2-3]
        diff[left] += val;
        if (right + 1 <  diff.length) {
            diff[right +1] -=val;
        }

    }
    public int[] recovery() {
        int[] arr = new int[diff.length];
        arr[0] = diff[0];
        for ( int i=1; i < diff.length; i++ ) {
            arr[i] = arr[i-1] + diff[i];
        }
        return arr;
    }
}
