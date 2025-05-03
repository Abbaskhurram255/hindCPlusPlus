#include <iostream>

int main() {
    double array[] = {0, 0.5, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7, 1.8, 1.9, 2.0};
    int size = sizeof(array)/sizeof(array[0]);
    
    for (int i=0, j=size-1; i<j; i++, j--) {
        array[i] = array[i] + array[j];
        array[j] = array[i] - array[j];
        array[i] = array[i] - array[j];
    }
    
    std::cout << "{";
    for (int i=0; i<size; i++) std::cout << "\n\t" << array[i] << ",";
    std::cout << "\n}\n";
}