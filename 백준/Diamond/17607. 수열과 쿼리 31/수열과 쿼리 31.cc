#include <iostream>
#include <algorithm>
#include <cstdlib>
#include <ctime>
#include <utility> // For std::swap

struct Node {
    int val;
    int priority;
    int size;
    int max_ones;
    int prefix_ones;
    int suffix_ones;
    bool reverse;
    Node *l, *r;

    Node(int v) : val(v), priority(rand()), size(1), max_ones(v), prefix_ones(v), suffix_ones(v), reverse(false), l(nullptr), r(nullptr) {}
};

int getSize(Node* t) {
    return t ? t->size : 0;
}

void push(Node* t) {
    if (t && t->reverse) {
        t->reverse = false;
        std::swap(t->l, t->r);
        if (t->l) {
            t->l->reverse ^= true;
            std::swap(t->l->prefix_ones, t->l->suffix_ones);
        }
        if (t->r) {
            t->r->reverse ^= true;
            std::swap(t->r->prefix_ones, t->r->suffix_ones);
        }
    }
}

void update(Node* t) {
    if (!t) return;

    int ls = getSize(t->l);
    int rs = getSize(t->r);
    t->size = ls + rs + 1;

    int left_max = t->l ? t->l->max_ones : 0;
    int right_max = t->r ? t->r->max_ones : 0;
    int left_prefix = t->l ? t->l->prefix_ones : 0;
    int left_suffix = t->l ? t->l->suffix_ones : 0;
    int right_prefix = t->r ? t->r->prefix_ones : 0;
    int right_suffix = t->r ? t->r->suffix_ones : 0;

    if (t->l) {
        if (left_prefix == ls && t->val == 1) {
            t->prefix_ones = ls + 1 + right_prefix;
        } else {
            t->prefix_ones = left_prefix;
        }
    } else {
        if (t->val == 1) {
            t->prefix_ones = 1 + right_prefix;
        } else {
            t->prefix_ones = 0;
        }
    }

     if (t->r) {
         if (right_suffix == rs && t->val == 1) {
            t->suffix_ones = rs + 1 + left_suffix;
        } else {
            t->suffix_ones = right_suffix;
        }
    } else {
        if (t->val == 1) {
            t->suffix_ones = 1 + left_suffix;
        } else {
            t->suffix_ones = 0;
        }
    }

    t->max_ones = std::max(left_max, right_max);
    if (t->val == 1) {
         t->max_ones = std::max(t->max_ones, left_suffix + 1 + right_prefix);
    }
     t->max_ones = std::max({t->max_ones, t->prefix_ones, t->suffix_ones});
}


void split(Node* t, int k, Node*& l, Node*& r) {
    if (!t) {
        l = r = nullptr;
        return;
    }
    push(t);
    int left_size = getSize(t->l);
    if (left_size < k) {
        split(t->r, k - left_size - 1, t->r, r);
        l = t;
    } else {
        split(t->l, k, l, t->l);
        r = t;
    }
    update(t);
}

Node* merge(Node* l, Node* r) {
    push(l);
    push(r);
    if (!l) return r;
    if (!r) return l;

    if (l->priority > r->priority) {
        l->r = merge(l->r, r);
        update(l);
        return l;
    } else {
        r->l = merge(l, r->l);
        update(r);
        return r;
    }
}


int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);
    std::cout.tie(NULL);
    srand(time(0));

    int n;
    std::cin >> n;

    Node* root = nullptr;
    for (int i = 1; i <= n; ++i) {
        int val;
        std::cin >> val;
        Node* newNode = new Node(val);
        root = merge(root, newNode);
    }

    int m;
    std::cin >> m;

    for (int i = 0; i < m; ++i) {
        int type, l, r;
        std::cin >> type >> l >> r;
        Node *t1, *t2, *tmid;

        split(root, r, t1, t2);
        split(t1, l - 1, t1, tmid);

        if (type == 1) {
            if (tmid) {
                tmid->reverse ^= true;
                std::swap(tmid->prefix_ones, tmid->suffix_ones);
            }
        } else {
            int result = tmid ? tmid->max_ones : 0;
            std::cout << result << "\n";
        }

        root = merge(merge(t1, tmid), t2);
    }

    return 0;
}