package graph;

import java.util.*;

public class CourseSchedule2 {

    public static void main(String[] args) {
        int[][] prerequisites = {{0,1},{0,2},{1,2}};
        int numCourses=3;
        int[] res = findOrder(numCourses,prerequisites);
        for(int i:res)
            System.out.print(i+" ");
    }
        static List<Integer> ls = new ArrayList<>();
        public static int[] findOrder(int numCourses, int[][] prerequisites) {

            Set<Integer> que = new HashSet<>();
            Map<Integer, List<Integer>> map = new HashMap<>();

            for(int i=0;i<prerequisites.length;i++){
                List<Integer> list = map.getOrDefault(prerequisites[i][0],new ArrayList<>());
                list.add(prerequisites[i][1]);
                map.put(prerequisites[i][0],list);
                que.add(prerequisites[i][0]);
            }

            while(que.size()>0){
                int curr = que.iterator().next();
                if(!dfs(que,map,curr,new HashSet<>()))
                    return new int[0];
            }

            int[] res=new int[numCourses];
            for(int i=0;i<numCourses;i++){
                if(!ls.contains(i))
                    ls.add(0,i);
            }

            for(int i=0;i<numCourses;i++){
                res[i]=ls.get(i);
            }
            return res;
        }

        public static boolean dfs(Set<Integer> que, Map<Integer, List<Integer>> map, int curr, Set<Integer> set){
            if(!que.contains(curr))
                return true;

            set.add(curr);
            if(map.containsKey(curr)){
                for(int nbr:map.get(curr)){
                    if(set.contains(nbr)){
                        return false;
                    }

                    if(!dfs(que,map,nbr,set))
                        return false;
                }
            }
            que.remove(curr);
            ls.add(curr);
            set.remove(curr);
            return true;
        }

}
