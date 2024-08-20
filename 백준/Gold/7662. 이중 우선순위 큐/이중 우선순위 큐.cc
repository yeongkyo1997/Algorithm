#include <iostream>
#include <set>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;
    while (T--)
    {
        int k;
        cin >> k;

        multiset<int> ms;

        while (k--)
        {
            char op;
            int num;
            cin >> op >> num;

            if (op == 'I')
            {
                ms.insert(num);
            }
            else if (op == 'D')
            {
                if (ms.empty())
                    continue;

                if (num == 1)
                {
                    auto it = prev(ms.end());
                    ms.erase(it);
                }
                else if (num == -1)
                {
                    auto it = ms.begin();
                    ms.erase(it);
                }
            }
        }

        if (ms.empty())
        {
            cout << "EMPTY\n";
        }
        else
        {
            cout << *prev(ms.end()) << " " << *ms.begin() << "\n";
        }
    }

    return 0;
}