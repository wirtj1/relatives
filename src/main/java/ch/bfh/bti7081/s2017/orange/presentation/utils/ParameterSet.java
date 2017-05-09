package ch.bfh.bti7081.s2017.orange.presentation.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Leandro on 8/5/2017.
 */
public class ParameterSet {
    private Map<String, String> parameters = new HashMap<String, String>();

    private static final String PARAM_EQUAL = "=";
    private static final String PARAM_SPLITTER = "&";


    public ParameterSet(){}

    public void addParameter(String key, String value)
    {
        parameters.put(key, value);
    }

    public String getParameter(String key)
    {
        return parameters.get(key);
    }

    @Override
    public String toString() {
        return parameters.entrySet()
                .stream()
                .map(stringStringEntry -> stringStringEntry.getKey() + PARAM_EQUAL + stringStringEntry.getValue())
                .reduce((s, s2) -> s + PARAM_SPLITTER + s2).orElse("");
    }

    public static ParameterSet decode(String encoded)
    {
        ParameterSet parameterSet = new ParameterSet();

        Arrays.stream(encoded.split(PARAM_SPLITTER)).forEach(s -> {
            String[] splitted = s.split(PARAM_EQUAL);
            parameterSet.addParameter(splitted[0], splitted[1]);
        });

        return parameterSet;
    }
}
