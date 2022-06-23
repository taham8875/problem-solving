#include <iostream>
using namespace std;

/*
In C++, when we pass an array to a function say fun(), it is always treated as a
pointer by fun(), so the size must be passed to the function
Cannot use ``int length = sizeof(elements) / sizeof(elements[0]);`` inside the fuction , it
will output wrong results
*/

void bubbleSort(int elements[], int numberOfElements)
{
    for (int i = 0; i < numberOfElements; i++)
    {
        for (int j = i + 1; j < numberOfElements; j++)
        {
            if (elements[i] > elements[j])
            {
                int temp = elements[j];
                elements[j] = elements[i];
                elements[i] = temp;
            }
        }
    }
}

int main()
{
    int numberOfElements;
    cout << "Enter the number of elements : ";
    cin >> numberOfElements;
    int elements[numberOfElements];

    cout << "Enter elements one by one : ";
    for (int i = 0; i < numberOfElements; i++)
    {
        cin >> elements[i];
    }

    cout << "print unsorted array" << endl;
    for (int i = 0; i < numberOfElements; i++)
    {
        cout << elements[i] << " ";
    }
    cout << endl;

    bubbleSort(elements, numberOfElements);

    cout << "print sorted array" << endl;
    for (int i = 0; i < numberOfElements; i++)
    {
        cout << elements[i] << " ";
    }
}