#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <string.h>

int expo(int x, int a){
	int sum = x;

	for (int i = 0; i < a - 1; ++i)
	{
		sum = sum * x;
	}

	return sum;
}

int fac(int n){
	if (n == 1)
	{
		printf("Found 1! Returning to fuc(%d)\n", n + 1);
		return n;
	}
	printf("Multiplying %d with fuc(%d)\n", n, n - 1);
	int s = n * fac(n - 1);
	printf("Returning value %d to fuc(%d)\n", s, n + 1);
	return s;
}

int main(int argc, char *argv[]) {
	unsigned int n = 0;

	n = fac(atoi(argv[1]));

	printf("%d\n", n);
}
