public class ReversedCharSequence implements CharSequence {

    private String data;
    private String original;

    public ReversedCharSequence(String str) {
        original = str;
        data = "";
        for (int i = str.length()-1; i >= 0; i--){
            data += str.charAt(i);
        }
    }
        
    public char charAt (int index) {
        return data.charAt(index);
    }

    public int length() {
        return data.length();
    }

    public ReversedCharSequence subSequence(int start, int end) {
        ReversedCharSequence seq = new ReversedCharSequence (original.substring(original.length() - end , original.length() - start));
        return seq;
    }
    
    public String toString() {
        String out = "";
        for (int i = 0; i < data.length(); i++) {
            out += data.charAt(i);
        }
        return out;
    }

/* TESTING
    public static void main(String[] args) {
        String s = "ABCDEF";
        ReversedCharSequence r = new ReversedCharSequence(s);
        System.out.println(r.charAt(0)); // F
        System.out.println(r.charAt(5)); // A
        System.out.println(r.length()); // 6
        System.out.println(r.subSequence(0,4)); // "FEDC"
        System.out.println(r.subSequence(0,6)); // "FEDCBA"
        System.out.println(r); // "FEDCBA"
    }
*/
    
}