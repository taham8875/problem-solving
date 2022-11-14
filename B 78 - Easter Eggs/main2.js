// Easter Eggs

// Link : https://codeforces.com/contest/78/problem/B

const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input;

readline.on("line", (line) => (input = line));
readline.on("close", () => {
  let colors = "ROYGBIV";
  let output = "";
  let j = 0;
  for (let i = 0; i < input; i++) {
    output += colors[j++];
    if (j === 7) {
      j -= 4;
    }
  }
  console.log(output);
});