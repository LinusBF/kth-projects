#include <stdio.h>

void isPrime(int x){
	int i;
	for(i = 2; i*i <= x; i++){
		if(x%i == 0){
			return;
		}
	}

	printf("%d\n", x);
}

int main() {
	int lower, upper;

	scanf("%d", &lower);
	scanf("%d", &upper);

	if(lower > 1){
		if(lower == 2){
			printf("%d\n", lower);
		}
		if(lower%2 == 0){
			lower++;
		}
		int i;
		for(i = lower; i <= upper; i += 2){
			isPrime(i);
		}
	}

	return 0;
}
