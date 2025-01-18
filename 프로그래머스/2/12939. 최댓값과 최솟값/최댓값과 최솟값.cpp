#include <string>
#include <vector>
#include <sstream>
#include <limits>

using namespace std;

string solution(string s) {
    vector<int> numbers;
    string temp;
    stringstream ss(s);
    
    while (ss >> temp) {
        numbers.push_back(stoi(temp));
    }
    
    int min_val = INT32_MAX;
    int max_val = INT32_MIN;
    
    for(auto num : numbers) {
        if(num < min_val) min_val = num;
        if(num > max_val) max_val = num;
    }
    
    return to_string(min_val) + " " + to_string(max_val);
}