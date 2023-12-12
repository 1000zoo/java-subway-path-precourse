package subway.constance;

public enum InstructionMessages {
    MAIN_INSTRUCTION("## 메인 화면\n1. 경조 조회\nQ. 종료"),
    SELECT_MESSAGE("## 원하는 기능을 선택하세요."),
    STANDARD_INSTRUCTION("## 경로 기준\n1. 최단 거리\n2. 최소 시간\nB. 돌아가기"),
    FROM_INSTRUCTION("## 출발역을 입력하세요."),
    TO_INSTRUCTION("## 도착역을 입력하세요."),
    RESULT_INSTRUCTION("## 조회 결과");

    private final String message;

    InstructionMessages(String s) {
        message = s;
    }

    public String getMessage() {
        return message;
    }
}
