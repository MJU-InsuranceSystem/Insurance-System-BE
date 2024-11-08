package fourservings_fiveservings.insurance_system_be.common.vo;

import java.util.HashMap;
import java.util.Map;

public class ResponseVO {

    private final Map<String, String> requestInfo = new HashMap<>();

    public void add(String key, String value) {
        requestInfo.put(key, value);
    }

    public String get(String key) {
        return requestInfo.get(key);
    }

    public Map<String, String> getTotalInfo() {
        return this.requestInfo;
    }
}
