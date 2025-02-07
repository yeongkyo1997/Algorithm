#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdlib>
using namespace std;
 
// 점을 표현하는 구조체
struct Point {
    int x, y;
};
 
// 정렬 기준: x좌표가 작으면 우선, 같으면 y좌표가 작은 순
bool cmp(const Point &a, const Point &b) {
    if(a.x == b.x)
        return a.y < b.y;
    return a.x < b.x;
}
 
// 벡터 OA와 OB의 외적 (O, A, B는 점)
long long cross(const Point &O, const Point &A, const Point &B) {
    return (long long)(A.x - O.x) * (B.y - O.y) - (long long)(A.y - O.y) * (B.x - O.x);
}
 
// 두 점 사이의 제곱 거리 계산
long long distSq(const Point &a, const Point &b) {
    long long dx = a.x - b.x;
    long long dy = a.y - b.y;
    return dx*dx + dy*dy;
}
 
int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int N;
    cin >> N;
    vector<Point> pts(N);
    for (int i = 0; i < N; i++){
        cin >> pts[i].x >> pts[i].y;
    }
    
    // 기둥이 한 개이면 최대 거리 0
    if(N == 1){
        cout << 0;
        return 0;
    }
    
    // Monotone Chain 알고리즘으로 볼록 껍질 구하기
    sort(pts.begin(), pts.end(), cmp);
    vector<Point> hull;
    // lower hull 구성
    for (int i = 0; i < N; i++){
        while(hull.size() >= 2 && cross(hull[hull.size()-2], hull[hull.size()-1], pts[i]) <= 0)
            hull.pop_back();
        hull.push_back(pts[i]);
    }
    // upper hull 구성
    for (int i = N - 2, t = hull.size() + 1; i >= 0; i--){
        while(hull.size() >= t && cross(hull[hull.size()-2], hull[hull.size()-1], pts[i]) <= 0)
            hull.pop_back();
        hull.push_back(pts[i]);
    }
    // 시작점이 중복되므로 제거
    hull.pop_back();
    
    int m = hull.size();
    if(m == 1){
        cout << 0;
        return 0;
    }
    if(m == 2){
        cout << distSq(hull[0], hull[1]);
        return 0;
    }
    
    // 회전하는 캘리퍼스(Rotating Calipers) 기법으로 최대 제곱 거리 구하기
    long long ans = 0;
    int j = 1;
    for (int i = 0; i < m; i++){
        // 현재 변 (hull[i] -> hull[(i+1)%m])에 대해, j를 옮기며 면적(외적 값)이 증가하는 한 계속 이동
        while ( abs(cross(hull[i], hull[(i+1)%m], hull[(j+1)%m]))
                > abs(cross(hull[i], hull[(i+1)%m], hull[j])) )
            j = (j + 1) % m;
        ans = max(ans, distSq(hull[i], hull[j]));
        ans = max(ans, distSq(hull[(i+1)%m], hull[j]));
    }
    
    cout << ans << "\n";
    return 0;
}