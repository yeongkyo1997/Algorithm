#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
const ll INF = 1e18;
const ll MAX_COST = 1000000001;

struct Recipe
{
    int output;
    vector<pair<int, int>> inputs;
};

string trim(const string &s)
{
    size_t start = s.find_first_not_of(" \t\r\n");
    size_t end = s.find_last_not_of(" \t\r\n");
    if (start == string::npos)
        return "";
    return s.substr(start, end - start + 1);
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);

    int N, M;
    cin >> N >> M;

    unordered_map<string, int> name_to_id;
    vector<string> id_to_name;
    int current_id = 0;

    auto get_id = [&](const string &name) -> int
    {
        auto it = name_to_id.find(name);
        if (it != name_to_id.end())
            return it->second;
        name_to_id[name] = current_id;
        id_to_name.push_back(name);
        return current_id++;
    };

    vector<Recipe> recipe_list;

    vector<pair<int, ll>> basic_ingredients;

    for (int i = 0; i < N; ++i)
    {
        string name;
        ll price;
        cin >> name >> price;
        int id = get_id(name);
        basic_ingredients.emplace_back(id, price);
    }

    for (int i = 0; i < M; ++i)
    {
        string line;
        cin >> ws;
        getline(cin, line);
        line = trim(line);
        if (line.empty())
            continue;

        size_t eq = line.find('=');
        if (eq == string::npos)
            continue;
        string output_name = line.substr(0, eq);
        string rhs = line.substr(eq + 1);

        output_name = trim(output_name);
        rhs = trim(rhs);

        int output_id = get_id(output_name);

        vector<string> terms;
        string term;
        stringstream ss(rhs);
        while (getline(ss, term, '+'))
        {
            terms.push_back(trim(term));
        }

        Recipe rec;
        rec.output = output_id;
        for (size_t j = 0; j < terms.size(); ++j)
        {
            if (terms[j].empty())
                continue;
            int cnt = terms[j][0] - '0';
            string ingredient = terms[j].substr(1);
            ingredient = trim(ingredient);
            int ing_id = get_id(ingredient);
            rec.inputs.emplace_back(cnt, ing_id);
        }
        recipe_list.push_back(rec);
    }

    int love_id = get_id("LOVE");

    int total = current_id;
    vector<ll> cost(total, INF);

    for (size_t i = 0; i < basic_ingredients.size(); ++i)
    {
        int id = basic_ingredients[i].first;
        ll price = basic_ingredients[i].second;
        cost[id] = min(cost[id], price);
    }

    bool updated = true;
    int iterations = 0;
    int max_iterations = total * 10;

    while (updated && iterations < max_iterations)
    {
        updated = false;
        iterations++;
        for (size_t i = 0; i < recipe_list.size(); ++i)
        {
            Recipe &rec = recipe_list[i];
            ll total_cost = 0;
            bool valid = true;
            for (size_t j = 0; j < rec.inputs.size(); ++j)
            {
                int cnt = rec.inputs[j].first;
                int ing_id = rec.inputs[j].second;
                if (cost[ing_id] == INF)
                {
                    valid = false;
                    break;
                }
                if (cost[ing_id] > (MAX_COST / cnt))
                {
                    total_cost = MAX_COST;
                    break;
                }
                total_cost += cnt * cost[ing_id];
                if (total_cost > MAX_COST)
                {
                    total_cost = MAX_COST;
                    break;
                }
            }
            if (valid)
            {
                if (total_cost > MAX_COST)
                {
                    total_cost = MAX_COST;
                }
                if (total_cost < cost[rec.output])
                {
                    cost[rec.output] = total_cost;
                    updated = true;
                }
            }
        }
    }

    if (love_id >= cost.size() || cost[love_id] == INF)
    {
        cout << "-1\n";
    }
    else if (cost[love_id] > 1000000000LL)
    {
        cout << "1000000001\n";
    }
    else
    {
        cout << cost[love_id] << "\n";
    }
}