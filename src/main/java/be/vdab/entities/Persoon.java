package be.vdab.entities;

import java.util.LinkedHashSet;
import java.util.Set;

public class Persoon {	
	private Set<String> voornamen;
	
	public Persoon(Set<String> voornamen){
		if (voornamen.isEmpty()){
			throw new IllegalArgumentException();
		} 		
		setVoornamen(voornamen);
	}	

	public Set<String> getVoornamen() {
		return voornamen;
	}
	
	private void setVoornamen(Set<String> voornamen) {
		this.voornamen = new LinkedHashSet<>();
		for (String entry:voornamen){
			addVoornaam(entry);
		}
	}	
	
	public void addVoornaam(String voornaam){
		if (! voornaam.isEmpty()){
			this.voornamen.add(voornaam);
		} else {
			throw new IllegalArgumentException();
		}		
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (String voornaam:voornamen){
			builder.append(voornaam).append(' ');
		}
		builder.deleteCharAt(builder.length() - 1);
		return builder.toString();
	}
}
