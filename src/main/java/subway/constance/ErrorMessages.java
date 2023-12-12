package subway.constance;

public enum ErrorMessages {
    INVALID_INPUT("유효하지 않은 입력입니다."),
    SAME_STATION("출발역과 도착역이 동일합니다."),
    UNCONNECTED("출발역과 도착역이 연결되어있지 않습니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
