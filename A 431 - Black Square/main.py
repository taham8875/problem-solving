# Codeforces - Black Square

# Link : https://codeforces.com/contest/431/problem/A

class BlackSquareGame:
    def __init__(self, caloriesDistribtion: list, gameState: list) -> None:
        self.__caloriesDistribtion = dict(enumerate(caloriesDistribtion, 1))
        self.__gameState = gameState

    def calculateWastedCalories(self):
        wastedCalories = 0
        for move in self.__gameState:
            wastedCalories += self.__caloriesDistribtion[move]
        return wastedCalories


def main():
    caloriesDistribtion = list(map(int, input().split(" ")))
    gameState = list(map(int, list(input())))
    blackSquareGame = BlackSquareGame(caloriesDistribtion, gameState)
    print(blackSquareGame.calculateWastedCalories())


if __name__ == "__main__":
    main()
