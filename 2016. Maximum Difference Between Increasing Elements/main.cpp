#include <climits>
#include <iostream>
#include <vector>

using namespace std;

int maximumDifference_brute_force(vector<int>& nums) {
    int answer = INT_MIN;
    for (int i = 0; i < nums.size(); i++) {
        for (int j = i + 1; j < nums.size(); j++) {
            if (nums[j] > nums[i]) {
                answer = max(answer, nums[j] - nums[i]);
            }
        }
    }
    return answer == INT_MIN ? -1 : answer;
}

int maximumDifference(vector<int>& nums) {
    int answer = INT_MIN;
    int maximum_number_so_far_from_the_end = nums.back();
    for (int i = nums.size() - 2; i >= 0; i--) {
        if (nums[i] < maximum_number_so_far_from_the_end) {
            answer = max(answer, maximum_number_so_far_from_the_end - nums[i]);
        }
        maximum_number_so_far_from_the_end = max(maximum_number_so_far_from_the_end, nums[i + 1]);
    }
}

int main() {
}