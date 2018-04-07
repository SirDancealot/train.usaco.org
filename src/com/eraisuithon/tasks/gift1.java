/*
ID: mj3
LANG: JAVA
PROG: gift1
 */
package com.eraisuithon.tasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.*;

class gift1 {
	public static void main(String[] args) throws IOException {
		//Output handle variables
			BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
			StreamTokenizer st = new StreamTokenizer(f);
			  
			//Variables for handling calculations
			TreeSet<Person> persons = new TreeSet<Person>();
			
			
			
			//Program logic
			st.nextToken();
			int personCount = (int) st.nval;
			
			for (int i = 0; i < personCount; i++) {
				st.nextToken();
				persons.add(new Person(st.sval, i));
				
			}

			for (int i = 0; i < personCount; i++) {
				st.nextToken();
				String gifterName = st.sval;
				st.nextToken();
				int giftingAmt = (int) st.nval;
				st.nextToken();
				int giftingTo = (int) st.nval;
				for (int j = 0; j < giftingTo; j++) {
					st.nextToken();
					persons.lower(new Person(st.sval + "a", 0)).addMoney((int) (giftingAmt / giftingTo));
				}
				if (giftingTo != 0) {
					int cost = - giftingAmt + (giftingAmt % giftingTo);
					persons.lower(new Person(gifterName + "a", 0)).addMoney(cost);
				}
			}
			
			//Output to file
			for (int i = 0; i < personCount; i++) {
				for (Person person : persons) {
					if (person.getInsertionNum() == i) {
						System.out.println(person);
						out.println(person);
						break;
					}
				}
			}
			out.close();
	}
}

class Person implements Comparable<Person>, Comparator<Person> {
	String name;
	String[] gifting;
	int giftMoney, giftedMoney, insertionNum;
	
	public Person(String name, int insertionNum) {
		this.name = name;
		this.giftedMoney = 0;
		this.giftMoney = 0;
		this.insertionNum = insertionNum;
	}
	
	public void addMoney(int money) {
		// TODO Auto-generated method stub
		this.giftedMoney += money;
	}
	
	public String getName() {
		return name;
	}
	
	public int getInsertionNum() {
		return insertionNum;
	}
	
	public String toString() {
		return (this.name + " " + String.valueOf(giftedMoney));
	}

	@Override
	public int compareTo(Person o) {
		return (this.name.compareTo(o.getName()));
	}

	@Override
	public int compare(Person o1, Person o2) {
		return (o1.getName().compareTo(o2.getName()));
	}
}