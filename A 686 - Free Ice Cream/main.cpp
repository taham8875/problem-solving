#include <iostream>

using namespace std;

int main() {
    long long number_of_operations, initial_number_of_ice_creams;
    cin >> number_of_operations >> initial_number_of_ice_creams;

    long long total_number_of_ice_creams_at_hand = initial_number_of_ice_creams;

    long long kids_with_distress = 0;

    char type_of_operation;
    long long number_of_ice_creams_for_operation;
    for (long long i = 0; i < number_of_operations; i++) {
        cin >> type_of_operation >> number_of_ice_creams_for_operation;
        if (type_of_operation == '+') {
            total_number_of_ice_creams_at_hand += number_of_ice_creams_for_operation;
        } else if (type_of_operation == '-') {
            if (number_of_ice_creams_for_operation > total_number_of_ice_creams_at_hand) {
                kids_with_distress++;
            } else {
                total_number_of_ice_creams_at_hand -= number_of_ice_creams_for_operation;
            }
        }
    }

    cout << total_number_of_ice_creams_at_hand << " " << kids_with_distress;
}