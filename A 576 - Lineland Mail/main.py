# Codeforces - Lineland Mail

# Link : https://codeforces.com/contest/567/problem/A

class Lineland:
    def __init__(self, numberOfCities: int, cities: list) -> None:
        self.__numberOfCities = numberOfCities
        self.__cities = cities

    @property
    def getMinMax(self):
        result = []
        for i in range(self.__numberOfCities):
            if (i == 0):
                minDistance = self.__cities[i + 1] - self.__cities[i]
            elif (i == self.__numberOfCities - 1):
                minDistance = self.__cities[i] - self.__cities[i - 1]
            elif (self.__cities[i + 1] - self.__cities[i] < self.__cities[i] - self.__cities[i - 1]):
                minDistance = self.__cities[i + 1] - self.__cities[i]
            else:
                minDistance = self.__cities[i] - self.__cities[i - 1]

            if (i == 0):
                maxDistance = self.__cities[len(
                    self.__cities) - 1] - self.__cities[i]
            elif (i == self.__numberOfCities - 1):
                maxDistance = self.__cities[i] - self.__cities[0]
            elif (self.__cities[-1] - self.__cities[i] > self.__cities[i] - self.__cities[0]):
                maxDistance = self.__cities[-1] - self.__cities[i]
            else:
                maxDistance = self.__cities[i] - self.__cities[0]

            result.append(f"{minDistance} {maxDistance}")

        return "\n".join(result)


def main():
    numberOfCities = int(input())
    cities = list(map(int, input().split(" ")))
    lineland = Lineland(numberOfCities, cities)
    print(lineland.getMinMax)


if __name__ == "__main__":
    main()
