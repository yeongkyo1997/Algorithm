#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <map>
#include <set>
#include <tuple> // Include tuple header

using namespace std;

typedef long long ll;

string N_str; // String representation of the input number N
int K;        // Required number of distinct digits
int L;        // Length of N

// Memoization table: map from state (idx, tight, leading_zeros, mask) to minimum suffix string ("INF" if impossible)
// idx: current digit index being processed (0 to L-1)
// tight: boolean, true if we are restricted by the digits of N, false otherwise
// leading_zeros: boolean, true if we are currently placing leading zeros
// mask: bitmask representing the set of distinct digits used so far
map<tuple<int, bool, bool, int>, string> memo;

// Function to count set bits (population count) in an integer mask
int countSetBits(int mask) {
    int count = 0;
    for (int i = 0; i < 10; ++i) {
        if ((mask >> i) & 1) {
            count++;
        }
    }
    return count;
}

// Recursive function to find the smallest number suffix satisfying the conditions
// Returns the minimum valid suffix string starting from index idx, or "INF" if impossible
string solve(int idx, bool tight, bool leading_zeros, int mask) {
    // Base case: reached the end of the number length
    if (idx == L) {
         // If we are not in a leading zeros state (number is not 0) and the number of distinct digits is exactly K, success
         // The number formed cannot be 0 since N >= 1, so leading_zeros must be false at the end.
         if (!leading_zeros && countSetBits(mask) == K) {
             return ""; // Empty suffix indicates success
         }
        return "INF"; // Otherwise, this path is invalid
    }

    // Create state tuple for memoization lookup
    tuple<int, bool, bool, int> state = {idx, tight, leading_zeros, mask};
    // Check if state already computed
    if (memo.count(state)) {
        return memo[state];
    }

    string min_found_suffix = "INF"; // Initialize minimum suffix found so far for this state

    // Determine the range of digits to try for the current position idx
    int lower_bound = tight ? (N_str[idx] - '0') : 0; // If tight, minimum digit is N_str[idx], else 0
    int upper_bound = 9; // Maximum digit is always 9

    for (int d = lower_bound; d <= upper_bound; ++d) {
        
        // Determine the 'tight' constraint for the next state
        bool next_tight = tight && (d == (N_str[idx] - '0')); 
        // Determine if we are still placing leading zeros
        bool next_leading_zeros = leading_zeros && (d == 0);
        
        // If placing 0 at the last position while still in leading_zeros state, this would form the number 0.
        // Since N >= 1, the result M must be >= 1. So this path is invalid.
        if (next_leading_zeros && idx == L - 1) {
             continue; 
        }

        // Update the mask of used digits. Don't include digit if it's a leading zero.
        int next_mask = mask;
        if (!next_leading_zeros) {
            next_mask |= (1 << d);
        }

        // Count distinct digits used based on the updated mask
        int current_distinct_count = countSetBits(next_mask);
        
        // Pruning check 1: If more than K distinct digits used, this path is invalid
        if (current_distinct_count > K) continue;

        int remaining_len = L - (idx + 1); // Number of remaining positions to fill

        // Calculate effective count: if leading zeros, effective count is 0, otherwise it's the popcount
        int effective_count = next_leading_zeros ? 0 : current_distinct_count;
        
        // Pruning check 2: Check if it's possible to reach exactly K distinct digits
        // Maximum distinct digits possible = current effective count + min(remaining length, available new digits)
        int max_possible_distinct = effective_count + min(remaining_len, 10 - effective_count);
        if (max_possible_distinct < K) continue;


        string current_suffix_res = "INF"; // Initialize suffix result for trying digit 'd'

        // If the 'tight' constraint is released (we chose d > N_str[idx] or were already not tight)
        if (!next_tight) { 
             // Compute the smallest possible suffix greedily
             int needed = K - current_distinct_count; // Number of new distinct digits needed
             
             // This check needs refinement based on effective count
             int effective_needed = K - effective_count;
             if (effective_needed < 0) effective_needed = 0; // Cannot need negative digits

             if (remaining_len < effective_needed) continue; // Not enough remaining positions to introduce needed distinct digits


             string suffix = ""; // The greedily constructed suffix string
             if (effective_count == K) { // Already have K distinct digits effectively
                 int fill_digit = 0; 
                 // If mask is non-zero, find the smallest digit present
                  if (effective_count > 0) {
                     for(int digit=0; digit<10; ++digit) {
                         if((next_mask >> digit) & 1) {
                             fill_digit = digit; break;
                         }
                     }
                 } 
                 // Fill remaining positions with the smallest used digit
                 for(int i=0; i<remaining_len; ++i) suffix += to_string(fill_digit);

             } else { // Need effective_needed more distinct digits
                 int fill_len = remaining_len - effective_needed; // Number of positions to fill with the smallest available digit
                 
                 set<int> new_digits; // Set to store the smallest required new digits
                 int count_added = 0;
                 // Find the smallest 'effective_needed' digits not present in next_mask
                 for(int digit=0; digit<10 && count_added < effective_needed; ++digit) {
                     if(!((next_mask >> digit) & 1)) { 
                         new_digits.insert(digit);
                         count_added++;
                     }
                 }

                 // Determine the overall smallest digit available (either in mask or among new required digits)
                 int overall_smallest = -1;
                 if ((next_mask >> 0) & 1 || new_digits.count(0)) { // Check if 0 is available
                      overall_smallest = 0;
                 } else { // 0 not available, find smallest digit > 0
                      for(int digit=1; digit<10; ++digit) {
                          if (((next_mask >> digit) & 1) || new_digits.count(digit)) {
                              overall_smallest = digit; break;
                          }
                      }
                 }
                 // If overall_smallest is still -1 (e.g. mask=0, new digits don't include 0), use smallest from new_digits
                 if (overall_smallest == -1) { 
                    if (!new_digits.empty()) overall_smallest = *new_digits.begin(); 
                    // If new_digits is also empty, means effective_needed=0, handled by `effective_count == K` case.
                 }

                 // Construct the suffix: fill 'fill_len' positions with smallest digit, then append new required digits sorted
                 for(int i=0; i<fill_len; ++i) suffix += to_string(overall_smallest);
                 for(int new_digit : new_digits) suffix += to_string(new_digit);
             }
             current_suffix_res = suffix; // Store the constructed greedy suffix

        } else { // Still tight, need to make recursive call for the next position
             current_suffix_res = solve(idx + 1, next_tight, next_leading_zeros, next_mask);
        }

        // If a valid suffix was found (either greedily or recursively)
        if (current_suffix_res != "INF") {
             // Combine the current digit 'd' with the found suffix
             string combined_suffix = string(1, d + '0') + current_suffix_res; 
             // If this is the first valid suffix found OR it's lexicographically smaller than the best found so far
             if (min_found_suffix == "INF" || combined_suffix < min_found_suffix) {
                 min_found_suffix = combined_suffix;
             }
             // Optimization: Since we iterate 'd' in increasing order, the first valid suffix found leads to the minimum number.
             // Store the result in memo and return immediately.
              memo[state] = min_found_suffix; 
              return min_found_suffix; 
        }
    }
    
    // After trying all possible digits 'd' for the current position, store and return the best suffix found (or INF)
    return memo[state] = min_found_suffix; 
}

