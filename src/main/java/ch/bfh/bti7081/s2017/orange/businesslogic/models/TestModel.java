package ch.bfh.bti7081.s2017.orange.businesslogic.models;

/**
 * Created by Sascha on 01/05/2017.
 */
public class TestModel extends BaseModel {
    private String message;

    public TestModel()
    {
        message = "That's the detail view, man!";
    }

    String getMessage()
    {
        return message;
    }
}
