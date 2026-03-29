import java.util.Stack;

public class StockSpanPrblem {
    public static int[] stockSpan(int stocks[]) {
        int span[] = new int[stocks.length];
        Stack<Integer> s = new Stack<>();
        span[0] = 1; // by default
        s.push(0); // index of cuurent span

        for (int i = 1; i < stocks.length; i++) {
            int currentPrice = stocks[i];
            // scheck for span
            while (!s.isEmpty() && currentPrice >= stocks[s.peek()]) { // last span greater nahi hai
                s.pop();
            }
            if (s.isEmpty()) {
                // if stack isEmpty
                span[i] = i + 1;
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i); // add cuurent index in the stack for other

        }
        return span;
    }

    public static void main(String[] args) {
        int stocks[] = { 100, 80, 60, 70, 60, 85, 100 };
        int span[] = stockSpan(stocks);
        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }
    }
}
