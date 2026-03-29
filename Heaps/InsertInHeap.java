import java.util.ArrayList;

public class InsertInHeap {

   static class Heap {
      ArrayList<Integer> arr = new ArrayList<>();

      public void add(int data) {
         // add data
         arr.add(data);
         int x = arr.size() - 1;// child index
         int par = (x - 1) / 2; // parent index

         // fix the heap
         // < condition chage > for max heap
         while ( arr.get(x) < arr.get(par)) { // min heap child is samll
            // swap

            int temp = arr.get(x);
            arr.set(x, arr.get(par));
            arr.set(par, temp);

            // update
            x = par;
            par = (x - 1) / 2;

         }
      }

      public void heapify(int i) {
         int left = (2 * i) + 1;
         int right = (2 * i) + 2;
         int midIndx = i;

         // left
         if (left < arr.size() && arr.get(left) < arr.get(midIndx)) { // invalid for min heap
            midIndx = left;
         }
         // right
         if (right < arr.size() && arr.get(right) < arr.get(midIndx)) { // invalid for min heap
            midIndx = right;
         }

         if (midIndx != i) {
            // midindex is changed
            // swap i with mid index
            int temp = arr.get(i);
            arr.set(i, arr.get(midIndx));
            arr.set(midIndx, temp);

            // call for heapfy
            heapify(midIndx);
         }

      }

      // get
      public int peek() {
         if (isEmpty()) {
            System.out.println("Empty Heap ! ");
            return -1;
         }
         return arr.get(0); // first element is peek
      }

      public boolean isEmpty() {
         return arr.size() == 0;
      }

      public int remove() {
         int data = arr.get(0); // first element is remove

         // interchag efirst and last element
         int temp = arr.get(0);
         arr.set(0, arr.get(arr.size() - 1));
         arr.set(arr.size() - 1,temp);
         
         arr.remove(arr.size() - 1);
         heapify(0); // heapify for the new frst element

         // remove last element which is minimum
        
       
         return data;
      }
   }

   public static void main(String[] args) {
      Heap hp = new Heap();
    hp.add(1);
    hp.add(-1);
    while (!hp.isEmpty()) {
      System.out.print(hp.remove()+" ");
    }

   }
}
