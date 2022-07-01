// A 486 - Calculating Function - Codeforces
// Link : https://codeforces.com/contest/486/problem/A

#include <iostream>
using namespace std;

int main()
{
    long long x;
    cin >> x;
    if (x % 2 == 0)
    {
        cout << x / 2;
    }
    else
    {
        cout << -1 * (x + 1) / 2;
    }
}
