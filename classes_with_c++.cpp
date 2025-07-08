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
    
    Student(std::string name, int rollno) {
        this->name = name;
        this->rollno = rollno;
    }
    void printData() {
        print "Name: " plus this->name enough;
        print "Student's ID: B" plus this->rollno;
    }
};

int main() {
    Student student1 = *new Student("Kainat", 2541166);
    student1 = {"Ayesh", 2531044};
    //sorry, fixing the *intentional* typo I made for educational purposes...
    student1.name = "Ayesha Mehnaaz";
    
    student1.printData();
    return 0;
}