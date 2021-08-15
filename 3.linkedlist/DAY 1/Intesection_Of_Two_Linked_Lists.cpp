#pragma warning(disable:4996)
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

 struct ListNode {
     int val;
     struct ListNode *next;
 };



 struct ListNode* getIntersectionNode(struct ListNode* headA, struct ListNode* headB) {
     int A_len = 0, B_len = 0;
     int diff = 0;
     struct ListNode* tmpA;
     struct ListNode* tmpB;

     tmpA = headA;
     while (1) {
         if (tmpA->next == NULL) break;
         tmpA = tmpA->next;
         A_len++;
     }

     tmpB = headB;
     while (1) {
         if (tmpB->next == NULL) break;
         tmpB = tmpB->next;
         B_len++;
     }

     diff = A_len - B_len;
     if (diff < 0) diff *= (-1);

     if (A_len >= B_len) {
         while (diff--) {
             headA = headA->next;
         }
     }
     else {
         while (diff--) {
             headB = headB->next;
         }
     }
     while (headA != NULL && headB != NULL) {
         if (headA == headB) return headA;
         else {
             headA = headA->next;
             headB = headB->next;
         }
     }
     return NULL;

 }
ListNode* getNode() {
    ListNode* tmp = NULL;
    tmp = (ListNode*)malloc(sizeof(ListNode));
    tmp->next = NULL;
    return tmp;
}
ListNode* getNode(int data) {
    ListNode* tmp = NULL;
    tmp = (ListNode*)malloc(sizeof(ListNode));
    tmp->next = NULL;
    tmp->val = data;
    return tmp;
}
void addNode(ListNode* head, int data) {
    ListNode* traveler = NULL;
    ListNode* newNode = getNode();
    newNode->val = data;

    traveler = head;

    while (1) {
        if (traveler->next == NULL) break;
        traveler = traveler->next;
    }

    traveler->next = newNode;

   
}

void printList(ListNode* head) {
    ListNode* traveler = NULL;

    traveler = head;
    while (1) {
        if (traveler == NULL) break;
        printf("%d ", traveler->val);
        traveler = traveler->next;
        
    }
    printf("\n");
}
int main() {
    ListNode* a = NULL;
    ListNode* b = NULL;
    ListNode* res = NULL;

    a = getNode(4);
    addNode(a, 1);
    addNode(a, 8);
    addNode(a, 4);
    addNode(a, 5);

    b = getNode(5);
    addNode(b, 6);
    addNode(b, 1);
    addNode(b, 8);
    addNode(b, 4);
    addNode(b, 5);

    printList(a);
    printList(b);

    res = getIntersectionNode(a, b);
    printf("%d\n", res->val);
	return 0;
}