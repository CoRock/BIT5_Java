package com.corock.day07;

class ATM implements Runnable {
	private long depositMoney = 10000;
	
	@Override
	public void run() {
		synchronized (this) {
			for(int i = 0; i < 10; i++) {
				try { Thread.sleep(1000); }
				catch (InterruptedException ie) { ie.printStackTrace(); }

				if(getDepositMoney() <= 0)	break;
				withDraw(1000);

				this.notify();
				try { this.wait(); }
				catch(InterruptedException ie) { ie.printStackTrace(); }
			}
		}
	}

	public void withDraw(long howMuch) {
		if(getDepositMoney() > 0) {
			depositMoney -= howMuch;
			System.out.print(Thread.currentThread().getName() + ", ");
			System.out.printf("balance: %,d won %n", getDepositMoney());
		} else {
			System.out.print(Thread.currentThread().getName() + ", ");
			System.out.println("*** Insufficient cash :(");
		}
	}
	
	public long getDepositMoney() {
		return depositMoney;
	}
}

public class SynchronizedEx {
	public static void main(String[] args) {
		ATM atm = new ATM();
		Thread mother = new Thread(atm, "mother");
		Thread son = new Thread(atm, "son");

		/*
		 * Two threads simultaneously use ATM.
		 * In this case, sychronization is required!
		 */
		
		mother.start();
		son.start();
	}
}