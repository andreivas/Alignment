package com.alignment.spring;

public class Solution {

    public int[] solutionChar (String originalText, String cleanText) {
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
    
    public int[] solutionWord (String[] originalText, String[] cleanText) {
    	
    	int cursor = 0;
    	int count = 0;
    	
		int[] solutionArr = new int[originalText.length];
		
		
    	
    	do {
    		
    		if ( originalText[cursor].equals(cleanText[count]) ) {
    			solutionArr[cursor] = 1;
    			cursor++;
    			count++;
    		} else {
    			solutionArr[cursor] = 0;
    			cursor++;
    		}	
    	} while (count < cleanText.length);
    	
    	return solutionArr;
    	
    }
	
	
}
