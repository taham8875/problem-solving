#include <iostream>
#include <stdio.h>
using namespace std;

struct Node
{
    int data;
    Node *next;
};

int lengthOfLinkedList(Node *head)
{
    int count = 0;
    while (head != NULL)
    {
        ++count;
        head = head->next;
    }
    return count;

    // Time Complexaty = O(n)
}

void insertInLinkedList(Node **head, int data, int position = 0)
{
    Node *newNode = new Node();

    if (!newNode)
    {
        cout << "Memory error" << endl;
        return;
    }
    newNode->data = data;

    Node *temp = *head;

    if (position == 0)
    {
        newNode->next = *head;
        *head = newNode;
    }
    else
    {
        for (int i = 1; temp != NULL && i < position; i++)
        {
            temp = temp->next;
        }
        newNode->next = temp->next;
        temp->next = newNode;
    }
}

void printLinkedList(Node *head)
{
    while (head != NULL)
    {
        cout << head->data << " ";
        head = head->next;
    }
}

int main()
{
    Node *head = NULL;
    insertInLinkedList(&head, 5);
    insertInLinkedList(&head, 9, 1);
    insertInLinkedList(&head, 3, 2);
    insertInLinkedList(&head, 4, 3);
    insertInLinkedList(&head, 10, 4);
    insertInLinkedList(&head, 6, 5);
    printLinkedList(head);
}