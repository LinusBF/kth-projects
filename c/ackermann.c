#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <time.h>

int ack(int m, int n){
	int ans = 0;

	if (m == 0)
	{
		ans = n + 1;
	} else if (n == 0)
	{
		ans = ack(m - 1, 1);
	} else{
		ans = ack(m - 1, ack(m, n - 1));
	}

	return ans;
}

void print_time(){
	time_t t = time(NULL);
	struct tm tm = *localtime(&t);

	printf("%d-%d-%d %02d:%02d:%02d : ", tm.tm_year + 1900, tm.tm_mon + 1, tm.tm_mday, tm.tm_hour, tm.tm_min, tm.tm_sec);
}

int main()
{
	printf("Starting at ");
	print_time();
	printf("\n");

	for (int i = 0; i < 7; ++i)
	{
		for (int j = 0; j < 7; ++j)
		{
			print_time();
			printf("Start solving ackermann [%d, %d]\n", i, j);
			int ans = ack(i, j);
			print_time();
			printf("Solved ackermann [%d, %d] = %d\n", i, j, ans);
		}
	}
}
