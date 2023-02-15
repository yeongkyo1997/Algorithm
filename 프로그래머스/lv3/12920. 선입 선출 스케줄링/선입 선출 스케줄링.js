function solution(n, cores) {
  let answer = 0;

  let min = 0; // 시간의 최소값
  let max = cores[0] * n; // 시간의 최대값

  let time = 0;
  let m = 0; // time까지 처리한 작업량

  while (min <= max) {
    let mid = parseInt((min + max) / 2);

    let count = CountWork(mid, cores);

    if (count >= n) {
      // 해당시간까지 처리한 작업량보다 n이 크면 time과 m갱신
      max = mid - 1;
      time = mid;
      m = count;
    } else {
      min = mid + 1;
    }
  }

  m -= n; // 처리한 작업량과 n의 차이 갱신
  for (let i = cores.length - 1; i >= 0; i--) {
    if (time % cores[i] == 0) {
      // 시간이 time일때, 작업을 처리하는 core
      if (m == 0) {
        answer = i + 1;
        break;
      }
      m--;
    }
  }

  return answer;
}

function CountWork(time, cores) {
  if (time == 0) {
    // 시간이 0일 때, 처리할 수 있는 작업량은 코어의 개수
    return cores.length;
  }

  let count = cores.length; // 시간이 0일 때, 처리한 작업량

  for (let i = 0; i < cores.length; i++) {
    // time까지 코어가 처리할 수 있는 작업량 합산
    count += parseInt(time / cores[i]);
  }

  return count;
}
