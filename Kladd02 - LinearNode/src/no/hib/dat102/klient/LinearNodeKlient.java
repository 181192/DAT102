package no.hib.dat102.klient;

import no.hib.dat102.adt.StackADT;
import no.hib.dat102.stack.LinearNode;
import no.hib.dat102.stack.LinkedStack;

/**
 * Klient for LinearNode
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
public class LinearNodeKlient {
	
	public static void main(String[] args) {
		StackADT<String> sta = new LinkedStack<String>();
		LinearNode<String> start = new LinearNode<String>("Ole");
		
		sta.push("Kari");
		sta.push("Per");
		sta.push("Tine");
		sta.push("Anne");
		
		System.out.println(sta.size());

		// 1. Legg inn ny node som er nr.2 i listen med objekt "Berit"
		LinearNode<String> nyNode = new LinearNode<String>("Berit");
		nyNode.setNext(start.getNext());
		start.setNext(nyNode);
		
		System.out.println(sta.size());

		// 2. Anta at listen har fått over 10 noder. Lag en ny node
		// som er nr.10 (med objekt "Person 10")
//		sta.push(tab[4]);
//		sta.push(tab[5]);
//		sta.push(tab[6]);
//		sta.push(tab[7]);
//		sta.push(tab[8]);
		
//		String p10 = "Person 10";

		// 3. Legg til ny node helt til slutt i listen med objekt "Sistemann"
//		String sistemann = "Sistemann";

		// 4. Fjern node nr.2 i listen
	
//		
		
		// 5. Fjern siste node i en lang liste
	} // main
} // class
