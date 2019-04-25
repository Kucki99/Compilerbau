package de.robinkuck.statemachine;

import java.util.HashMap;

public class StateMap {

	private HashMap<String, State> m_stateMap;
	private State m_startState;
	
	public StateMap() {
		m_stateMap = new HashMap<String, State>();
	}

	public State getState(String stateName) {
		State state = m_stateMap.get(stateName);
		if (state != null) {
			return state;
		} else {
			state = new State(stateName);
			if (m_startState == null) {
				m_startState = state;
			}
			m_stateMap.put(stateName,  state);
			return state;
		}
	}
	
	public State getStartState() {
		return m_startState;
	}
}
