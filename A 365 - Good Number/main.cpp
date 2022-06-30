// A 365 - Good Number
// Link on codeforces https://codeforces.com/contest/365/problem/A)

#include <iostream>
#include <string>
#include <vector>
using namespace std;

bool isGood(string element, int limit)
{
    bool isGood = true;
    for (int i = 0; i <= limit; i++)
    {
        if (element.find(to_string(i)) == -1)
        {
            isGood = false;
        }
    }
    return isGood;
}

int main()
{
    int numberOfElements, limit;
    cin >> numberOfElements >> limit;
    string element;
    vector<string> elements;
    int numberOfGood = 0;

    for (int i = 0; i < numberOfElements; i++)
    {
        cin >> element;
        if (isGood(element, limit))
        {
            ++numberOfGood;
        }
        // elements.push_back(element);
    }
    cout << numberOfGood;
    // for (auto i = elements.cbegin(); i != elements.cend() ; i++)
    // {
    //     if ((element))
    // }
}