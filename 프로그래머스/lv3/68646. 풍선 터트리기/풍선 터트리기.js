function solution(a) {
  let leftMin = new Array(a.length).fill(0);
  let rightMin = new Array(a.length).fill(0);
  let l = a[0]; //왼쪽 값 중 최소값
  let r = a[a.length - 1]; //오른쪽 값 중 최소값

  //i일때 왼쪽 원소의 최소값을 저장
  for (let i = 1; i < a.length - 1; i++) {
    if (l > a[i]) l = a[i];
    leftMin[i] = l;
  }
  //i일때 오른쪽 원소의 최소값을 저장
  for (let i = a.length - 2; i > 0; i--) {
    if (r > a[i]) r = a[i];
    rightMin[i] = r;
  }

  if (a.length == 1) return 1; //원소가 1개면 답은 1이다.
  let answer = 2; // 반환할 값. 원소가 2개 이상일때 무조건 2개 이상은 남게된다.
  for (let i = 1; i <= a.length - 2; i++) {
    if (a[i] > leftMin[i] && a[i] > rightMin[i]) continue;
    answer++;
  }
  return answer;
}
