#include <cstdio>

using namespace std;

int main()
{
	int n, f;
	scanf("%d", &n);
	scanf("%d", &f);
	
	n = (n / 100) * 100;

	for (int i = 0; i < 100; i++)
	{
		if ((n + i) % f == 0) {
			n += i;
			break;
		}
	}
	
	printf("%02d\n", n % 100);

	return 0;
}