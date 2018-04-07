/*
ID: mj3
LANG: JAVA
PROG: beads
 */
package com.eraisuithon.tasks;

import java.io.*;

public class beads {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("beads.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		StreamTokenizer st = new StreamTokenizer(f);
		
		st.nextToken();
		int numBeads = (int) st.nval;
		st.nextToken();
		char[] beads = st.sval.toLowerCase().toCharArray().clone();
		int[] beadGrps = new int[numBeads];
		
		for (int i = 0; i < numBeads; i++) {
			if (beads[i] != 'w') {
				int j = i;
				if (beads[i] == 'b') {
					while (beads[j] == 'b' || beads[j++] == 'w') {
						if (j == numBeads) {
							j %= numBeads;
						}
					}
					System.out.println("Index of start blue: " + i + "\nIndex of registred red: " + j + "\n");
				} else {
					while (beads[j] == 'r' || beads[j++] == 'w') {
						if (j == numBeads) {
							j %= numBeads;
						}
					}
					System.out.println("Index of start red: " + String.valueOf(i) + "\nIndex of registred blue: " + j + "\n");
				}
			}
		}
		out.close();
	}
}