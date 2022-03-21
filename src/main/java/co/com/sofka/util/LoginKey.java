package co.com.sofka.util;

public enum LoginKey {

    EMAIL("[email]"),
    PASSWORD(" "),

    NAME("[name]"),
    JOB("[job]");



    private final String value;

    LoginKey(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
