
#include <stdlib.h>
#include <stdio.h>

char *text1 = "This is a string.";
char *text2 = "Yet another thing.";
int *list1;
int *list2;
int count = 0;


void printlist(const int *lst) {
    printf("ASCII codes and corresponding characters.\n");
    while (*lst != 0) {
        printf("0x%03X '%c' ", *lst, (char) *lst);
        lst++;
    }
    printf("\n");
}

void endian_proof(const char *c) {
    printf("\nEndian experiment: 0x%02x,0x%02x,0x%02x,0x%02x\n",
           (int) *c, (int) *(c + 1), (int) *(c + 2), (int) *(c + 3));

}

void copycodes(char *text, int *list, int *count) {
    do {
        *list++ = (int) *text++;
        *count = *count + 1;
    } while (*text != 0);
}

void work() {
    list1 = calloc(20, sizeof(int));
    copycodes(text1, list1, &count);

    list2 = calloc(20, sizeof(int));
    copycodes(text2, list2, &count);
}

int main(void) {
    work();

    printf("\nlist1: ");
    printlist(list1);
    printf("\nlist2: ");
    printlist(list2);
    printf("\nCount = %d\n", count);

    endian_proof((char *) &count);

    free(list1);
    free(list2);
}
