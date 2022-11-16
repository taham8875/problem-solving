// HackerRank - Detect HTML links

// link : https://www.hackerrank.com/challenges/detect-html-links/problem?isFullScreen=true

function processData(input) {
  input = input.split("\n");
  numberOfLines = +input[0];
  regex = /<a href="(.*?)".*?>([\w ,.&;\/]*)(?=<\/)/g;
  for (let i = 1; i < input.length; i++) {
    matches = input[i].matchAll(regex);
    for (const match of matches) {
      console.log(`${match[1]},${match[2].trim()}`);
    }
  }
}

process.stdin.resume();
process.stdin.setEncoding("ascii");
_input = "";
process.stdin.on("data", function (input) {
  _input += input;
});

process.stdin.on("end", function () {
  processData(_input);
});