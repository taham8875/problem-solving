class Solution {
   public:
    void moveZeroes(vector<int>& nums) {
        int number_of_non_zero_elements = 0;
        for (int i = 0; i < (int)nums.size(); i++) {
            if (nums[i] != 0) {
                swap(nums[i], nums[number_of_non_zero_elements]);
                number_of_non_zero_elements++;
            }
        }
    }
};