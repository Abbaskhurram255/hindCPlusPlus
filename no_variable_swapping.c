#include <stdio.h>
int main() {
    int a = 5,
      b = 8;
      
    printf("Before swapping:\n");
    printf("A = %d, B = %d\n\n", a, b);
    
    a = a + b; //[a] now contains values from both variables [a] [b], and equals 13; this variable itself will function as a third variable
    b = a - b; //kind of like `b = a`, but it wouldn't directly work since [a] contains values from both [a], and [b], for the sake of swapping; since [a] contains values from both variables now, it's time to actually assign [b] to the value of [a] WITHOUT/BEFORE it EVER contained the value of [b] (hence the subtraction of [b] from [a] during reassignment of [b] to a new value)
    a = a - b; //since [b] now contains the value of [a], and [a] contains values from both (past)[a] and (past)[b], let's make (now)[a] equal to (now)[a]<with values from both of the variables> - (now)[b]<!past [a]!> to only store the value of [b], and throw away the old old [a] value
    printf("After swapping:\n");
    printf("A = %d, B = %d\n\n", a, b);
}