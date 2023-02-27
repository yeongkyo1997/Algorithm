import sys

sys.setrecursionlimit(1000000)
input = lambda: sys.stdin.readline().rstrip()

def main():
    N = int(input())
    heights = list(map(int, input().split()))
    max_height = 0
    max_kill = 0
    for height in heights:
        if height > max_height:
            max_height = height
            kill = 0
        else:
            kill += 1
            if kill > max_kill:
                max_kill = kill
    print(max_kill)

if __name__ == '__main__':
    main()