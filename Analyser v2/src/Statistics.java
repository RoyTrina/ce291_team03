import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Statistics {

    // function to find the mean of the subject given an Array
    public static double findMean(ArrayList<Integer> array) {
        int mean = 0;
        int length = array.size();

        for (int i : array) {
            mean += i;
        }

        return mean/length;
    }

    // function to find the mode of the subject given an Array
    public static int findMode(ArrayList<Integer> array) {
        int modalValue = 0;
        int frequency = 0;
        boolean isMode = false;

        // putting array into a Set
        Set<Integer> modeSet = new HashSet<>();
        for (int i = 0; i < array.size(); i++) {
            int num = array.get(i);
            int count = 1;
            // for loop will go through each value in the array and count its interval
            for (; (i+count) < array.size() && (array.get(i+count) == num) ; count++) {
            }

            // multiple if statements to determine if it is the modal value
            i += (count - 1);
            if (frequency != 0 && count != frequency) {
                isMode = true;
            }

            if (count > frequency) {
                modeSet.clear();
                modeSet.add(num);
                frequency = count;
            }

            else if (count == frequency){
                modeSet.add(num);
            }
        }

        if (!isMode){
            modeSet.clear();
        }

        for (int i: modeSet){
            modalValue = i;
        }

        //returns the modalValue as a integer
        return modalValue;
    }

    // function to find the mean of the subject given an Array
    public static double findMedian(ArrayList<Integer> array) {
        int length = array.size();
        int lengthHalf = length/2;

        // if the array length is an even number, it gets the average of the two middle numbers
        if (array.size() % 2 == 0) {
            return ((double) array.get(lengthHalf) + array.get(lengthHalf - 1)) / 2;
        }

        // if the array length is an odd number, it will return the middle value
        else {
            return (array.get(lengthHalf));
        }

    }
}

