/*
 * Lab 2 - Assignment 5
 *
 * Created by Linus Bein Fahlander on 2018-09-09.
 *
 * This program reads an integer array and puts all values less than 0 first in the array
 */

#include <stdio.h>
#include <stdlib.h>

void swap(int *list, int i, int j){
    int temp = list[i];
    list[i] = list[j];
    list[j] = temp;
}

void negativeSort(int *list, int length){
    // Invariant: A[0..j-1] contains the same elements as
    // the original subarray A[0..j-1], but all values
    // less than 0 are at the start of the array.
    for(int i = 0; i < length - 1; i++){
        for(int j = i + 1; j < length; j++){
            if(list[i] >= 0 && list[j] < 0){
                swap(list, i, j);
            }
        }
    }
}

int main(){
    int testList[] = {1,-2,3,-4,5,-6};
    negativeSort(testList, 6);
    for(int i = 0; i < 6; i++){
        printf("%d\n", testList[i]);
    }
}
