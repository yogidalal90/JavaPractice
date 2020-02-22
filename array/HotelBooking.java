package array;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * A hotel manager has to process N advance bookings of rooms for the next season.
 * His hotel has K rooms. Bookings contain an arrival date and a departure date.
 * He wants to find out whether there are enough rooms in the hotel to satisfy the demand.
 *
 * Input :  Arrivals :   [1 3 5]
 *          Departures : [2 6 8]
 *          K: 1
 * Output: False
 */
public class HotelBooking {

    public static void main(String[] args) {
        int rooms = 1;
        List arrivals = new ArrayList<Integer>();
        //36, 45, 41
        arrivals.add(36);
        arrivals.add(45);
        arrivals.add(41);

        List departures = new ArrayList<Integer>();
        //51, 53, 65
        departures.add(51);
        departures.add(53);
        departures.add(65);

        System.out.println(isBookingPossible(arrivals,departures,rooms));
    }

    private static boolean isBookingPossible(List<Integer> arrive, List<Integer> depart, int K){
        if(!(isValidSchedule(arrive,depart,K))){
            System.out.println("invalid input");
            return false;
        }

        Collections.sort(arrive);
        Collections.sort(depart);

        for(int i = 0 ; i < arrive.size() ; i++) {
            if(arrive.get(i) >= depart.get(0)) {
                depart.remove(0);
            }
        }

        return depart.size() <= K;
    }

    private static boolean isValidSchedule(List arrivals, List departures, int k){
        if(arrivals == null || arrivals.isEmpty() || departures == null || departures.isEmpty() )
        {
            return false;
        }
        if(k<1){
            return false;
        }
        if(arrivals.size() != departures.size()){
            return false;
        }
        return true;
    }
}
