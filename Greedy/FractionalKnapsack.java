import java.util.*;

public class FractionalKnapsack {
    public static void fractionalKhanpsack(int value[], int weight[], int capacity) {
        double ratio[][] = new double[value.length][2]; // 2 col index ratio

        // calculate the ration
        for (int i = 0; i < value.length; i++) {
            ratio[i][0] = i; // oth index
            ratio[i][1] = (value[i] / (double) weight[i]);
        }

        // sort the ration we want deccending hece we backworrd travel on the accending
        // ration
        // we want large reation first
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1])); // sort on the basis of the ratio

        // calculating the knapsack
        int finalValue = 0;
        for (int i = ratio.length - 1; i >= 0; i--) { // ratio is accending sorting and we want the deccending sorting
                                                      // hence backloop
            int index = (int) ratio[i][0];
            if (capacity >= weight[index]) {
                // add this in the bag

                finalValue += value[index];
                capacity -= weight[index]; // capacity - add the item in the bag
            } else {
                // add item fractionally

                finalValue += (ratio[i][1] * capacity); // value of fractional item (ratio*capacity)
                capacity = 0; // beacause weight is > capacity
                break; // break the loop

            }

        }
        System.out.println("Final value = " + finalValue);
    }

    public static void main(String[] args) {
        int weight[] = { 10, 20, 30 };
        int value[] = { 60, 100, 120 };
        fractionalKhanpsack(value, weight, 50);
    }
}
