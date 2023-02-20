#include<iostream>
void star(int n, int x, int y);
 
using namespace std;
 
char arr[3072][6144];
 
int main(void)
{
    int n, i, j;
 
    cin >> n;  //N입력
 
    //배열 초기화
    //각 높이의 행의 요소들을 공백으로, 행의 끝부분만 null로 초기화한다.
    for (i = 0; i<n; i++){
        for (j = 0; j<2 * n; j++){
            if (j == 2 * n - 1)
                arr[i][j] = '\0';
            else
                arr[i][j] = ' ';
        }
    }
 
    star(n, n - 1, 0);//삼각형의 높이와, 삼각형 맨 위 꼭지점 좌표를 매개변수로 넘긴다.
 
    //삼각형 출력
    for (i = 0; i < n; i++)
    {
        for (j = 0; j < 2 * n - 1; j++)
        {
            cout << arr[i][j];
        }
        cout << endl;
    }
 
    return 0;
}
 
void star(int n, int x, int y)
{
    if (n == 3)//높이가 3이라면 별을 만들어 출력한다.
    {
        //별을 그린다.
        arr[y][x] = '*';
        arr[y + 1][x - 1] = '*';
        arr[y + 1][x + 1] = '*';
        arr[y + 2][x - 2] = '*';
        arr[y + 2][x - 1] = '*';
        arr[y + 2][x] = '*';
        arr[y + 2][x + 1] = '*';
        arr[y + 2][x + 2] = '*';
        return;
    }
    star(n / 2, x, y); // 위의 삼각형 높이와 맨 위 꼭대기 좌표를 보낸다. 
    star(n / 2, x - (n / 2), y + (n / 2)); // 왼쪽 하단 삼각형 높이와 맨 위 꼭대기 좌표를 보낸다.
    star(n / 2, x + (n / 2), y + (n / 2)); // 오른쪽 하단 삼각형 높이와 맨 위 꼭대기 좌표를 보낸다.
}
