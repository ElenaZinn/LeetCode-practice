//https://leetcode-cn.com/problems/ransom-note/
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] rn = ransomNote.toCharArray();
        char[] mg = magazine.toCharArray();
        for(char c :mg) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(char c: rn) {
            if(map.containsKey(c) && map.get(c)>0){
                map.put(c,map.get(c)-1);
            }else{
                return false;
            }
        }
        return true;
    }
}