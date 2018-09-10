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
        recursiveIn();
        putchar(in);
    }
}

/* ITERATIVE SOLUTION */

void iterative() {
    char stack[100];
    char in = getchar();
    int i = 0;
    while (in != '\n') {
        stack[i] = in;
        i++;
        in = getchar();
    }

    for(int j = i - 1; j >= 0; j--){
        putchar(stack[j]);
    }
}


int main() {
    recursive();
    putchar("\n");
    iterative();
}


