import sys

sys.setrecursionlimit(1000000)
input = lambda: sys.stdin.readline().rstrip()

def main():
    N = int(input())
    prime = [True] * (N + 1)
    prime[0] = False
    prime[1] = False
    for i in range(2, int(N ** 0.5) + 1):
        if prime[i]:
            for j in range(i + i, N + 1, i):
                prime[j] = False
    prime = [i for i in range(N + 1) if prime[i]]
    result = 0
    for i in range(len(prime)):
        sum = 0
        for j in range(i, len(prime)):
            sum += prime[j]
            if sum == N:
                result += 1
                break
            elif sum > N:
                break
    print(result)

if __name__ == '__main__':
    main()