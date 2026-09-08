
class stringmethods {

    public static void main(String[] args) {
        String str = "Multi National";
        System.out.println(str);
        System.out.println(str.toLowerCase());
        System.out.println(str.toUpperCase());
        System.out.println(str.charAt(4));
        System.out.println(str.contains("lti"));
        System.out.println(str.startsWith("Multi"));
        System.out.println(str.endsWith("nal"));
        System.out.println(str.indexOf("N"));
        System.out.println(str.lastIndexOf("N"));
        System.out.println(str.replace('t', 'L'));
        System.out.println(str.replace("ti", "LA"));
        System.out.println(str.substring(5));
        System.out.println(str.substring(5, 8));
        System.out.println(str.length());
        System.out.println(str.isEmpty());
        System.out.println(str.isBlank());
        System.out.println(str.equals("Multi National"));
        System.out.println(str.equalsIgnoreCase("Multi National"));
        System.out.println(str.compareTo("Multi National"));
        System.out.println(str.compareToIgnoreCase("Multi National"));
        System.out.println(str.concat(" Company"));

    }
}
