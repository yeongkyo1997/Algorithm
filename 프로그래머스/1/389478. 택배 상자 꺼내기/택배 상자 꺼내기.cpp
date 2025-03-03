#include <string>
#include <vector>
#include <cmath> 
using namespace std;

int solution(int n, int w, int num) {
    int target_row = (num - 1) / w;
    int pos = (num - 1) % w;
    int col;
    if (target_row % 2 == 0) {
        col = pos;
    } else {
        col = w - 1 - pos;
    }
    
    int total_rows = (n + w - 1) / w;

    int removed = 1; 

    for (int r = target_row + 1; r < total_rows; r++) {
        if (r == total_rows - 1) {
            int last_row_count = (n % w == 0 ? w : n % w);
            if (r % 2 == 0) {
                if (col < last_row_count) {
                    removed++;
                }
            } else {
                if (col >= w - last_row_count) {
                    removed++;
                }
            }
        } else {
            removed++;
        }
    }
    
    return removed;
}
