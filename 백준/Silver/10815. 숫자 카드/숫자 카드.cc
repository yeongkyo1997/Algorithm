#include <iostream>
#include <algorithm>
using namespace std;
int card[500001];
int serch[500001];

bool twoserch(int left, int right, int serchnum) {
	int mid = (left + right) / 2;
	bool result;
	if (left > right)
		return false;
	else {
		if (card[mid] > serchnum) {
			result = twoserch(left, mid - 1, serchnum);
		}
		else if (card[mid] < serchnum)
		{
			result = twoserch(mid + 1, right, serchnum);
		}
		else {
			return true;

		}

		return result;
	}
}

int main(void) {


	int N, M;

	cin >> N;

	for (int i = 0; i < N; i++)
		cin >> card[i];

	cin >> M;

	for (int i = 0; i < M; i++)
		cin >> serch[i];

	sort(card, card + N);

	for (int i = 0; i < M; i++) {
		int searchNum = serch[i];
		int left = 0, right = N - 1;
		int mid;


		if (twoserch(left, right, searchNum))
			cout << "1 ";
		else
			cout << "0 ";
	}
	cout << endl;

	return 0;
}