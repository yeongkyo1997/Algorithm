#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

long long solution(int cap, int n, vector<int> deliveries, vector<int> pickups)
{
    ll ret = 0;
    int deliver_idx = n - 1;
    int pickup_idx = n - 1;

    while (deliver_idx >= 0 || pickup_idx >= 0)
    {
        while (deliver_idx >= 0 && deliveries[deliver_idx] == 0)
        {
            deliver_idx--;
        }
        while (pickup_idx >= 0 && pickups[pickup_idx] == 0)
        {
            pickup_idx--;
        }

        if (deliver_idx < 0 && pickup_idx < 0)
        {
            break;
        }

        int farthest = max(deliver_idx, pickup_idx);
        ret += (ll)(farthest + 1) * 2;

        int load_deliver = 0;
        while (deliver_idx >= 0 && load_deliver < cap)
        {
            if (deliveries[deliver_idx] + load_deliver > cap)
            {
                int deliverable = cap - load_deliver;
                deliveries[deliver_idx] -= deliverable;
                load_deliver = cap;
            }
            else
            {
                load_deliver += deliveries[deliver_idx];
                deliveries[deliver_idx] = 0;
                deliver_idx--;
            }
        }

        int load_pickup = 0;
        while (pickup_idx >= 0 && load_pickup < cap)
        {
            if (pickups[pickup_idx] + load_pickup > cap)
            {
                int pickable = cap - load_pickup;
                pickups[pickup_idx] -= pickable;
                load_pickup = cap;
            }
            else
            {
                load_pickup += pickups[pickup_idx];
                pickups[pickup_idx] = 0;
                pickup_idx--;
            }
        }
    }

    return ret;
}
