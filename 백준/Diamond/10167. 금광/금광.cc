#include <bits/stdc++.h>
using namespace std;

class Node {
public:
	long long tsum, lsum, rsum, msum;
	
	Node() : tsum{ 0 }, lsum{ 0 }, rsum{ 0 }, msum{ 0 } {};
	Node sum(int val) {
		this->tsum += val;
		this->lsum = this->rsum = this->msum = this->tsum;
		return *this;
	}
	Node merge(const Node& left, const Node& right) {
		this->tsum = left.tsum + right.tsum;
		this->lsum = max(left.lsum, left.tsum + right.lsum);
		this->rsum = max(right.rsum, left.rsum + right.tsum);
		this->msum = max({ left.rsum + right.lsum, left.msum, right.msum, this->lsum, this->rsum });
		return *this;
	}
};

class Dot {
public:
	int x, y, w;

	Dot() {};
	Dot(int x, int y, int w) : x{ x }, y{ y }, w{ w } {};
};

long long res;
int N, xs_len, ys_len;

vector < Node > tree;
vector < int > xs, ys;
vector < Dot > dot_list;
vector < vector<Dot> > zip;

Node update(int inx, int val, int node, int x, int y) {
	if (y < inx || inx < x)
		return tree[node];
	if (x == y)
		return tree[node].sum(val);

	int mid = (x + y) >> 1;
	return tree[node].merge(update(inx, val, node * 2, x, mid), update(inx, val, node * 2 + 1, mid + 1, y));
}

int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL);

	cin >> N;
	dot_list.resize(N);
	for (Dot& dot : dot_list) {
		cin >> dot.x >> dot.y >> dot.w;
		xs.push_back(dot.x);
		ys.push_back(dot.y);
	}
	sort(xs.begin(), xs.end());
	sort(ys.begin(), ys.end());

	xs.erase(unique(xs.begin(), xs.end()), xs.end());
	xs_len = xs.size();
	ys.erase(unique(ys.begin(), ys.end()), ys.end());
	ys_len = ys.size();

	zip.resize(xs_len);
	for (Dot& dot : dot_list) {
		int x = lower_bound(xs.begin(), xs.end(), dot.x) - xs.begin();
		int y = lower_bound(ys.begin(), ys.end(), dot.y) - ys.begin();

		zip[x].push_back(Dot(x, y, dot.w));
	}

	for (int i = 0; i < xs_len; i++) {
		tree.resize(ys_len * 4);

		for (int j = i; j < xs_len; j++) {
			for (Dot& k : zip[j])
				update(k.y, k.w, 1, 0, ys_len - 1);
			res = max(tree[1].msum, res);
		}

		tree.clear();
	}

	cout << res;

	return 0;
}