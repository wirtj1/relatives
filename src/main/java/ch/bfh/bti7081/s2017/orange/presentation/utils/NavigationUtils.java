package ch.bfh.bti7081.s2017.orange.presentation.utils;

/**
 * @author Leandro
 * This helper class provides additional functionality for the navigation.
 */
public class NavigationUtils {

    /**
     * Combines Name and Parameter
     * @param name: name of the targetView
     * @param parameterSet: parameters to be passed
     * @return: String which combines name and parameters
     *
     * @author Leandro
     */
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
