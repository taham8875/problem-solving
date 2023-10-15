// Calculating Function
// Link : https://codeforces.com/contest/514/problem/A

const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input;
let output = "";

readline.on("line", (line) => (input = line));
readline.on("close", () => {
  let digit;
  for (let i = 0; i < input.length; i++) {
    digit = Number(input[i]);
    if (digit > 4) {
      digit = 9 - digit;
    }
    output += digit;
  }
  if (output[0] == 0) {
    output = "9" + output.slice(1);
  }
  console.log(output);
});
