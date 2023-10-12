import java.util.List;

public class ThreeSum_TwoPointer {
    public void threeSumTwoPointer (int[] nums) {
        int n = nums.length;
        for (int i = 0; i <= n - 3; i++) {
            int j = i + 1;
            for (int k = n - 1; k >= i + 1; k --) {
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        System.out.println(nums[i]+ " " + nums[j] + " " + nums[k]);
                        j ++;
                    } else if (sum < 0) {
                        j ++;
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
