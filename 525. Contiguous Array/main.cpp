class Solution {
   public:
    int findMaxLength(vector<int>& nums) {
        for (int i = 0; i < (int)nums.size(); i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }

        map<int, int> prefix_table;
        prefix_table[0] = -1;

        int prefix_sum = 0;

        int maximum_length = 0;
        for (int i = 0; i < (int)nums.size(); i++) {
            prefix_sum += nums[i];

            if (prefix_table.count(prefix_sum)) {
                maximum_length =
                    max(maximum_length, i - prefix_table[prefix_sum]);
            }

            if (!prefix_table.count(prefix_sum)) {
                prefix_table[prefix_sum] = i;
            } else {
                prefix_table[prefix_sum] = min(prefix_table[prefix_sum], i);
            }
        }
        return maximum_length;
    }
};