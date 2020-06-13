package graph;

import java.util.*;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 */
public class CourseScheduleI {
    public static void main(String[] args) {
        int[][] prerequisites = {{1,0},{0,1}};
        int n=2;
        System.out.println(canFinish(n,prerequisites));
    }
    private static boolean canFinish(int numCourses, int[][] prerequisites) {

        if(numCourses < 2)
            return true;

        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> que = new LinkedList<>();
        for(int i=0;i<prerequisites.length;i++){
            List<Integer> list = map.getOrDefault(prerequisites[i][0],new ArrayList<>());
            list.add(prerequisites[i][1]);
            map.put(prerequisites[i][0],list);

        }
        for(int i=0;i<numCourses;i++){
            que.add(i);
            if(!map.containsKey(i))
                map.put(i,new ArrayList<>());
        }
        Set<Integer> greySet = new HashSet<>();
        while(que.size()>0){
            int num = que.iterator().next();
            que.remove(num);
            if(!dfs(que,greySet,map,num))
                return false;
        }
        return true;
    }

    private static boolean dfs(Queue<Integer> que, Set<Integer> greySet, Map<Integer, List<Integer>> map , int num){
        que.remove(num);
        greySet.add(num);

        for(Integer nbr:map.get(num)){
            if(greySet.contains(nbr)) return false;
            if(!dfs(que,greySet,map,nbr))
                return false;
        }
        greySet.remove(num);
        return true;
    }
}
