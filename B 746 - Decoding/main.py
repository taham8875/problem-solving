# B 469 - Decoding - Codeforces
# Link : https://codeforces.com/contest/746/problem/B

numberOfChars, encodedMessage = int(input()), input()

decodedMessage = " " * numberOfChars

direction = 1 if numberOfChars % 2 == 1 else -1

cursorPosition = numberOfChars // 2 if numberOfChars % 2 == 1 else (numberOfChars // 2) - 1
for i in range(numberOfChars):
    cursorPosition += direction * i
    direction *= -1
    decodedMessage = decodedMessage[:cursorPosition] + encodedMessage[i] + decodedMessage[cursorPosition + 1:]
    
print(decodedMessage)