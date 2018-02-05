/*
 prime.c
 By David Broman.
 Last modified: 2015-09-15
 This file is in the public domain.
*/


#include <stdio.h>

// Checks if a positive integer n is prime or not - Linus Bein Fahlander
int is_prime(int n){
  for(int i = 2; i*i <= n; i++){ // Check all numbers starting from 2 until i squared is greater than n
    if(n%i == 0){ // If n % i is 0 then the number is not prime as it is divisible by i
      return 0; // Return false
    }
  }

  return 1; // Return true
}

int main(void){
  printf("%d\n", is_prime(11));  // 11 is a prime.      Should print 1.
  printf("%d\n", is_prime(383)); // 383 is a prime.     Should print 1.
  printf("%d\n", is_prime(987)); // 987 is not a prime. Should print 0.
}
