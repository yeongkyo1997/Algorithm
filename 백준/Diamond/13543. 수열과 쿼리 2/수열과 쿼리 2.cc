#include <iostream>
#include <vector>
#include <cstdlib>
#include <ctime>
#include <algorithm> // Not strictly needed, but good practice

using namespace std;

using u32 = unsigned int;

u32 C[11][11];

void precompute_combinations() {
    for (int i = 0; i <= 10; ++i) {
        C[i][0] = C[i][i] = 1;
        for (int j = 1; j < i; ++j) {
            C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
        }
    }
}

struct Node {
    u32 key;
    int priority;
    Node *l, *r;
    int size;
    u32 sums[11];

    Node(u32 k) : key(k), priority(rand()), l(nullptr), r(nullptr), size(1) {
        for (int j = 0; j <= 10; ++j) {
            sums[j] = key;
        }
    }
};

inline int get_size(Node* t) {
    return t ? t->size : 0;
}

inline void update_size(Node* t) {
    if (t) {
        t->size = 1 + get_size(t->l) + get_size(t->r);
    }
}

void push_up(Node* t) {
    if (!t) return;

    update_size(t);

    int sl = get_size(t->l);
    u32 sl1 = sl + 1;

    u32 pow_sl1[11];
    pow_sl1[0] = 1;
    for (int p = 1; p <= 10; ++p) {
        pow_sl1[p] = pow_sl1[p - 1] * sl1;
    }

    for (int j = 0; j <= 10; ++j) {
        u32 left_sum = t->l ? t->l->sums[j] : 0;
        u32 root_term = t->key * pow_sl1[j];
        u32 right_contrib = 0;

        if (t->r) {
            for (int p = 0; p <= j; ++p) {
                u32 term = C[j][p] * pow_sl1[p];
                // Check if t->r->sums[j-p] exists before multiplying
                if (j - p >= 0) { // Ensure index is non-negative
                     u32 right_sum_term = t->r->sums[j - p];
                     term *= right_sum_term;
                     right_contrib += term;
                }
            }
        }
        t->sums[j] = left_sum + root_term + right_contrib;
    }
}

void split(Node* t, int pos, Node*& l, Node*& r) {
    if (!t) {
        l = r = nullptr;
        return;
    }
    int current_pos = get_size(t->l);
    if (pos <= current_pos) {
        split(t->l, pos, l, t->l);
        r = t;
    } else {
        split(t->r, pos - current_pos - 1, t->r, r);
        l = t;
    }
    update_size(t);
    push_up(t); // Must recalculate sums after structural change potential
}

Node* merge(Node* l, Node* r) {
    if (!l) return r;
    if (!r) return l;

    if (l->priority > r->priority) {
        l->r = merge(l->r, r);
        push_up(l);
        return l;
    } else {
        r->l = merge(l, r->l);
        push_up(r);
        return r;
    }
}

void insert(Node*& t, int pos, u32 val) {
    Node* newNode = new Node(val);
    Node *l, *r;
    split(t, pos, l, r);
    t = merge(merge(l, newNode), r);
}

void erase(Node*& t, int pos) {
    Node *l, *mid, *r;
    split(t, pos + 1, l, r);
    split(l, pos, l, mid);
    if(mid) {
         delete mid;
    }
    t = merge(l, r);
}

void update(Node*& t, int pos, u32 val) {
    erase(t, pos);
    insert(t, pos, val);
}

u32 query(Node*& t, int l, int r, int k_query) {
     if (l > r || !t) return 0;
     // Ensure range is within current bounds before splitting
     int current_size = get_size(t);
     l = max(0, l);
     r = min(current_size - 1, r);
     if (l > r) return 0;


    Node *t1, *t2, *t3;
    split(t, r + 1, t1, t3);
    split(t1, l, t1, t2);

    u32 result = (t2 ? t2->sums[k_query] : 0);

    t = merge(merge(t1, t2), t3);

    return result;
}


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    srand(time(0));
    precompute_combinations();

    int N;
    cin >> N;

    Node* root = nullptr;
    for (int i = 0; i < N; ++i) {
        u32 val;
        cin >> val;
        insert(root, i, val);
    }

    int M;
    cin >> M;

    while (M--) {
        int type;
        cin >> type;
        int p, l, r, k_query;
        u32 v;

        if (type == 1) {
            cin >> p >> v;
            int current_size = get_size(root);
             // Allow p == current_size for appending
            if (p >= 0 && p <= current_size) {
                 insert(root, p, v);
            }
        } else if (type == 2) {
            cin >> p;
            int current_size = get_size(root);
            if (p >= 0 && p < current_size) {
                 erase(root, p);
            }
        } else if (type == 3) {
            cin >> p >> v;
             int current_size = get_size(root);
            if (p >= 0 && p < current_size) {
                update(root, p, v);
            }
        } else {
            cin >> l >> r >> k_query;
             int current_size = get_size(root);
             // Query assumes valid indices relative to *current* array state
             if (l >= 0 && r < current_size && l <= r && k_query >=0 && k_query <= 10) {
                 cout << query(root, l, r, k_query) << "\n";
             } else {
                  if (l > r || l >= current_size || r < 0) {
                     cout << 0 << "\n";
                  } else {
                     l = max(0, l);
                     r = min(current_size - 1, r);
                     if (l > r) {
                         cout << 0 << "\n";
                     } else {
                         cout << query(root, l, r, k_query) << "\n";
                     }
                  }
             }
        }
    }

    return 0;
}