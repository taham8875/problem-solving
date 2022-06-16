#include <iostream>
#include <stdio.h>
using namespace std;

int main()
{
    int numberOfPersons, heightOfFence;
    cin >> numberOfPersons >> heightOfFence;
    int heightOfIthPerson[numberOfPersons];
    for (int i = 0; i < numberOfPersons; i++)
    {
        cin >> heightOfIthPerson[i];
    }
    int width = 0;
    for (int i = 0; i < numberOfPersons; i++)
    {
        if (heightOfIthPerson[i] > heightOfFence)
        {
            width += 2;
        }
        else
        {
            ++width;
        }
    }
    cout << width;
}
