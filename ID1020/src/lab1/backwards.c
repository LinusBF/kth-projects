/*
 Created by Linus on 2018-09-09.

 Lab 1 - Assignment 1
*/

#include <stdio.h>
#include <stdlib.h>

/* RECURSIVE SOLUTION */

void recursive() {
    char in = getchar();
    if (in != '\n') {
        recursive();
        putchar(in);
    }
}

/* ITERATIVE SOLUTION */

typedef struct node {
    char c;
    struct node *prev;
} node;

void iterative() {
    //Input
    char in = getchar();
    Node prev = NULL;
    while (in != '\n') {
        node *newNode = malloc(sizeof(node));
        newNode->c = in;
        newNode->prev = prev;
        prev = newNode;
        in = getchar();
    }
    //Output
    Node lastIn = prev;
    while (lastIn != NULL) {
        putchar(lastIn->c);
        lastIn = lastIn->prev;
    }
    putchar('\n');
}


int main() {
    printf("Your input:\n");
    recursive();
    printf("Your input has been reversed recursively\n");
    putchar('\n');
    printf("Your input:\n");
    iterative();
    printf("Your input has been reversed iteratively\n");
    putchar('\n');
}


