/* mipslabwork.c

   This file written 2015 by F Lundevall
   Updated 2017-04-21 by F Lundevall

   This file should be changed by YOU! So you must
   add comment(s) here with your name(s) and date(s):

   This file modified 2017-04-31 by Ture Teknolog

   For copyright and licensing, see file COPYING */

#include <stdint.h>   /* Declarations of uint_32 and the like */
#include <pic32mx.h>  /* Declarations of system-specific addresses etc */
#include "mipslab.h"  /* Declatations for these labs */

int mytime = 0x5957;
char textstring[] = "text, more text, and even more text!";
int timeoutcount = 0;
volatile unsigned * led_port = (unsigned *) 0xBF886110;
int prime = 1234567;

// For Debugging
char* itoa(int i, char b[]){
    char const digit[] = "0123456789";
    char* p = b;
    if(i<0){
        *p++ = '-';
        i *= -1;
    }
    int shifter = i;
    do{ //Move to where representation ends
        ++p;
        shifter = shifter/10;
    }while(shifter);
    *p = '\0';
    do{ //Move back, inserting digits as u go
        *--p = digit[i%10];
        i = i/10;
    }while(i);
    return b;
}

/* Interrupt Service Routine */
void user_isr( void )
{
  if(IFS(0) & 0x100){
    IFSCLR(0) = 0x100;
    timeoutcount += 1;

    if(timeoutcount == 10){
      timeoutcount = 0;
      time2string( textstring, mytime );
      display_string( 3, textstring );
      display_update();
      tick( &mytime );
    }
  }

  if(IFS(0) & 0x80){
    IFSCLR(0) = 0x80;
    if(*led_port < 0xFF){
      *led_port = *led_port + 1;
    } else{
      *led_port = 0x00;
    }
  }
}

/* Lab-specific initialization goes here */
void labinit( void )
{

  *led_port = 0x00;

  PORTD = 0xFE0;

  T2CONSET = 0x70;
  PR2 = 31250;
  T2CONSET = 0x8000;

  IECSET(0) = 0x100;
  IPCSET(2) = 0x1F;

  IECSET(0) = 0x80;
  IPCSET(1) = 0x1E00;

  enable_interrupt();

  return;
}

/* This function is called repetitively from the main program */
void labwork( void )
{
  /*
  char debug[150];
  itoa((PORTD >> 4), debug);
  display_string(2, debug);
  */

  //display_debug(&mytime);
  prime = nextprime( prime );
  display_string( 0, itoaconv( prime ) );
  display_update();
}
