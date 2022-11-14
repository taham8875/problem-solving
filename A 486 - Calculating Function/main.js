// Calculating Function

// Link : https://codeforces.com/contest/486/problem/A

const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input;

readline.on("line", (line) => (input = parseInt(line)));
readline.on("close", () => {
  if (input % 2 == 0) {
    console.log(Math.floor(input / 2));
  } else {
    console.log(Math.floor((-1 * (input + 1)) / 2));
  }
});