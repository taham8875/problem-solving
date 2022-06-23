#include <iostream>
#include <stdio.h>
using namespace std;

struct Node
{
    int data;
    Node *next;
};

int lengthOfLinkedList(Node **head)
{
    Node *temp = *head;
    int count = 0;
    while (temp != NULL)
    {
        ++count;
        temp = temp->next;
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

// Delete node rom linked list
// Either the frist node, last node or an intermediate node.

void deleteFromLinkedList(Node **head, int position = 0)
{
    if (position == 0)
    {
        Node *temp = *head;
        *head = (*head)->next;
        delete temp;
    }
    else
    {
        Node *temp1 = *head;
        Node *temp2 = (*head)->next;
        for (int i = 1; temp2->next != NULL && i < position; i++)
        {
            temp1 = temp1->next;
            temp2 = temp2->next;
        }
        temp1->next = temp2->next;
        delete temp2;
    }
}

void deleteLinkedList(Node **head)
{
    while (*head != NULL)
    {
        deleteFromLinkedList(head);
    }
}

void printLinkedList(Node *head)
{
    while (head != NULL)
    {
        cout << head->data << " ";
        head = head->next;
    }
    cout << endl;
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
    cout << "linked list : ";
    printLinkedList(head);
    cout << "length of linked list : " << lengthOfLinkedList(&head) << "\n";
    deleteFromLinkedList(&head);
    deleteFromLinkedList(&head);
    deleteFromLinkedList(&head, 2);
    cout << "linked list : ";
    printLinkedList(head);
    cout << "length of linked list : " << lengthOfLinkedList(&head) << "\n";
    deleteLinkedList(&head);
    cout << "linked list is deleted." << endl;
    cout << "length of linked list : " << lengthOfLinkedList(&head) << "\n";
}