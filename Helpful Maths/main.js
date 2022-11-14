// Helpful Maths

// Link : https://codeforces.com/contest/339/problem/A

const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input;

readline.on("line", (line) => (input = line));
readline.on("close", () => {
  input = input.split("+").map(Number);
  input.sort((a, b) => a - b);
  console.log(input.join("+"));
});