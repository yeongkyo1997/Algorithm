#include <vector>
#include <map>
#include <algorithm>
#include <set>
#include <vector>

using namespace std;

long long MOD = 1000000007;

struct Point
{
    int x, y, k;
    int id;
    long long d;
    long long v;
};

struct BIT
{
    vector<long long> tree;
    int size;

    BIT() : size(0) {}

    BIT(int s) : size(s)
    {
        tree.assign(s + 1, 0);
    }

    void update(int idx, long long delta)
    {
        delta %= MOD;
        if (delta < 0)
            delta += MOD;
        if (delta == 0)
            return;

        for (; idx <= size; idx += idx & -idx)
        {
            tree[idx] = (tree[idx] + delta) % MOD;
        }
    }

    long long query(int idx)
    {

        if (idx <= 0)
            return 0;
        if (idx > size)
            idx = size;

        long long sum = 0;

        for (; idx > 0; idx -= idx & -idx)
        {
            sum = (sum + tree[idx]) % MOD;
        }
        return sum;
    }
};

vector<int> solution(int n, vector<vector<int>> point_vec, vector<vector<int>> query)
{

    vector<Point> points(n);

    map<pair<int, int>, int> coord_to_id;

    set<int> y_coords_set;
    set<long long> d_vals_set;
    set<long long> v_vals_set;

    int S_idx = -1, E_idx = -1;
    int min_x = 2e9 + 7, max_x = -2e9 - 7;

    for (int i = 0; i < n; ++i)
    {
        points[i] = {point_vec[i][0], point_vec[i][1], point_vec[i][2], i};
        if (points[i].x < min_x)
            min_x = points[i].x;
        if (points[i].x > max_x)
            max_x = points[i].x;
    }

    for (int i = 0; i < n; ++i)
    {
        if (points[i].x == min_x)
            S_idx = i;
        if (points[i].x == max_x)
            E_idx = i;

        points[i].d = (long long)points[i].x - points[i].y;
        points[i].v = points[i].d - points[i].k;

        coord_to_id[{points[i].x, points[i].y}] = i;

        y_coords_set.insert(points[i].y);
        d_vals_set.insert(points[i].d);
        v_vals_set.insert(points[i].v);
    }

    if (S_idx == -1 || E_idx == -1)
    {
        vector<int> error_result(query.size() + 1, 0);
        return error_result;
    }
    Point S = points[S_idx];
    Point E = points[E_idx];

    vector<int> y_coords(y_coords_set.begin(), y_coords_set.end());
    map<int, int> mapY;
    for (int i = 0; i < y_coords.size(); ++i)
        mapY[y_coords[i]] = i + 1;
    int Ny = y_coords.size();

    vector<long long> d_vals(d_vals_set.begin(), d_vals_set.end());
    map<long long, int> mapD;
    for (int i = 0; i < d_vals.size(); ++i)
        mapD[d_vals[i]] = i + 1;

    vector<long long> v_vals(v_vals_set.begin(), v_vals_set.end());
    map<long long, int> mapV;
    for (int i = 0; i < v_vals.size(); ++i)
        mapV[v_vals[i]] = i + 1;

    vector<Point> sorted_points_fwd = points;

    sort(sorted_points_fwd.begin(), sorted_points_fwd.end(), [](const Point &a, const Point &b)
         { return a.x < b.x; });

    vector<long long> N_val(n, 0);
    map<int, BIT> forward_forest;

    N_val[S.id] = 1;

    if (mapD.count(S.d))
    {
        int idxD_S = mapD[S.d];
        if (mapY.count(S.y))
        {
            int idxY_S = mapY[S.y];
            forward_forest.emplace(idxD_S, BIT(Ny));
            forward_forest.at(idxD_S).update(idxY_S, 1);
        }
    }

    for (const auto &P : sorted_points_fwd)
    {
        if (P.id == S.id)
            continue;

        long long D_target = P.v;
        long long current_dp = 0;
        if (mapD.count(D_target))
        {
            int idxD_target = mapD[D_target];
            if (forward_forest.count(idxD_target))
            {
                BIT &ft = forward_forest.at(idxD_target);
                if (mapY.count(P.y))
                {
                    int idxY_P = mapY[P.y];

                    long long total_sum = ft.query(Ny);
                    long long prefix_sum = ft.query(idxY_P);
                    current_dp = (total_sum - prefix_sum + MOD) % MOD;
                }
            }
        }
        N_val[P.id] = current_dp;

        long long d_P = P.d;
        if (mapD.count(d_P))
        {
            int idxD_P = mapD[d_P];
            if (mapY.count(P.y))
            {
                int idxY_P = mapY[P.y];
                if (!forward_forest.count(idxD_P))
                {
                    forward_forest.emplace(idxD_P, BIT(Ny));
                }
                forward_forest.at(idxD_P).update(idxY_P, N_val[P.id]);
            }
        }
    }

    vector<Point> sorted_points_bwd = points;

    sort(sorted_points_bwd.begin(), sorted_points_bwd.end(), [](const Point &a, const Point &b)
         { return a.x > b.x; });

    vector<long long> N_prime_val(n, 0);
    map<int, BIT> backward_forest;

    N_prime_val[E.id] = 1;

    if (mapV.count(E.v))
    {
        int idxV_E = mapV[E.v];
        if (mapY.count(E.y))
        {
            int idxY_E = mapY[E.y];
            backward_forest.emplace(idxV_E, BIT(Ny));
            backward_forest.at(idxV_E).update(idxY_E, 1);
        }
    }

    for (const auto &P : sorted_points_bwd)
    {
        if (P.id == E.id)
            continue;

        long long D_target = P.d;
        long long current_dp = 0;

        if (mapV.count(D_target))
        {
            int idxV_target = mapV[D_target];
            if (backward_forest.count(idxV_target))
            {
                BIT &ft = backward_forest.at(idxV_target);
                if (mapY.count(P.y))
                {
                    int idxY_P = mapY[P.y];

                    current_dp = ft.query(idxY_P - 1);
                }
            }
        }
        N_prime_val[P.id] = current_dp;

        long long v_P = P.v;
        if (mapV.count(v_P))
        {
            int idxV_P = mapV[v_P];
            if (mapY.count(P.y))
            {
                int idxY_P = mapY[P.y];
                if (!backward_forest.count(idxV_P))
                {
                    backward_forest.emplace(idxV_P, BIT(Ny));
                }
                backward_forest.at(idxV_P).update(idxY_P, N_prime_val[P.id]);
            }
        }
    }

    vector<int> answer;
    answer.push_back((int)N_val[E.id]);

    for (const auto &q : query)
    {
        int type = q[0];
        if (type == 0)
        {

            Point P_new = {q[1], q[2], q[3], -1};
            P_new.d = (long long)P_new.x - P_new.y;
            P_new.v = P_new.d - P_new.k;

            long long N_new = 0;
            long long D_target_fwd = P_new.v;
            if (mapD.count(D_target_fwd))
            {
                int idxD_target = mapD[D_target_fwd];
                if (forward_forest.count(idxD_target))
                {
                    BIT &ft = forward_forest.at(idxD_target);

                    auto it = upper_bound(y_coords.begin(), y_coords.end(), P_new.y);
                    if (it != y_coords.end())
                    {
                        int query_start_idx = mapY[*it];

                        long long total_sum = ft.query(Ny);
                        long long prefix_sum = ft.query(query_start_idx - 1);
                        N_new = (total_sum - prefix_sum + MOD) % MOD;
                    }
                }
            }

            long long N_prime_new = 0;
            long long D_target_bwd = P_new.d;
            if (mapV.count(D_target_bwd))
            {
                int idxV_target = mapV[D_target_bwd];
                if (backward_forest.count(idxV_target))
                {
                    BIT &ft = backward_forest.at(idxV_target);

                    auto it = lower_bound(y_coords.begin(), y_coords.end(), P_new.y);
                    if (it != y_coords.begin())
                    {
                        --it;
                        int query_end_idx = mapY[*it];
                        N_prime_new = ft.query(query_end_idx);
                    }
                }
            }

            long long paths_through_new = (N_new * N_prime_new) % MOD;
            long long current_total_paths = N_val[E.id];
            long long new_total_paths = (current_total_paths + paths_through_new) % MOD;
            answer.push_back((int)new_total_paths);
        }
        else
        {
            int rem_x = q[1];
            int rem_y = q[2];
            if (coord_to_id.find({rem_x, rem_y}) == coord_to_id.end())
            {
                answer.push_back((int)N_val[E.id]);
                continue;
            }
            int rem_id = coord_to_id.at({rem_x, rem_y});

            if (rem_id == S_idx || rem_id == E_idx)
            {
                answer.push_back(0);
            }
            else
            {
                long long paths_through_rem = (N_val[rem_id] * N_prime_val[rem_id]) % MOD;
                long long current_total_paths = N_val[E.id];
                long long new_total_paths = (current_total_paths - paths_through_rem + MOD) % MOD;
                answer.push_back((int)new_total_paths);
            }
        }
    }

    return answer;
}