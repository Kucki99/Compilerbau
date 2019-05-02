package de.robinkuck.lexer;

public class Token extends TokenIntf {

    public String toString() {
        String s = type2String(m_type);
        if (m_type == Type.IDENT) {
            s += ' ';
            s += m_stringValue;
        } else if (m_type == Type.INTEGER) {
            s += ' ';
            s += Integer.toString(m_intValue);
        }
        return s;
    }

    static String type2String(Type type) {
        if (type == Type.EOF) {
            return "EOF";
        } else if (type == Type.IDENT) {
            return "IDENT";
        } else if (type == Type.INTEGER) {
            return "INTEGER";
        } else if (type == Type.PLUS) {
            return "PLUS";
        } else if (type == Type.MINUS) {
            return "MINUS";
        } else if (type == Type.MUL) {
            return "MUL";
        } else if (type == Type.DIV) {
            return "DIV";
        } else if (type == Type.LPAREN) {
            return "LPAREN";
        } else if (type == Type.RPAREN) {
            return "RPAREN";
        } else if (type == Type.ASSIGN) {
            return "ASSIGN";
        } else {
            return null;
        }

    }
}
