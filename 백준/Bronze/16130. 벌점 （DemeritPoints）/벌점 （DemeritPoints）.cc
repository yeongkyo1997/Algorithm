#include <bits/stdc++.h>
using namespace std;

int main()
{
    int N;
    cin >> N;
    cin.ignore();

    for (int i = 0; i < N; i++)
    {
        string s;
        getline(cin, s);
        if (s.empty())
        {
            getline(cin, s);
        }

        int cumu = 0;
        int prev_quo = 0;
        long long total_time = 0;
        string flag = "";

        for (char c : s)
        {
            if (flag != "")
            {
                break;
            }

            int X;
            if (c >= '0' && c <= '9')
            {
                X = c - '0';
            }
            else if (c >= 'A' && c <= 'Z')
            {
                X = 10 + (c - 'A');
            }
            else
            {
                continue;
            }

            cumu += X;
            int new_quo = cumu / 10;

            if (new_quo > prev_quo)
            {
                if (new_quo >= 1 && new_quo <= 3)
                {
                    total_time += new_quo;
                    prev_quo = new_quo;
                }
                else if (new_quo == 4)
                {
                    flag = "(weapon)";
                    prev_quo = new_quo;
                }
                else
                {
                    flag = "(09)";
                    prev_quo = new_quo;
                }
            }
        }

        if (flag != "")
        {
            cout << total_time << flag << "\n";
        }
        else
        {
            cout << total_time << "\n";
        }
    }
}