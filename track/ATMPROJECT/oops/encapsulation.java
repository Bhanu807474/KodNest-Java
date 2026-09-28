
class Book {
    private int pageNum;

    // Setter method with validation
    public void setData(int x) {
        if (x > 0) {
            pageNum = x;
        } else {
            System.out.println("Invalid page number!");
        }
    }

    // Getter method
    public void getData() {
        System.out.println("Page Number: " + pageNum);
    }
}

public class encapsulation {
    public static void main(String[] args) {
        Book b1 = new Book();
        b1.setData(50);
        b1.getData();
    }
}

