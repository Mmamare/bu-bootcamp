#include <stdio.h>

// Function to swap two integer values
void swap(int *a, int *b) {
    int temp;

    temp = *a;
    *a = *b;
    *b = temp;
}
// This function does not actually swap the original variables
void broken_swap(int a, int b) {
    int temp;

    temp = a;
    a = b;
    b = temp;

    // a and b are only copies of the original variables.
}

//Function to swap two characters
void swap_chars(char *a, char *b) {
    char temp;

    temp = *a;
    *a = *b;
    *b = temp;
}

int main() {
    int num1 = 10;
    int num2 = 20;

    printf("Before swap:\n");
    printf("num1 = %d, num2 = %d\n", num1, num2);

    // Pass the addresses of num1 and num2
    swap(&num1, &num2);

    printf("After swap:\n");
    printf("num1 = %d, num2 = %d\n", num1, num2);

     printf("Before broken_swap:\n");
    printf("num1 = %d, num2 = %d\n", num1, num2);

    broken_swap(num1, num2);

    // The values do not change because broken_swap receives
    // copies of num1 and num2, not their addresses.
    printf("After broken_swap:\n");
    printf("num1 = %d, num2 = %d\n", num1, num2);

    //Swap two characters
    char char1 = 'A';
    char char2 = 'B';

    printf("Before swap:\n");
    printf("char1 = %c, char2 = %c\n", char1, char2);

    swap_chars(&char1, &char2);

    printf("After swap:\n");
    printf("char1 = %c, char2 = %c\n", char1, char2);
    
    return 0;
}