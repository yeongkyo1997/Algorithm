#include <iostream>
#include <cstdlib>
#include <string>
using namespace std;

struct Node
{
    char c;
    int priority, size;
    Node *left;
    Node *right;
    Node(char _c) : c(_c), priority(rand()), size(1), left(nullptr), right(nullptr) {}
};

int getSize(Node *root)
{
    return root ? root->size : 0;
}

void update(Node *root)
{
    if (root)
        root->size = 1 + getSize(root->left) + getSize(root->right);
}

void split(Node *root, int key, Node *&left, Node *&right)
{
    if (!root)
    {
        left = right = nullptr;
        return;
    }
    int leftSize = getSize(root->left);
    if (key <= leftSize)
    {
        split(root->left, key, left, root->left);
        right = root;
    }
    else
    {
        split(root->right, key - leftSize - 1, root->right, right);
        left = root;
    }
    update(root);
}

Node *merge(Node *left, Node *right)
{
    if (!left || !right)
        return left ? left : right;
    if (left->priority > right->priority)
    {
        left->right = merge(left->right, right);
        update(left);
        return left;
    }
    else
    {
        right->left = merge(left, right->left);
        update(right);
        return right;
    }
}

char getKth(Node *root, int k)
{
    Node *curr = root;
    while (curr)
    {
        int leftSize = getSize(curr->left);
        if (k < leftSize)
        {
            curr = curr->left;
        }
        else if (k == leftSize)
        {
            return curr->c;
        }
        else
        {
            k -= leftSize + 1;
            curr = curr->right;
        }
    }
    return '?';
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string S;
    cin >> S;
    Node *root = nullptr;

    for (char c : S)
    {
        root = merge(root, new Node(c));
    }

    int Q;
    cin >> Q;
    while (Q--)
    {
        int type;
        cin >> type;
        if (type == 1)
        {

            int x, y;
            cin >> x >> y;
            Node *left = nullptr, *mid = nullptr, *right = nullptr;

            split(root, y + 1, mid, right);

            split(mid, x, left, mid);

            root = merge(mid, merge(left, right));
        }
        else if (type == 2)
        {

            int x, y;
            cin >> x >> y;
            Node *left = nullptr, *mid = nullptr, *right = nullptr;

            split(root, y + 1, mid, right);

            split(mid, x, left, mid);

            root = merge(left, merge(right, mid));
        }
        else if (type == 3)
        {

            int x;
            cin >> x;
            cout << getKth(root, x) << "\n";
        }
    }
    return 0;
}