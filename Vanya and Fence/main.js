const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout,
});
const input = [];

readline.on("line", (line) => input.push(line.split(" ")));
readline.on("close", () => {
  let numberOfPersons = parseInt(input[0][0]);
  let heightOfFence = parseInt(input[0][1]);
  let heightOfIthPerson = input[1].map(Number);
  let width = 0;
  for (let i = 0; i < heightOfIthPerson.length; i++) {
    if (heightOfIthPerson[i] > heightOfFence) {
      width += 2;
    } else {
      width += 1;
    }
  }
  console.log(width);
});