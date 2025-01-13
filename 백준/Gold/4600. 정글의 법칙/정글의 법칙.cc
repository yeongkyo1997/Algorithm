#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    while (true)
    {
        int B, P;
        cin >> B >> P;
        if (!cin || (B == 0 && P == 0))
        {
            break;
        }

        B = -B;

        vector<int> C(B), T(B);
        for (int i = 0; i < B; i++)
        {
            cin >> C[i] >> T[i];
        }

        vector<int> wait(B + 1, 0);
        vector<int> crossing(B, 0);
        vector<int> crossingTime(B, 0);

        wait[0] = P;

        int totalTime = 0;

        while (wait[B] < P)
        {

            for (int i = 0; i < B; i++)
            {
                if (crossing[i] == 0 && wait[i] > 0)
                {

                    int groupSize = min(C[i], wait[i]);
                    crossing[i] = groupSize;
                    crossingTime[i] = T[i];
                    wait[i] -= groupSize;
                }
            }

            bool allEmpty = true;
            for (int i = 0; i < B; i++)
            {
                if (crossing[i] != 0)
                {
                    allEmpty = false;
                    break;
                }
            }
            if (allEmpty)
            {

                break;
            }

            int dt = INT_MAX;
            for (int i = 0; i < B; i++)
            {
                if (crossing[i] != 0 && crossingTime[i] < dt)
                {
                    dt = crossingTime[i];
                }
            }

            totalTime += dt;

            for (int i = 0; i < B; i++)
            {
                if (crossing[i] != 0)
                {
                    crossingTime[i] -= dt;

                    if (crossingTime[i] == 0)
                    {

                        wait[i + 1] += crossing[i];
                        crossing[i] = 0;
                    }
                }
            }
        }

        cout << totalTime << "\n";
    }

    return 0;
}