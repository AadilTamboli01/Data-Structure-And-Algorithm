import java.util.*;

public class MaxAreaInHistogram {
    public static int maxAreaHistogram(int height[]) {
        int maxArea = 0;
        int nextSmallestRight[] = new int[height.length];
        int nextSmallestLeft[] = new int[height.length];

        Stack<Integer> s = new Stack<>();
        // next smallest left
        nextSmallestLeft[0] = -1; // always
        s.push(0); // add first in stack
        for (int i = 1; i < nextSmallestLeft.length; i++) {
            int current = height[i];
            while (!s.isEmpty() && current <= height[s.peek()]) {
                s.pop(); // remove the element from the stack

            }
            if (s.isEmpty()) { // not smaller in left then -1
                nextSmallestLeft[i] = -1;

            } else {
                // hence smaller element in the stack
                nextSmallestLeft[i] = s.peek();
            }
            // push the current in the stack
            s.push(i);
        }

        // renew the stack
        s = new Stack<>();
        // calculating the next smallest right

        nextSmallestRight[nextSmallestRight.length - 1] = height.length; //  assing n beacase next s right not exist s
        // for better calculation we put the assing than to n
        s.push(nextSmallestRight.length - 1); // inex of the element
        for (int i = nextSmallestRight.length - 2; i >= 0; i--) {
            int current = height[i];
            while (!s.isEmpty() && current <= height[s.peek()]) {
                s.pop(); // remove the getest element fron the stack
            }
            if (s.isEmpty()) {
                // stack is Empty
                nextSmallestRight[i] = nextSmallestRight.length; // assign n means no smallest in the right
            } else {
                // smallest element on the top
                nextSmallestRight[i] = s.peek();

            }
            // push the curernt index in the stack
            s.push(i);
        }

        // calculate the area
        // height = current height
        // width nsmaller right - enxt smaller left -1 hence nsr[i] - nextsleft[i] -1;
        for (int i = 0; i < height.length; i++) {
            int width = nextSmallestRight[i] - nextSmallestLeft[i] - 1;
            int currHeight = height[i];
            int currArea = width * currHeight;
            maxArea = Math.max(maxArea, currArea);