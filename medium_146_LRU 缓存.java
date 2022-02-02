//https://leetcode-cn.com/problems/lru-cache/

class LRUCache {
    int cap;
    LinkedHashMap<Integer,Integer> cache = new LinkedHashMap<>();
    public LRUCache(int capacity) {
        this.cap = capacity;
    }
    
    public int get(int key) {
        //若包含key，将key变为最近使用的
        if(!cache.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        //若key已存在
        if(cache.containsKey(key)) {
            //修改value
            cache.put(key,value);
            //将key变为最近使用的
            makeRecently(key);
            return;
        }
        //若key不存在
        if(cache.size() >=this.cap) {
            //若容量已满，淘汰最久未使用的key(链表头部)
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        
        //若容量未满，直接插入key和val
        cache.put(key,value);
    }

    public void makeRecently(int key) {
        int val = cache.get(key);
        //删除key，重新插入
        cache.remove(key);
        cache.put(key,val);
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */