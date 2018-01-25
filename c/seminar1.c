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


int main(int argc, char const *argv[])
{
    /*
    signed int x = 123456789;
    signed int y = 987654321;
    signed int z = 192837465;

    printBits(sizeof(x), &x);
    printBits(sizeof(z), &z);

    z = z & (x >> 17 );

    printBits(sizeof(z), &z);
    */
    int s = foo(7);
    printf("%d\n", s);
	return 0;
}