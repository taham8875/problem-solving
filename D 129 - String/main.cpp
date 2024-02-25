#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    string input;
    int desired_index;
    cin >> input >> desired_index;

    desired_index--;  // 0-based index
    int number_of_substrings = (input.size() * (input.size() + 1)) / 2;
    vector<string> all_substrings;
    all_substrings.reserve(2 * number_of_substrings);

    // cout << "all_substrings size: " << all_substrings.size() << endl;

    for (int i = 0; i < (int)input.size(); i++) {
        for (int j = i; j < (int)input.size(); j++) {
            all_substrings.push_back(input.substr(i, j - i + 1));
        }
    }

    // for (int i = 0; i < (int)all_substrings.size(); i++) {
    //     cout << "i" << i << " " << endl;
    //     cout << all_substrings[i] << endl;
    // }

    // sort(all_substrings.begin(), all_substrings.end());

    // for (int i = 0; i < (int)all_substrings.size(); i++) {
    //     cout << all_substrings[i] << endl;
    // }

    // cout << "=====" << endl;
    // qsort(&all_substrings[0], all_substrings.size(), sizeof(string), [](const void* a, const void* b) {
    //     cout << "a: " << *(string*)a << " b: " << *(string*)b << endl;
    //     return (*(string*)a).compare(*(string*)b);
    // });

    sort(all_substrings.begin(), all_substrings.end());

    // print the sorted substrings
    // for (int i = 0; i < (int)all_substrings.size(); i++) {
    //     cout << all_substrings[i] << endl;
    // }

    // cout << "hi .. " << endl;

    if (desired_index < (int)all_substrings.size()) {
        cout << all_substrings[desired_index];
    } else {
        cout << "No such line.";
    }
}