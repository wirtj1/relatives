package ch.bfh.bti7081.s2017.orange.businesslogic.models;

/**
 * Created by Sascha on 01/05/2017.
 */
public class  MainModel extends BaseModel {
    private long userId;

    private String userName;


    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }


}
