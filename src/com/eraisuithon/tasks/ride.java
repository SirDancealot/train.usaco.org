package com.eraisuithon.tasks;
/*
ID: mj3
LANG: JAVA
PROG: ride
*/
import java.io.*;
import java.util.*;

class ride {
	public static void main (String [] args) throws IOException {
		//Output handle vars
		BufferedReader f = new BufferedReader(new FileReader("ride.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		  
		StreamTokenizer st = new StreamTokenizer(f);
		  
		  
		//Vars for handeling calculations
		String outString, grpName, cmtName;
		long grpProduct = 1, cmtProduct = 1;
		  
		  
		//Program logic
		st.nextToken();
		grpName = st.sval.toLowerCase();
		st.nextToken();
		cmtName = st.sval.toLowerCase();
		
		for (char grpChar : grpName.toCharArray()) {
			grpProduct *= (long) grpChar - 96;
		}
		
		for (char cmtChar : cmtName.toCharArray()) {
			cmtProduct *= (long) cmtChar - 96;
		}
		
		if (grpProduct % 47 == cmtProduct % 47) {
			outString = "GO";
		} else {
			outString = "STAY";
		}
		
		//Output to file
		out.println(outString);
		out.close();
	}
}