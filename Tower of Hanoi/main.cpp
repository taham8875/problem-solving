#include <iostream>
using namespace std;

int count = 0;
int cost[3][3];

int towerOfHanoiCost(int numberOfDisks, int start, int end, int temp)
{
    if (numberOfDisks > 0)
    {
        towerOfHanoiCost(numberOfDisks - 1, start, temp, end);
        count += cost[start - 1][end - 1];
        towerOfHanoiCost(numberOfDisks - 1, temp, end, start);
        return count;
    }
}

int main()
{
    int numberOfDisks;

    for (int i = 0; i < 3; i++)
    {
        cin >> cost[i][0] >> cost[i][1] >> cost[i][2];
    }
    cin >> numberOfDisks;
    cout << towerOfHanoiCost(numberOfDisks, 1, 3, 2);
}
