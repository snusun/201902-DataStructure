import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // TODO Run your method here to compute and print the GCD of a and b!
            System.out.println("GCD<" + a + ", " + b + "> = " + GCD.gcd(a, b));
        }
    }

}
