def safe_squares(T, test_cases):
    res = []
    for t in range(T):
        R, C, K = test_cases[t][0]
        monster_positions = test_cases[t][1]
        grid = [[0 for _ in range(C)] for _ in range(R)]

        for r, c in monster_positions:
            grid[r][c] = 1

        count = 0
        for d in range(1, min(R, C) + 1):
            for r in range(R - d + 1):
                for c in range(C - d + 1):
                    is_safe = True
                    for i in range(r, r + d):
                        for j in range(c, c + d):
                            if grid[i][j] == 1:
                                is_safe = False
                                break
                        if not is_safe:
                            break
                    if is_safe:
                        count += 1
        res.append(count)

    return res


def main():
    T = int(input().strip())
    test_cases = []
    for _ in range(T):
        R, C, K = map(int, input().strip().split())
        monster_positions = [tuple(map(int, input().strip().split())) for _ in range(K)]
        test_cases.append(((R, C, K), monster_positions))

    results = safe_squares(T, test_cases)

    for i, result in enumerate(results):
        print(f"Case #{i + 1}: {result}")


if __name__ == "__main__":
    main()