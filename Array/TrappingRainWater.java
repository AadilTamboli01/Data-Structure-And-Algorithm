public class TrappingRainWater {
    public static void trappingRainwater(int height[]) {
        int leftMax[] = new int[height.length];
        int rightMax[] = new int[height.length];
        int width = 1;
        // calculate the leftMax
        leftMax[0] = height[0];
        for (int i = 1; i < leftMax.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        // calculate the rightMax
        rightMax[rightMax.length - 1] = height[height.length - 1];
        for (int i = rightMax.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // calculate the trappedwater
        int trappedWater = 0;
        for (int i = 0; i < height.length; i++) {

            int waterlevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += (waterlevel - height[i]) * width;

        }
        System.out.println("Total water trapped after raining is = " + trappedWater);
    }

    public static void main(String[] args) {
        int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        trappingRainwater(height);

    }
}
