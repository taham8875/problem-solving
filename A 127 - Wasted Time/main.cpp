// A 127 - Wasted Time - Codeforces
// Link : https://codeforces.com/contest/127/problem/A

#include <iostream>
#include <cmath>
#include <vector>
using namespace std;

int main()
{
    int numberOfPoints, numberOfPapers;
    cin >> numberOfPoints >> numberOfPapers;
    double distance = 0;
    int x1, y1, x2, y2;
    cin >> x1 >> y1;
    for (int i = 1; i < numberOfPoints; i++)
    {
        cin >> x2 >> y2;
        distance += sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        x1 = x2;
        y1 = y2;
    }
    // cout << fixed;
    // cout.precision(9);
    cout << distance / 50 * numberOfPapers;
}
