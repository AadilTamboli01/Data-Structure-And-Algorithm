public class ShortestPath {
    public static void shortestPath(String path){
        int x =0;
        int y=0;
        for(int i=0;i<path.length();i++){
           if(path.charAt(i)=='E'){
            x++;
           }
           else if(path.charAt(i)=='S'){
            y--;
           }
           else if(path.charAt(i)=='N'){
            y++;
           }
           else{
            x--;
           }

        }
        int xsq = x*x;
        int ysq = y*y;

        double distanceFromorigin = Math.sqrt(xsq+ysq);
        System.out.println("The shortest Path = "+distanceFromorigin);
    }
    public static void main(String[] args) {
      String  Path = "WNEENESENNNN";
      shortestPath(Path);

      System.out.println(Path.substring(0,3));
    }
}
