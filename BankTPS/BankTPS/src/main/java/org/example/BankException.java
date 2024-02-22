package org.example;

import java.util.HashMap;

public class BankException extends Exception{
    private final ErrorCode errorCode;
    private static final HashMap<ErrorCode,String> exceptions = new HashMap<>();
    static {
        exceptions.put(ErrorCode.NEGATIVEVALUE,"Enter Positive value, please");
        exceptions.put(ErrorCode.INSUFFENCTVALUE,"This value is high than your balance");
    }
    public BankException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return exceptions.get(errorCode);
    }
}
