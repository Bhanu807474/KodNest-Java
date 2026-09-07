
import java.util.Scanner;

public class threearrays {

    public static void main(String[] args) {
        int a[][][] = new int[2][3][4];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array elements : ");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 4; k++) {
                    a[i][j][k] = sc.nextInt();
                }
            }
        }
        System.out.println("Array Elements are : ");
        for (int i = 0; i < 2; i++) {
            System.out.println("Block " + (i + 1) + ":");
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 4; k++) {
                    System.out.print(a[i][j][k] + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }
        sc.close();
    }
}
