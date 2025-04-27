#include <iostream>
#include <vector>
using namespace std;

// 6면을 3×3 배열로 저장
// 0=U, 1=D, 2=F, 3=B, 4=L, 5=R
char cube[6][3][3];

// f번 면을 시계방향으로 90도 회전
void rotate_face(int f) {
    char tmp = cube[f][0][0];
    cube[f][0][0] = cube[f][2][0];
    cube[f][2][0] = cube[f][2][2];
    cube[f][2][2] = cube[f][0][2];
    cube[f][0][2] = tmp;
    tmp = cube[f][0][1];
    cube[f][0][1] = cube[f][1][0];
    cube[f][1][0] = cube[f][2][1];
    cube[f][2][1] = cube[f][1][2];
    cube[f][1][2] = tmp;
}

// U+ (윗면을 위에서 바라보아 시계)
void cmd_U() {
    rotate_face(0);
    char tmp;
    // F ↑← R ↑← B ↑← L ↑← F ↑
    for (int i = 0; i < 3; i++) {
        tmp = cube[2][0][i];
        cube[2][0][i] = cube[5][0][i];
        cube[5][0][i] = cube[3][0][i];
        cube[3][0][i] = cube[4][0][i];
        cube[4][0][i] = tmp;
    }
}

// D+ (아랫면을 아래에서 바라보아 시계)
void cmd_D() {
    rotate_face(1);
    char tmp;
    // F ↓← L ↓← B ↓← R ↓← F ↓
    for (int i = 0; i < 3; i++) {
        tmp = cube[2][2][i];
        cube[2][2][i] = cube[4][2][i];
        cube[4][2][i] = cube[3][2][i];
        cube[3][2][i] = cube[5][2][i];
        cube[5][2][i] = tmp;
    }
}

// F+ (앞면을 앞에서 바라보아 시계)
void cmd_F() {
    rotate_face(2);
    char tmp;
    // U 하단 ← L 우열(하→상) ← D 상단(우→좌) ← R 좌열(상→하) ← U 하단
    for (int i = 0; i < 3; i++) {
        tmp = cube[0][2][i];
        cube[0][2][i] = cube[4][2 - i][2];
        cube[4][2 - i][2] = cube[1][0][2 - i];
        cube[1][0][2 - i] = cube[5][i][0];
        cube[5][i][0] = tmp;
    }
}

// B+ (뒷면을 뒤에서 바라보아 시계)
void cmd_B() {
    rotate_face(3);
    char tmp;
    // U 상단 ← R 우열(상→하) ← D 하단(우→좌) ← L 좌열(하→상) ← U 상단
    for (int i = 0; i < 3; i++) {
        tmp = cube[0][0][i];
        cube[0][0][i] = cube[5][i][2];
        cube[5][i][2] = cube[1][2][2 - i];
        cube[1][2][2 - i] = cube[4][2 - i][0];
        cube[4][2 - i][0] = tmp;
    }
}

// L+ (왼쪽면을 왼쪽에서 바라보아 시계)
void cmd_L() {
    rotate_face(4);
    char tmp;
    // U 좌열 ← B 우열(하→상) ← D 좌열 ← F 좌열 ← U 좌열
    for (int i = 0; i < 3; i++) {
        tmp = cube[0][i][0];
        cube[0][i][0] = cube[3][2 - i][2];
        cube[3][2 - i][2] = cube[1][i][0];
        cube[1][i][0] = cube[2][i][0];
        cube[2][i][0] = tmp;
    }
}

// R+ (오른쪽면을 오른쪽에서 바라보아 시계)
void cmd_R() {
    rotate_face(5);
    char tmp;
    // U 우열 ← F 우열 ← D 우열 ← B 좌열(하←상) ← U 우열
    for (int i = 0; i < 3; i++) {
        tmp = cube[0][i][2];
        cube[0][i][2] = cube[2][i][2];
        cube[2][i][2] = cube[1][i][2];
        cube[1][i][2] = cube[3][2 - i][0];
        cube[3][2 - i][0] = tmp;
    }
}

// face, dir 에 따라 연산 (dir='+' 시계, dir='-' 반시계)
void apply(char face, char dir) {
    // 반시계면 시계 연산 3회
    if (dir == '-') {
        for (int k = 0; k < 3; k++) apply(face, '+');
        return;
    }
    // 시계('+') 연산
    switch (face) {
        case 'U': cmd_U(); break;
        case 'D': cmd_D(); break;
        case 'F': cmd_F(); break;
        case 'B': cmd_B(); break;
        case 'L': cmd_L(); break;
        case 'R': cmd_R(); break;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;
    while (T--) {
        // 초기 상태 세팅
        for (int f = 0; f < 6; f++) {
            char color;
            if (f == 0) color = 'w';
            if (f == 1) color = 'y';
            if (f == 2) color = 'r';
            if (f == 3) color = 'o';
            if (f == 4) color = 'g';
            if (f == 5) color = 'b';
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    cube[f][i][j] = color;
        }

        int n;
        cin >> n;
        while (n--) {
            string op;
            cin >> op;
            apply(op[0], op[1]);
        }

        // 윗면(U) 출력
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cout << cube[0][i][j];
            }
            cout << "\n";
        }
    }
    return 0;
}
