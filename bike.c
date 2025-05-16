#include <stdio.h>
#include <stdbool.h>

typedef struct {
    double x, y;
} position;

void printCards(double x, double y, int score) {
    printf("Current motorcycle position:\n{\n\tx: %.1f,\n\ty: %.1f,\n\tscore: %d\n}\n", x, y, score);
}

int main() {
    int score = 0;
    position pos = {0, 0};
    printCards(pos.x, pos.y, score);
    char choice;
    bool kickstarted;
    printf("\nPlease enter a choice:\nk: kickstart\nw: race\na: turnL\nd: turnR\ns: brake\n\n");
    while (true) {
        scanf("%c", &choice);
        switch (choice) {
            case 'k':
                if (!kickstarted) {
                    kickstarted = true;
                    printf("The bike was kickstarted!\n");
                } else {
                    printf("Engine already ignited\n");
                }
                break;
            case 'w':
                if (!kickstarted) {
                    printf("Bike start to keejye pehle!\n");
                    break;
                }
                pos.y += 5;
                score += (int)5/2;
                printCards(pos.x, pos.y, score);
                break;
            case 'a':
                if (!kickstarted) {
                    printf("Bike start to keejye pehle!\n");
                    break;
                }
                if (!pos.y) {
                    printCards(pos.x, pos.y, score);
                    break;
                }
                 if (pos.x - 2.5 < -20) {
                    printf("Dead! Dusri bike se takra gae!\nScore: %d", score);
                    break;
                }
                pos.x -= 2.5;
                score += (int)2.5/2;
                printCards(pos.x, pos.y, score);
                break;
            case 'd':
                if (!kickstarted) {
                    printf("Bike start to keejye pehle!\n");
                    break;
                }
                if (!pos.y) {
                    printCards(pos.x, pos.y, score);
                    break;
                }
                 if (pos.x + 2.5 > 20) {
                    printf("Dead! Dusri bike se takra gae!\nScore: %d", score);
                    break;
                }
                pos.x += 2.5;
                score += (int)2.5/2;
                printCards(pos.x, pos.y, score);
                break;
            case 's':
                if (!kickstarted || pos.y -5 < 0) {
                    printf("Reverse feature will be added soon!\n");
                    break;
                }
                pos.y -= 5;
                score -= .5;
                printCards(pos.x, pos.y, score);
                break;
        }
    }
}