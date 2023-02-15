let visited = [];
let answer = 0;

function solution(begin, target, words) {
  visited = Array.from({ length: words.length }, () => false);
  dfs(begin, target, words, 0);
  return answer;
}

function dfs(begin, target, words, cnt) {
  if (begin === target) {
    answer = cnt;
    return;
  }

  for (let i = 0; i < words.length; i++) {
    let k = 0;
    if (visited[i]) continue;

    for (let j = 0; j < begin.length; j++) {
      if (begin[j] === words[i][j]) k++;
    }
    if (k === begin.length - 1) {
      visited[i] = true;
      dfs(words[i], target, words, cnt + 1);
      visited[i] = false;
    }
  }
}
