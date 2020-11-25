package edu.webapp.webapp.DTO;

public class SentenceDTO {
	private String sentence;

	public SentenceDTO() {
	}

	public String getSentence() {
		return sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	@Override
	public String toString() {
		return sentence;
	}
}
