// Buy a Shovel

// Link : https://codeforces.com/contest/732/problem/A

const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input;

readline.on("line", (line) => (input = line));
readline.on("close", () => {
  input = input.split(" ").map(Number);
  let price = input[0];
  let coin = input[1];
  for (let i = 1;; i++) {
    if ((price * i) % 10 === 0 || (price * i - coin) % 10 === 0) {
      console.log(i);
      break;
    }
  }
});