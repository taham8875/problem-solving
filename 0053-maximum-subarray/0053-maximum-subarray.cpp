class Solution {
   public:
    int maxSubArray(vector<int>& nums) {
        int prefix_sum = 0;
        int max_so_far = INT_MIN;
        int min_so_far = INT_MAX;
        for (int i = 0; i < (int)nums.size(); i++) {
            prefix_sum += nums[i];
            max_so_far = max(max_so_far, prefix_sum);
            if (i != 0) max_so_far = max(max_so_far, prefix_sum - min_so_far);
            min_so_far = min(min_so_far, prefix_sum);
        }
        return max_so_far;
    }
};