public class IsSorteArray {
    public static boolean issortedArray(int arr[], int i) { // ascemding
        if (i == arr.length - 1) {
            return true; // base case
        }
        if(arr[i]>arr[i+1]){
            return false;
        }

        return issortedArray(arr, i+1);

    }

    public static void main(String[] args) {
int arr[]={1,2,3,4,5};
System.out.println(issortedArray(arr, 0));
    }
}
