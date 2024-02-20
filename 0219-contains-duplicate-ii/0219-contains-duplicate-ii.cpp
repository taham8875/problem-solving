class Solution {
   public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        map<int, int> element_to_last_index_table;
        for (int i = 0; i < (int)nums.size(); i++) {
            if (element_to_last_index_table.count(nums[i]) && i - element_to_last_index_table[nums[i]] <= k) {
                return true;
            }
            element_to_last_index_table[nums[i]] = i;
        }
        return false;
    }
};