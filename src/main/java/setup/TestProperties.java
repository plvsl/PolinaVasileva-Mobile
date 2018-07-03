package setup;

import enums.PropertyFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class TestProperties {
    private Properties currentProps = new Properties();
    PropertyFile propertyFile;

    private Properties getCurrentProps() throws IOException {
        FileInputStream in = new FileInputStream(new File(propertyFile.value).getAbsolutePath());
        currentProps.load(in);
        in.close();
        return currentProps;
    }

    String getProp(String propKey) throws IOException {
        if (!currentProps.containsKey(propKey)) {
            currentProps = getCurrentProps();
        }
        // "default" form used to handle the absence of parameter
        return currentProps.getProperty(propKey, null);
    }
}