import java.util.HashMap;
import java.util.Map;

public class NetBalancePeriodCounter {

    public static long countPeriods(int[] transactions, long k) {
        Map<Long, Integer> seen = new HashMap<>();
        seen.put(0L, 1);
        long runningTotal = 0;
        long count = 0;

        for (int t : transactions) {
            runningTotal += t;
            count += seen.getOrDefault(runningTotal - k, 0);
            seen.put(runningTotal, seen.getOrDefault(runningTotal, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] t1 = {3, 4, -7, 1, 3, 3, 1, -4};
        System.out.println(countPeriods(t1, 7));

        int[] t2 = {1, 2, 3};
        System.out.println(countPeriods(t2, 10));
    }
}
