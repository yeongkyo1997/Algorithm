#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

// -------------------------------------------
// 전역 혹은 정적 크기로 잡을 분포 배열 최대 크기 설정
// n 최대 10, A 혹은 B 각각 n/2 = 5개의 주사위를 가질 수 있음
// 각 주사위 면의 값 최대 100, 즉 5개면 최대 합 500
// 여유 있게 3001 정도까지 할당
#define MAX_SUM 3000

// -------------------------------------------
// 주사위 합 분포를 계산하는 함수
// subsetDice[]: 부분집합에 포함된 주사위 인덱스 배열
// subsetSize: 부분집합 크기 (n/2)
// dice: 주어진 주사위 정보 (dice_rows x 6)
// dice_rows: 주사위 개수 n
// freq[]: 결과로 얻을 분포 배열(0 ~ MAX_SUM까지)
// -------------------------------------------
void buildDistribution(int *subsetDice, int subsetSize, int **dice, int dice_rows, long long *freq) {
    // freq 초기화
    memset(freq, 0, sizeof(long long) * (MAX_SUM + 1));
    
    // 시작: 아무 주사위도 사용하지 않았을 때 sum=0을 만들 수 있는 경우는 1가지
    freq[0] = 1;

    // 부분집합 내 주사위들을 하나씩 반영하며 분포를 업데이트(합성)한다
    for(int i = 0; i < subsetSize; i++){
        int dieIndex = subsetDice[i];
        // 각 주사위에 쓰인 6개 값을 불러온다
        int faces[6];
        for(int f = 0; f < 6; f++){
            faces[f] = dice[dieIndex][f];
        }

        // 임시 분포 배열 (이번 주사위 적용 후)
        static long long temp[MAX_SUM + 1];
        memset(temp, 0, sizeof(temp));

        // 현재 freq에 있는 모든 합에 대해
        for(int sumVal = 0; sumVal <= MAX_SUM; sumVal++){
            long long countHere = freq[sumVal];
            if(countHere > 0){
                // 이번 주사위의 각 면(face)만큼 더해진 합으로 분포 누적
                for(int f = 0; f < 6; f++){
                    int newSum = sumVal + faces[f];
                    if(newSum <= MAX_SUM){
                        temp[newSum] += countHere;
                    }
                }
            }
        }
        // temp를 freq로 복사
        memcpy(freq, temp, sizeof(temp));
    }
}

// -------------------------------------------
// A의 분포 freqA, B의 분포 freqB가 있을 때,
// A가 이기는 총 경우의 수를 계산
// 최대합이 얼마까지인지 알아야 하므로, 전체적으로 가능한 maxSum까지 탐색
// -------------------------------------------
long long countWins(long long *freqA, long long *freqB) {
    // B의 분포 누적합(prefix) 계산
    static long long prefixB[MAX_SUM + 1];
    long long running = 0;
    for(int i = 0; i <= MAX_SUM; i++){
        running += freqB[i];
        prefixB[i] = running;
    }

    // A가 이기는 경우: sumA > sumB
    // sumA = i, sumB = j
    // freqA[i] * (B가 0 ~ i-1인 freqB 합)
    long long wins = 0;
    for(int i = 1; i <= MAX_SUM; i++){
        if(freqA[i] == 0) continue;
        // B가 i-1 이하인 부분의 합
        long long lessThanA = prefixB[i-1]; 
        wins += freqA[i] * lessThanA;
    }
    return wins;
}

// -------------------------------------------
// combination 함수를 통해서 A가 가질 주사위(subset)를 고른다
// n개 중 n/2개를 고르는 모든 조합을 확인하여, 승리 확률(= 승리 횟수) 가장 큰 조합을 찾는다
// -------------------------------------------
int* solution(int** dice, size_t dice_rows, size_t dice_cols) {
    int n = (int)dice_rows;     // 주사위 개수
    int half = n / 2;           // A 혹은 B가 가질 주사위 수

    // 최적 조합을 저장할 배열 동적 할당
    // 문제에서 "승리 확률이 가장 높은 주사위 조합은 유일"하다고 했으므로
    // 여기에 최종적으로 그 조합을 저장
    int* answer = (int*)malloc(sizeof(int) * half);

    // 전체 경우의 수를 셀 때 6^n 이지만,
    // '승리 횟수'를 직접 비교하는 것으로 충분(= 더 많이 이기는 조합이 승률이 큰 조합)

    // 최대 승리 횟수(또는 그에 상응하는 확률)를 추적
    long long bestWins = -1;

    // 부분집합 선택을 위해 비트마스크 방식 활용( n <= 10 이므로 2^10 = 1024 )
    // 각 비트마스크에서 1의 개수가 half인 경우만 유효
    int totalMask = 1 << n;  // 2^n
    for(int mask = 0; mask < totalMask; mask++){
        // 현재 mask에서 켜진 비트(=선택된 주사위)가 half개인지 검사
        // popcount(마스크 내 1의 개수)
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(mask & (1 << i)){
                cnt++;
            }
        }
        if(cnt != half) continue; // A가 가져갈 주사위 수와 다르면 패스

        // A가 갖는 주사위 목록, B가 갖는 주사위 목록 만들기
        static int subsetA[10], subsetB[10];
        int idxA = 0, idxB = 0;
        for(int i = 0; i < n; i++){
            if(mask & (1 << i)){
                subsetA[idxA++] = i;
            } else {
                subsetB[idxB++] = i;
            }
        }

        // 분포 배열 준비
        static long long freqA[MAX_SUM + 1];
        static long long freqB[MAX_SUM + 1];
        memset(freqA, 0, sizeof(freqA));
        memset(freqB, 0, sizeof(freqB));

        // A 분포 구하기
        buildDistribution(subsetA, half, dice, n, freqA);
        // B 분포 구하기
        buildDistribution(subsetB, half, dice, n, freqB);

        // A가 이기는 경우의 수 계산
        long long wins = countWins(freqA, freqB);

        // 최적이면 갱신
        if(wins > bestWins){
            bestWins = wins;
            // 현재 선택된 subsetA를 오름차순(문제에서 주사위 번호는 1부터이므로 +1 처리)
            // answer에 저장
            // subsetA 안은 인덱스(0부터 시작)들이 들어 있으니, +1 하여 1-based로 저장
            // 그리고 오름차순 정렬
            // idxA == half
            // 정렬
            for(int i = 0; i < half - 1; i++){
                for(int j = i+1; j < half; j++){
                    if(subsetA[i] > subsetA[j]){
                        int temp = subsetA[i];
                        subsetA[i] = subsetA[j];
                        subsetA[j] = temp;
                    }
                }
            }
            for(int i = 0; i < half; i++){
                answer[i] = subsetA[i] + 1; 
            }
        }
    }

    return answer;
}
