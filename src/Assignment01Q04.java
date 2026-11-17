import java.util.Arrays;

public class Assignment01Q04 {

    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
        int n = array.length;
        if (n == 0)
            return array;
        move %= n;
        move = (move + n) % n; // to avoid negatives
        if (direction != 'R' && direction != 'L' || move == 0) // if nothing is needed to be done
            return array;
        boolean isR = direction == 'R';
        move = isR ? n - move : move; // moving n-move left is the same as moving move right
        array = shiftArrayLeftCyclic(array, move, n);
        return array;
    }

    private static int[] shiftArrayLeftCyclic(int[] array, int move, int n) {
        int[] temp = Arrays.copyOf(array, move);
        for (int i = 0; i < n - move; i++) {
            array[i] = array[i + move]; // moving move steps to the left
        }
        for (int i = 0; i < move; i++) { // returning the numbers we put aside
            array[n - move + i] = temp[i];
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, -1, 'R'))); // [2, 3, 4, 5, 1]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, 1, 'R'))); // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, 1, 'r'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, -2, 'g'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, 3, 'L'))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, -3, 'L'))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 0, 8, 9, 5, 6 }, 6, 'L'))); // [8, 9, 5, 6, 0]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] {}, 3, 'R'))); // []
    }
}