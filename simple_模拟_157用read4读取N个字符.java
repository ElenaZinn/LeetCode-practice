/**
https://leetcode.cn/problems/read-n-characters-given-read4/
*/
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    // if cont = read4(buf) == 0 break
    public int read(char[] buf, int n) {
        int size = 0;
        char[] buf4 = new char[4];
        int index = 0;
        //  System.out.println(" n = " + n);
        do {
          size = read4(buf4);
          // System.out.println(" size = " + size);
          if (size == 0) {
            break;
          }
          
          for( int i=0;i<size && index <n; i++) {
              buf[index ++] = buf4[i];
          }
          // System.out.println("index = " + index);
        }while (index < n && size >0);
        return index;
    }
}