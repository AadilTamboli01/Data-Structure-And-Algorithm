import java.util.ArrayList;

public class ActivitySelcetion {
    public static void activitySelection(int start[], int end[]) {
        ArrayList<Integer> list = new ArrayList<>();
        int maxActivity = 0;

        // sorted on the endTime basis
        list.add(0); // oth acitivity is always selected because end time sorted

        int lastEnd = end[0];

        maxActivity++; // one activity selected

        for (int i = 1; i <end.length; i++) {

            if (start[i] >= lastEnd) {
                // doable activity
                maxActivity++;
                list.add(i);// index of activity
                lastEnd = end[i];// update last end
            }
        }
        // print
        for (int i = 0; i < list.size(); i++) {
            System.out.print("Acitivity "+list.get(i)+"  ");
        }
    }

    public static void main(String[] args) {
        int start[] = { 10, 12, 20 };
        int end[] = { 20, 25, 30 };

        activitySelection(start, end);
    }
}