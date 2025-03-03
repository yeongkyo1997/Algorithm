#include <iostream>
#include <vector>
using namespace std;

int toMinutes(int time) {
    int hour = time / 100;
    int minute = time % 100;
    return hour * 60 + minute;
}

int solution(vector<int> schedules, vector<vector<int>> timelogs, int startday) {
    int answer = 0;
    int n = schedules.size();  

    for (int i = 0; i < n; i++) {
        int allowed = toMinutes(schedules[i]) + 10;
        bool qualifies = true;
        
        for (int j = 0; j < 7; j++) {
            int dayOfWeek = ((startday - 1 + j) % 7) + 1;
            
            if (dayOfWeek >= 1 && dayOfWeek <= 5) {
                int arrival = toMinutes(timelogs[i][j]);
                if (arrival > allowed) {
                    qualifies = false;
                    break;
                }
            }
        }
        
        if (qualifies) answer++;
    }
    
    return answer;
}