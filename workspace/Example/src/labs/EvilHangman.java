package labs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;

/**
 * In Evil Hangman, the computer maintains a list of every word in the
 * English language, then continuously pares down the word list to try
 * to dodge the player's chances as much as possible.
 *
 * Details here:
 * http://nifty.stanford.edu/2011/schwarz-evil-hangman/Evil_Hangman.pdf
 */
public class EvilHangman extends Hangman {

		EvilHangman() throws FileNotFoundException {
			super();
			File file = new File("resources/dictionary.txt");
			FileReader reader = new FileReader(file);
			Scanner scanner = new Scanner(reader);
			
			// TODO: build up a data structure here
			while (scanner.hasNextLine())
			{
				String tempstring = scanner.nextLine().toLowerCase();
				int a = 0;
				if (tempstring.length() == chances)
				{
					WordList[a] = tempstring;
					a++;
					Wordnum++;
				}
				System.out.println(scanner.nextLine());
			}
		}
		
		//TODO: Extend exisitong methods to be evil
		
		// Get the word
		public String getWord() {
			return Word;
		}
		// Get guesses remaining
		public int GuessRemaining(int RemainingNum)
		{
			return RemainingNum;
		}
		
		//Letters remaining
		public int letterRemaining()
		{
			return LetterLeftNum;
		}
		//Winner?
		public boolean winning()
		{
			return false;
		}
		//game ended
		public boolean over()
		{
			return (guessesRemaining() <= 0) || won();
		}
		// How many guesses remain?
		public String chances() {
			if(!GuessResult)
			{
				GuessLetter = GuessLetter + pastchances;
			}
			return GuessLetter;
		}
		
				// What can the player see?
		public String visible() {
			StringBuilder b = new StringBuilder();
			for (char letter : Word.toCharArray()) {
				b.append(getGuesses().contains(letter) ? letter : '*');
			}
			return b.toString();
		}
		
		//Adjusted to be EVIL

		public boolean makeGuessEVIL(char letter) {
			int temp = 0;
			for(int i = 0; i<Wordnum; i++)
			{
				for (int a = 0; a <SecretString_length; a++)
				{
					if(WordList[i].charAt(a)== letter)
					{
						break;
					}
					else {
						if(a == SecretString_length -1)
						{
							if (WordList[i].charAt(a) != letter)
							{
								temp++;
							}}}}}
			String[] temp1 = new String[temp];
			int tempIndex = 0;
			for (int i = 0; i < Wordnum; i++) {
				for (int j = 0; j < SecretString_length; j++) {
					if (WordList[i].charAt(j) == letter) {
						break;
					} else {
						if (j == SecretString_length - 1) {
							if (WordList[i].charAt(j) != letter) {
								temp1[tempIndex] = WordList[i];
								tempIndex++;
							}
						}
					}
				}
			}
			if (temp == 0)
			{
				Word = WordList[0];
				return false;
			}
			else
			{
				Word = temp1[0];
				Wordnum = temp;
				WordList = temp1;
				//return true;
			}
			return GuessResult;
		}

	private String Word = "";
	private int chances;
	private String current = "";
	private String pastchances = "";
	private String GuessLetter;
	private String[] WordList = new String[23500];
	private int Wordnum = 0;
	private int SecretString_length;
	private int LetterLeftNum = 26;
	private boolean GuessResult = false;
}















	