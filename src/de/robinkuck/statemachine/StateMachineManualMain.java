package de.robinkuck.statemachine;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class StateMachineManualMain {

    public static void main(String[] args) throws Exception {
        File file = new File(args[0]);
        InputStream inputStream = new FileInputStream(file);
        FileReaderIntf fileReader = new FileReader(inputStream);
        StateReaderIntf stateReader = new StateReader(fileReader);
        while (fileReader.lookAheadChar() != 0) {
            stateReader.readState();
        }
        String result = StateMachineTest.testWord(stateReader.getStateMap(), args[1], true);
        System.err.println(result);
    }

}
