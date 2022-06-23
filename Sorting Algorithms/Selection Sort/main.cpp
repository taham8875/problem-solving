#include <iostream>
using namespace std;

void swap(int *first, int *second)
{
    int temp = *first;
    *first = *second;
    *second = temp;
}

int indexOfMin(int elements[], int length, int start)
{
    int indexOfMin = start;
    for (int i = start; i < length; i++)
    {
        if (elements[i] < elements[indexOfMin])
        {
            indexOfMin = i;
        }
    }

    return indexOfMin;
}

void selectionSort(int elements[], int length)
{
    for (int i = 0; i < length; i++)
    {
        swap(&elements[i], &elements[indexOfMin(elements, length, i)]);
    }
}

int main()
{
    int elements[] = {78, 456, 95, 3, 4, 15, 321, 0, 4153, 4, 784, 684, 12, 0, 468, 435, 4, 94, 68};
    int length = sizeof(elements) / sizeof(elements[0]);
    cout << "Unsorted array : " << endl;
    for (int i = 0; i < length; i++)
    {
        cout << elements[i] << " ";
    }
    cout << endl;

    // cout << indexOfMin(elements, length);
    selectionSort(elements, length);

    cout << "Sorted array : " << endl;
    for (int i = 0; i < length; i++)
    {
        cout << elements[i] << " ";
    }
}
