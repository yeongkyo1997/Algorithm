let v = []; // 체크 배열
function solution(m, n, board) {
  let answer = 0;
  let copy = Array.from({ length: m }, () =>
    Array.from({ length: n }, () => 0)
  );
  for (let i = 0; i < m; i++) {
    copy[i] = board[i].split("");
  }
  let flag = true;
  while (flag) {
    v = Array.from({ length: m }, () => Array.from({ length: n }, () => false));
    flag = false;
    for (let i = 0; i < m - 1; i++) {
      for (let j = 0; j < n - 1; j++) {
        if (copy[i][j] === "_") continue; // _은 빈칸을 의미
        if (check(i, j, copy)) {
          // 2*2 체크
          v[i][j] = true;
          v[i][j + 1] = true;
          v[i + 1][j] = true;
          v[i + 1][j + 1] = true;
          flag = true;
        }
      }
    }
    answer += erase(m, n, copy);
    v = Array.from({ length: m }, () => Array.from({ length: n }, () => false));
  }
  return answer;
}
/* 2*2가 같은지 체크 */ function check(x, y, board) {
  let ch = board[x][y];

  if (
    ch === board[x][y + 1] &&
    ch === board[x + 1][y] &&
    ch === board[x + 1][y + 1]
  ) {
    return true;
  }
  return false;
}
/* 같은 블록 제거 */ function erase(m, n, board) {
  let cnt = 0;
  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (v[i][j]) board[i][j] = ".";
    }
  }
  /* 큐를 이용해 세로로 제거 작업 진행 */ for (let i = 0; i < n; i++) {
    let q = [];
    for (let j = m - 1; j >= 0; j--) {
      if (board[j][i] === ".") {
        cnt++; // 지우는 블록 카운트
      } else {
        q.push(board[j][i]);
      }
    }
    let idx = m - 1; // 삭제한 블록 위의 블록들 내리기
    // while (!q.isEmpty()) {
    while (q.length > 0) {
      board[idx--][i] = q.shift();
    } // 빈칸 채우기
    for (let j = idx; j >= 0; j--) {
      board[j][i] = "_";
    }
  }
  return cnt;
}
