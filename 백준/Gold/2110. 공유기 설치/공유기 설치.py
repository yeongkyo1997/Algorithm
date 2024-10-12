import sys

input = lambda: sys.stdin.readline().rstrip()

if __name__ == '__main__':
    N, C = map(int, input().split())

    arr = [int(input()) for _ in range(N)]
    arr.sort()
    start = 1
    end = arr[-1] - arr[0]

    result = 0

    while (start <= end):
        # 가장 가까운 공유기 사이의 최대 거리(최대 거리이기 때문에 lower bound를 사용해야한다.
        mid = start + end >> 1
        # 현재 가장 가까운 공유기
        cur = arr[0]
        # 선택된 공유기의 개수
        cnt = 1

        for i in range(1, N):
            # 가장 가까운 공유기의 거리와 같거나 크다면 공유기 개수 증가
            if arr[i] - cur >= mid:
                cnt += 1
                cur = arr[i]

        if cnt >= C:
            start = mid + 1
            result = mid
        elif cnt < C:
            end = mid - 1

    print(result)