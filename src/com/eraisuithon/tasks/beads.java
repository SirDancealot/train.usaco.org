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
		int lenOfChain = 0;
		
		for (int i = 0; i < beads.length; i++) {
			int loopI = i;
			boolean changed = false;
			boolean stop = false;
			int lenOfThisChain = 0;
			String lastChar = "";
			while (!stop) {
				if (beads[loopI] == 'w') {
					lenOfThisChain++;
				} else {
					if (lastChar.isEmpty()) {
						lastChar = String.valueOf(beads[loopI]);
						lenOfThisChain++;
					} else {
						if (lastChar.equals(String.valueOf(beads[loopI]))) {
							lenOfThisChain++;
						} else {
							if (changed) {
								stop = true;
							} else {
								lastChar = String.valueOf(beads[loopI]);
								changed = true;
								lenOfThisChain++;
							}
						}
					}
				}
				
				loopI++;
				loopI %= beads.length;
				if (loopI == i) {
					out.println(beads.length);
					out.close();
					System.exit(0);
				}
			}
			if (lenOfThisChain > lenOfChain)
				lenOfChain = lenOfThisChain;
		}
		
		out.println(lenOfChain);
		out.close();
	}
}