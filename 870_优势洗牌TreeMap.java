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
        Arrays.sort(nums1);//nums1升序
        int[] res = new int[nums1.length];

        ArrayList<Map.Entry<Integer, Integer>> mappingList = nums2Decline(nums2);

        int left = 0, right = nums1.length-1;
        for(Map.Entry<Integer, Integer> mapping:mappingList){  
            int max = mapping.getValue();
             if (max < nums1[right]) {
                 //比得过就比
                res[mapping.getKey()] = nums1[right];
                right --;
            }else{
                //比不过用最小值比
                res[mapping.getKey()] = nums1[left];
                left++;
            }
        }

        return res;
    }
    public ArrayList<Map.Entry<Integer, Integer>> nums2Decline(int[] num){
        int length = num.length;
        ArrayList<Map.Entry<Integer, Integer>> mappingList = null; 
        TreeMap<Integer, Integer> res = new TreeMap<Integer, Integer>();

        for(int i=0; i<length;i++) {
            res.put(i,num[i]);
        }
        //按照value进行降序
       //通过ArrayList构造函数把map.entrySet()转换成list 
        mappingList = new ArrayList<Map.Entry<Integer, Integer>>(res.entrySet()); 
        //通过比较器实现比较排序 
        Collections.sort(mappingList, new Comparator<Map.Entry<Integer, Integer>>(){ 
            public int compare(Map.Entry<Integer, Integer> mapping1,Map.Entry<Integer,Integer> mapping2) {  
                return mapping2.getValue().compareTo(mapping1.getValue()); 
            }
        });
        return mappingList;
    }
  
}