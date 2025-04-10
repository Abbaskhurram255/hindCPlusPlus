#include <stdio.h>

int main()
{
    int attendance[5][6] = {{1, 0, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1}};
    int absence = 0, presence = 0;
    int size = sizeof(attendance)/sizeof(attendance[0]);
    for (int i=0; i<size; i++) {
        for (int j=0; j<sizeof(attendance[i])/sizeof(attendance[i][0]); j++) {
            if (attendance[i][j]) presence += 1;
            else absence += 1;
        }
    }
    int okay = 0;
    if (presence >= 24) okay = 1;
    printf("Presence: %d days\nAbsence: %d days\nKya me ek din off lelu? %s", presence, absence, okay ? "Okay, le leejye off" : "Nahi le sakte, you're short on attendance!");
}