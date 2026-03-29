public class LastOccurence {
    public static int lastOccurence(int arr[], int i, int key) {
        if (i == arr.length - 1) { // base case
            if (arr[i] == key) {
                return i;
            } else {
                return -1;
            }
        }

        int isFound = lastOccurence(arr, i + 1, key);

        if (isFound == -1 && arr[i] == key) {
            return i;
        }

        return isFound;

    }

    public static void main(String[] args) {
int arr[]={1,2,3,34};
System.out.println(lastOccurence(arr, 0, 34));
    }
}
