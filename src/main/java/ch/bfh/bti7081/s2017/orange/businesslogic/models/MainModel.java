package ch.bfh.bti7081.s2017.orange.businesslogic.models;

import javax.persistence.*;

/**
 * Created by Sascha on 01/05/2017.
 */

@Entity
@Table(name = "USER")
public class MainModel extends BaseModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USERID")
    private long userId;

    @Column(name = "USERNAME")
    private String userName;


    public void setUserId(long userId)
    {
        this.userId = userId;
    }

    public long getUserId()
    {
        return userId;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }


}
