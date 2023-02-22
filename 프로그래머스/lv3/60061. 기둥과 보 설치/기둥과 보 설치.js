let arr = Array.from({ length: 101 }, () =>
  Array.from({ length: 101 }, () => [0, 0])
);
let N;

function install_item(x, y, a) {
  if (a == 0) {
    // 기둥 설치
    if (y == 0) return true; // 바닥위에 있거나
    if (x > 0 && arr[x - 1][y][1]) return true; // 보의 오른쪽 끝 위
    if (y < N && arr[x][y][1]) return true; // 보의 왼쪽 끝 위
    if (y > 0 && arr[x][y - 1][0]) return true; // 다른 기둥 위
  } else {
    // 보 설치
    if (y > 0 && arr[x][y - 1][0]) return true; // 왼쪽 끝 아래 기둥
    if (x < N && y > 0 && arr[x + 1][y - 1][0]) return true; // 오른쪽 끝 아래 기둥
    if (x > 0 && x < N && arr[x - 1][y][1] && arr[x + 1][y][1]) return true; // 양쪽 끝 부분 다른 보
  }
  return false;
}

function remove_item(x, y, a) {
  arr[x][y][a] = 0;

  if (a == 0) {
    // 기둥 삭제
    // 위에 기둥 있을 때, 설치 가능?
    if (y < N && arr[x][y + 1][0] && !install_item(x, y + 1, 0)) return false;

    // 위에 보 있을 때, 설치 가능?
    if (y < N && arr[x][y + 1][1] && !install_item(x, y + 1, 1)) return false;
    if (
      x > 0 &&
      y < N &&
      arr[x - 1][y + 1][1] &&
      !install_item(x - 1, y + 1, 1)
    )
      return false;
  } else {
    // 위에 기둥 있을 때, 설치 가능?
    if (arr[x][y][0] && !install_item(x, y, 0)) return false;
    if (x < N && arr[x + 1][y][0] && !install_item(x + 1, y, 0)) return false;

    // 다른 보와 연결되어 있을 때, 설치 가능?
    if (x > 0 && arr[x - 1][y][1] && !install_item(x - 1, y, 1)) return false;
    if (x < N && arr[x + 1][y][1] && !install_item(x + 1, y, 1)) return false;
  }

  return true;
}

function solution(n, build_frame) {
  N = n;
  let answer = [];

  for (let frame of build_frame) {
    let x = frame[0];
    let y = frame[1];
    let a = frame[2];
    let b = frame[3];

    if (b == 0) {
      if (!remove_item(x, y, a)) arr[x][y][a] = 1;
    } else {
      if (install_item(x, y, a)) arr[x][y][a] = 1;
    }
  }

  for (let i = 0; i <= n; ++i) {
    for (let j = 0; j <= n; ++j) {
      if (arr[i][j][0]) answer.push([i, j, 0]);
      if (arr[i][j][1]) answer.push([i, j, 1]);
    }
  }

  return answer;
}
