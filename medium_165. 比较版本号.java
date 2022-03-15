class Solution {
    public int compareVersion(String version1, String version2) {
        //split分割
        //split a dot ".", the regex "." means "any character", so you need to escape the dot with two backsplashes.
        String[] a1 = version1.split("\\.");
        String[] a2 = version2.split("\\.");
        int len = Math.max(a1.length,a2.length);
        for(int i=0;i<len;i++){
            Integer num1 = i <a1.length?Integer.parseInt(a1[i]):0;
            Integer num2 = i<a2.length? Integer.parseInt(a2[i]):0;
            // int num1 = 3;
            // int num2 = 4;
            if(num1<num2){
                return -1;
            }
            if(num1>num2) {
                return 1;
            }
        }
        return 0;

    }
    // public void iterate(String[] a1){
    //     for()
    // }
}