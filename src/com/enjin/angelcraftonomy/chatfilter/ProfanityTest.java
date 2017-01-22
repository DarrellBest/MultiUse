package com.enjin.angelcraftonomy.chatfilter;

public class ProfanityTest {

	public static void main(String[] args) {
		ChatFilter prof = new ChatFilter();
		String message = "fuckshitpiss";
		message = prof.replaceSwearWords(message);
		System.out.println(message);

	}

}
