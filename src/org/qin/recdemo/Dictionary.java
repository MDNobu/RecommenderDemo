package org.qin.recdemo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

/**
 * 
 * @author qin
 * 
 */
public class Dictionary {
	
	
	private static final String SPLIT_REGEX = "\\s+";
	
	private static Dictionary dict = new Dictionary();
	private Set<String> keyWordsSet = new TreeSet<String>();
	private Map<String, Integer> wordIndexs = new HashMap<String, Integer>();
	private Set<String> stopWordsSet = new HashSet<String>();
	private int length = 0;
	
	private Dictionary() {
		
	}
	
	public static Dictionary getDict() {
		return dict;
	}
	
	public void addKeyWords(String line) {
		keyWordsSet.addAll(FIOUtils.getWordsFromPattern(line, FIOUtils.WORD_PATTERN));
	}
	
	public void addStopWords(String line) {
		stopWordsSet.addAll(FIOUtils.getWordsFromPattern(line, FIOUtils.WORD_PATTERN));
	}
	
	public void initIndexMap() {
		length = keyWordsSet.size();
		int i = 0;
		for(String word : keyWordsSet) {
			wordIndexs.put(word, i++);
		}
	}
	
	public int getWordIndex(String word) {
		return wordIndexs.get(word) == null ? -1 : wordIndexs.get(word);
	}
	
	
	public int getLength() {
		return length;
	}
	
	public void print() {
		System.out.println(this.length);
		
		System.out.println("key words :");
		for(String word : keyWordsSet) {
			System.out.print(word + " ");
		}
		System.out.println();
		System.out.println("stop words :");
		for(String word : stopWordsSet) {
			System.out.print(word + " ");
		}
		System.out.println();	
		
	}
}
