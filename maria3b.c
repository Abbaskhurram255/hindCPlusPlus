#include <stdio.h>
#include <string.h>
#if defined __has_include
    #if __has_include (<conio.h>)
        #include <conio.h>
    #endif
#endif

void br(n) {
	for (int i=0; i<n; i++) printf("\n");
}
void tb(n) {
	for (int i=0; i<n; i++) printf("\t");
}
void clr(int c) {
	textcolor(c);
}
int main(int argc, char *argv[])
{
	br(1);
	printf("\t\t    *   ---- ---- ----  *");
	br(2);
	printf("\t\t    Multi-Choice Program\n\t\t    __      v1.0       __");
	printf("\n\t\t    ||                 ||");
	printf("\n\t\t    \\\\                 //");
	br(2);
	int green = GREEN, red = RED, def = WHITE;
	//char topic[] = "Miss Maria";
	char choice;
	char questions[32][512] = {"Miss Maria kya parhati hen?", "Acha parhati hen, ya eve hi?", "Kuch cheeze jo ap ne inke baare\n\t\t    me notice ki hon?"};
	char choices[][256][512] = {{"Information Technology", "Discrete Structures", "English", "Programming Fundamentals"}, {"Bura nahi", "Good, not great", "She's an expert", "No comment"}, {"Speaks Sindhi\n\t\t       <it's obvious!>", "She's married", "Kaafi programming languages jaanti\n\t\t       hongi, C ke ilawa bhi <I believe>", "Upar wale sare 3 options!"}};
	printf("\t\t ___ ___                    Subject\n");
	printf("\t\t/  / \\  \\             |    /  ___  ___  ___\n");
	printf("\t\t| /^ ^\\ |             |\\  /|   |   |__  |__\n");
	printf("\t\t|/     \\|             | \\/ |  ___  __|  __|\n");
	printf("\t\t\\       /=🌺\n");
	printf("\t\t \\_____/  ||       \n");
	printf("\t\t__\\___/   ||      |    |   /\\   |') ___  _\n");
	printf("\t       /       \\  ||      |\\  /|  /__\\  |/   |  /_\\\n");
	printf("\t       |       |  []      | \\/ | /    \\ | \\ ___ | |\n");
	br(4);
	printf("\tQuestion 1: %s\n\n", questions[0]);
	printf("\t\t    a: %s\n\t\t    b: %s\n\t\t    c: %s\n\t\t    d: %s\n\tAnswer: ", choices[0][0], choices[0][1], choices[0][2], choices[0][3]);
	scanf("%c", &choice);
	if (choice == 'd' || choice == 'D') {
		#ifdef CONIO_H
		    clr(green);
		#endif
		printf("\t\t    ✔️ Correct!");
		#ifdef CONIO_H
		    clr(def);
		#endif
		br(3);
	}
	else {
		#ifdef CONIO_H
		    clr(red);
		#endif
		printf("\t\t    ❌ Not a valid choice!");
		#ifdef CONIO_H
		    clr(def);
		#endif
		br(3);
	}
	printf("\tQuestion 2: %s\n\n", questions[1]);
	printf("\t\t    a: %s\tb: %s\n\t\t    c: %s\td: %s\n\tAnswer: ", choices[1][0], choices[1][1], choices[1][2], choices[1][3]);
	scanf(" %c", &choice);
	if (choice == 'c' || choice == 'C') {
		#ifdef CONIO_H
		    clr(green);
		#endif
		printf("\t\t    ✔️ Correct!");
		#ifdef CONIO_H
		    clr(def);
		#endif
		br(3);
	}
	else {
		#ifdef CONIO_H
		    clr(red);
		#endif
		printf("\t\t    ❌ Not a valid choice!");
		#ifdef CONIO_H
		    clr(def);
		#endif
		br(3);
	}
	printf("\tQuestion 3: %s\n", questions[2]);
	printf("\t\t    a: %s\n\t\t    b: %s\n\t\t    c: %s\n\t\t    d: %s\n\tAnswer: ", choices[2][0], choices[2][1], choices[2][2], choices[2][3]);
	scanf(" %c", &choice);
	if (choice == 'd' || choice == 'D') {
		#ifdef CONIO_H
		    clr(green);
		#endif
		printf("\t\t    ✔️ Correct!");
		#ifdef CONIO_H
		    clr(def);
		#endif
		br(3);
	}
	else {
		#ifdef CONIO_H
		    clr(red);
		#endif
		printf("\t\t    ❌ Not a valid choice!");
		#ifdef CONIO_H
		    clr(def);
		#endif
		br(3);
	}
}