int main() {
    // Faster I/O
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    ll n_val; // Input number N
    cin >> n_val >> K; // Read N and K
    N_str = to_string(n_val); // Convert N to string
    L = N_str.length(); // Get length of N

    // Call the recursive function starting from index 0
    string result = solve(0, true, true, 0);

    // If solve returned "INF", no number of length L satisfies the condition.
    // We need to find the smallest number of length L+1 (or greater if needed) with K distinct digits.
    if (result == "INF") {
        int target_len = L + 1; // Start checking from length L+1
        // The minimal possible length for a number with K distinct digits is K (if K>1), or 1 (if K=1).
        // If L+1 is less than K, the target length must be at least K.
        if (target_len < K && K > 1) { 
             target_len = K; 
        } else if (target_len == 0) { // Should not happen as N >= 1 implies L >= 1
             target_len = 1;
        }

        if (K == 1) { // Smallest number with 1 distinct digit
             result = "";
             // Smallest number of target_len consisting of one digit is '1' repeated target_len times.
             for(int i=0; i < target_len; ++i) result += '1';
        } else { // K >= 2
             // Construct the smallest number of length target_len using K distinct digits {0, 1, ..., K-1}
             result = "1"; // Smallest number must start with 1
             // Number of zeros to place after '1' before placing other required digits
             int num_zeros_prefix = target_len - K; 
             for(int i=0; i<num_zeros_prefix; ++i) result += '0';
             
             // Define the set of required digits besides '1': {0, 2, ..., K-1}
             set<int> required_new_digits; 
             required_new_digits.insert(0); // Digit 0 is required
             for(int i=2; i<K; ++i) required_new_digits.insert(i); // Digits 2 to K-1 are required
             
             // Append the required digits in increasing order to minimize the number
             for(int digit : required_new_digits) {
                 result += to_string(digit);
             }
        }
    }

    // Print the final result
    cout << result << endl;

    return 0;
}