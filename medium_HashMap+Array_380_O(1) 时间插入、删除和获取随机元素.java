//https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
class RandomizedSet {
    //使用数组存储val，实现O(1)时间内的插入与删除
    List<Integer> list;
    //记录val对应的索引, 实现快速查找
    HashMap<Integer,Integer> valToIndex = new HashMap<>();
    Random rand = new Random();
    public RandomizedSet() {
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        //当元素val存在，不需要插入
        if(valToIndex.containsKey(val)) {
            return false;
        }
        //若元素val不存在，插入到数组尾部
        valToIndex.put(val,list.size());
        list.add(list.size(), val);
        return true;
    }
    
    public boolean remove(int val) {
        //当元素val不存在，不需要移除
        if(! valToIndex.containsKey(val)) {
            return false;
        }
        /**
        当元素存在，将元素swap到数组尾部，删除数组尾部元素
        注意同步更新valToIndex
         */
         //得到最后一个元素的val
         int lastElement = list.get(list.size() - 1);
         //将元素swap到数组尾部，同步更新valToIndex
         int index = valToIndex.get(val);
         list.set(index, lastElement);
         valToIndex.put(lastElement,index);
         //删除数组尾部元素
         list.remove(list.size() - 1);
         valToIndex.remove(val);
        return true;

    }
    
    public int getRandom() {
        //随机获取数组中的一个元素
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */