import java.util.*;

import javax.print.attribute.standard.JobName;

public class JobSequencing {
    public static class Job {
        int deadline;
        int profit;
        int id; // 0 =A 1 = B

        public Job(int deadline, int profit, int id) {
            this.deadline = deadline;
            this.profit = profit;
            this.id = id;
        }
    }

    public static void main(String[] args) {
        int JobInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };
        ArrayList<Job> Jobs = new ArrayList<>();

        // create new jobs
        for (int i = 0; i < JobInfo.length; i++) {
            Jobs.add(new Job(JobInfo[i][0], JobInfo[i][1], i)); // i = id
        }
        // sort on the basis of dec profit
        Collections.sort(Jobs, (obj1, obj2) -> obj2.profit - obj1.profit);

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for (int i = 0; i < Jobs.size(); i++) {
            Job curr = Jobs.get(i);

            if (curr.deadline > time) {
                seq.add(curr.id);
                time++;
            }
        }
        for (int i = 0; i < seq.size(); i++) {
            System.out.print("Job"+seq.get(i)+"  ");
        }
        System.out.println();

    }
}
