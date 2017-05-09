package ch.bfh.bti7081.s2017.orange.presentation.utils;

/**
 * Created by Leandro on 7/5/2017.
 */
public class NavigationUtils {

    public static String combineNameAndParams(String name, ParameterSet parameterSet)
    {
        if(parameterSet != null)
        {
            return name + "/" + parameterSet.toString();
        }
        else
        {
            return name;
        }
    }
}
