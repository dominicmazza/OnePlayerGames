# OnePlayerGames
Game playing interface for customized versions of Wordle and Hangman called Elordle and Snowman respectively. 

OnePlayerGames - Elordle and Snowman         	         		Dominic Mazza
Description:
Customized versions of Wordle and Hangman called Elordle and Snowman respectively. To begin, I created a OnePlayerGame interface, defining the methods required to facilitate either game. I then created an Elordle class and Snowman class which both implemented OnePlayerGame. I also created a Play class allowing any OnePlayerGame to be played using a single method.
Instructions:
When ran, you first pick the game you would like to play, Snowman or Elordle.
If Snowman is picked, enter your letter guesses for the snow-themed word one at a time. The program keeps track and displays the current letters guessed by filling in the empty string and the incorrect letters guessed by displaying them.
For example:
	Target word:		“front”
	User enters:		“o”
	Output: 		Make a guess: o
Word: --o–
Incorrect letters: 
Guesses left: 7
	User enters:		“a”
Make a guess: a
Word: --o--
Incorrect letters: a
Guesses left: 6

If Elordle is picked, begin entering your 5-letter guess of the word. If a letter is in the right spot, it is capitalized. If a letter is in the wrong spot, but still present in the word, it shows up in the space you entered it lower-cased.
For example: 
Target word: “nurse” 
User enters: “slope”
Output: 	Make a guess: slope
Word: s - - - E
Guesses left: 5
This is because s was not in the right spot, but it is present in the word. E was in the right spot, so it is capitalized.


