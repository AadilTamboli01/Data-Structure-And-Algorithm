public class CharcterPyramid {
    public static void characterPattern(int n ){
        char character = 'A';
        for(int i=0;i<n;i++){
        
            for(int j=0;j<=i;j++){
                System.out.print(" "+character+++" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        characterPattern(5);
    }
}
