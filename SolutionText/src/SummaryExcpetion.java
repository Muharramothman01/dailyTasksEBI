import java.util.HashMap;

public class SummaryExcpetion extends Exception{
    private ErrorCode errorCode;
    private static final HashMap<ErrorCode,String> exceptions = new HashMap<>();

    static {
        exceptions.put(ErrorCode.EMPTYSTRING,"Empty String");
        exceptions.put(ErrorCode.EMPTYWORDLIST,"Empty WordList");
        exceptions.put(ErrorCode.PERCENTATGEOUTOFRANGE,"Out of Range");
    }

    public SummaryExcpetion(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return exceptions.get(errorCode);
    }
}
