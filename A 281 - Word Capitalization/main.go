package main

import (
	"fmt"
	"strings"
)

func main() {
	var uncapitalizedWord string
	fmt.Scanln(&uncapitalizedWord)
	fmt.Println(strings.ToUpper(string(uncapitalizedWord[0])) + uncapitalizedWord[1:])
}
