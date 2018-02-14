#include <stdint.h>
#include <pic32mx.h>
#include "mipslab.h"

int getsw(){
	int sws = PORTD & 0xF00;
	return (sws >> 8);
}

int getbtns(){
	int btns = PORTD & 0xE0;
	return (btns >> 5);
}
