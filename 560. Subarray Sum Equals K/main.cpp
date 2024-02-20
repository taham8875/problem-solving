#include <climits>
#include <iostream>
#include <map>
#include <vector>

using namespace std;
int subarraySum(vector<int>& nums, int k) {
    map<int, int> prefix_table;
    prefix_table[0] = 1;  // therefore the first element(s) can be the solution if it is equal to k
    int number_of_wanted_subarray = 0;
    int prefix_sum = 0;

    for (int i = 0; i < (int)nums.size(); i++) {
        prefix_sum += nums[i];

        if (prefix_table.count(prefix_sum - k)) {
            number_of_wanted_subarray += prefix_table[prefix_sum - k];
        }

        prefix_table[prefix_sum]++;
    }
}

int subarraySum_brute_force(vector<int>& nums, int k) {
    // time limit exceeded
    int number_of_wanted_subarray = 0;
    for (int i = 0; i < (int)nums.size(); i++) {
        for (int j = i; j < (int)nums.size(); j++) {
            int sum = 0;
            for (int k = i; k <= j; k++) {
                sum += nums[k];
            }
            if (sum == k) {
                number_of_wanted_subarray++;
            }
        }
    }

    return number_of_wanted_subarray;
}

void prefix_sum(vector<int>& nums) {
    for (int i = 1; i < (int)nums.size(); i++) {
        nums[i] += nums[i - 1];
    }
}

int range_sum(vector<int>& nums, int start, int end) {
    if (start == 0) {
        return nums[end];
    }
    return nums[end] - nums[start - 1];
}

int subarraySum_brute_force_with_prefix_sum(vector<int>& nums, int k) {
    // time limit exceeded
    prefix_sum(nums);
    int number_of_wanted_subarray = 0;
    for (int i = 0; i < (int)nums.size(); i++) {
        for (int j = i; j < (int)nums.size(); j++) {
            int sum = range_sum(nums, i, j);
            if (sum == k) {
                number_of_wanted_subarray++;
            }
        }
    }

    return number_of_wanted_subarray;
}

int main() {
}