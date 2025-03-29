import sys

def main():
    input = sys.stdin.read().split()
    ptr = 0
    N = int(input[ptr])
    ptr += 1
    T = list(map(int, input[ptr:ptr + N]))
    ptr += N
    Q = int(input[ptr])
    ptr += 1
    queries = []
    for _ in range(Q):
        l = int(input[ptr])
        r = int(input[ptr + 1])
        queries.append((l - 1, r - 1))  # Convert to 0-based indices
        ptr += 2
    
    # Precompute dp_precomp
    dp_precomp = [[None for _ in range(N)] for _ in range(N)]
    for l in range(N):
        current_dp = [-1] * 512
        current_dp[0] = 0  # Base case: empty subset
        for r in range(l, N):
            new_dp = current_dp.copy()
            t = T[r]
            for x in range(512):
                if current_dp[x] != -1:
                    new_x = x ^ t
                    new_size = current_dp[x] + 1
                    if new_dp[new_x] < new_size:
                        new_dp[new_x] = new_size
            dp_precomp[l][r] = new_dp
            current_dp = new_dp
    
    # Process each query
    for l, r in queries:
        dp = dp_precomp[l][r]
        max_val = 0
        for x in range(512):
            if dp[x] != -1:
                max_val = max(max_val, x + dp[x])
        print(max_val)

if __name__ == "__main__":
    main()