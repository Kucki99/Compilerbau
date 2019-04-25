package de.robinkuck.statemachine;

import de.robinkuck.filereader.FileReaderIntf;

public class StateReader implements StateReaderIntf {
    private FileReaderIntf m_reader;
    private StateMap m_stateMap;

    public StateReader(FileReaderIntf reader) {
        m_reader = reader;
        m_stateMap = new StateMap();
    }

    public void readState() throws Exception {
        String stateName = getIdent();
        State state = m_stateMap.getState(stateName);
        m_reader.expect(':');
        while (m_reader.lookAheadChar() == '(') {
            m_reader.advance();
            char terminal = m_reader.lookAheadChar();
            m_reader.advance();
            m_reader.expect(',');
            String targetStateName = getIdent();
            State targetState = m_stateMap.getState(targetStateName);
            m_reader.expect(')');
            state.addTransition(terminal, targetState);
        }
        if (m_reader.lookAheadChar() == '!') {
            m_reader.advance();
            state.setFinal();
        }
        m_reader.expect('\n');
    }

    public String getIdent() throws Exception {
        String ident = "";
        char nextChar = m_reader.lookAheadChar();
        if (isIdentifierStart(nextChar)) {
            do {
                ident += nextChar;
                m_reader.advance();
                nextChar = m_reader.lookAheadChar();
            } while (isIdentifierPart(nextChar));
        } else {
            throw new Exception("Identifier expected");
        }
        return ident;
    }

    public boolean isIdentifierStart(char c) {
        boolean isStart = ('a' <= c && c <= 'z');
        return isStart;
    }

    public boolean isIdentifierPart(char c) {
        boolean isPart = ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
        return isPart;
    }

    public StateMap getStateMap() {
        return m_stateMap;
    }
}