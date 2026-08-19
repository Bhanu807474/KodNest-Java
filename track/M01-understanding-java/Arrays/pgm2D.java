
import java.util.Scanner;

public class pgm2D {

    public static void main(String[] args) {
        int a[][] = new int[3][5];
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the array elements :");
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 4; j++) {
                a[i][j] = sc.nextInt();

            }
        }
        System.out.println("Array Elements are : ");
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 4; j++) {
                System.out.print(a[i][j] + "	");
            }
            System.out.println();
        }

    }
}
