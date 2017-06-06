package ch.bfh.bti7081.s2017.orange.businesslogic.models;

import ch.bfh.bti7081.s2017.orange.persistence.entity.PinBoard;
import ch.bfh.bti7081.s2017.orange.persistence.entity.PinBoardEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jasmin
 * This model is used by the pinboard view to present all pinboard
 * entries to the user.
 **/
public class PinboardModel extends BaseModel
{

    private PinBoard pinboard;

    public PinboardModel()
    {
        pinboard = new PinBoard();
    }

    public List<PinBoardEntry> getEntries()
    {
        return pinboard.getEntries();
    }

    public void addEntry(PinBoardEntry entry)
    {
        pinboard.addEntry(entry);
    }


    public PinBoard getPinboard()
    {
        return pinboard;
    }

    public void setPinboard(PinBoard pinboard)
    {
        this.pinboard = pinboard;
    }
}
