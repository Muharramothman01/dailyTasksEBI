import java.util.HashMap;

public class SummeriesException extends Exception{

    private ErrorCode errorCodes;

    private static final HashMap<ErrorCode,String> exceptions = new HashMap<>();

    static {
        exceptions.put(ErrorCode.EMPTYSTRING,"String is Empty !!!");
        exceptions.put(ErrorCode.EMPTYWORDLIST,"There is not any important words in this files !!!");
        exceptions.put(ErrorCode.PERCENTATGEOUTOFRANGE,"Percentage out of range, you should enter between 10% or higher to 100% !!!");
        exceptions.put(ErrorCode.EMPTYPATH,"You should enter path !!!");
    }

    public SummeriesException(ErrorCode errorCodes) {
        this.errorCodes = errorCodes;
    }

    @Override
    public String getMessage() {
        return exceptions.get(errorCodes);
    }
}
