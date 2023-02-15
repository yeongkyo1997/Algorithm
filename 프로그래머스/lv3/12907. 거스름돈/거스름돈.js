function solution(n, money) {
  let DP = Array.from({ length: n + 1 }, () => 0);
  money = money.sort((a, b) => a - b);
  for (let i = 0; i <= n; i++) {
    if (i % money[0] === 0) DP[i] = 1;
  }

  for (let i = 1; i < money.length; i++) {
    for (let j = money[i]; j <= n; j++) {
      DP[j] += DP[j - money[i]];
    }
  }

  answer = DP[n] % 1000000007;
  return answer;
}
