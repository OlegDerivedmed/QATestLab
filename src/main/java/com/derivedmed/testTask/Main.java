package com.derivedmed.testTask;

import com.derivedmed.testTask.res.controllers.Mapper;
import com.derivedmed.testTask.res.controllers.TimeController;

import java.io.File;
import java.io.IOException;

/**
 * Result of program is 2 files in resources and console logs.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        TimeController tc = new TimeController();
        tc.startEmulaiton();
        Mapper.writeData(tc.getData());
    }
}
