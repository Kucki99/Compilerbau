package de.robinkuck.lexer;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class TestBase {
    private String[] m_fileContent;
    private int m_currentLine;

    public String[] readLines(String fileName) throws Exception {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        return lines.toArray(new String[lines.size()]);
    }

    public TestBase(String fileName) throws Exception {
        m_fileContent = readLines(fileName);
        m_currentLine = 0;
    }

    public TestBase() throws Exception {
        m_fileContent = new String[0];
        m_currentLine = 0;
    }

    private String getCurrentLine() {
        if (m_currentLine == m_fileContent.length) {
            return null;
        } else {
            return m_fileContent[m_currentLine];
        }
    }

    public InputStream stringToInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    public abstract String executeTest(String input) throws Exception;

    private void singleTestRun() throws Exception {
        m_currentLine++; // $IN
        String input = new String();
        while (getCurrentLine() != null && !getCurrentLine().equals("$OUT")) {
            input += getCurrentLine();
            input += '\n';
            m_currentLine++;
        }
        if (getCurrentLine() != null) {
            m_currentLine++;
        }
        String output = new String();
        while (getCurrentLine() != null && !getCurrentLine().equals("$IN")) {
            output += getCurrentLine();
            output += '\n';
            m_currentLine++;
        }
        String result = executeTest(input);
        if (result.equals(output)) {
            System.err.println("TEST SUCCEEDED");
            System.err.print(input);
            System.err.println("ACTUAL OUTPUT");
            System.err.print(result);
        } else {
            System.err.println("TEST FAILED");
            System.err.print(input);
            System.err.println("EXPECTED OUTPUT");
            System.err.print(output);
            System.err.println("ACTUAL OUTPUT");
            System.err.print(result);
            throw new Exception("TestFailure");
        }
    }

    public void testRun() throws Exception {
        while (getCurrentLine() != null) {
            while (getCurrentLine() != null && !getCurrentLine().equals("$IN")) {
                System.err.print(getCurrentLine());
                m_currentLine++;
            }
            if (getCurrentLine() != null) {
                singleTestRun();
            }
        }
    }
}