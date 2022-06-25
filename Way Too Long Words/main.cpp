// Way Too Long Words - Codeforces
// Link : https://codeforces.com/contest/71/problem/A

#include <iostream>
#include <string>
using namespace std;

int main()
{
    int numberOfWords = 0;
    cin >> numberOfWords;

    string words[numberOfWords + 1];

    for (int i = 0; i < numberOfWords + 1; i++)
    {
        getline(cin, words[i]);
    }

    for (int i = 0; i < numberOfWords + 1; i++)
    {
        if (words[i].length() <= 10)
        {
            cout << words[i] << endl;
        }
        else
        {
            cout << words[i][0] << words[i].length() - 2 << words[i][words[i].length() - 1] << endl;
        }
    }
}
