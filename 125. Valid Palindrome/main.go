package main

import (
	"fmt"
)

func main() {
	s := " "
	fmt.Println(isPalindrome(s))
}

func isPalindrome(s string) bool {
	for index := 0; index < len(s); index++ {
		character := rune(s[index])
		if character >= 'A' && character <= 'Z' {
			s = s[:index] + string(character+32) + s[index+1:]
		} else if !(character >= 'a' && character <= 'z') && !(character >= '0' && character <= '9') {
			s = s[:index] + s[index+1:]
			index--
		}
	}

	for index := 0; index < len(s)/2; index++ {
		if s[index] != s[len(s)-index-1] {
			return false
		}
	}

	return true
}
