#include <bits/stdc++.h>
#include <ctime>
using namespace std;

int main(){
    // 현재 시간을 time_t 타입으로 가져오기
    time_t t = time(NULL);
    
    // time_t를 UTC 시간대로 변환
    struct tm *gmt = gmtime(&t);
    
    // 연도, 월, 일을 출력 (연도는 1900을 더해 실제 연도로 변환)
    printf("%04d\n%02d\n%02d\n", 1900 + gmt->tm_year, gmt->tm_mon + 1, gmt->tm_mday);
    
    return 0;
}