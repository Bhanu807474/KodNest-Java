// switch is used when we need one option from multiple fixed options

class switchstatement {

    public static void main(String[] args) {
        int number = 3;
        switch (number) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Invalid");
        }

    }
}
