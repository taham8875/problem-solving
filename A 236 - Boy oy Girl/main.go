package main

import (
	"fmt"
)

func main() {
	var username string
	fmt.Scanln(&username)
	var alphabetsExists [26]int
	for _, character := range username {
		alphabetIndex := int(character) - 97
		alphabetsExists[alphabetIndex]++
	}

	numberOfDistinctAlphabets := 0
	for _, alphabetExists := range alphabetsExists {
		if alphabetExists > 0 {
			numberOfDistinctAlphabets++
		}
	}

	if numberOfDistinctAlphabets%2 == 0 {
		fmt.Println("CHAT WITH HER!")
	} else {
		fmt.Println("IGNORE HIM!")
	}
}
