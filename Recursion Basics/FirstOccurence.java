public class FirstOccurence {
    public static int firstOccurence(int arr[],int i,int key){

        // base case
        if(i==arr.length-1){
            if(arr[i]==key){
                return i;
            }
            else{
                return -1;
            }
        }

        if(arr[i]==key){
            return i;
        }
        return firstOccurence(arr, i+1, key);


    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        System.out.println(firstOccurence(arr, 0, 3));
    }
}
