#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>


int* tick_clock(int h, int m, int s){
	s += 1;

    /*After adding one second, check if the seconds are at 60, if so add one minute and reset the seconds to zero*/
	if (s >= 60){
		m += 1;
		s = 0;
	}
    /*After adding one second, check if the minutes are at 60, if so add one hour and reset the minutes to zero*/
	if (m >= 60){
		h += 1;
		m = 0;
	}
    /*After adding one second, check if the hours are at 24, if so reset the hours to zero*/
	if (h >= 24){
		h = 0;
	}

    /*Store the new clock values in an array and return it*/
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
        /*Pause the program for 1 second*/
		sleep(1);

        /*Check if the current time is the same as the set alarm time*/
		if (c_h == a_h && c_m == a_m && c_s == a_s){
			printf("ALARM!!!\n");
            /*Stop the loop*/
			timer = 0;
            break;
		}
		else{
			/*Print time with 2 digits with leading zeros*/
			printf("Current time: %02d:%02d:%02d\n", c_h, c_m, c_s);
		}

		/*Add one second to the current time*/
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
