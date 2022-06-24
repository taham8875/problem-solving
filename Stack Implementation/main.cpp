#include <iostream>

using namespace std;

#define MAX 1000

class Stack
{
private:
    int top;

public:
    int elements[MAX];

    //    Create a constructor
    Stack()
    {
        // default value of top is -1, it top == -1 then it is empty
        top = -1;
    }

    bool push(int data)
    {
        if (top >= (MAX - 1))
        {
            cout << "Push failed, stack overflow" << endl;
        }
        else
        {
            ++top;
            elements[top] = data;
            cout << data << " pushed into the stack" << endl;
        }
    }

    int pop()
    {
        if (top < 0)
        {
            cout << "Stack is empty, stack underflow" << endl;
        }
        else
        {
            // return the data and then decrement top
            return elements[top--];
        }
    }

    int peek()
    {
        if (top < 0)
        {
            cout << "Stack is empty" << endl;
        }
        else
        {
            // just show the peek value without popping it
            return elements[top];
        }
    }

    bool isEmpty()
    {
        return (top == -1);
    }
};

int main()
{
    class Stack myStack;
    myStack.push(10);
    myStack.push(20);
    myStack.push(55);
    myStack.push(8);
    myStack.push(9);
    myStack.push(100);
    myStack.push(0);
    myStack.push(30);
    cout << endl;
    cout << myStack.pop() << " Popped from stack\n";
    cout << myStack.pop() << " Popped from stack\n";
    cout << myStack.pop() << " Popped from stack\n";

    cout << endl;
    // print top element of stack after poping
    cout << "Top element is : " << myStack.peek() << endl;

    // print all elements in stack :
    cout << "Elements present in stack : ";
    while (!myStack.isEmpty())
    {
        // pop every element and print the popped element one by one
        cout << myStack.pop() << " ";
    }

    return 0;
}
