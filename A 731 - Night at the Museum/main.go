package main

import (
	"fmt"
	"math"
)

func main() {
	var name string
	fmt.Scanln(&name)
	minimumNumberOfRotations := 0.0
	previousCharacter := 'a'
	for _, character := range name {
		minimumDistance := 0.0
		if math.Abs(float64(character-previousCharacter)) > 13 {
			minimumDistance = 26 - math.Abs(float64(character-previousCharacter))
		} else {
			minimumDistance = math.Abs(float64(character - previousCharacter))
		}
		minimumNumberOfRotations += minimumDistance
		previousCharacter = character
	}
	fmt.Println(minimumNumberOfRotations)
}
