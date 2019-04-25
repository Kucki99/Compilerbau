package de.robinkuck.statemachine;

import java.util.HashMap;

public class State {
	private String m_name;
	private HashMap<String, State> m_transitionMap;
	private boolean m_isFinal;

	public State(String name) {
		m_name = name;
		m_transitionMap = new HashMap<String, State>();
		m_isFinal = false;
	}
	
	public void addTransition(char terminal, State targetState) {
		String s = new String();
		s += terminal;
		m_transitionMap.put(s, targetState);
	}
	
	public State getTransition(char terminal) {
		String s = new String();
		s += terminal;
		State st = m_transitionMap.get(s);
		return st;
	}
	
	public String getName() {
		return m_name;
	}

	public boolean isFinal() {
		return m_isFinal;
	}
	
	public void setFinal() {
		m_isFinal = true;
	}
}
