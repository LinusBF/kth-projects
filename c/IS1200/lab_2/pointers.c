
#include <stdlib.h>
#include <stdio.h>

char *text1 = "This is a string.";
char *text2 = "Yet another thing.";
// Initializing variables as described in assembly file - Linus Bein Fahlander
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

// Copies the chars in text to list in ascii format - Linus Bein Fahlander
void copycodes(char *text, int *list, int *count) {
    do {
        *list++ = (int) *text++; // Save the ascii value of "text" in "list" and increment both addresses
        (*count)++; // Increment the count variable
    } while (*text != 0); // Continue until the value at text is 0
}

// - Linus Bein Fahlander
void work() {
    list1 = calloc(80 / sizeof *list1, sizeof *list1); // Initialize list1, size is 80 bits as described in assembly file
    copycodes(text1, list1, &count);

    list2 = calloc(80 / sizeof *list2, sizeof *list2); // Initialize list1, size is 80 bits as described in assembly file
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

    free(list1); // - Linus Bein Fahlander
    free(list2); // - Linus Bein Fahlander
}
