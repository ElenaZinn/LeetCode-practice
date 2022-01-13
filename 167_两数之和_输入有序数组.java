class Solution {
    //数组有序：双指针
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int i = 0,j =numbers.length - 1; //!!! -1
        while (i < j) {
            int sum = numbers[i]  + numbers[j];
            if (sum  == target ) {
                //  res[0] = i + 1;
                //  res[1] = j + 1;
                return new int[]{i +1  , j+1 };

            }
            else if (sum > target) {
                j--;
                // i--; 虽然都是向数值小的方向移动，但这样移动容易超出界限
            }else if (sum < target){
                i++;
                // j++;
            }
        }
        return new int[]{i, j };

    }
}