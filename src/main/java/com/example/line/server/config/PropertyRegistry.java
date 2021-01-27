package com.example.line.server.config;

import com.example.line.server.constants.ConstantManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class PropertyRegistry {

    private Environment env;

    @Autowired
    public PropertyRegistry(Environment env) {
        this.env = env;
        setConstantsValue();
    }

    private void setConstantsValue() {
        ConstantManager.FILE_PATH.setValue( getPropertyValue( PropertiesValues.FOLDER_PATH ) );
    }

    public String getPropertyValue( String property ) {
        String returnValue = Defaults.getDefaultWithConfigKey(property);

        String keyValue = env.getProperty( property );

        if ( keyValue != null && !keyValue.isEmpty() ) {
            returnValue = keyValue;
        }
        return returnValue;
    }

    public enum Defaults {

        DEFAULT_FILE_PATH(PropertiesValues.FOLDER_PATH, "README.md");

        private final String propertyKey;
        private final String defaultValue;

        Defaults(String propertyKey, String defaultValue) {
            this.propertyKey = propertyKey;
            this.defaultValue = defaultValue;
        }

        protected String getDefaultValue() {
            return defaultValue;
        }

        protected String getPropertyKey() {
            return propertyKey;
        }

        public static String getDefaultWithConfigKey(String value ) {
            for ( Defaults town : Defaults.values()) {
                if ( town.getPropertyKey().toUpperCase().equals(value.toUpperCase())) {
                    return town.getDefaultValue();
                }
            }
            return Defaults.DEFAULT_FILE_PATH.getDefaultValue();
        }

    }

}
