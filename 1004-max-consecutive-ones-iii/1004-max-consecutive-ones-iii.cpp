class Solution {
   public:
    int longestOnes(vector<int>& nums, int k) {
        int len = 0;
        int start = 0;
        int end = 0;
        int zeros = 0;
        for (; end < (int)nums.size(); end++) {
            if (nums[end] == 0) {
                zeros++;
                while (zeros > k) {
                    if (nums[start] == 0) {
                        zeros--;
                    }
                    start++;
                }
            }
            len = max(len, end - start + 1);
        }
        return len;
    }
};