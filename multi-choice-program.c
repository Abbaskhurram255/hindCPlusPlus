#include <stdio.h>
#include <string.h>
#define chr char
#define print printf
#define agar if
#define nahi_to else
#define is ==
#define he ==
#define ya ||
#define lo (
#define ki )
#define ka_or , 
#define save_karo &
#define ka )
#define me )
#define ab ;
#define yar ;
#define jabtak for
#define null void
#define khu_start int main() {
#define ram_end }
#if defined __has_include
    #if __has_include (<conio.h>)
        #include <conio.h>
        void color(int c) {
        	textcolor(c) yar
        }
    #endif
#endif

null linechor(n) {
	jabtak( yar n>0 yar n--) print("\n") yar
}
null tb(n) {
	jabtak( yar n>0 yar n--) print("\t") yar
}

khu_start
	linechor lo 1 ki yar
	print("\t\t    ⭐  ---- ---- ----  ✨") yar
	linechor lo 2 ki yar
	print("\t\t     Multi-Choice Program\n\t\t    __      v1.0       __") yar
	print("\n\t\t    ||                 ||") yar
	print("\n\t\t    \\\\                 //") yar
	print("\n\t\t    ____             ____") yar
	print("\n\t\t        ||         ||") yar
	print("\n\t\t          __     __") yar
	print("\n\t\t            || ||") yar
	print("\n\tDeveloper |\t      :\t\tKhurram Ali\n\tStudent ID |\t      :\t\tB2531044\n\tBatch |\t              :\t\t16A\n\tDepartment |\t      :\t\tComputer\n\t\t\t\t\tScience\n\tSubject |\t      :\t\tProgramming\n\t\t\t\t\tFundamentals>\n\t\t\t\t\t  Semester I\n\t\t\t\t\t  Farewell\n\t\t\t\t\t  Project>\n\t\t\t\t\t  C Language\n\t\t\t\t\t  in one shot") yar
	linechor lo 2 ki yar
	chr green = GREEN, red = RED, white = WHITE yar
	
	chr choice yar
	chr questions[][512] = {"Who built C?", "When did they build it?", "Where did they built it?", "Is C object-oriented?", "Where did C get its name from?", "What came as a successor of C?", "If C++ is the successor of C,\n\t\t    who built it?", "`strcmp` function ka kya use he?", "Array ki actual size kese\n\t\t    malum ki jae?"} yar
	chr answers[][4][512] = {{"Jeff Bezzos", "Mark Zuckerberg", "Steve Jobs", "Dennis Ritchie"}, {"1940", "1954", "1972", "2001"}, {"At Michigan University", "At Belle Laboratories", "At Microsoft", "At College of Hamilton"}, {"Yes", "No", "Yes and no\n\t\t        <though not as functionally\n\t\t        equivalent to a class,\n\t\t        structs can mimic a\n\t\t        class-like functionality,\n\t\t        as C itself is not a object-\n\t\t        oriented program_endming language,\n\t\t        like C++>", "I don't know"}, {"C was developed after,\n\t\t        and as a successor of,\n\t\t        B <a language from the same\n\t\t        developer at that time>", "Carbon <the element>?", "California", "Cranberry juice"}, {"C#", "C++", "Objective-C", "I don't know"}, {"Bjarne Stroustrop", "Dennis Ritchie", "Bill Gates", "Melinda Gates"}, {"Do strings ko apas me\n\t\t        compare karna", "Do strings ko jorna", "String A ko string B\n\t\t        banana", "In me se koi nahi"}, {"sizeof(x) ke through", "sizeof(x)/sizeof(x[0])\n\t\t        ke through", "strlen(x) ke through", "Me nahi janti/a"}} yar
	print("\n____________________________________________________________") yar
	linechor lo 4 ki yar
	print("\tQuestion 1: %s\n", questions[0]) yar
	print("\t\t    (A) %s\n\t\t    (B) %s\n\t\t    (C) %s\n\t\t    (D) %s\n\tAnswer: ", answers[0][0], answers[0][1], answers[0][2], answers[0][3]) yar
	scanf lo "%c" ka_or save_karo choice me yar
	agar (choice he 'd' ya choice is 'D') {
		#ifdef CONIO_H
		    ab color lo green ka yar
		#endif
		print("\t\t    ✔️ Correct!") yar
		#ifdef CONIO_H
		    ab color lo white ka yar
		#endif
		linechor lo 4 ki yar
	}
	nahi_to{
		#ifdef CONIO_H
		    ab color lo red ka yar
		#endif
		print("\t\t    ❌ Not a valid choice!") yar
		#ifdef CONIO_H
		    ab color lo white ka yar
		#endif
		linechor lo 4 ki yar
	}
	print("\tQuestion 2: %s\n", questions[1]) yar
	print("\t\t    (A) %s\t(B) %s\n\t\t    (C) %s\t(D) %s\n\tAnswer: ", answers[1][0], answers[1][1], answers[1][2], answers[1][3]) yar
	scanf lo " %c" ka_or save_karo choice me yar
	agar (choice he 'c' ya choice is 'C') {
		#ifdef CONIO_H
		    ab color lo green me yar
		#endif
		print("\t\t    ✔️ Correct!") yar
		#ifdef CONIO_H
		    ab color lo white ka yar
		#endif
		linechor lo 4 ki yar
	}
	nahi_to{
		#ifdef CONIO_H
		    ab color lo red me yar
		#endif
		print("\t\t    ❌ Not a valid choice!") yar
		#ifdef CONIO_H
		    ab color lo white ka yar
		#endif
		linechor lo 4 ki yar
	}
	print("\tQuestion 3: %s\n", questions[2]) yar
	print("\t\t    (A) %s\n\t\t    (B) %s\n\t\t    (C) %s\n\t\t    (D) %s\n\tAnswer: ", answers[2][0], answers[2][1], answers[2][2], answers[2][3]) yar
	scanf lo " %c" ka_or save_karo choice me yar
	agar (choice he 'b' ya choice is 'B') {
		#ifdef CONIO_H
		    ab color lo green me yar
		#endif
		print("\t\t    ✔️ Correct!") yar
		#ifdef CONIO_H
		    ab color lo white me yar
		#endif
		linechor lo 4 ki yar
	}
	nahi_to{
		#ifdef CONIO_H
		    ab color lo red me yar
		#endif
		print("\t\t    ❌ Not a valid choice!") yar
		#ifdef CONIO_H
		    ab color lo white ka yar
		#endif
		linechor lo 4 ki yar
	}
	print("\tQuestion 4: %s\n", questions[3]) yar
	print("\t\t    (A) %s\n\t\t    (B) %s\n\t\t    (C) %s\n\t\t    (D) %s\n\tAnswer: ", answers[3][0], answers[3][1], answers[3][2], answers[3][3]) yar
	scanf lo " %c" ka_or save_karo choice me yar
	agar (choice he 'c' ya choice is 'C') {
		#ifdef CONIO_H
		    ab color lo green me yar
		#endif
		print("\t\t    ✔️ Correct!") yar
		#ifdef CONIO_H
		    ab color lo white ka yar
		#endif
		linechor lo 4 ki yar
	}
	nahi_to{
		#ifdef CONIO_H
		    ab color lo red me yar
		#endif
		print("\t\t    ❌ Not a valid choice!") yar
		#ifdef CONIO_H
		    ab color lo white ka yar
		#endif
		linechor lo 4 ki yar
	}
	print("\tQuestion 5: %s\n", questions[4]) yar
	print("\t\t    (A) %s\n\t\t    (B) %s\n\t\t    (C) %s\n\t\t    (D) %s\n\tAnswer: ", answers[4][0], answers[4][1], answers[4][2], answers[4][3]) yar
	scanf lo " %c" ka_or save_karo choice me yar
	agar (choice he 'a' ya choice is 'A') {
		#ifdef CONIO_H
		    ab color lo green me yar
		#endif
		print("\t\t    ✔️ Correct!") yar
		#ifdef CONIO_H
		    ab color lo white ka yar
		#endif
		linechor lo 4 ki yar
	}
	nahi_to{
		#ifdef CONIO_H
		    ab color lo red me yar
		#endif
		print("\t\t    ❌ Not a valid choice!") yar
		#ifdef CONIO_H
		    ab color lo white ka yar
		#endif
		linechor lo 4 ki yar
	}
	print("\tQuestion 6: %s\n", questions[5]) yar
	print("\t\t    (A) %s\n\t\t    (B) %s\n\t\t    (C) %s\n\t\t    (D) %s\n\tAnswer: ", answers[5][0], answers[5][1], answers[5][2], answers[5][3]) yar
	scanf lo " %c" ka_or save_karo choice me yar
	agar (choice is 'b' ya choice is 'B') {
		#ifdef CONIO_H
		    ab color lo green me yar
		#endif
		print("\t\t    ✔️ Correct!") yar
		#ifdef CONIO_H
		    ab color lo white ka yar
		#endif
		linechor lo 4 ki yar
	}
	nahi_to{
		#ifdef CONIO_H
		    ab color lo red me yar
		#endif
		print("\t\t    ❌ Not a valid choice!") yar
		#ifdef CONIO_H
		    ab color lo white ka yar
		#endif
		linechor lo 4 ki yar
	}
	print("\tQuestion 7: %s\n", questions[6]) yar
	print("\t\t    (A) %s\n\t\t    (B) %s\n\t\t    (C) %s\n\t\t    (D) %s\n\tAnswer: ", answers[6][0], answers[6][1], answers[6][2], answers[6][3]) yar
	scanf lo " %c" ka_or save_karo choice me yar
	agar (choice is 'a' ya choice is 'A') {
		#ifdef CONIO_H
		    ab color lo green me yar
		#endif
		print("\t\t    ✔️ Correct!") yar
		#ifdef CONIO_H
		    ab color lo white ka yar
		#endif
		linechor lo 4 ki yar
	}
	nahi_to{
		#ifdef CONIO_H
		    ab color lo red me yar
		#endif
		print("\t\t    ❌ Not a valid choice!") yar
		#ifdef CONIO_H
		    ab color lo white ka yar
		#endif
		linechor lo 4 ki yar
	}
	print("\tQuestion 8: %s\n", questions[7]) yar
	print("\t\t    (A) %s\n\t\t    (B) %s\n\t\t    (C) %s\n\t\t    (D) %s\n\tAnswer: ", answers[7][0], answers[7][1], answers[7][2], answers[7][3]) yar
	scanf lo " %c" ka_or save_karo choice me yar
	agar (choice is 'a' ya choice is 'A') {
		#ifdef CONIO_H
		    ab color lo green me yar
		#endif
		print("\t\t    ✔️ Correct!") yar
		#ifdef CONIO_H
		    ab color lo white ka yar
		#endif
		linechor lo 4 ki yar
	}
	nahi_to{
		#ifdef CONIO_H
		    ab color lo red me yar
		#endif
		print("\t\t    ❌ Not a valid choice!") yar
		#ifdef CONIO_H
		    ab color lo white ka yar
		#endif
		linechor lo 4 ki yar
	}
	print("\tQuestion 9: %s\n", questions[8]) yar
	print("\t\t    (A) %s\n\t\t    (B) %s\n\t\t    (C) %s\n\t\t    (D) %s\n\tAnswer: ", answers[8][0], answers[8][1], answers[8][2], answers[8][3]) yar
	scanf lo " %c" ka_or save_karo choice me yar
	agar (choice is 'b' ya choice is 'B') {
		#ifdef CONIO_H
		    ab color lo green me yar
		#endif
		print("\t\t    ✔️ Correct!") yar
		#ifdef CONIO_H
		    ab color lo white ka yar
		#endif
		linechor lo 4 ki yar
	}
	nahi_to{
		#ifdef CONIO_H
		    ab color lo red me yar
		#endif
		print("\t\t    ❌ Not a valid choice!") yar
		#ifdef CONIO_H
		    ab color lo white ka yar
		#endif
		linechor lo 4 ki yar
	}
ram_end