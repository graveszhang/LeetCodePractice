//主要思路是每次操作记录index 删除pair时遍历选出数字最小的entry

class LRUCache {
    
    HashMap<Integer, Integer[]> map = new HashMap<Integer, Integer[]>();
    int maxsize = -1;     // size of the map
    int curr = 0;         // a counter, whose smaller value means least usage
    
    public LRUCache(int capacity) {
        maxsize = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
            int val = map.get(key)[0];
            curr++;
            map.put(key,new Integer[]{val,curr});
            return val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        int least = Integer.MAX_VALUE;
        if (map.containsKey(key)){              // 如果map已有该值 直接更新即可
            curr++;
            map.put(key,new Integer[]{value,curr});
            return;
        }
        if (map.size() >= maxsize){
            Iterator<Map.Entry<Integer, Integer[]>> entries = map.entrySet().iterator();
            Map.Entry<Integer, Integer[]> delete_this = null;
		    while (entries.hasNext()) {
			    Map.Entry<Integer, Integer[]> entry = entries.next();
                if (entry.getValue()[1] < least){
                    least = entry.getValue()[1];
                    delete_this = entry;
                }
		    }
            map.remove(delete_this.getKey());
        } 
        curr++;
        map.put(key,new Integer[]{value,curr});
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
