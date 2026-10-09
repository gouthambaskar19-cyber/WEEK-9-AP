public class LongestBudgetStreak {

    public static int[] longestStreak(int[] costs, long budget) {
        int left = 0;
        long sum = 0;
        int bestLength = 0;
        int bestStart = -1;

        for (int right = 0; right < costs.length; right++) {
            sum += costs[right];
            while (sum > budget && left <= right) {
                sum -= costs[left];
                left++;
            }
            int length = right - left + 1;
            if (length > bestLength) {
                bestLength = length;
                bestStart = left;
            }
        }
        return new int[]{bestLength, bestStart};
    }

    public static void main(String[] args) {
        int[] costs1 = {4, 2, 1, 7, 3, 1, 2, 1, 5};
        int[] r1 = longestStreak(costs1, 8);
        System.out.println("(" + r1[0] + ", " + r1[1] + ")");

        int[] costs2 = {9, 10};
        int[] r2 = longestStreak(costs2, 8);
        System.out.println("(" + r2[0] + ", " + r2[1] + ")");
    }
}
