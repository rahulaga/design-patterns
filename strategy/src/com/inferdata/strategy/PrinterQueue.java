package com.inferdata.strategy;

public interface PrinterQueue {
	
	/*
	 * Adds a job to the queue
	 */
	void addJob(Job j);
	/*
	 * Removes the job that is next from the queue.
	 * Returns null if there are no jobs in the queue.
	 */
	Job getNextJob();

}
