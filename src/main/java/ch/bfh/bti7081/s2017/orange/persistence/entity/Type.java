package ch.bfh.bti7081.s2017.orange.persistence.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yvesbeutler
 *         Enumeration for different information level used for {@link PinBoardEntry}.
 */
public enum Type
{
    WARNING(2),
    INFORMATION(3),
    ALERT(1);


    private int typeValue;

    private static final Map<Integer, Type> MAPPING_TYPE = new HashMap<>();

    static
    {
        for (Type value : Type.values())
            MAPPING_TYPE.put(value.typeValue(), value);
    }


    Type(int typeValue)
    {
        this.typeValue = typeValue;
    }

    public int typeValue()
    {
        return typeValue;
    }

    public static Type valueOf(int typeValue)
    {
        return MAPPING_TYPE.get(typeValue);
    }
}


