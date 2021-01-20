package sorting;

import java.util.ArrayList;
import java.util.List;

public class UnionInterval {

    public static void main(String[] args) {
        List<Event> ls= new ArrayList<>();
        ls.add(new Event(0,3));
        ls.add(new Event(1,1));
        ls.add(new Event(2,4));
        ls.add(new Event(3,4));
        ls.add(new Event(5,7));
        ls.add(new Event(7,8));
        ls.add(new Event(8,11));
        ls.add(new Event(9,11));
        ls.add(new Event(12,14));
        ls.add(new Event(12,16));
        ls.add(new Event(13,15));
        ls.add(new Event(16,17));

        List<Event> res = unionOfEvents(ls);
        for(Event e:res)
            System.out.println(e.start+" : "+e.end);

    }
static class Event{
    int start;
    int end;
    public Event(int start,int end){
        this.start=start;
        this.end=end;
    }
}
  static  public List<Event> unionOfEvents(List<Event> events){

        int start=events.get(0).start;
        int end = events.get(0).end;

        List<Event> res=  new ArrayList<>();
        int n = events.size();

        for(int i=1;i<n;i++){
            if(events.get(i).start <= end){
                start = Math.min(start,events.get(i).start);
                end = Math.max(end,events.get(i).end);
            }else{
                res.add(new Event(start,end));
                start = events.get(i).start;
                end = events.get(i).end;
            }
        }
        res.add(new Event(start,end));
        return res;
    }

}
