import java.util.*;

public class ChocolaProblem {

    public static void main(String[] args) {
        int n = 4;
        int m = 6;

        Integer horizontalCut[] = { 4, 1, 2 };
        Integer verticalCut[] = { 2, 1, 3, 1, 4 };

        // sort in decensdin order
        Arrays.sort(horizontalCut, Collections.reverseOrder());
        Arrays.sort(verticalCut, Collections.reverseOrder());
        // initially horizontal and vertical piece is one
        int hp = 1;
        int vp = 1;

        // horizontal and vertical cuts
        int h = 0;
        int v = 0;

        int cost = 0;

        while (h < horizontalCut.length && v < verticalCut.length) {
            if (horizontalCut[h] <= verticalCut[v]) {// vertical cut
                // vertical is greater
                cost += verticalCut[v] * hp; // vertical cost * horizontal Pieces
                vp++;
                v++;
            } else {
                // horizontalCut
                cost += horizontalCut[h] * vp; // horizontal cost * vertical pieces
                hp++;
                h++;
            }
        }
        // for remaining element
        while (h < horizontalCut.length) {
            cost += horizontalCut[h] * vp; // horizontal cost * vertical pieces
            hp++;
            h++;
        }
        while (v < verticalCut.length) {
            cost += verticalCut[v] * hp; // vertical cost * horizontal Pieces
            vp++;
            v++;
        }
        System.out.println("cost = " + cost);

    }
}
