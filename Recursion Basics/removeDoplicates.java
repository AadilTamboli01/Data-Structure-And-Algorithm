public class removeDoplicates {
    public static void removeDuplicates(String str, int i, StringBuilder sb, boolean map[]) {
        if (i == str.length()) {
            System.out.println(sb.toString());
            return;
        }
        if (map[str.charAt(i) - 'a'] == false) {
            // visited
            map[str.charAt(i) - 'a'] = true;
            removeDuplicates(str, i + 1, sb.append(str.charAt(i)), map);
        } else {
            removeDuplicates(str, i + 1, sb, map);
        }

    }

    public static void main(String[] args) {
        removeDuplicates("aaaaiiillll", 0, new StringBuilder(""), new boolean[26]);
    }
}
