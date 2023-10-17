# B 469 - Complete the Word - Codeforces
# Link : https://codeforces.com/contest/716/problem/B

word = input()

alphabet = {
    "A": 0,
    "B": 0,
    "C": 0,
    "D": 0,
    "E": 0,
    "F": 0,
    "G": 0,
    "H": 0,
    "I": 0,
    "J": 0,
    "K": 0,
    "L": 0,
    "M": 0,
    "N": 0,
    "O": 0,
    "P": 0,
    "Q": 0,
    "R": 0,
    "S": 0,
    "T": 0,
    "U": 0,
    "V": 0,
    "W": 0,
    "X": 0,
    "Y": 0,
    "Z": 0,
}

numberOfQuestionMarks = 0


def resetCounters():
    global numberOfQuestionMarks
    numberOfQuestionMarks = 0
    for key in alphabet:
        alphabet[key] = 0


def isNiceWord(word):
    if len(word) < 26:
        return False  # Not enough characters to form a nice substring.

    for i in range(len(word) - 25):
        substring = word[i : i + 26]

        if len(substring) == len(set(substring)):
            return True # Every character is unique.
    return False


def cleanWordFromQuestionMarks(word):
    for i in range(len(word)):
        if word[i] == "?":
            word = word[:i] + "A" + word[i + 1 :] # Choosing 'A' is arbitrary.

if len(word) < 26:
    print("-1")
    exit()

for i in range(len(word) - 25):
    resetCounters()
    substring = word[i : i + 26]
    
    # count the number of question marks and the number of unique characters.
    for j in range(len(substring)):
        if substring[j] == "?":
            numberOfQuestionMarks += 1
        else:
            alphabet[substring[j]] = 1
    numberOfAlphabet = 0
    for key in alphabet:
        if alphabet[key] == 1:
            numberOfAlphabet += 1
            
    # if the number of unique characters + the number of question marks is 26, then we can fill the question marks with the missing characters.
    if numberOfAlphabet + numberOfQuestionMarks == 26:
        for j in range(len(substring)):
            if substring[j] == "?":
                for key in alphabet:
                    if alphabet[key] == 0:
                        substring = substring[:j] + key + substring[j + 1 :]
                        alphabet[key] = 1
                        break
        word = word[:i] + substring + word[i + 26 :]
        if isNiceWord(word):
            word = cleanWordFromQuestionMarks(word)
            print(word)
            exit()

print("-1")
