import java.util.*;

class Solution {

    long solve(int i, long[] bit) {
        long ans = 0;

        for (; i > 0; i -= (i & -i)) {
            ans = Math.max(bit[i], ans);
        }

        return ans;
    }
        void update(int i, long x, long[] bit) {
        for (; i < bit.length; i += (i & -i)) {
            bit[i] = Math.max(bit[i], x);
        }
    }

    public List<Boolean> getResults(int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        long[] bit = new long[50001];

        TreeSet<Integer> blocks = new TreeSet<>();
        blocks.add(0);

        for (int[] q : queries) {
            if (q[0] == 1) {
                blocks.add(q[1]);
            }
        }

        Integer prev = null;
        for (Integer curr : blocks) {
            if (prev != null) {
                update(curr, curr - prev, bit);
            }
            prev = curr;
        }
         for (int i = queries.length - 1; i >= 0; i--) {
            int x = queries[i][1];

            Integer curr = blocks.ceiling(x);

            if (queries[i][0] == 1) {

                Integer left = blocks.lower(x);
                Integer right = blocks.higher(x);

                if (right != null) {
                    update(right, right - left, bit);
                }

                blocks.remove(x);
            } else {

                int size = queries[i][2];
                Integer left = blocks.lower(x);

                int ds = x - left;

                if (ds >= size || solve(x, bit) >= size) {
                    ans.add(true);
                } else {
                    ans.add(false);
                }
            }
        }

        Collections.reverse(ans);
        return ans;
    }
}