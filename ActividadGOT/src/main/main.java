package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class main {

	public static void main(String[] args) {
		readCSV();
	}
	public static void readCSV(){
	    BufferedReader bf = null;
	    try {
	        bf = new BufferedReader(new FileReader("../src/stormofswords.csv"));
	    } catch (FileNotFoundException e) {
	    e.printStackTrace();
	    }
	    String line = null;
	    try {
	        while ((line = bf.readLine())!=null) {
	        StringTokenizer tokens = new StringTokenizer(line, ",");
	        while(tokens.hasMoreTokens()){
	            System.out.println(tokens.nextToken());
	        }
	        }
	    } catch (IOException e) {
	    e.printStackTrace();
	    }
	}
}
