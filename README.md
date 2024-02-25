# Problem Solving

My solutions for several problem on leetcode and codeforces.

## `create_problem.sh`

This script is used to create a new problem folder with the following structure:

```bash
source create_problem.sh <problem_name> <language_extension>
```

Where `<problem_name>` is the name of the problem (and will me the name of the new directory and the filename of the code snippet) and `<language_extension>` is the the extension of the code snippet.

for example:

```bash
source create_problem.sh "584. Find Customer Referee" "sql"
```

Will create the following structure:

```
584. Find Customer Referee/
└── 584. Find Customer Referee.sql
```

Try to solve the problem in your editor.

## lazygit

Typing `git add . && git commit -m "commit message>" && git push` is too much work. you can add the following alias to your `.bashrc` or `.zshrc`:

```bash
function lazygit() {
    git add .
    git commit -a -m "$1"
    git push
}
```

Then you can use it like this:

```bash
lazygit "commit message"
```
