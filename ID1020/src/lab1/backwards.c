/*
 * Lab 1 - Assignment 1
 *
 * Created by Linus Bein Fahlander on 2018-09-09.
 *
 * This program reads a text string and prints it backwards
 * This is done twice when run, once recursively and once iteratively
 */

#include <stdio.h>
#include <stdlib.h>

/* RECURSIVE SOLUTION */

/**
 * Starts off by reading the current character input,
 * then runs itself until a newline is encountered.
 * Each instance of the function will then print the value
 * it read. This will cause the inputted text to be printed
 * backwards as the function called last will be finished with
 * its recursive call first.
 */
void recursive() {
    char in = getchar();
    if (in != '\n') {
        recursive();
        putchar(in);
    }
}

/* ITERATIVE SOLUTION */

/**
 * A struct is used to store a char and
 * a reference to the previous char
 */
typedef struct node {
    char c;
    struct node *prev;
} node;

/**
 * Reads each char until newline and creates a node
 * with the value of the char and a reference to the
 * last char.
 * Then all nodes will be printed, starting with the
 * last one created. This will make the inputted text
 * print out backwards
 */
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


