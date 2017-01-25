package no.hib.dat102.klient;

import no.hib.dat102.adt.StackADT;
import no.hib.dat102.stack.LinkedStack;

public class LinearNodeKlient {
	public static void main(String[] args) {
		StackADT<String> sta = new LinkedStack<String>();
		String[] tab = { "Kari", "Per", "Tine", "Anne" };

		sta.push(tab[0]);
		sta.push(tab[1]);
		sta.push(tab[2]);
		sta.push(tab[3]);

		System.out.println(sta.size());

		// 1. Legg inn ny node som er nr.2 i listen med objekt "Berit"
		
		
		// 2. Anta at listen har fått over 10 noder. Lag en ny node
		// som er nr.10 (med objekt "Person 10")
		
		
		// 3. Legg til ny node helt til slutt i listen med objekt "Sistemann"
		
		
		// 4. Fjern node nr.2 i liste
		
		
		// 5. Fjern siste node i en lang liste
	}
}
