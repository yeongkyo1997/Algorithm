// N-Queen
function solution(n) {
  let answer = 0
  let board = []
  let col = []

  for (let i = 0; i < n; i++) {
    board[i] = []
    col[i] = 0
    for (let j = 0; j < n; j++) {
      board[i][j] = 0
    }
  }

  function check(row, col) {
    for (let i = 0; i < row; i++) {
      if (board[i][col] == 1) {
        return false
      }
    }
    for (let i = row, j = col; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 1) {
        return false
      }
    }
    for (let i = row, j = col; i >= 0 && j < n; i--, j++) {
      if (board[i][j] == 1) {
        return false
      }
    }
    return true
  }

  function solve(row) {
    if (row == n) {
      answer++
      return
    }
    for (let i = 0; i < n; i++) {
      if (check(row, i)) {
        board[row][i] = 1
        col[row] = i
        solve(row + 1)
        board[row][i] = 0
      }
    }
  }

  solve(0)
  return answer
}
