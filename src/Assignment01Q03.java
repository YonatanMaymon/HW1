public class Assignment01Q03 {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        System.out.println("The first " + x + " Fibonacci numbers are:");

        int numOdd = 0;
        int num1 = 1, num2 = 1;

        for (int i = 0; i < x; i++) {
            System.err.print(num1);
            if (num1 % 2 == 1)
                numOdd++;
            int sum = num1 + num2;
            num1 = num2;
            num2 = sum;
            if (i < x - 1)
                System.out.print(" ");
        }
        System.out.println();
        System.out.println("The number of odd numbers is: " + numOdd);
    }
}
