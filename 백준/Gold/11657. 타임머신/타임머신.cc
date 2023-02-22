#include<cstdio>
#include<vector>
#include<utility>
#define mp(a,b) make_pair(a,b)
#define pb(a) push_back(a)

using namespace std;

typedef long long LLD;
typedef pair<LLD, LLD> PLL;
typedef vector<PLL> VPLL;
typedef vector<LLD> VLL;

VPLL path[505];
VLL dist;
const LLD INF = 1LL << 55;

int main() {
	int n, m;
	scanf("%d%d", &n, &m);
	dist = VLL(n + 1, INF);

	for (int i = 0; i < m; i++) {
		LLD u, v, w;

		scanf("%lld%lld%lld", &u, &v, &w);

		path[u].pb(mp(v, w));
	}
	dist[1] = 0;

	for (int v = 0; v < n - 1; v++) {
		for (int here = 1; here <= n; here++) {
			for (auto iter = path[here].begin(); iter != path[here].end(); iter++) {
				PLL p = *iter;
				LLD there = p.first;
				LLD cost = p.second;

				if (dist[here] != INF &&
					dist[there] > dist[here] + cost) {
					dist[there] = dist[here] + cost;
				}
			}
		}
	}

	int non = 0;

	for (int here = 1; here <= n; here++) {
		for (auto iter = path[here].begin(); iter != path[here].end(); iter++) {
			PLL p = *iter;
			LLD there = p.first;
			LLD cost = p.second;
			if (dist[here] != INF && dist[there] > dist[here] + cost) {
				dist[there] = dist[here] + cost;
				non++;
			}
		}
	}

	if (non)
		puts("-1");
	else {
		for (int i = 2; i <= n; i++) {
			if (dist[i] == INF)
				puts("-1");
			else
				printf("%lld\n", dist[i]);
		}
	}

	return 0;
}