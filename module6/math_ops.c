#include <stdio.h>

// Function that prints the sum and product
void print_math(int a, int b) {
    printf("Sum: %d\n", a + b);
    printf("Product: %d\n", a * b);
}

int main() {
    int num1, num2;

    printf("Enter first integer: ");
    scanf("%d", &num1);

    printf("Enter second integer: ");
    scanf("%d", &num2);

    print_math(num1, num2);

    return 0;
}