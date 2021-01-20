package graph;
import  java.util.*;
public class MinimumCourses {
    public static void main(String[] args) {
       int N = 3;
        int[][]relations = {{0,1},{1,2},{2,0}};
        System.out.print(new MinimumCourses().minimumSemesters(N,relations));
    }
    public int minimumSemesters(int N, int[][] relations) {

        Map<Integer,HashSet<Integer>> map = new HashMap<>();
        int[] inDegree = new int[N];

        for(int i=0;i<N;i++)
            map.put(i,new HashSet<>());

        for(int[] rel:relations){
            if(map.get(rel[0]).add(rel[1]))
                inDegree[rel[1]]++;
        }

        Queue<Integer> que= new LinkedList<>();
        for(int i=0;i<N;i++){
            if(inDegree[i]==0)
                que.offer(i);
        }

        int taken=0; int sem=0;
        while(!que.isEmpty()){
            int count = que.size();
            taken +=count;
            for(int i=0;i<count;i++){
                int curr = que.poll();
                for(Integer nbr:map.get(curr)){
                    inDegree[nbr]--;
                    if(inDegree[nbr]==0)
                        que.offer(nbr);
                }
            }
            sem+=1;
        }

        return taken==N?sem:-1;

    }

}
