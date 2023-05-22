def input_data():
    global N
    N = int(input())

def solution():
    DP = [0] * 110
    DP[1] = DP[2] = DP[3] = 1
    DP[4] = DP[5] = 2
    
    for i in range(6, N + 1):
        DP[i] = DP[i - 1] + DP[i - 5]
    
    print(DP[N])

def solve():
    Tc = int(input())
    for _ in range(Tc):
        input_data()
        solution()

def main():
    solve()

if __name__ == "__main__":
    main()