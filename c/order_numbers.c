#include <stdio.h>

void basic_version(int n1, int n2, int n3){
    int min, max, mid;

    if(n1 > n2){
        max = n1;
        min = n2;

        if(n3 > n2){
            if(n3 > n1){
                max = n3;
                mid = n1;
            }
            else{
                mid = n3;
            }
        }
        else {
            mid = n2;
            min = n3;
        }
    }
    else{
        max = n2;
        min = n1;

        if(n3 > n1){
            if(n3 > n2){
                max = n3;
                mid = n2;
            }
            else{
                mid = n3;
            }
        }
        else {
            mid = n1;
            min = n3;
        }
    }
}


int* insertion_sort(int numbers[], int size){

    for(int i = 1; i < size; i++){
        int temp = numbers[i];
        int j = i - 1;

        while(j >= 0 && numbers[j] > temp){
            numbers[j + 1] = numbers[j];
            j--;
        }

        numbers[j + 1] = temp;
    }

    return numbers;
}


void print_array(int arr[], int n)
{
    int i;
    for (i=0; i < n; i++)
        printf("%d ", arr[i]);
    printf("\n");
}


int main(){
    int nums[] = {10, 15, 25, 5, 2, 6, 2};

    int size = sizeof(nums)/sizeof(nums[0]);
    print_array(nums, size);

    int *new_nums = insertion_sort(nums, size);

    print_array(nums, size);
}
