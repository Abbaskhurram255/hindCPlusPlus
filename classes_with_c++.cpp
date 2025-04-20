#include <iostream>
using namespace std;
#define print std::cout <<
#define plus <<
#define enough << endl
#define extends : public

class Student {
    public:
    string name;
    int rollno;
    
    Student(string name, int rollno) {
        this->name = name;
        this->rollno = rollno;
    }
    void printData() {
        Student student = *new Student(this->name, this->rollno);
        print "Name: " plus student.name enough;
        print "Student's ID: B" plus student.rollno;
    }
};

int main() {
    Student student1 = *new Student("Kainat", 2541166);
    student1 = {"Ayesh", 2531044};
    //sorry, fixing the *intentional* typo, for further education:
    student1.name = "Ayesha Mehnaaz";
    
    student1.printData();
    return 0;
}