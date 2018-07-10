package enums;

public enum Properties {
    APP("app"),
    SUT("sut"),
    PLATFORM_NAME("platformName"),
    PLATFORM_VERSION("platformVersion"),
    HOST("host"),
    DEVICE_NAME("deviceName"),
    UDID("udid"),
    APP_PACKAGE("appPackage"),
    APP_ACTIVITY("appActivity");

    public String value;

    Properties(String value) {
        this.value = value;
    }
}
