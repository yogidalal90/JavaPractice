package array;

import java.util.ArrayList;
import java.util.List;

/**
 * A hotel manager has to process N advance bookings of rooms for the next season.
 * His hotel has K rooms. Bookings contain an arrival date and a departure date.
 * He wants to find out whether there are enough rooms in the hotel to satisfy the demand.
 *
 * Input :  Arrivals :   [1 3 5]
 *          Departures : [2 6 8]
 *          K: 1
 * Output: false
 */
public class Hotel
{

    public static void main(String[] args) {
        int rooms = 2;
        ArrayList  arrivals = new ArrayList<Integer> ();
        //36, 45, 41
        arrivals.add(36);
        arrivals.add(45);
        arrivals.add(41);

        ArrayList departures = new ArrayList();
        //51, 53, 65
        departures.add(51);
        departures.add(53);
        departures.add(65);

        System.out.println(isBookingPossible(arrivals,departures,rooms));
    }
    private static boolean isBookingPossible(ArrayList<Integer> arrive, ArrayList<Integer>  depart, int K)
    {
        if(!isValidSchedule(arrive,depart,K)){
            return false;
        }
        int currentBookings = 1;

        arrive.sort(Integer::compareTo);
        depart.sort(Integer::compareTo);
        int i=0;int j=0;
        int n = arrive.size();
        while (i<n && j<n) {

            if (arrive.get(i) < depart.get(j)) {
                currentBookings += 1;
                i += 1;
            } else {
                currentBookings -= 1;
                j += 1;
            }
            if (currentBookings > K)
                return false;
        }
        return true;
    }

    private static boolean isValidSchedule(List arrive, List depart, int k){
        if(arrive == null || arrive.isEmpty() || depart == null || depart.isEmpty() )
        {
            return false;
        }
        if(k<1){
            return false;
        }
        if(arrive.size() != depart.size()){
            return false;
        }
        return true;
    }
}
