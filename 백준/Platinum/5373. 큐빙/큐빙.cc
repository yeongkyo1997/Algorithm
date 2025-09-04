#include <bits/stdc++.h>
using namespace std;

enum { U=0, D=1, F=2, B=3, L=4, R=5 };

char cube[6][3][3];

void initCube() {
    // U,D,F,B,L,R : w,y,r,o,g,b
    for (int i = 0; i < 3; ++i)
        for (int j = 0; j < 3; ++j) {
            cube[U][i][j] = 'w';
            cube[D][i][j] = 'y';
            cube[F][i][j] = 'r';
            cube[B][i][j] = 'o';
            cube[L][i][j] = 'g';
            cube[R][i][j] = 'b';
        }
}

void rotateFace(int f, char dir) {
    char tmp[3][3];
    for (int i = 0; i < 3; ++i)
        for (int j = 0; j < 3; ++j)
            tmp[i][j] = cube[f][i][j];

    if (dir == '+') {
        // clockwise
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 3; ++j)
                cube[f][i][j] = tmp[2-j][i];
    } else {
        // counter-clockwise
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 3; ++j)
                cube[f][i][j] = tmp[j][2-i];
    }
}

void turnU(char dir) {
    rotateFace(U, dir);
    char t[3];
    if (dir == '+') {
        for (int i = 0; i < 3; ++i) t[i] = cube[F][0][i];
        for (int i = 0; i < 3; ++i) cube[F][0][i] = cube[R][0][i];
        for (int i = 0; i < 3; ++i) cube[R][0][i] = cube[B][0][i];
        for (int i = 0; i < 3; ++i) cube[B][0][i] = cube[L][0][i];
        for (int i = 0; i < 3; ++i) cube[L][0][i] = t[i];
    } else {
        for (int i = 0; i < 3; ++i) t[i] = cube[F][0][i];
        for (int i = 0; i < 3; ++i) cube[F][0][i] = cube[L][0][i];
        for (int i = 0; i < 3; ++i) cube[L][0][i] = cube[B][0][i];
        for (int i = 0; i < 3; ++i) cube[B][0][i] = cube[R][0][i];
        for (int i = 0; i < 3; ++i) cube[R][0][i] = t[i];
    }
}

void turnD(char dir) {
    rotateFace(D, dir);
    char t[3];
    if (dir == '+') {
        for (int i = 0; i < 3; ++i) t[i] = cube[F][2][i];
        for (int i = 0; i < 3; ++i) cube[F][2][i] = cube[L][2][i];
        for (int i = 0; i < 3; ++i) cube[L][2][i] = cube[B][2][i];
        for (int i = 0; i < 3; ++i) cube[B][2][i] = cube[R][2][i];
        for (int i = 0; i < 3; ++i) cube[R][2][i] = t[i];
    } else {
        for (int i = 0; i < 3; ++i) t[i] = cube[F][2][i];
        for (int i = 0; i < 3; ++i) cube[F][2][i] = cube[R][2][i];
        for (int i = 0; i < 3; ++i) cube[R][2][i] = cube[B][2][i];
        for (int i = 0; i < 3; ++i) cube[B][2][i] = cube[L][2][i];
        for (int i = 0; i < 3; ++i) cube[L][2][i] = t[i];
    }
}

void turnF(char dir) {
    rotateFace(F, dir);
    char t[3];
    if (dir == '+') {
        for (int i = 0; i < 3; ++i) t[i] = cube[U][2][i];
        for (int i = 0; i < 3; ++i) cube[U][2][i] = cube[L][2 - i][2];
        for (int i = 0; i < 3; ++i) cube[L][i][2] = cube[D][0][i];
        for (int i = 0; i < 3; ++i) cube[D][0][i] = cube[R][2 - i][0];
        for (int i = 0; i < 3; ++i) cube[R][i][0] = t[i];
    } else {
        for (int i = 0; i < 3; ++i) t[i] = cube[U][2][i];
        for (int i = 0; i < 3; ++i) cube[U][2][i] = cube[R][i][0];
        for (int i = 0; i < 3; ++i) cube[R][i][0] = cube[D][0][2 - i];
        for (int i = 0; i < 3; ++i) cube[D][0][i] = cube[L][i][2];
        for (int i = 0; i < 3; ++i) cube[L][i][2] = t[2 - i];
    }
}

