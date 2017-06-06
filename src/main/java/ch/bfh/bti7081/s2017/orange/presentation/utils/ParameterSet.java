package ch.bfh.bti7081.s2017.orange.presentation.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Set of key-value-parameters, which can be passed to a view. Encoding and decoding is handled here
 * (encode:toString(), decode:decode(String encoded)).
 * @author Leandro
 */
public class ParameterSet {
    private Map<String, String> parameters = new HashMap<String, String>();

    private static final String PARAM_EQUAL = "=";
    private static final String PARAM_SPLITTER = "&";

    /**
     * Initializes a new ParameterSet
     */
    public ParameterSet(){}

    /**
     * Add a key-value-parameter to the parameter set
     * @param key: key
     * @param value: value
     */
    public void addParameter(String key, String value)
    {
        parameters.put(key, value);
    }

    /**
     * Gets parameter by key
     * @param key: key to the value
     * @return: value of the key
     */
    public String getParameter(String key)
    {
        if(parameters.containsKey(key))
            return parameters.get(key);

        return "";
    }

    /**
     * Encodes the parameters, so it can be passed. Decode with ParameterSet.decode()
     * @return: Encoded String
     */
    @Override
    public String toString() {
        return parameters.entrySet()
                .stream()
                .map(stringStringEntry -> stringStringEntry.getKey() + PARAM_EQUAL + stringStringEntry.getValue())
                .reduce((s, s2) -> s + PARAM_SPLITTER + s2).orElse("");
    }

    /**
     * Decodes an encoded ParameterSet, which typically is retrieved by a view.
     * @param encoded: The encoded parameter string of a view
     * @return: ParameterSet representing the passed parameters
     */
    public static ParameterSet decode(String encoded)
    {
        ParameterSet parameterSet = new ParameterSet();

        if(encoded == null || encoded.equals("")) return parameterSet;

        Arrays.stream(encoded.split(PARAM_SPLITTER)).forEach(s -> {
            String[] splitted = s.split(PARAM_EQUAL);
            parameterSet.addParameter(splitted[0], splitted[1]);
        });

        return parameterSet;
    }
}
