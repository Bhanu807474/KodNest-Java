class placementeligible {

    public static void main(String[] args) {
        double cgpa = 7.0;
        int attendance = 75;

        if (cgpa >= 6.5 && attendance >= 50) {
            System.out.println("Eligible");
        } else {
            System.out.println("Not Eligible");
        }
    }
}