void turnB(char dir) {
    rotateFace(B, dir);
    char t[3];
    if (dir == '+') {
        for (int i = 0; i < 3; ++i) t[i] = cube[U][0][i];
        for (int i = 0; i < 3; ++i) cube[U][0][i] = cube[R][i][2];
        for (int i = 0; i < 3; ++i) cube[R][i][2] = cube[D][2][2 - i];
        for (int i = 0; i < 3; ++i) cube[D][2][i] = cube[L][i][0];
        for (int i = 0; i < 3; ++i) cube[L][i][0] = t[2 - i];
    } else {
        for (int i = 0; i < 3; ++i) t[i] = cube[U][0][i];
        for (int i = 0; i < 3; ++i) cube[U][0][i] = cube[L][2 - i][0];
        for (int i = 0; i < 3; ++i) cube[L][i][0] = cube[D][2][i];
        for (int i = 0; i < 3; ++i) cube[D][2][i] = cube[R][2 - i][2];
        for (int i = 0; i < 3; ++i) cube[R][i][2] = t[i];
    }
}

void turnL(char dir) {
    rotateFace(L, dir);
    char t[3];
    if (dir == '+') {
        for (int i = 0; i < 3; ++i) t[i] = cube[U][i][0];
        for (int i = 0; i < 3; ++i) cube[U][i][0] = cube[B][2 - i][2];
        for (int i = 0; i < 3; ++i) cube[B][i][2] = cube[D][2 - i][0];
        for (int i = 0; i < 3; ++i) cube[D][i][0] = cube[F][i][0];
        for (int i = 0; i < 3; ++i) cube[F][i][0] = t[i];
    } else {
        for (int i = 0; i < 3; ++i) t[i] = cube[U][i][0];
        for (int i = 0; i < 3; ++i) cube[U][i][0] = cube[F][i][0];
        for (int i = 0; i < 3; ++i) cube[F][i][0] = cube[D][i][0];
        for (int i = 0; i < 3; ++i) cube[D][i][0] = cube[B][2 - i][2];
        for (int i = 0; i < 3; ++i) cube[B][i][2] = t[2 - i];
    }
}

void turnR(char dir) {
    rotateFace(R, dir);
    char t[3];
    if (dir == '+') {
        for (int i = 0; i < 3; ++i) t[i] = cube[U][i][2];
        for (int i = 0; i < 3; ++i) cube[U][i][2] = cube[F][i][2];
        for (int i = 0; i < 3; ++i) cube[F][i][2] = cube[D][i][2];
        for (int i = 0; i < 3; ++i) cube[D][i][2] = cube[B][2 - i][0];
        for (int i = 0; i < 3; ++i) cube[B][i][0] = t[2 - i];
    } else {
        for (int i = 0; i < 3; ++i) t[i] = cube[U][i][2];
        for (int i = 0; i < 3; ++i) cube[U][i][2] = cube[B][2 - i][0];
        for (int i = 0; i < 3; ++i) cube[B][i][0] = cube[D][2 - i][2];
        for (int i = 0; i < 3; ++i) cube[D][i][2] = cube[F][i][2];
        for (int i = 0; i < 3; ++i) cube[F][i][2] = t[i];
    }
}

void applyMove(const string &mv) {
    char f = mv[0], d = mv[1];
    switch (f) {
        case 'U': turnU(d); break;
        case 'D': turnD(d); break;
        case 'F': turnF(d); break;
        case 'B': turnB(d); break;
        case 'L': turnL(d); break;
        case 'R': turnR(d); break;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T; 
    if (!(cin >> T)) return 0;
    while (T--) {
        initCube();
        int n; cin >> n;
        for (int i = 0; i < n; ++i) {
            string mv; cin >> mv;
            applyMove(mv);
        }
        // Output U face: first line is the row adjacent to the back face (i=0)
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) cout << cube[U][i][j];
            cout << '\n';
        }
    }
    return 0;
}