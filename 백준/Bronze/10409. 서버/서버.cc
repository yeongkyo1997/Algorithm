#include <iostream>
using namespace std;
int main(void)
{
	int n, t, arr[50], sum = 0, cnt = 0;
	cin >> n >> t;
	for (int i = 0; i < n; i++)
		cin >> arr[i];
	for (int i = 0; i < n; i++)
	{
		if (sum + arr[i] > t)
			break;
		sum += arr[i], cnt++;
	}
	cout << cnt;
}
