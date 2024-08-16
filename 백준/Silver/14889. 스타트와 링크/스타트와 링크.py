from itertools import combinations


def calc(team, S):
    ret = 0
    for i in range(len(team)):
        for j in range(i + 1, len(team)):
            ret += S[team[i]][team[j]] + S[team[j]][team[i]]
    return ret


def dfs(N, S):
    players = range(N)
    ret = float('inf')

    for start_team in combinations(players, N // 2):
        link_team = [player for player in players if player not in start_team]

        start_ability = calc(start_team, S)
        link_ability = calc(link_team, S)

        difference = abs(start_ability - link_ability)
        ret = min(ret, difference)

        if ret == 0:
            break

    return ret


N = int(input().strip())
S = [list(map(int, input().strip().split())) for _ in range(N)]

result = dfs(N, S)
print(result)