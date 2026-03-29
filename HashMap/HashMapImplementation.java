import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;;

public class HashMapImplementation {
    static class HashMap<K, V> { // generic
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int N; // size of array
        private int n; // n no of nodes
        private LinkedList<Node> buckets[];// N arr of bucktes store nodes of linkedlist

        // constructor
        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4; // initially no nodes in hashmap
            this.buckets = new LinkedList[N]; // 4 size array N
            // initializa array with empty linkedlist
            for (int i = 0; i < 4; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hashcode = key.hashCode();
            int bi = Math.abs(hashcode) % N; // size of Array
            return bi; // bucket index of linkedlist
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi]; // linkedlist of bucket index b i

            int di = 0;
            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key == key) { // if key exist
                    return di;
                }
                di++;
            }
            return -1; // key not present
        }

        private void rehash() {
            LinkedList<Node> oldArray[] = buckets; // store bucket in array

            // create new Array of double size
            buckets = new LinkedList[N * 2]; // double size of buckets
            N = N * 2; // incresse size of N

            // initializi with empty linkedlist
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            // add old nodes in new bucktes
            for (int i = 0; i < oldArray.length; i++) {
                LinkedList<Node> ll = oldArray[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.remove(); // remove from old
                    put(node.key, node.value); // put in the bucktet new Bucket

                }
            }

        }

        public void put(K key, V value) {
            // find bucket index
            int bi = hashFunction(key); // get Bucket index of the key

            // find data index of the key in bi linkedlist
            int di = searchInLL(key, bi); // pass bi to seach in linkedlist (find key on bicket index )

            if (di != -1) { // key is already exist the update only
                // get node for updation
                Node node = buckets[bi].get(di);
                node.value = value; // updated value
            } else {// di ==-1
                    // key not exist crete new pair key value
                buckets[bi].add(new Node(key, value)); // add new node
                n++;// no of nodes ++

            }

            // after insertion of each node check for rehashing condition
            // lambda = n/N no of nodes/ size of array

            double lambda = (double) n / N;
            // let thrsold value == 2.0
            if (lambda > 2.0) {
                rehash(); // perform rehashing

            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key); // bucket index
            int di = searchInLL(key, bi); // data index

            if (di != -1) {
                // key exist
                return true;
            } else {
                return false; // key nahi hai
            }

        }

        public V get(K key) {
            int bi = hashFunction(key); // get bucket index

            int di = searchInLL(key, bi); // get data index

            if (di != -1) { // key is already exist the update only
                // get node for updation
                Node node = buckets[bi].get(di); // get node if data index

                return node.value; // return value
            } else {// di ==-1
                return null;
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key); // get bucket index

            int di = searchInLL(key, bi); // get data index

            if (di != -1) {
                // node exist
                Node node = buckets[bi].remove(di); // remove element on data index
                n--; // no of node --
                return node.value;

            } else {
                // not exist key
                return null;
            }
        }

        public ArrayList<K> kySet() {
            ArrayList<K> keys = new ArrayList<>();

            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    // add key in arraylist
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }

    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("Aadil", 21);
        hm.put("Tamboli", 21);
        hm.put("Hello", 21);
        hm.put("World", 21);

        for (String key : hm.kySet()) {
            System.out.print(hm.get(key) + " ");
        }
    }
}
