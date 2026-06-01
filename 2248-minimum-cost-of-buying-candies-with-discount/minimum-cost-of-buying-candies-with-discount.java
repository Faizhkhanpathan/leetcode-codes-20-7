import java.util.*;

class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);

        int total = 0;
        int n = cost.length;

        for (int i = n - 1, count = 0; i >= 0; i--, count++) {
            if (count % 3 != 2) {
                total += cost[i];
            }
            }

        return total;
    }
}