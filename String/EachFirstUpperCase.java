public class EachFirstUpperCase {
    public static String eachLetterUpperCase(String str) {
        StringBuilder sb = new StringBuilder("");
        char ch = str.charAt(0);
        sb.append(Character.toUpperCase(ch));
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(str.charAt(i));
                i++;

                sb.append(Character.toUpperCase(str.charAt(i))); // character after space

            }else{
                 // add as it is
            sb.append(str.charAt(i));
            }
           
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String name = "aadil is good";
        System.out.println(eachLetterUpperCase(name));
    }
}
