#include <stdlib.h>
#include <stdio.h>


void printBits(size_t const size, void const * const ptr)
{
    unsigned char *b = (unsigned char*) ptr;
    unsigned char byte;
    int i, j;

    for (i=size-1;i>=0;i--)
    {
        for (j=7;j>=0;j--)
        {
            byte = (b[i] >> j) & 1;
            printf("%u", byte);
        }
    }
    puts("");
}


void adder(const int *x, const int *y, int *z){
    *z = *x + *y;
}

int foo(int a){
    const int k = 10;
    int t;
    adder(&a, &k, &t);
    return t;
}

void dumb_shit(int x, int y, int *z){
    *z = *z & ~(0xff) | ((x & (0x1f << 13)) >> 13) | ((y & 0x7) << 5);
}

void square_reverse(const double *x, double *y, const int len){
    for (int i = 0; i < len; ++i)
    {
        double t = *(x + i);
        *(y + ((len - 1) - i)) = t * t;
    }
}


int main(int argc, char const *argv[])
{

    signed int x = 0x23FA5B6C;
    signed int y = 0xFFFB9AEC;
    signed int z = 0x34FF7E4A;

    printBits(sizeof(x), &x);
    printBits(sizeof(y), &y);
    printBits(sizeof(z), &z);

    dumb_shit(x, y, &z);

    printBits(sizeof(z), &z);

    printf("%d\n", foo(7));

    double in[] = {11.0, 20.0, 100.0};
    double out[3];

    square_reverse(in, out, 3);

    for (int i = 0; i < 3; ++i)
    {
        printf("%f\n", out[i]);
    }

	return 0;
}