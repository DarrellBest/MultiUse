package com.enjin.angelcraftonomy.interfaces;

public interface CommandInterface {
	public void initialize();

	public void run();

	public void cleanup();

	public void sendNoPermMessage();
}
