#include <iostream>
#include <string>

using namespace std;

int main()
{
    string retake_code;
    cin >> retake_code;

    int N;
    cin >> N;

    string first5 = retake_code.substr(0, 5);

    int result = 0;
    for (int i = 0; i < N; ++i)
    {
        string course_code;
        cin >> course_code;
        if (course_code.substr(0, 5) == first5)
        {
            result++;
        }
    }

    cout << result;
    return 0;
}