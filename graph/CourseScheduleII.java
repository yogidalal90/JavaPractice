package graph;

import java.util.*;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array
 */
public class CourseScheduleII {
    public static void main(String[] args) {
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        int n=4;
        int[]  courses = findOrder(n,prerequisites);
        for(int course:courses)
            System.out.print(course+" ");
    }
   private static List<Integer> blackSet = new ArrayList<>();
    private static int[] findOrder(int numCourses, int[][] prerequisites) {

        HashMap<Integer,List<Integer>> map =new HashMap<>();
        Set<Integer> whiteSet = new HashSet<>(), greySet = new HashSet<>();

        for(int i=0;i<prerequisites.length;i++){
            List<Integer> ls = map.getOrDefault(prerequisites[i][0], new ArrayList<>());
            ls.add(prerequisites[i][1]);
            map.put(prerequisites[i][0],ls);

        }

        for(int i=0;i<numCourses;i++){
            whiteSet.add(i);
            if(!map.containsKey(i)){
                map.put(i,new ArrayList<>());
            }
        }
        while(whiteSet.size()>0){
            int current = whiteSet.iterator().next();
            if(!dfs(current,whiteSet,greySet,map)){
                return new int[0];
            }
        }
        int[] courses = new int[blackSet.size()];
        for(int i=0;i<blackSet.size();i++){
            courses[i] = blackSet.get(i);
        }
        return courses;
    }

    private static boolean dfs(int current,  Set<Integer> whiteSet , Set<Integer> greySet , HashMap<Integer,List<Integer>> map ){
        whiteSet.remove(current);
        greySet.add(current);
        for(Integer nbr : map.get(current) ){
            if(blackSet.contains(nbr)) continue;
            if(greySet.contains(nbr)) return false;
            if(!dfs(nbr,whiteSet,greySet,map))
                return false;
        }
        greySet.remove(current);
        blackSet.add(current);
        return true;
    }

}
