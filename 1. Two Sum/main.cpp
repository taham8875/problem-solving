class Solution {
   public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int, int> value_to_index_map;
        int remain;
        for (int i = 0; i < nums.size(); i++) {
            remain = target - nums[i];
            if (value_to_index_map.count(remain)) {
                return vector<int>({i, value_to_index_map[remain]});
            }
            value_to_index_map[nums[i]] = i;
        }
        return vector<int>({0, 0});
    }
};