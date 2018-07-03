package enums;

public enum DeviceName {
    EMULATOR("emulator-5554"),
    REAL_DEVICE("e081dc16");

    public String value;

    DeviceName(String value) {
        this.value = value;
    }
}
