package main

/*
	cerner_2tothe5th_2022
	cerner_2^5th_2022

	Day 5 Submission: first time coding in Go. Thought it might be fun to do a Klingon translation while learning about Go and POST requests.
*/
import (
	"bytes"
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"
)

// Structs that are used to represent the response data from the API
type APIResponse struct {
	Success  APISuccess
	Contents APIContents
}
type APISuccess struct {
	Total int
}
type APIContents struct {
	Translated  string
	Text        string
	Translation string
}

// driver method.
func main() {
	fmt.Println("\nTranslating. . . .")

	URL := fmt.Sprintf("https://api.funtranslations.com/translate/klingon.json")
	toTranslate := bytes.NewReader([]byte(`{"text":"Fool me once, shame on you. Fool me twice, prepare to die!"}`))

	// Do HTTP logic
	request, _ := http.NewRequest(http.MethodPost, URL, toTranslate)
	response, _ := http.DefaultClient.Do(request)
	resData, _ := ioutil.ReadAll(response.Body)
	defer response.Body.Close()

	// Translate the API response, and display
	var apiResponse APIResponse
	json.Unmarshal(resData, &apiResponse)
	fmt.Println(fmt.Sprintf("\nOriginal Text: %s\nTranslated Text: %s", apiResponse.Contents.Text, apiResponse.Contents.Translated))
}
