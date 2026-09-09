
class pgm9 {

    public static void main(String[] args) {

        String s1 = "bhanu";
        char arr[] = s1.toCharArray();
        System.out.println(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        String res = new String(arr);
        System.out.println(res);
    }

}
