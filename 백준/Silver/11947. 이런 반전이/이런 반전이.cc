#include <iostream>
#include <string>

using namespace std;

int main() {
    int T;
    cin >> T;
    
    for (int i = 0; i < T; i++) {
        string N;
        cin >> N;
        
        string median = N;

        median[0] = '5';

        for (int j = 1; j < median.length(); j++)
            median[j] = '0';
        
        if (stol(N) > stol(median)){
            string temp = median;
            for (int j = 0; j < median.length(); j++) {
                temp[j] = 57 - median[j] + 48;
            }
            cout << stol(median) * stol(temp) << endl;
        }
		else {
            string temp = N;
            for (int j = 0; j < N.length(); j++) {
                temp[j] = 57 - N[j] + 48;
            }
            cout << stol(N) * stol(temp) << endl;
        }
    }
    return 0;
}