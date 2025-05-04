#include <iostream>
#include <vector>
#include <cmath>
#include <iomanip>

using namespace std;

// Cross product of a and b, result in c
void cross(const double a[3], const double b[3], double c[3]) {
    c[0] = a[1]*b[2] - a[2]*b[1];
    c[1] = a[2]*b[0] - a[0]*b[2];
    c[2] = a[0]*b[1] - a[1]*b[0];
}

// Dot product of a and b
double dot(const double a[3], const double b[3]) {
    return a[0]*b[0] + a[1]*b[1] + a[2]*b[2];
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    // 축 벡터 h, v
    double h[3], v[3];
    // 법선 벡터 n = h × v
    double nrm[3];

    // 부동소수점 오차 허용치
    const double EPS = 1e-9;

    // 입력 개수
    cin >> n;
    // 축 벡터 입력
    for (int i = 0; i < 3; i++) cin >> h[i];
    for (int i = 0; i < 3; i++) cin >> v[i];

    // 법선 벡터 계산
    cross(h, v, nrm);

    // h, v 크기의 제곱
    double H2 = dot(h, h);
    double V2 = dot(v, v);

    int hits = 0;
    // 다트 하나씩 처리
    for (int i = 0; i < n; i++) {
        double p[3], d[3];
        for (int j = 0; j < 3; j++) cin >> p[j];
        for (int j = 0; j < 3; j++) cin >> d[j];

        double nd = dot(nrm, d);
        double np = dot(nrm, p);

        // 1) 평면과 교차하는 경우
        if (fabs(nd) > EPS) {
            double t = -np / nd;
            if (t < 0) continue;  // 뒤로 가므로 놓침
            // 교차점 좌표 x = p + t d
            double x[3];
            for (int j = 0; j < 3; j++) x[j] = p[j] + t * d[j];
            // 타원 좌표계(u, w) 계산
            double ph = dot(x, h) / H2;
            double pv = dot(x, v) / V2;
            // 타원 내부 판정
            if (ph*ph + pv*pv <= 1.0 + EPS) hits++;
        }
        // 2) 평면에 평행하거나 내에 있는 경우
        else {
            // 평면과 평행하지만 다른 위치 -> 교차 없음
            if (fabs(np) > EPS) continue;

            // 직선이 평면 위에 놓임 -> 2차 방정식으로 타원 교차 판정
            double ph = dot(p, h);
            double pv = dot(p, v);
            double dh = dot(d, h);
            double dv = dot(d, v);

            // u(t) = (ph + t dh)/H2, w(t) = (pv + t dv)/V2
            // f(t) = u(t)^2 + w(t)^2 - 1 <= 0 판단
            double A = dh*dh/(H2*H2) + dv*dv/(V2*V2);
            double B = 2.0*(ph*dh/(H2*H2) + pv*dv/(V2*V2));
            double C = ph*ph/(H2*H2) + pv*pv/(V2*V2) - 1.0;

            // 2-1) 2차항이 0이면 1차 또는 상수
            if (fabs(A) < EPS) {
                // 1차항도 0 이면 상수 부등식
                if (fabs(B) < EPS) {
                    if (C <= 0.0) hits++;  // p가 타원 내부 -> 즉시 히트
                } else {
                    // B t + C <= 0 의 해 검토
                    // B>0: t <= -C/B, B<0: t >= -C/B
                    if (B > 0) {
                        if (-C/B >= 0.0) hits++;
                    } else {
                        // B<0 이면 충분히 큰 t에서 항상 만족
                        hits++;
                    }
                }
            }
            // 2-2) 일반 2차 방정식
            else {
                double D = B*B - 4.0*A*C;
                if (D < 0.0) continue;  // 허근 -> 교차 없음
                double sqrtD = sqrt(D);
                // 두 근 t1<=t2
                double t2 = (-B + sqrtD) / (2.0 * A);
                // t2 >= 0 이면 t>=0 구간과 겹침
                if (t2 >= 0.0) hits++;
            }
        }
    }

    // 결과 출력
    cout << hits << "\n";
    return 0;
}
