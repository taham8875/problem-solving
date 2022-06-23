#include <iostream>
#include <string>
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
    string input;
    cin >> input;
    int numberOfPluses = 0;
    for (int i = 0; i < input.length(); i++)
    {
        if (input[i] == '+')
            ++numberOfPluses;
    }
    int numberOfNumbers = input.length() - numberOfPluses;
    int numbers[numberOfNumbers];
    for (int i = 0, index = 0; i < input.length(); i++)
    {
        if (input[i] == '+')
            continue;
        else
        {
            numbers[index] = input[i] - '0';
            ++index;
        }
    }
    bubbleSort(numbers, numberOfNumbers);

    for (int i = 0; i < numberOfNumbers - 1; i++)
    {
        cout << numbers[i] << '+';
    }
    cout << numbers[numberOfNumbers - 1];
}