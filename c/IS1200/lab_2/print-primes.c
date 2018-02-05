/*
 print-prime.c
 By David Broman.
 Last modified: 2015-09-15
 This file is in the public domain.
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

// Prints all prime numbers up to and including an integer n - Linus Bein Fahlander
void print_primes(int n) {
    int i = 2;
    while(i <= n){
        if(is_prime(i)){
            print_number(i);
        }
        i++;
    }
}

// 'argc' contains the number of program arguments, and
// 'argv' is an array of char pointers, where each
// char pointer points to a null-terminated string.
int main(int argc, char *argv[]) {
    if (argc == 2)
        print_primes(atoi(argv[1]));
    else
        printf("Please state an interger number.\n");
    return 0;
}

 
