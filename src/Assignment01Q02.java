public class Assignment01Q02 {
    public static void main(String[] args) {
        double actualPi = Math.PI;
        double approxPi = 0;
        int approxIndex = Integer.parseInt(args[0]);

        for (int i = 0; i < approxIndex; i++) {
            double nudge = 1.0 / (1 + 2 * i);
            approxPi += 4 * (i % 2 == 0 ? nudge : -nudge);
        }

        System.out.println(approxPi + " " + actualPi);
    }
}
