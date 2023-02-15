function solution(n) {
  let answer = Array.from({ length: parseInt((n * (n + 1)) / 2) }, () => 0); // 삼각형의 크기 ( 1 ~ n 까지 합)
  let tri = Array.from({ length: n }, () => Array.from({ length: n }, () => 0));

  let x = -1; // x 좌표
  let y = 0; // y 좌표
  let num = 1; // 달팽이 채우기 값

  for (let i = 0; i < n; i++) {
    for (let j = i; j < n; j++) {
      if (i % 3 === 0) {
        // 대각선 아래
        x++;
      } else if (i % 3 === 1) {
        // 가로
        y++;
      } else if (i % 3 === 2) {
        // 대각선 위
        x--;
        y--;
      }
      tri[x][y] = num++;
    }
  }

  let index = 0;
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (tri[i][j] === 0) break;
      answer[index++] = tri[i][j];
    }
  }

  return answer;
}
