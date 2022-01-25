//https://leetcode-cn.com/problems/advantage-shuffle/
//hint: double pointer
//思路：比得过就比，比不过用最小值比
/**
example
nums1 = [2,7,11,15], nums2 = [1,10,4,11]
after sort, nums1 = [2,7,1,15], mappingList = {11:3,10:1,4:2,1:0}, right = nums1.length-1 = 3, left = 0
in loop: 
    max = 11 < 15, res[3] = 15, right = 2;
    max = 10 < 11, res[1] = 11, right = 1;
    max = 4 < 7, res[2] = 7, right = 0;
    max = 1 <2, res[0] = 2, right = -1, loop finish();
res = [2,11,7,15];
 */
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        // 给 nums2 降序排序
        PriorityQueue<int[]> maxpq = new PriorityQueue<>(
            (int[] pair1, int[] pair2) -> {
            return pair2[1] - pair1[1];
        });
        for (int i = 0; i < n; i++) {
            maxpq.offer(new int[]{i, nums2[i]});
       
        }
        // 给 nums1 升序排序
        Arrays.sort(nums1);
        // nums1[left] 是最⼩值，nums1[right] 是最⼤值
        int left = 0, right = n - 1;
        int[] res = new int[n];
        while (!maxpq.isEmpty()) {
            int[] pair = maxpq.poll();
            // maxval 是 nums2 中的最⼤值，i 是对应索引
            int i = pair[0], maxval = pair[1];
            if (maxval < nums1[right]) {
                // 如果 nums1[right] 能胜过 maxval，那就⾃⼰上
                res[i] = nums1[right];
                right--;
            } else {
            // 否则⽤最⼩值混⼀下，养精蓄锐
            res[i] = nums1[left];
            left++;
            }
        }
        return res;
    }
  
}