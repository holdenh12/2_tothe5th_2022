#include <stdio.h>
/*
    cerner_2tothe5th_2022
    cerner_2^5th_2022

    Day 8: Running a bit short on time today. Decided to just go with the Recursive Factorial in c.
            I wasn't able to find out how to get a BigInt value in C to cover the case of 32!, so 
            that is something that can be improved on.
*/

int factorial(int n) {
    if (n < 0) return n;
    if (n == 0 || n == 1) {
        return 1;
    } else {
        return n * factorial(n-1);
    }
}

int main()
{
    printf("Day 8 Submission.");
    printf("\n\nHello all programmers of 2^5 competition");
    printf("\nHere is a basic output of the Factorials for each term in 2^5\n\n");
    printf("2!: %d\n", factorial(2));
    printf("5!: %d\n\n", factorial(5));
    return 0;
}
