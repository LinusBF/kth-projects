#include <stdio.h>

int main(){
    int number_1 = 5;
    int number_2 = 1;
    int number_3 = 2;

    int min, max, mid;

    if(number_1 > number_2){
        max = number_1;
        min = number_2;

        if(number_3 > number_2){
            if(number_3 > number_1){
                max = number_3;
                mid = number_1;
            }
            else{
                mid = number_3;
            }
        }
        else {
            mid = number_2;
            min = number_3;
        }
    }
    else{
        max = number_2;
        min = number_1;

        if(number_3 > number_1){
            if(number_3 > number_2){
                max = number_3;
                mid = number_2;
            }
            else{
                mid = number_3
            }
        }
        else {
            mid = number_1;
            min = number_3;
        }
    }

    printf("%d is the largest number", &max);
    printf("%d is the second largest number", &mid);
    printf("%d is the smallest number", &min);
}
