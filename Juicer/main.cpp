#include <iostream>
#include <stdio.h>
using namespace std;

int main()
{
    long long numberOfOranges;
    long long maxSize;
    long long maxWaste;
    cin >> numberOfOranges >> maxSize >> maxWaste;

    long long sizeOfOranges[numberOfOranges];
    for (long long i = 0; i < numberOfOranges; i++)
    {
        cin >> sizeOfOranges[i];
    }
    long long sum = 0;
    long long numberOfEmpty = 0;
    for (long long i = 0; i < numberOfOranges; i++)
    {
        if (sizeOfOranges[i] <= maxSize)
        {
            sum += sizeOfOranges[i];
        }
        if (sum > maxWaste)
        {
            ++numberOfEmpty;
            sum = 0;
        }
    }
    cout << numberOfEmpty;
}
