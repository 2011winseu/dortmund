package test;

import com.dortmund.westfalen.assets.Clazz;
import com.dortmund.westfalen.assets.LogTools;

/**
 * Created by sunmingwei on 16/7/7.
 */
public class TestClazz {

    public static void main(String[] args) {
        WestFalen test = new WestFalen("xxx", "yyy");

        Clazz.setObjectValueByPropertyName("url", test, "ttt");

        new WestFalen("123", "234");
    }

    private static class WestFalen {

        private String value;

        private String key;

        public WestFalen(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }
}

