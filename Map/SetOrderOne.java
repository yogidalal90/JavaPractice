package Map;

import java.util.HashMap;
import java.util.Map;

public class SetOrderOne {

    public static void main(String[] args) {
        SetOrderOne map = new SetOrderOne();
        map.set(0, 1);
       System.out.println(map.get(0)); // 1
        map.set(1, 2);
        System.out.println(map.get(1)); // 2
        map.setAll(5);
        System.out.println(map.get(0)); // 5
        System.out.println(map.get(1)); // 5
        System.out.println( map.get(2)); // null, there's no such key
        map.set(2, 7);
        System.out.println(map.get(0)); // 5
        System.out.println(map.get(1)); // 5
        System.out.println(map.get(2)); // 7
    }
    class Node{
        int version;
        int val;

        public Node(int version,int val){
            this.version = version;
            this.val=val;
        }
    }

    int version;
    Map<Integer,Node> map;
    Map<Integer,Integer> versionMap;

    public SetOrderOne(){
        version=0;
        map = new HashMap<>();
        versionMap = new HashMap<>();
    }
    public void set(int key, int value) {
        map.put(key, new Node(version,value));
    }

    public Integer get(int key) {
            if(!map.containsKey(key))
                return null;
            Node res = map.get(key);
            if(res.version <version)
                return versionMap.get(version);
            return res.val;
    }

    public void setAll(int value) {
        version++;
        versionMap.put(version,value);
    }
}
