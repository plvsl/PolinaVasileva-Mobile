package setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class TestProperties {
    private Properties currentProps = new Properties();
    String propertyPath;

    private Properties getCurrentProps() throws IOException {
        FileInputStream in = new FileInputStream(propertyPath);
        currentProps.load(in);
        in.close();
        return currentProps;
    }

    protected String getProp(String propKey) throws IOException {
        if(!currentProps.containsKey(propKey)) {
            currentProps = getCurrentProps();
        }
        // "default" form used to handle the absence of parameter
        return currentProps.getProperty(propKey, null);
    }
}