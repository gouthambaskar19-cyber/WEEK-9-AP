import java.util.ArrayList;
import java.util.List;

public class MallFootfallReport {

    public static List<Integer> footfallReport(int[] visitors, int[][] queries) {
        int[] prefix = new int[visitors.length + 1];
        for (int i = 0; i < visitors.length; i++) {
            prefix[i + 1] = prefix[i] + visitors[i];
        }

        List<Integer> result = new ArrayList<>();
        for (int[] q : queries) {
            int start = q[0];
            int end = q[1];
            result.add(prefix[end + 1] - prefix[start]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] visitors = {12, 7, 3, 9, 15, 4, 8};
        int[][] queries = {{0, 2}, {2, 5}, {4, 6}, {3, 3}};
        System.out.println(footfallReport(visitors, queries));
    }
}
