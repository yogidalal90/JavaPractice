package graph;

import javafx.util.Pair;

import java.util.*;

public class OpenLock {

    public static void main(String[] args) {
        ArrayList<Integer> ls=  new ArrayList<>();
        ls.clear();
        OpenLock op = new OpenLock();
        System.out.print(op.openLock(new String[]{"1002","1220","0122","0112","0121"},"1200"));
    }
    public int openLock(String[] deadends, String target) {

        String start="0000";
        if(start.equals(target))
            return 0;
        Set<String> set = new HashSet<>();
        for(String end:deadends)
            set.add(end);


        if(set.contains(start) || set.contains(target))
            return -1;

        Set<String> visited = new HashSet<>();
        Queue<String> que = new LinkedList<>();
        Queue<String> que1 = new LinkedList<>();
        Set<String> visited1 = new HashSet<>();
        visited1.add(target);
        visited.add(start);
        que.offer(start);
        que1.offer(target);
        int step=1;
        while(!que.isEmpty() && !que1.isEmpty()){
            int n=que.size();
            for(int j=0;j<n;j++){

                String str = que.poll();

                for(int i=0;i<str.length();i++){
                    String fow = rotateForward(str.toCharArray(),i);
                    if(!visited.contains(fow) && !set.contains(fow)){
                        que.offer(fow);
                        visited.add(fow);
                    }

                    String back = rotateBackward(str.toCharArray(),i);
                    if(!visited.contains(back) && !set.contains(back)){
                        que.offer(back);
                        visited.add(back);
                    }
                    if(visited1.contains(fow) || visited1.contains(back))
                        return step;
                    System.out.println(fow+":"+back);
                }


            }
            step+=1;
            n=que1.size();
            for(int j=0;j<n;j++){

                String str = que1.poll();

                for(int i=0;i<str.length();i++){
                    String fow = rotateForward(str.toCharArray(),i);
                    if(!visited1.contains(fow) && !set.contains(fow)){
                        que1.offer(fow);
                        visited1.add(fow);
                    }

                    String back = rotateBackward(str.toCharArray(),i);
                    if(!visited1.contains(back) && !set.contains(back)){
                        que1.offer(back);
                        visited1.add(back);
                    }
                    if(visited.contains(fow) || visited.contains(back))
                        return step;
                    //  System.out.println(fow+":"+back);
                }


            }
            step+=1;
        }

        return -1;
    }




    String rotateForward(char[] arr, int idx){

        //+1
        if(arr[idx]=='9'){
            arr[idx]='0';
        }else{
            arr[idx]= (char)(arr[idx]+1);
        }
        return new String(arr);
    }

    String rotateBackward(char[] arr, int idx){

        //-1
        if(arr[idx]=='0'){
            arr[idx]='9';
        }else{
            arr[idx]=(char)(arr[idx]-1);
        }
        return new String(arr);
    }
}
