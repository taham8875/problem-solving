class Solution {
   public:
    int maxSubArray(vector<int>& nums) {
        int max_so_far = INT_MIN;
        int max_at_end_i = 0;
        for (int i = 0; i < (int)nums.size(); i++) {
            max_at_end_i = max(nums[i], max_at_end_i + nums[i]);
            max_so_far = max(max_so_far, max_at_end_i);
        }

        return max_so_far;
    }
};