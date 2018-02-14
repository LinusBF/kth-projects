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
  return;
}

/* Lab-specific initialization goes here */
void labinit( void )
{
  volatile unsigned * led_port = (unsigned *) 0xBF886110;

  *led_port = 0x00;

  PORTD = 0xFE0;

  return;
}

/* This function is called repetitively from the main program */
void labwork( void )
{
  volatile unsigned * led_port = (unsigned *) 0xBF886110;

  if(*led_port < 0xFF){
    *led_port = *led_port + 1;
  } else{
    *led_port = 0x00;
  }

  int btns = getbtns();
  /*
  char debug[150];
  itoa((PORTD >> 4), debug);
  display_string(2, debug);
  */
  if (btns > 0)
  {
    int sw = getsw();

    if ((btns & 0x4))
    {
      int new_time = mytime & 0x0FFF;
      new_time = (sw << 12) | new_time;
      mytime = new_time;
    }

    if((btns & 0x2))
    {
      int new_time = mytime & 0xF0FF;
      new_time = (sw << 8) | new_time;
      mytime = new_time;
    }

    if((btns & 0x1))
    {
      int new_time = mytime & 0xFF0F;
      new_time = (sw << 4) | new_time;
      mytime = new_time;
    }
  }

  delay( 1000 );
  time2string( textstring, mytime );
  display_string( 3, textstring );
  display_update();
  tick( &mytime );
  display_image(96, icon);
}
