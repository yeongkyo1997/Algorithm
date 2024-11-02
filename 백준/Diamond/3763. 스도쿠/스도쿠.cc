#include <bits/stdc++.h>
using namespace std;

// 상수 정의
const int N = 16;

// DLX Node 구조체
struct Node
{
    int row, col;
    Node *left, *right, *up, *down, *head;
    Node(int r = -1, int c = -1) : row(r), col(c), left(this), right(this), up(this), down(this), head(nullptr) {}
};

// 헤더 노드
Node *header;

// 열 헤더 배열
vector<Node *> columnHeaders;

// 각 제약 조건의 크기
int numConstraints;

// 현재 해를 저장하는 벡터
vector<int> solution;

// 맵핑 함수: (row, col, num) -> unique row index
inline int getRowIndex(int r, int c, int num)
{
    return r * N * N + c * N + num;
}

// 맵핑 함수: 각 제약 조건을 열 인덱스로 변환
inline int getColIndex(int constraintType, int index)
{
    // constraintType: 0 = Cell, 1 = Row, 2 = Column, 3 = Block
    return constraintType * N * N + index;
}

// 연결 함수
void linkNodes(Node *node, Node *target)
{
    node->left = target->left;
    node->right = target;
    target->left->right = node;
    target->left = node;
}

// DLX 초기화
void initializeDLX(int totalColumns)
{
    header = new Node();
    header->left = header->right = header;
    columnHeaders.resize(totalColumns, nullptr);
    numConstraints = totalColumns;
    for (int i = 0; i < totalColumns; ++i)
    {
        Node *col = new Node(-1, i);
        col->up = col->down = col;
        col->head = col;
        columnHeaders[i] = col;
        // 링크 to header
        linkNodes(col, header);
    }
}

// 컬럼 헤더에서 열을 커버
void cover(Node *col)
{
    col->left->right = col->right;
    col->right->left = col->left;
    for (Node *row = col->down; row != col; row = row->down)
    {
        for (Node *node = row->right; node != row; node = node->right)
        {
            node->up->down = node->down;
            node->down->up = node->up;
        }
    }
}

// 컬럼 헤더에서 열을 언커버
void uncover(Node *col)
{
    for (Node *row = col->up; row != col; row = row->up)
    {
        for (Node *node = row->left; node != row; node = node->left)
        {
            node->up->down = node;
            node->down->up = node;
        }
    }
    col->left->right = col;
    col->right->left = col;
}

