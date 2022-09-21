# Tower of Hanoi

This is not a codeforces problem

The Tower of Hanoi is a well-known mathematical puzzle. It consists of three rods, and a number of disks of different sizes which can slide onto any rod. The puzzle starts with the disks in a neat stack in ascending order of size on one rod, the smallest at the top, thus making a conical shape.

The objective of the puzzle is to move the entire stack to another rod, obeying the following simple rules:

1. Only one disk can be moved at a time.

2. Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack i.e. a disk can only be moved if it is the uppermost disk on a stack.

3. No disk may be placed on top of a smaller disk.


With three disks, the puzzle can be solved in seven moves. The minimum number of moves required to solve a Tower of Hanoi puzzle is $2n - 1$, where $n$ is the number of disks. (c) Wikipedia.



In the problem you are given matrix $t$ and an integer $n$. You need to count the cost of solving the Tower of Hanoi, consisting of $n$ disks.

Input: 

Each of the first three lines contains three integers — matrix $t$. The $j$-th integer in the $i$-th line is $t_{ij}$ $(1 \leq t_{ij} \leq 10000; i \neq j)$. The following line contains a single integer $n (1 \leq n \leq 40)$ — the number of disks.

It is guaranteed that for all $i (1 \leq i \leq 3)$, $t_{ij} = 0$.

Output: 

Print a single integer — the cost of solving the Tower of Hanoi.

