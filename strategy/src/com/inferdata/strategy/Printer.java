package com.inferdata.strategy;

import java.util.Random;

public class Printer extends Thread {
	public enum QueueStrategy {
		FIFO,
		JobPriority
	}
	private boolean shouldRun = true;
//	private PrinterQueue printerQueue = new SimpleFIFOPrinterQueue();
//	private PrinterQueue printerQueue = new JobPriorityPrinterQueue();
	private Random myRandom = new Random();
	private PrinterQueue printerQueue;

	public Printer() {
		this(QueueStrategy.FIFO);
	}
	public Printer(QueueStrategy queueStrategy) {
		if (queueStrategy == QueueStrategy.FIFO) {
			this.printerQueue = new SimpleFIFOPrinterQueue();
		} else if (queueStrategy == QueueStrategy.JobPriority) {
			this.printerQueue = new JobPriorityPrinterQueue();
		}
	}

	public void run() {
		while (this.shouldRun) {
			try {
				Thread.sleep(100);
				Job j = this.printerQueue.getNextJob();
				if (j != null) {
					this.printJob(j);
					this.informUser(j);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void printJob(Job j) {
		try {
			System.out.println("Start of job " + j.getId());
			Thread.sleep(this.myRandom.nextInt(1000));
			System.out.println("Printed: " + this.getJobAsPrinterLanguage(j));
			Thread.sleep(this.myRandom.nextInt(1000));
			System.out.println("End of job " + j.getId());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void informUser(Job j) {
		if (j.getUser() != null) {
			System.out.println("Notifying the user: " + j.getUser().getName()
					+ " that the job is done");
			j.getUser().printJobComplete(j);
		}
	}

	private String getJobAsPrinterLanguage(Job j) {
		// fake translation... Up-case and then reverse
		String retVal = new StringBuilder(j.getContent().toUpperCase())
				.reverse().toString();
		System.out.println("Translated: " + j.getContent() + " --> " + retVal);
		return retVal;
	}

	synchronized public void print(Job job) {
		this.printerQueue.addJob(job);
	}

	synchronized public void shutdownPrinter() {
		this.shouldRun = false;
	}
}
