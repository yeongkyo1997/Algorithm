// 하노이탑
function solution(n) {
  var answer = [[]]

  function hanoi(n, from, to, using) {
    if (n === 1) {
      let arr = [from, to]
      answer[0].push(arr)
      return
    }
    hanoi(n - 1, from, using, to)
    let arr = [from, to]
    answer[0].push(arr)
    hanoi(n - 1, using, to, from)
  }

  hanoi(n, 1, 3, 2)

  return answer[0]
}
