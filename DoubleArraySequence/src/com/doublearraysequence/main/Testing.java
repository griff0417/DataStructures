package com.doublearraysequence.main;

public class Testing 
{
	public static void main(String[] args)
	{
		DoubleArraySeq sq1 = new DoubleArraySeq();
		DoubleArraySeq sq2 = new DoubleArraySeq();
		DoubleArraySeq sq3 = new DoubleArraySeq();
		DoubleArraySeq sq4 = new DoubleArraySeq();
		
		sq1.addAfter(1);
		sq1.addAfter(2);
		sq1.addAfter(3);
		sq1.addAfter(4);
		sq1.addAfter(5);
		sq1.removeFromEnd();
		
		sq2.addAfter(6);
		sq2.addAfter(7);
		sq2.addAfter(8);
		sq2.addAfter(9);
		sq2.addAfter(10);
		sq2.addToFront(5);
		sq2.removeFromFront();
		
		sq3 = DoubleArraySeq.concatenate(sq1, sq2);
		
		System.out.println("Sequence 1:");
		for (sq1.start(); sq1.isCurrent(); sq1.advance())
		{
			System.out.println(sq1.getCurrent());
		}
		
		System.out.println("\nSequence 2:");
		for (sq2.start(); sq2.isCurrent(); sq2.advance())
		{
			System.out.println(sq2.getCurrent());
		}
		
		System.out.println("\nSequence 3:");
		for (sq3.start(); sq3.isCurrent(); sq3.advance())
		{
			System.out.println(sq3.getCurrent());
		}
	}
}
