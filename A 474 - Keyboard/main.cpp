// A 474 - Keyboard - Codeforces
// Link : https://codeforces.com/contest/474/problem/A

#include <iostream>
#include <string>
using namespace std;

int main()
{
    string keyboard = {"qwertyuiopasdfghjkl;zxcvbnm,./"};

    char direction;
    cin >> direction;

    string input;
    cin >> input;

    for (int i = 0; i < input.length(); i++)
    {
        int index = keyboard.find(input[i]);

        if (direction == 'R')
        {
            input[i] = keyboard[index - 1];
        }
        else
        {
            input[i] = keyboard[index + 1];
        }
    }

    cout << input;
}