// DLX 재귀 함수
bool DLX_search(int k, vector<string> &grid, vector<string> &result)
{
    if (header->right == header)
    {
        // 해를 찾음
        // 해를 저장
        string solvedGrid[N];
        for (int i = 0; i < N; ++i)
            solvedGrid[i] = string(N, '-');
        for (auto row : solution)
        {
            // (r, c, num)
            int num = row % N;
            int c = (row / N) % N;
            int r = row / (N * N);
            solvedGrid[r][c] = 'A' + num;
        }
        for (int i = 0; i < N; ++i)
            result.push_back(solvedGrid[i]);
        return true;
    }

    // 최소 컬럼 선택 (MRV)
    Node *chosen = nullptr;
    int minSize = INT32_MAX;
    for (Node *col = header->right; col != header; col = col->right)
    {
        int cnt = 0;
        for (Node *row = col->down; row != col; row = row->down)
            cnt++;
        if (cnt < minSize)
        {
            minSize = cnt;
            chosen = col;
            if (cnt == 0)
                break;
        }
    }

    if (!chosen || minSize == 0)
        return false;

    cover(chosen);

    for (Node *row = chosen->down; row != chosen; row = row->down)
    {
        solution.push_back(row->row);
        for (Node *node = row->right; node != row; node = node->right)
        {
            cover(node->head);
        }

        if (DLX_search(k + 1, grid, result))
            return true;

        // 백트래킹
        solution.pop_back();
        for (Node *node = row->left; node != row; node = node->left)
        {
            uncover(node->head);
        }
    }

    uncover(chosen);
    return false;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);

    // 입력 그리드
    vector<string> grid(N);
    for (int i = 0; i < N; ++i)
        cin >> grid[i];

    // 총 제약 조건 수: 4 * 16 * 16 = 1024
    initializeDLX(4 * N * N);

    // 가능한 모든 행을 추가
    // (r, c, num)에 대해 제약 조건을 연결
    // 제약 조건:
    // 1. 각 셀은 하나의 숫자
    // 2. 각 행은 각 숫자를 하나씩
    // 3. 각 열은 각 숫자를 하나씩
    // 4. 각 블록은 각 숫자를 하나씩

    // 블록 인덱스 함수
    auto getBlock = [&](int r, int c) -> int
    {
        return (r / 4) * 4 + (c / 4);
    };

    // 맵핑을 위한 벡터
    // 각 행 인덱스는 (r * N * N + c * N + num)
    // 이를 통해 각 셀에 대한 고유한 행을 생성
    // 각 제약 조건은 0 ~ 1023 (4 * 16 * 16)

    // Pre-fill constraints based on the initial grid
    vector<bool> filled(N * N, false);
    for (int r = 0; r < N; ++r)
    {
        for (int c = 0; c < N; ++c)
        {
            if (grid[r][c] != '-')
            {
                filled[r * N + c] = true;
            }
        }
    }

    // 모든 가능한 (r, c, num) 조합에 대해 링크 추가
    for (int r = 0; r < N; ++r)
    {
        for (int c = 0; c < N; ++c)
        {
            if (grid[r][c] != '-')
            {
                // 이미 채워진 숫자
                int num = grid[r][c] - 'A';
                // 각 제약 조건에 해당하는 열 인덱스 계산
                int cellCol = getColIndex(0, r * N + c);
                int rowCol = getColIndex(1, r * N + num);
                int colCol = getColIndex(2, c * N + num);
                int blockCol = getColIndex(3, getBlock(r, c) * N + num);
                // 행 인덱스
                int rowIndex = getRowIndex(r, c, num);
                // 링크 생성
                Node *n1 = new Node(rowIndex, cellCol);
                Node *n2 = new Node(rowIndex, rowCol);
                Node *n3 = new Node(rowIndex, colCol);
                Node *n4 = new Node(rowIndex, blockCol);
                // 연결
                n1->head = columnHeaders[cellCol];
                n2->head = columnHeaders[rowCol];
                n3->head = columnHeaders[colCol];
                n4->head = columnHeaders[blockCol];
                // 링크 수직으로 연결
                // n1
                n1->up = columnHeaders[cellCol]->up;
                n1->down = columnHeaders[cellCol];
                columnHeaders[cellCol]->up->down = n1;
                columnHeaders[cellCol]->up = n1;
                // n2
                n2->up = columnHeaders[rowCol]->up;
                n2->down = columnHeaders[rowCol];
                columnHeaders[rowCol]->up->down = n2;
                columnHeaders[rowCol]->up = n2;
                // n3
                n3->up = columnHeaders[colCol]->up;
                n3->down = columnHeaders[colCol];
                columnHeaders[colCol]->up->down = n3;
                columnHeaders[colCol]->up = n3;
                // n4
                n4->up = columnHeaders[blockCol]->up;
                n4->down = columnHeaders[blockCol];
                columnHeaders[blockCol]->up->down = n4;
                columnHeaders[blockCol]->up = n4;
                // 링크 좌우로 연결
                n1->right = n2;
                n2->left = n1;
                n2->right = n3;
                n3->left = n2;
                n3->right = n4;
                n4->left = n3;
                n4->right = n1;
                n1->left = n4;
            }
            else
            {
                // 빈 칸: 가능한 모든 숫자에 대해 링크 추가
                for (int num = 0; num < N; ++num)
                {
                    // 각 숫자가 이미 행, 열, 블록에 사용되지 않았는지 확인
                    bool conflict = false;
                    // Check row
                    for (int k = 0; k < N; ++k)
                    {
                        if (grid[r][k] == ('A' + num))
                        {
                            conflict = true;
                            break;
                        }
                    }
                    if (conflict)
                        continue;
                    // Check column
                    for (int k = 0; k < N; ++k)
                    {
                        if (grid[k][c] == ('A' + num))
                        {
                            conflict = true;
                            break;
                        }
                    }
                    if (conflict)
                        continue;
                    // Check block
                    int br = (r / 4) * 4, bc = (c / 4) * 4;
                    for (int i = br; i < br + 4; ++i)
                    {
                        for (int j = bc; j < bc + 4; ++j)
                        {
                            if (grid[i][j] == ('A' + num))
                            {
                                conflict = true;
                                break;
                            }
                        }
                        if (conflict)
                            break;
                    }
                    if (conflict)
                        continue;

                    // 각 제약 조건에 해당하는 열 인덱스 계산
                    int cellCol = getColIndex(0, r * N + c);
                    int rowCol = getColIndex(1, r * N + num);
                    int colCol = getColIndex(2, c * N + num);
                    int blockCol = getColIndex(3, getBlock(r, c) * N + num);
                    // 행 인덱스
                    int rowIndex = getRowIndex(r, c, num);
                    // 링크 생성
                    Node *n1 = new Node(rowIndex, cellCol);
                    Node *n2 = new Node(rowIndex, rowCol);
                    Node *n3 = new Node(rowIndex, colCol);
                    Node *n4 = new Node(rowIndex, blockCol);
                    // 연결
                    n1->head = columnHeaders[cellCol];
                    n2->head = columnHeaders[rowCol];
                    n3->head = columnHeaders[colCol];
                    n4->head = columnHeaders[blockCol];
                    // 링크 수직으로 연결
                    // n1
                    n1->up = columnHeaders[cellCol]->up;
                    n1->down = columnHeaders[cellCol];
                    columnHeaders[cellCol]->up->down = n1;
                    columnHeaders[cellCol]->up = n1;
                    // n2
                    n2->up = columnHeaders[rowCol]->up;
                    n2->down = columnHeaders[rowCol];
                    columnHeaders[rowCol]->up->down = n2;
                    columnHeaders[rowCol]->up = n2;
                    // n3
                    n3->up = columnHeaders[colCol]->up;
                    n3->down = columnHeaders[colCol];
                    columnHeaders[colCol]->up->down = n3;
                    columnHeaders[colCol]->up = n3;
                    // n4
                    n4->up = columnHeaders[blockCol]->up;
                    n4->down = columnHeaders[blockCol];
                    columnHeaders[blockCol]->up->down = n4;
                    columnHeaders[blockCol]->up = n4;
                    // 링크 좌우로 연결
                    n1->right = n2;
                    n2->left = n1;
                    n2->right = n3;
                    n3->left = n2;
                    n3->right = n4;
                    n4->left = n3;
                    n4->right = n1;
                    n1->left = n4;
                }
            }
        }
    }

    vector<string> result;

    bool found = DLX_search(0, grid, result);

    if (found && result.size() > 0)
    {
        for (auto &r : result)
        {
            cout << r << '\n';
        }
    }

    return 0;
}