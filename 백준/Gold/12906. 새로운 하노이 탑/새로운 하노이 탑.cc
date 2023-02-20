#include<iostream>
#include<vector>
#include<queue>
#include<string>
#include<set>
 
#define endl "\n"
using namespace std;
 
set<pair<pair<string, string>, string>> Visit;
 
typedef struct
{
    string S1;
    string S2;
    string S3;
}State;
 
State Hanoi;
string A, B, C;
 
void Input()
{
    int Idx = 0;
    for (int i = 0; i < 3; i++)
    {
        int a; cin >> a;
        if (Idx == 0)
        {
            if (a == 0)
            {
                A = "";
                Hanoi.S1 = A;
                Idx++;
            }
            else
            {
                cin >> A;
                Hanoi.S1 = A;
                Idx++;
            }            
        }
        else if (Idx == 1)
        {
            if (a == 0)
            {
                B = "";
                Hanoi.S2 = B;
                Idx++;
 
            }
            else
            {
                cin >> B;
                Hanoi.S2 = B;
                Idx++;
            }
        }
        else 
        {
            if (a == 0)
            {
                C = "";
                Hanoi.S3 = C;
            }
            else
            {
                cin >> C;
                Hanoi.S3 = C;
            }
        }
    }
}
 
bool Check_Hanoi_Tower(string A, string B, string C)
{
    char Plate_A = 'A';
    char Plate_B = 'B';
    char Plate_C = 'C';
    
    if (A.length() > 0)
    {
        for (int i = 0; i < A.length(); i++)
        {
            if (A[i] != Plate_A) return false;
        }
    }
 
    if (B.length() > 0)
    {
        for (int i = 0; i < B.length(); i++)
        {
            if (B[i] != Plate_B) return false;
        }
    }
 
    if (C.length() > 0)
    {
        for (int i = 0; i < C.length(); i++)
        {
            if (C[i] != Plate_C) return false;
        }
    }
 
    return true;
}
 
string Remove_Top(string S)
{
    string Temp = "";
    for (int i = 0; i < S.length() - 1; i++)
    {
        Temp = Temp + S[i];
    }
    return Temp;
}
 
void BFS(State S, int Init)
{
    queue<pair<State, int>> Q;
    Q.push(make_pair(S, Init));
    Visit.insert(make_pair(make_pair(S.S1, S.S2), S.S3));
 
    while (Q.empty() == 0)
    {
        string Hanoi_A = Q.front().first.S1;
        string Hanoi_B = Q.front().first.S2;
        string Hanoi_C = Q.front().first.S3;
        int Cnt = Q.front().second;
        Q.pop();
 
        if (Check_Hanoi_Tower(Hanoi_A, Hanoi_B, Hanoi_C) == true)
        {
            cout << Cnt << endl;
            return;
        }
 
        if (Hanoi_A.length() > 0)
        {
            // B한테 하나주는거
            string A_Temp = Remove_Top(Hanoi_A);
            string B_Temp = Hanoi_B + Hanoi_A[Hanoi_A.length() - 1];
            if (Visit.find(make_pair(make_pair(A_Temp, B_Temp), Hanoi_C)) == Visit.end())
            {
                Visit.insert(make_pair(make_pair(A_Temp, B_Temp), Hanoi_C));
                State S_Temp;
                S_Temp.S1 = A_Temp; S_Temp.S2 = B_Temp; S_Temp.S3 = Hanoi_C;
                Q.push(make_pair(S_Temp, Cnt + 1));
            }
 
            string C_Temp = Hanoi_C + Hanoi_A[Hanoi_A.length() - 1];
            if (Visit.find(make_pair(make_pair(A_Temp, Hanoi_B), C_Temp)) == Visit.end())
            {
                Visit.insert(make_pair(make_pair(A_Temp, Hanoi_B), C_Temp));
                State S_Temp;
                S_Temp.S1 = A_Temp; S_Temp.S2 = Hanoi_B; S_Temp.S3 = C_Temp;
                Q.push(make_pair(S_Temp, Cnt + 1));
            }
        }
 
        if (Hanoi_B.length() > 0)
        {
            string B_Temp = Remove_Top(Hanoi_B);
            string A_Temp = Hanoi_A + Hanoi_B[Hanoi_B.length() - 1];
            if (Visit.find(make_pair(make_pair(A_Temp, B_Temp), Hanoi_C)) == Visit.end())
            {
                Visit.insert(make_pair(make_pair(A_Temp, B_Temp), Hanoi_C));
                State S_Temp;
                S_Temp.S1 = A_Temp; S_Temp.S2 = B_Temp; S_Temp.S3 = Hanoi_C;
                Q.push(make_pair(S_Temp, Cnt + 1));
            }
 
            string C_Temp = Hanoi_C + Hanoi_B[Hanoi_B.length() - 1];
            if (Visit.find(make_pair(make_pair(Hanoi_A, B_Temp), C_Temp)) == Visit.end())
            {
                Visit.insert(make_pair(make_pair(Hanoi_A, B_Temp), C_Temp));
                State S_Temp;
                S_Temp.S1 = Hanoi_A; S_Temp.S2 = B_Temp; S_Temp.S3 = C_Temp;
                Q.push(make_pair(S_Temp, Cnt + 1));
            }
        }
 
        if (Hanoi_C.length() > 0)
        {
            string C_Temp = Remove_Top(Hanoi_C);
            string A_Temp = Hanoi_A + Hanoi_C[Hanoi_C.length() - 1];
            if (Visit.find(make_pair(make_pair(A_Temp, Hanoi_B), C_Temp)) == Visit.end())
            {
                Visit.insert(make_pair(make_pair(A_Temp, Hanoi_B), C_Temp));
                State S_Temp;
                S_Temp.S1 = A_Temp; S_Temp.S2 = Hanoi_B; S_Temp.S3 = C_Temp;
                Q.push(make_pair(S_Temp, Cnt + 1));
            }
 
            string B_Temp = Hanoi_B + Hanoi_C[Hanoi_C.length() - 1];
            if (Visit.find(make_pair(make_pair(Hanoi_A, B_Temp), C_Temp)) == Visit.end())
            {
                Visit.insert(make_pair(make_pair(Hanoi_A, B_Temp), C_Temp));
                State S_Temp;
                S_Temp.S1 = Hanoi_A; S_Temp.S2 = B_Temp; S_Temp.S3 = C_Temp;
                Q.push(make_pair(S_Temp, Cnt + 1));
            }
        }
    }
}
 
void Solution()
{
    BFS(Hanoi, 0);
}
 
void Solve()
{
    Input();
    Solution();
}
 
int main(void)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
 
    //freopen("Input.txt", "r", stdin);
    Solve();
 
    return 0;
}