#include <stdio.h>
#include <string.h>
#if defined __has_include
    #if __has_include (<conio.h>)
        #include <conio.h>
    #endif
#endif

void br(n) {
	for (; n>0; n--) printf("\n");
}
void tb(n) {
	for (; n>0; n--) printf("\t");
}
void clr(int c) {
	textcolor(c);
}
int main(int argc, char *argv[])
{
	br(1);
	printf("\t\t    *   ---- ---- ----  *");
	br(2);
	printf("\t\t     Multi-Choice Program\n\t\t    __      v1.0       __");
	printf("\n\t\t    ||                 ||");
	printf("\n\t\t    \\\\                 //");
	printf("\n\t\t    ____             ____");
	printf("\n\t\t        ||         ||");
	printf("\n\t\t          __     __");
	printf("\n\t\t            || ||");
	printf("\n\tDeveloper |\t      :\t\tKhuram Ali\n\tStudent ID |\t      :\t\tB2531044\n\tBatch |\t              :\t\t16\n\tDepartment |\t      :\t\tComputer\n\t\t\t\t\tScience\n\tSubject |\t      :\t\tProgramming\n\t\t\t\t\tFundamentals>\n\t\t\t\t\t  Semester I\n\t\t\t\t\t  Farewell\n\t\t\t\t\t  Project");
	br(2);
	int green = GREEN, red = RED, def = WHITE;
	
	char choice;
	char topic[] = "C Language";
	char questions[][512] = {"Who built C?", "When did they build it?", "Where did they built it?", "Is C object-oriented?", "Where did C get its name from?", "What came as a successor of C?", "If C++ is the successor of C,\n\t\t    who built it?"};
	char answers[][4][512] = {{"Jeff Bezzos", "Mark Zuckerberg", "Steve Jobs", "Dennis Ritchie"}, {"1940", "1954", "1972", "2001"}, {"At Michigan University", "At Belle Laboratories", "At Microsoft", "At College of Hamilton"}, {"Yes", "No", "Yes and no\n\t\t       <though not as functionally\n\t\t       reliable as a class,\n\t\t       structs can give you a\n\t\t       class-like functionality>", "I don't know"}, {"C was developed after,\n\t\t       and as a successor of,\n\t\t       B <a language from the same\n\t\t       developer at that time>", "Carbon <the element>?", "California", "Cranberry juice"}, {"C#", "C++", "Objective-C", "I don't know"}, {"Bjarne Stroustrop", "Dennis Ritchie", "Bill Gates", "Melinda Gates"}};
	printf("\n____________________________________________________________", topic);
	br(4);
	printf("\tQuestion 1: %s\n", questions[0]);
	printf("\t\t    a: %s\tb: %s\n\t\t    c: %s\td: %s\n\tAnswer: ", answers[0][0], answers[0][1], answers[0][2], answers[0][3]);
	scanf("%c", &choice);
	if (choice == 'd' || choice == 'D') {
		#ifdef CONIO_H
		    clr(green);
		#endif
		printf("\t\t    ✔️ Correct!");
		#ifdef CONIO_H
		    clr(def);
		#endif
		br(4);
	}
	else {
		#ifdef CONIO_H
		    clr(red);
		#endif
		printf("\t\t    ❌ Not a valid choice!");
		#ifdef CONIO_H
		    clr(def);
		#endif
		br(4);
	}
	printf("\tQuestion 2: %s\n", questions[1]);
	printf("\t\t    a: %s\tb: %s\n\t\t    c: %s\td: %s\n\tAnswer: ", answers[1][0], answers[1][1], answers[1][2], answers[1][3]);
	scanf(" %c", &choice);
	if (choice == 'c' || choice == 'C') {
		#ifdef CONIO_H
		    clr(green);
		#endif
		printf("\t\t    ✔️ Correct!");
		#ifdef CONIO_H
		    clr(def);
		#endif
		br(4);
	}
	else {
		#ifdef CONIO_H
		    clr(red);
		#endif
		printf("\t\t    ❌ Not a valid choice!");
		#ifdef CONIO_H
		    clr(def);
		#endif
		br(4);
	}
	printf("\tQuestion 3: %s\n", questions[2]);
	printf("\t\t    a: %s\n\t\t    b: %s\n\t\t    c: %s\n\t\t    d: %s\n\tAnswer: ", answers[2][0], answers[2][1], answers[2][2], answers[2][3]);
	scanf(" %c", &choice);
	if (choice == 'b' || choice == 'B') {
		#ifdef CONIO_H
		    clr(green);
		#endif
		printf("\t\t    ✔️ Correct!");
		#ifdef CONIO_H
		    clr(def);
		#endif
		br(4);
	}
	else {
		#ifdef CONIO_H
		    clr(red);
		#endif
		printf("\t\t    ❌ Not a valid choice!");
		#ifdef CONIO_H
		    clr(def);
		#endif
		br(4);
	}
	printf("\tQuestion 4: %s\n", questions[3]);
	printf("\t\t    a: %s\n\t\t    b: %s\n\t\t    c: %s\n\t\t    d: %s\n\tAnswer: ", answers[3][0], answers[3][1], answers[3][2], answers[3][3]);
	scanf(" %c", &choice);
	if (choice == 'c' || choice == 'C') {
		#ifdef CONIO_H
		    clr(green);
		#endif
		printf("\t\t    ✔️ Correct!");
		#ifdef CONIO_H
		    clr(def);
		#endif
		br(4);
	}
	else {
		#ifdef CONIO_H
		    clr(red);
		#endif
		printf("\t\t    ❌ Not a valid choice!");
		#ifdef CONIO_H
		    clr(def);
		#endif
		br(4);
	}
	printf("\tQuestion 5: %s\n", questions[4]);
	printf("\t\t    a: %s\n\t\t    b: %s\n\t\t    c: %s\n\t\t    d: %s\n\tAnswer: ", answers[4][0], answers[4][1], answers[4][2], answers[4][3]);
	scanf(" %c", &choice);
	if (choice == 'a' || choice == 'A') {
		#ifdef CONIO_H
		    clr(green);
		#endif
		printf("\t\t    ✔️ Correct!");
		#ifdef CONIO_H
		    clr(def);
		#endif
		br(4);
	}
	else {
		#ifdef CONIO_H
		    clr(red);
		#endif
		printf("\t\t    ❌ Not a valid choice!");
		#ifdef CONIO_H
		    clr(def);
		#endif
		br(4);
	}
	printf("\tQuestion 6: %s\n", questions[5]);
	printf("\t\t    a: %s\n\t\t    b: %s\n\t\t    c: %s\n\t\t    d: %s\n\tAnswer: ", answers[5][0], answers[5][1], answers[5][2], answers[5][3]);
	scanf(" %c", &choice);
	if (choice == 'b' || choice == 'B') {
		#ifdef CONIO_H
		    clr(green);
		#endif
		printf("\t\t    ✔️ Correct!");
		#ifdef CONIO_H
		    clr(def);
		#endif
		br(4);
	}
	else {
		#ifdef CONIO_H
		    clr(red);
		#endif
		printf("\t\t    ❌ Not a valid choice!");
		#ifdef CONIO_H
		    clr(def);
		#endif
		br(4);
	}
	printf("\tQuestion 7: %s\n", questions[6]);
	printf("\t\t    a: %s\n\t\t    b: %s\n\t\t    c: %s\n\t\t    d: %s\n\tAnswer: ", answers[6][0], answers[6][1], answers[6][2], answers[6][3]);
	scanf(" %c", &choice);
	if (choice == 'a' || choice == 'A') {
		#ifdef CONIO_H
		    clr(green);
		#endif
		printf("\t\t    ✔️ Correct!");
		#ifdef CONIO_H
		    clr(def);
		#endif
		br(4);
	}
	else {
		#ifdef CONIO_H
		    clr(red);
		#endif
		printf("\t\t    ❌ Not a valid choice!");
		#ifdef CONIO_H
		    clr(def);
		#endif
		br(4);
	}
}