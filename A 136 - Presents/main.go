package main

import (
	"fmt"
)

func indexOf(arr []int, val int) int {

	for i, v := range arr {
		if v == val {
			return i
		}
	}
	return -1
}

func main() {
	var numberOfFriends int
	fmt.Scanln(&numberOfFriends)
	var friendsData = make([]int, numberOfFriends)
	for i := 0; i < numberOfFriends; i++ {
		fmt.Scan(&friendsData[i])
	}
	for i := range friendsData {
		fmt.Print(indexOf(friendsData, i+1)+1, " ")
	}
}
