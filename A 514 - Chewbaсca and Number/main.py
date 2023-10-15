# A 486 - Chewbaсca and Number - Codeforces
# Link : https://codeforces.com/contest/514/problem/A

number = input()
output = ""

for digitChar in number:
    digit = int(digitChar)
    if (digit > 4):
        digit = 9 - digit
    output += str(digit)

if (output[0] == "0"):
    output = "9" + output[1:]

print(int(output))