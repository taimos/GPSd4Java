package de.taimos.gpsd4java.backend;

/**
 * Not as efficient as AtomicBoolean but you can wait on it.
 *
 * @author TimW
 */
class WaitableBoolean {
	
	private boolean val;
	
	public WaitableBoolean(boolean b) {
		this.val = b;
	}
	
	synchronized void set(boolean value) {
		this.val = value;
		notifyAll();
	}
	
	synchronized boolean get() {
		return this.val;
	}
	
	synchronized public void waitFor(long millis) throws InterruptedException {
		super.wait(millis);
	}
}