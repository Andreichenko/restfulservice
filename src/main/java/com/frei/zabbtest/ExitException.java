package com.frei.zabbtest;


import lombok.NonNull;
import org.springframework.boot.ExitCodeGenerator;

/**
 *  Class Exception for App
 *
 *
 *  by Andreichenko
 */

public class ExitException extends RuntimeException implements ExitCodeGenerator{

    /**
     *
     * @return  return method
     */

    @Override
    public int getExitCode() {
        return 1;
    }

    public ExitException() {
        super();
    }

    public ExitException(Exception source) {
        super(source);
    }

    public ExitException(@NonNull String message) {
        super(message);
    }
}
