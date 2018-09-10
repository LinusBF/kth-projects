/*
 Created by Linus on 2018-09-09.

 Lab 1 - Assignment 1
*/

#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    char c;
    struct node *prev;
} node;

/* RECURSIVE SOLUTION */

void recursiveIn() {
    char in = getchar();
    if (in != '\n') {
        recursiveIn();
    }
    putchar(in);
}

void recursivePrint(node *lastIn) {
    if (lastIn->prev != NULL) {
        putchar(lastIn->c);
        recursivePrint(lastIn->prev);
    } else {
        putchar(lastIn->c);
        putchar('\n');
    }
    free(lastIn);
}

/* ITERATIVE SOLUTION */

node *iterativeIn(node *prev) {
    char in = getchar();
    while (in != '\n') {
        node *newNode = malloc(sizeof(node));
        newNode->c = in;
        newNode->prev = prev;
        prev = newNode;
        in = getchar();
    }
    return prev;
}

void iterativePrint(node *lastIn) {
    while (lastIn != NULL) {
        putchar(lastIn->c);
        lastIn = lastIn->prev;
    }
    putchar('\n');
}


int main() {
    recursiveIn();
}


