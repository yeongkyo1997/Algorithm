#include <bits/stdc++.h>
using namespace std;

void op1(vector<vector<int>> &arr, int N, int M)
{

    for (int r = 0; r < N / 2; r++)
    {
        for (int c = 0; c < M; c++)
        {
            swap(arr[r][c], arr[N - 1 - r][c]);
        }
    }
}

void op2(vector<vector<int>> &arr, int N, int M)
{

    for (int r = 0; r < N; r++)
    {
        for (int c = 0; c < M / 2; c++)
        {
            swap(arr[r][c], arr[r][M - 1 - c]);
        }
    }
}

vector<vector<int>> op3(const vector<vector<int>> &arr, int N, int M)
{

    vector<vector<int>> newArr(M, vector<int>(N));
    for (int r = 0; r < N; r++)
    {
        for (int c = 0; c < M; c++)
        {
            newArr[c][N - 1 - r] = arr[r][c];
        }
    }
    return newArr;
}

vector<vector<int>> op4(const vector<vector<int>> &arr, int N, int M)
{

    vector<vector<int>> newArr(M, vector<int>(N));
    for (int r = 0; r < N; r++)
    {
        for (int c = 0; c < M; c++)
        {
            newArr[M - 1 - c][r] = arr[r][c];
        }
    }
    return newArr;
}

void op5(vector<vector<int>> &arr, int N, int M)
{

    int n2 = N / 2, m2 = M / 2;

    vector<vector<int>> temp(N, vector<int>(M));

    for (int r = 0; r < n2; r++)
    {
        for (int c = 0; c < m2; c++)
        {
            temp[r][c + m2] = arr[r][c];
        }
    }

    for (int r = 0; r < n2; r++)
    {
        for (int c = 0; c < m2; c++)
        {
            temp[r + n2][c + m2] = arr[r][c + m2];
        }
    }

    for (int r = 0; r < n2; r++)
    {
        for (int c = 0; c < m2; c++)
        {
            temp[r + n2][c] = arr[r + n2][c + m2];
        }
    }

    for (int r = 0; r < n2; r++)
    {
        for (int c = 0; c < m2; c++)
        {
            temp[r][c] = arr[r + n2][c];
        }
    }

    arr = temp;
}

void op6(vector<vector<int>> &arr, int N, int M)
{
    int n2 = N / 2, m2 = M / 2;
    vector<vector<int>> temp(N, vector<int>(M));

    for (int r = 0; r < n2; r++)
    {
        for (int c = 0; c < m2; c++)
        {
            temp[r + n2][c] = arr[r][c];
        }
    }

    for (int r = 0; r < n2; r++)
    {
        for (int c = 0; c < m2; c++)
        {
            temp[r + n2][c + m2] = arr[r + n2][c];
        }
    }

    for (int r = 0; r < n2; r++)
    {
        for (int c = 0; c < m2; c++)
        {
            temp[r][c + m2] = arr[r + n2][c + m2];
        }
    }

    for (int r = 0; r < n2; r++)
    {
        for (int c = 0; c < m2; c++)
        {
            temp[r][c] = arr[r][c + m2];
        }
    }

    arr = temp;
}

void applyOperation(vector<vector<int>> &arr, int &N, int &M, int op)
{
    switch (op)
    {
    case 1:
        op1(arr, N, M);
        break;
    case 2:
        op2(arr, N, M);
        break;
    case 3:
    {
        vector<vector<int>> newArr = op3(arr, N, M);

        arr = newArr;

        int tmp = N;
        N = M;
        M = tmp;
        break;
    }
    case 4:
    {
        vector<vector<int>> newArr = op4(arr, N, M);
        arr = newArr;

        int tmp = N;
        N = M;
        M = tmp;
        break;
    }
    case 5:
        op5(arr, N, M);
        break;
    case 6:
        op6(arr, N, M);
        break;
    default:

        break;
    }
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M, R;
    cin >> N >> M >> R;
    vector<vector<int>> arr(N, vector<int>(M));

    for (int r = 0; r < N; r++)
    {
        for (int c = 0; c < M; c++)
        {
            cin >> arr[r][c];
        }
    }

    vector<int> ops(R);
    for (int i = 0; i < R; i++)
    {
        cin >> ops[i];
    }

    for (int i = 0; i < R; i++)
    {
        applyOperation(arr, N, M, ops[i]);
    }

    for (int r = 0; r < N; r++)
    {
        for (int c = 0; c < M; c++)
        {
            cout << arr[r][c] << " ";
        }
        cout << "\n";
    }

    return 0;
}