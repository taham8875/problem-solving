#include <bits/stdc++.h>

#include <iostream>

using namespace std;

bool is_worthy_to_build_an_oven(int number_of_cakes,
                                int time_to_bake_cakes,
                                int number_of_cakes_baked_at_same_time,
                                int time_to_build_an_oven) {
    int total_time_to_bake_with_one_oven = ceil((double)number_of_cakes / number_of_cakes_baked_at_same_time) * time_to_bake_cakes;
    int time_to_build_and_bake_one_cake = time_to_build_an_oven + time_to_bake_cakes;

    return total_time_to_bake_with_one_oven > time_to_build_and_bake_one_cake;
}

int main() {
    int number_of_cakes, time_to_bake_cakes, number_of_cakes_baked_at_same_time, time_to_build_an_oven;

    cin >> number_of_cakes >> time_to_bake_cakes >> number_of_cakes_baked_at_same_time >> time_to_build_an_oven;

    bool answer = is_worthy_to_build_an_oven(number_of_cakes, time_to_bake_cakes, number_of_cakes_baked_at_same_time, time_to_build_an_oven);

    if (answer) {
        cout << "YES" << endl;
    } else {
        cout << "NO" << endl;
    }
}