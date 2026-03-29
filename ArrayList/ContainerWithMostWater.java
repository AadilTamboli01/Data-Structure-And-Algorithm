import java.util.*;

public class ContainerWithMostWater {
    public static int containerMostWater(ArrayList<Integer> container) { // O(n^2)
        int maxWater = Integer.MIN_VALUE;
        for (int i = 0; i < container.size() - 1; i++) {
            for (int j = i + 1; j < container.size(); j++) {
                // water height
                int height = Math.min(container.get(i), container.get(j));
                int width = j - 1;
                int currentWater = width * height;
                maxWater = Math.max(maxWater, currentWater);
            }

        }
        return maxWater;
    }

    public static int mostWaterTwoPointer(ArrayList<Integer> list) {
        int maxWater = Integer.MIN_VALUE;
        int leftPointer = 0;
        int rightPointer = list.size() - 1;
        while (leftPointer < rightPointer) {
            int height = Math.min(list.get(leftPointer), list.get(rightPointer));
            int width = rightPointer - leftPointer;
            int currentWater = height * width;
            maxWater = Math.max(maxWater, currentWater);

            // jo chota hai use update kardo 
            if (list.get(leftPointer) < list.get(rightPointer)) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);
        System.out.println(mostWaterTwoPointer(list));
        System.out.println(containerMostWater(list));
    }
}
