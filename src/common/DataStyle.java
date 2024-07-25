package common;

public enum DataStyle {

    RANDOM("random","随机数"),
    STEP("step","指定步长");

    private String style;
    private String desc;

    DataStyle() {
    }

    DataStyle(String style, String desc) {
        this.style = style;
        this.desc = desc;
    }
}
