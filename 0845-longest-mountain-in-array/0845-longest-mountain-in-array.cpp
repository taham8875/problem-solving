class Solution {
   public:
    int longestMountain(vector<int>& arr) {
        int longest_mountain_length = 0;
        int index = 0;
        int start = 0;
        int end = 0;
        while (index < (int)arr.size()) {
            start = index;
            while (index + 1 < (int)arr.size() && arr[index] < arr[index + 1]) {
                index++;
            }

            if (start == index) {
                index++;
                continue;
            }

            end = index;
            while (index + 1 < (int)arr.size() && arr[index] > arr[index + 1]) {
                index++;
            }

            if (end == index) {
                index++;
                continue;
            }

            longest_mountain_length = max(longest_mountain_length, index - start + 1);
        }
        return longest_mountain_length;
    }
};