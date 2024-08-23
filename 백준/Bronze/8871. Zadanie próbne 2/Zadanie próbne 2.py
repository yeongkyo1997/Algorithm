def solve(n):
    min_problems = 2 * (n + 1)
    max_problems = 3 * (n + 1)
    return min_problems, max_problems


n = int(input())
min_problems, max_problems = solve(n)
print(min_problems, max_problems)