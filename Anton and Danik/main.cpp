#include <iostream>
#include <stdio.h>
#include <string>
using namespace std;

int main()
{
    int numberOfGames;
    cin >> numberOfGames;
    string status;
    cin >> status;
    int anton = 0, danik = 0;
    for (int i = 0; i < numberOfGames; i++)
    {
        if (status[i] == 'A')
        {
            ++anton;
        }
        else if (status[i] == 'D')
        {
            ++danik;
        }
    }
    if (anton > danik)
    {
        cout << "Anton";
    }
    else if (anton < danik)
    {
        cout << "Danik";
    }
    else
    {
        cout << "Friendship";
    }
}
