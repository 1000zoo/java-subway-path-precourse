package subway.view;

public class ResultOutput {

    private final static String PREFIX = "[INFO] ";
    private final static String LINE = "---";
    private final static String TOTAL_DISTANCE = "총 거리: %skm";
    private final static String TOTAL_TIME = "총 소요 시간: %s분";

    private static void print(String message) {
        Output.print(PREFIX + message);
    }

    public static void printLine() {
        print(LINE);
    }

    public static void printStation(String station) {
        print(station);
    }

    public static void printDistance(int distance) {
        print(String.format(TOTAL_DISTANCE, distance));
    }

    public static void printTime(int time) {
        print(String.format(TOTAL_TIME, time));
    }

    public static void printResult(int distance, int time) {
        printLine();
        printDistance(distance);
        printTime(time);
        printLine();
    }
}
