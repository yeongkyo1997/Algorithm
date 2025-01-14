#include <bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, K; // N: 멀티탭 구멍 수, K: 전기용품 사용 횟수
    cin >> N >> K;

    vector<int> sequence(K);
    for(int i = 0; i < K; i++){
        cin >> sequence[i];
    }

    // 멀티탭에 꽂혀있는 전기용품들을 저장할 컨테이너
    vector<int> multiTap; 
    int unplugCount = 0;  // 플러그를 빼는 횟수

    for(int i = 0; i < K; i++){
        int currentDevice = sequence[i];

        // 이미 꽂혀있으면 패스
        bool isPlugged = false;
        for(int dev : multiTap){
            if(dev == currentDevice){
                isPlugged = true;
                break;
            }
        }
        if(isPlugged) continue;

        // 꽂혀있지 않고, 멀티탭에 여유 구멍이 있으면 바로 꽂음
        if((int)multiTap.size() < N){
            multiTap.push_back(currentDevice);
            continue;
        }

        // 멀티탭에 여유가 없으므로, 플러그 교체가 필요.
        // -> 앞으로 사용될 순서를 보고, 가장 멀리서 재사용되거나 더 이상 사용되지 않는 것 뽑아내기
        int indexToUnplug = -1; // 멀티탭에서 뺄 전기용품의 위치
        int furthestUse = -1;   // 가장 나중에 사용되는 인덱스

        for(int j = 0; j < (int)multiTap.size(); j++){
            int pluggedDevice = multiTap[j];
            // 앞으로 pluggedDevice가 사용되는 인덱스 찾기
            int nextUseIndex = -1;
            for(int k = i+1; k < K; k++){
                if(sequence[k] == pluggedDevice){
                    nextUseIndex = k;
                    break;
                }
            }
            // 만약 앞으로 사용되지 않는다면(nextUseIndex == -1)이 가장 우선적으로 뺄 후보
            if(nextUseIndex == -1){
                indexToUnplug = j;
                break;
            }
            // 가장 늦게 쓰이는 기기가 있다면 그 기기를 빼기 위해 업데이트
            if(nextUseIndex > furthestUse){
                furthestUse = nextUseIndex;
                indexToUnplug = j;
            }
        }

        // 결정된 기기를 멀티탭에서 제거
        multiTap[indexToUnplug] = currentDevice;
        unplugCount++;
    }

    cout << unplugCount << "\n";

    return 0;
}