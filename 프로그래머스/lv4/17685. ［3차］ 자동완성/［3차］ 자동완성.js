class Trie {
  constructor(node) {
    this.node = node;
  }

  insert(word) {
    let node = this.node;

    for (let i = 0; i < word.length; i++) {
      let val = node.children.get(word[i]);
      if (val == null) {
        val = new Node();
        node.children.set(word[i], val);
      }
      node.count++;
      node = node.children.get(word[i]);
    }
    let val2 = node.children.get("*");
    if (val2 == null) {
      val2 = new Node();
      node.children.set("*", val2);
    }
    node.count++;
  }

  count(word) {
    let node = this.node;
    let cnt = 0;
    for (let i = 0; i < word.length; i++) {
      cnt++;
      if (node.children.get(word[i]).count > 1) {
        node = node.children.get(word[i]);
      } else {
        break;
      }
    }
    return cnt;
  }
}
class Node {
  constructor() {
    this.children = new Map();
    this.count = 0;
  }
}

let root = new Trie(new Node());

function solution(words) {
  let answer = 0;
  for (let word of words) {
    root.insert(word);
  }
  for (let word of words) {
    answer += root.count(word);
  }
  return answer;
}
