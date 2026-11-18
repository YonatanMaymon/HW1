public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        if(i==j) return 0;
        return helper(m, i, j, 0);
    }
    private static int helper(int[][] m, int i, int j, int steps) {
        if(steps>= m.length)
            return -1;
        steps++;
        int num = m.length+1;
        for(int k = 0; k<m.length; k++){
            if(m[i][k] != 0){
                if(k==j) return steps;
            num = Math.min(helper(m, k, j, steps), num) ;
            }
        }
        return num == m.length+1?-1:num;
    }

    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}