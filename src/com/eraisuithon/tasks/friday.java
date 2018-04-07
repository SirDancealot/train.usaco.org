/*
ID: mj3
LANG: JAVA
PROG: friday
 */

package com.eraisuithon.tasks;
import java.io.*;
import java.util.*;

class friday {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("friday.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
    StreamTokenizer st = new StreamTokenizer(f);
    
    st.nextToken();
    int n = (int) st.nval;
    int weekDay = 2; //format: [Saturday, Sunday, Monday, Tuesday, Wednesday, Thursday, Friday]
    int[] thirteens = new int[] {0, 0, 0, 0, 0, 0, 0};
    int[] months = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    for (int year = 1900; year < (1900+n); year++) {
    	//System.out.println(year);
		if (year % 400 == 0) {
			months[1] = 29;
		} else if (year % 100 == 0){
			months[1] = 28;
		} else if (year % 4 == 0) {
			months[1] = 29;
		} else {
			months[1] = 28;
		}
		for (int month = 0; month < months.length; month++) {
			for (int dayNum = 0; dayNum < months[month]; dayNum++) {
				if (dayNum == 12) {
					thirteens[weekDay] += 1;
				}
				weekDay++;
				weekDay %= 7;
			}
		}
	}
    
    for (int i = 0; i < 7; i++) {
		out.print(thirteens[i]);
		if (i != 6) {
			out.print(" ");
		} else {
			out.print("\n");
		}
    }			
    out.close();
    System.exit(0);
  }
}