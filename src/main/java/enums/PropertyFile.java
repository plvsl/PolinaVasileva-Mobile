package enums;

public enum PropertyFile {
    NATIVE("nativeTest.properties"),
    WEB("webTest.properties");

    public String value;

    PropertyFile(String value) {
        this.value = value;
    }
}
