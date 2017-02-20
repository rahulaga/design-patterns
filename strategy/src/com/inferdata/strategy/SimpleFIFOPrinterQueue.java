package com.inferdata.strategy;

import java.util.LinkedList;
import java.util.Queue;

public class SimpleFIFOPrinterQueue implements PrinterQueue {

	private Queue<Job> queue = new LinkedList<Job>();

	@Override
	public void addJob(Job j) {
		this.queue.add(j);

	}

	@Override
	public Job getNextJob() {
		return this.queue.poll();
	}

}
