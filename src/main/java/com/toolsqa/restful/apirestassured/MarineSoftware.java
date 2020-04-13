/**
 *   File Name: MarineSoftware.java<br>
 *
 *   Yutaka<br>
 *   Created: Feb 16, 2018
 *   
 */

package com.toolsqa.restful.apirestassured;

import java.util.*;

/**
 * MarineSoftware //ADDD (description of class)
 * 
 * This is just a simple shared plaintext pad, with no execution capabilities.
 * When you know what language you'd like to use for your interview,
 * simply choose it from the dropdown in the top bar.
 * You can also change the default language your pads are created with
 * in your account settings: https://coderpad.io/settings
 * Enjoy your interview!
 * 
 * 
 * @author      Yutaka
 * @version     1.0.0
 * @since       1.0
 *
 */
public class MarineSoftware {

// write a method that takes a list of words and prints the unique words

public void printUniqueWords(List<String> words) {

  // enter code here
  Set<String> wordsWithoutDupl = new HashSet<>(words);
  System.out.println("All words: " + words); // All words: [a, c, b, c, d, b, e]
	System.out.println("Words Without Dupl: " + wordsWithoutDupl); // without dupl: [a, b, c, d, e]

  StringBuilder result = new StringBuilder();
  
  for(String word: wordsWithoutDupl) {
    if(Collections.frequency(words, word) > 1) {
      result.append(word + " : " + Collections.frequency(words, word) + "\n");
    }
  }
 // System.out.println(result.toString()); // b : 2
  										// c : 2
}

public Set<String> uniqueWords04(List words) {
	Set<String> wordsSet = new HashSet<>(words);
	Set<String> uniqueWords = new HashSet<>();
	for(String word : wordsSet) {
		if(Collections.frequency(words, word) == 1)
			uniqueWords.add(word);
	}
	//System.out.println("words       " + words);
	//System.out.println("wordsSet    " + wordsSet);
	//System.out.println("uniqueWords " + uniqueWords);
	return uniqueWords;
}

public Set<String> uniqueWords02(List<String> words) {
	Set<String> unique = new HashSet<>();
	HashMap<String, Integer> allWordsHM = new HashMap<>();
	for (String word : words) {
		if(allWordsHM.containsKey(word)) {
			allWordsHM.put(word, allWordsHM.get(word) + 1);
		} else {
			allWordsHM.put(word,  1);
		}
	}
	for(String word : words) {
		if(allWordsHM.get(word) == 1) {
			unique.add(word);
		}
	}
	return unique;
}


}


