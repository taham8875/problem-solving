
#include <climits>
#include <iostream>
#include <map>
#include <vector>

using namespace std;

class Solution {
   public:
    string compress(string input) {
        if (input == "") return "";
        int count = 1;
        string output = "";
        // char  current_char =  input[0];
        for (int i = 1; i < (int)input.size(); i++) {
            // cout << "i: " << i << " input[i]: " << input[i] << " input[i - 1]: " << input[i - 1] << endl;
            if (input[i] == input[i - 1]) {
                count++;
            } else {
                output += input[i - 1] + to_string(count);
                cout << "output: " << output << endl;
                count = 1;
            }
        }
        output += input[(int)input.size() - 1] + to_string(count);
        return output;
    }
};
int main() {
    Solution s;
    string input;
    cin >> input;
    cout << s.compress(input) << endl;
}