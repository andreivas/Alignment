package com.alignment.spring;

public class Solution {

    public int[] solution (String originalText, String cleanText) {
    	int[] solutionArr = new int[originalText.length()];
    	int cursor = 0;
    	int count = 0;
    	
    	do {
    		if ( originalText.charAt(cursor)== cleanText.charAt(count) ) {
    			solutionArr[cursor] = 1;
    		    cursor++;
    			count++;
    		} else {
    			solutionArr[cursor] = 0;
    			cursor++;
    		}
    		
    	} while (count < cleanText.length());
    	
    	return solutionArr;
    }
	
	
}
