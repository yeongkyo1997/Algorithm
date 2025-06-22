#include <iostream>
#include <vector>
#include <numeric>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);

    int n;
    std::cin >> n;

    std::vector<int> switches(n);
    for (int i = 0; i < n; ++i) {
        std::cin >> switches[i];
    }

    int num_students;
    std::cin >> num_students;

    for (int student_idx = 0; student_idx < num_students; ++student_idx) {
        int gender, number;
        std::cin >> gender >> number;

        if (gender == 1) { // Male student
            // Toggle switches that are multiples of 'number'
            // Switch numbers are 1-based, vector indices are 0-based.
            // For switch number 's', its index is 's-1'.
            // A switch 'i+1' is a multiple of 'number' if (i+1) % number == 0.
            for (int i = number - 1; i < n; i += number) {
                switches[i] = 1 - switches[i]; // Toggle state
            }
        } else { // Female student
            // Find the longest symmetric segment centered at 'number'
            int center_idx = number - 1;
            
            int left = center_idx;
            int right = center_idx;
            
            // Expand outwards from the center
            for (int k = 1; ; ++k) {
                int l_idx = center_idx - k;
                int r_idx = center_idx + k;

                // Check if indices are within bounds and if states are symmetric
                if (l_idx >= 0 && r_idx < n && switches[l_idx] == switches[r_idx]) {
                    left = l_idx;
                    right = r_idx;
                } else {
                    // Symmetry broken or out of bounds, stop expanding
                    break;
                }
            }

            // Toggle switches within the identified symmetric segment [left, right]
            for (int i = left; i <= right; ++i) {
                switches[i] = 1 - switches[i]; // Toggle state
            }
        }
    }

    // Print the final state of switches
    for (int i = 0; i < n; ++i) {
        std::cout << switches[i] << (i == n - 1 ? "" : " "); // Print space unless it's the last element
        
        // Print a newline after every 20 switches, but not after the very last switch
        if ((i + 1) % 20 == 0 && i != n - 1) {
            std::cout << "\n";
        }
    }
    std::cout << "\n"; // Ensure there is a trailing newline at the end of the output

    return 0;
}