
class pgm3 {

    public static void main(String[] args) {

        String s1 = "java";
        String s2 = "jaVa";

        if (s1 == s2) {
            System.out.println("content are equal");
        } else {
            System.out.println("content are not equal");
        }
        if (s1.equalsIgnoreCase(s2)) {
            System.out.println("content are equal");
        } else {
            System.out.println("content are not equal");
        }
    }
}
