public class HalfNumberPyramid {
    public static void halfPyramidNumber(int n ){
        for(int i=0; i<n;i++){
            int count=1;
            for(int j=0;j<=i;j++){
                System.out.print(" "+count+++" ");

            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        halfPyramidNumber(5);
    }
}
