package main

import (
	"fmt"
)

func main() {
	fmt.Println("Hello, World!")
}

func isAnagram(s string, t string) bool {
	existingAlphabets := make(map[rune]int)
	for _, character := range s {
		existingAlphabets[character]++
	}

	for _, character := range t {
		existingAlphabets[character]--
	}

	for _, alphabetExists := range existingAlphabets {
		if alphabetExists != 0 {
			return false
		}
	}

	return true
}
