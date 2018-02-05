/*
 sieves.c
 By Linus Bein Fahlander.
 Last modified: 2018-02-05
*/


#include <stdio.h>
#include <stdlib.h>

#define COLUMNS 6
int written_numbers = 0;


// Checks if a positive integer n is prime or not - Linus Bein Fahlander
int is_prime(int n){
    for(int i = 2; i*i <= n; i++){ // Check all numbers starting from 2 until i squared is greater than n
        if(n%i == 0){ // If n % i is 0 then the number is not prime as it is divisible by i
            return 0; // Return false
        }
    }

    return 1; // Return true
}

// Prints a number in one of the columns - Linus Bein Fahlander
void print_number(int n){
    if(written_numbers == COLUMNS){
        printf("\n");
        written_numbers = 0;
    }

    printf("%10d ", n);
    written_numbers++;
}

// Prints all sieves numbers up to and including an integer n - Linus Bein Fahlander
void print_sieves(int n) {
    // Start of Sieve algorithm using 1 as prime and 0 as !prime
    int a[n];
    for(int i = 0; i < n; i++){ // Set every element in array to true (1)
        a[i] = 1;
    }

    int i = 2;
    while(i*i <= n){
        if(a[i]){
            for (int j = i*i; j <= n; j += i) {
                a[j] = 0; // Set j to !prime
            }
        }
        i++;
    } // End of Sieve algorithm

    // Print array
    for(i = 2; i < n; i++){
        if(a[i]){ // If i is prime, print
            print_number(i);
        }
    }
}

// 'argc' contains the number of program arguments, and
// 'argv' is an array of char pointers, where each
// char pointer points to a null-terminated string.
int main(int argc, char *argv[]) {
    if (argc == 2)
        print_sieves(atoi(argv[1]));
    else
        printf("Please state an interger number.\n");
    return 0;
}


