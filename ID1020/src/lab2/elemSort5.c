/*
 * Lab 2 - Assignment 5
 *
 * Created by Linus Bein Fahlander on 2018-09-09.
 *
 * This program reads an integer array and puts all values less than 0 first in the array
 */

#include <stdio.h>
#include <stdlib.h>

void negativeSort(int *list, int length){
    int i = 0;
    for(i; i < length; i++){
        if(list[i] >= 0 && list[i + 1] < 0){
            swap(list, i, i + 1);
        }
    }
}

void swap(int *list, int i, int j){
    int temp = list[i];
    list[i] = list[j];
    list[j] = temp;
}

int main(){
    int[] testList = [1,-2,3,-4,5,-6];
    negativeSort(testList, sizeof(testList)/sizeof(testList[0]));
    for(int i = 0; i < 6; i++){
        printf("%d", testList[i]);
    }
}
