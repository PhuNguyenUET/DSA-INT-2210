//1.24: To get F with the number of broken eggs ~ lgN and used ~lgN eggdrop, we used binary search on N floor
// Meaning if an egg is broken at m floor, then cut r = m - 1, else l = m + 1, loop until l == r
// To get with ~2lgF, I think we drop eggs at 2^1, then at 2^2 and so on
// With this, we will get a space between 2^k and 2^(k + 1) where F lies in
// Then binary search in this range

//1.25: Drop the first egg at sqrt(N) then 2.sqrt(N), and so on. We will be able to detect a range
// between k.sqrt(N) and (k + 1).sqrt(N) where F lies. Then drop the second egg floor by floor
// in this range, which sums up to at most 2sqrt(N) drops
// Another option is to drop the first egg at 1 then 4 then 9 and so on.
// So we would get a range k^2 and (k + 1)^2 where F lies. We then drop the second egg floor by floor between
// this range, which is at most 2k drop, where k ~ F, so it sums up to 2sqrt(F) drop.

//Given that there is n eggs and k floors, find the minimum number of drops needed to find F
// in the worst case scenario
// Algorithm: There are two scenarios on floor x: the egg break and doesn't break
// If broken, there are x-1 floors (below) and n-1 eggs
// If not, there are k - x floors (above) and n eggs
// We need to minimize the worst case, so we take the max of these two and choose the floor
// with minimum of trials
public class EggDrop {
    public static int eggDrop (int n, int k) {
        // Dynamic programming for i eggs and j floors
        int[][] eggFloor = new int[n + 1][k + 1];
        int res;
        int i, j, x;

        for (i = 1; i <= n; i++) {
            eggFloor[i][1] = 1;
            eggFloor[i][0] = 0;
        }

        for (j = 1; j <= k; j++) {
            eggFloor[1][j] = j;
        }

        for (i = 2; i <= n; i++) {
            for (j = 2; j <= n; j++) {
                eggFloor[i][j] = Integer.MAX_VALUE;
                // Try every floor from the first up
                for (x = 1; x <= j; x ++) {
                    // 1 is to account for the initial drop at the x floor, which divides
                    // searching into half
                    res = 1 + Math.max(eggFloor[i - 1][x - 1], eggFloor[i][j - x]);
                    if (res < eggFloor[i][j]) {
                        eggFloor[i][j] = res;
                    }
                }
            }
        }

        return eggFloor[n][k];
    }
}
