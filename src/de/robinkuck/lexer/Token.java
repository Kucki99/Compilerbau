package de.robinkuck.lexer;

public class Token extends TokenIntf {

    @Override
    public String toString() {
        if (m_type == Type.INTEGER) {
            return m_type + " " + m_intValue;
        } else {
            return m_type + " " + m_stringValue;
        }
    }
}
