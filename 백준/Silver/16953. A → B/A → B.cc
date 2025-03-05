#include <iostream>
using namespace std;

int main() {
    long long A, B;
    cin >> A >> B;
    
    int operations = 0;
    while(B > A) {
        if(B % 10 == 1) {
            B = (B - 1) / 10;
        }
        else if(B % 2 == 0) {
            B /= 2;
        }
        else {
            break;
        }
        operations++;
    }
    
    if(B == A) 
        cout << operations + 1;
    else 
        cout << -1;
    
    return 0;
}