import sys

def main():
    data = sys.stdin.read().split()
    it = iter(data)
    n = int(next(it))
    # 재료의 맛 수치 리스트 (0-indexed)
    T = [int(next(it)) for _ in range(n)]
    q = int(next(it))
    queries = [ (int(next(it)), int(next(it))) for _ in range(q) ]
    
    NEG_INF = -1000  # dp상 불가능한 값을 대신함 (최대 재료 개수 최대 500이므로 충분)

    # 미리 각 t(0~511)에 대해, mapping_table[t][x] = x XOR t 를 계산해둔다.
    mapping_table = [ [ (x ^ t) for x in range(512) ] for t in range(512) ]
    
    # answers[l][r]에 구간 [l, r] (0-indexed) 에 대한 최대 맛을 저장
    ans = [[0] * n for _ in range(n)]
    rng = range(512)  # 내부 loop에서 사용할 range; 512는 상수
    
    # 모든 시작 위치 l에 대해 오른쪽 구간 [l, r]에 대해 dp 갱신
    for l in range(n):
        # dp 초기화: dp[x] = 재료를 선택해 XOR 결과가 x가 될 때 최대 몇 개를 사용했는지
        dp = [NEG_INF] * 512
        dp[0] = 0  # 아무것도 선택하지 않은 경우
        for r in range(l, n):
            t = T[r]
            m = mapping_table[t]
            old_dp = dp[:]  # dp업데이트는 "병렬적"(이전 dp 상태 사용)으로 진행됨
            # dp 업데이트: 각 x에 대해 new_dp[x] = max( old_dp[x], old_dp[x XOR t] + 1 )
            dp = [ old_dp[i] if old_dp[i] >= old_dp[m[i]] + 1 else old_dp[m[i]] + 1 for i in rng ]
            # 현재 dp 상태에서 최댓 맛 = max(x + dp[x]) for x=0..511
            best = -10000
            for i in rng:
                v = dp[i] + i
                if v > best:
                    best = v
            ans[l][r] = best

    # 쿼리 처리(입력은 1-indexed이므로 변환)
    out_lines = []
    for l, r in queries:
        out_lines.append(str(ans[l-1][r-1]))
    sys.stdout.write("\n".join(out_lines))
    
if __name__ == "__main__":
    main()
