import java.util.ArrayList;

public class Pairsum {
    public static void pairSum(ArrayList<Integer> list, int sum) {
        int leftP = 0;
        int rightP = list.size() - 1;
        while (leftP < rightP) {
            if (list.get(leftP) + list.get(rightP) == sum) {
                System.out.println("has the pair " + leftP + ""
                        + rightP);
                return;
            } else if (list.get(leftP) + list.get(rightP) < sum) {
                leftP++;// if sum i greater
            } else {
                rightP--; // if sum is small
            }
        }
    }

    public static void main(String[] args) {
ArrayList<Integer> list = new ArrayList<>();
list.add(1);
list.add(2);
list.add(3);
list.add(4);
list.add(5);
list.add(6);
list.add(7);
list.add(8);
list.add(9);
pairSum(list, 7);
    }
}
