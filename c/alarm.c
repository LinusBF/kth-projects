#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>


int* tick_clock(int h, int m, int s){
	s += 1;

	if (s >= 60){
		m += 1;
		s = 0;
	}
	if (m >= 60){
		h += 1;
		m = 0;
	}
	if (h >= 24){
		h = 0;
	}

	int *ticked_clock = NULL;

	ticked_clock = malloc(10 * sizeof *ticked_clock);	

	ticked_clock[0] = h;
	ticked_clock[1] = m;
	ticked_clock[2] = s;

	return ticked_clock;
}


void start_timer(char *current_time, char *alarm_time){
	int timer = 1;

	/*Split current time into hours, minutes and seconds*/
	int c_h, c_m, c_s;
	sscanf(current_time, "%d:%d:%d", &c_h, &c_m, &c_s);

	/*Split alarm time into hours, minutes and seconds*/
	int a_h, a_m, a_s;
	sscanf(alarm_time, "%d:%d:%d", &a_h, &a_m, &a_s);

	while (timer){
		sleep(1);

		if (c_h == a_h && c_m == a_m && c_s == a_s){
			printf("ALARM!!!\n");
			timer = 0;
		}
		else{
			printf("Current time: %02d:%02d:%02d\n", c_h, c_m, c_s);
		}

		int *new_time = tick_clock(c_h, c_m, c_s);
		c_h = new_time[0];
		c_m = new_time[1];
		c_s = new_time[2];
	}

}

int main()
{
	char *current = NULL;
	char *alarm = NULL;

	current = malloc(10 * sizeof *current);
	alarm = malloc(10 * sizeof *alarm);

	printf("What's the current time? (Format: HH:MM:SS)\n");
	scanf("%s", current);
	
	printf("What's the alarm time? (Format: HH:MM:SS)\n");
	scanf("%s", alarm);

	start_timer(current, alarm);

	return 0;
}
