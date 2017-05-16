package ch.bfh.bti7081.s2017.orange.businesslogic.models;

/**
 * Created by Jasmin on 16.05.2017.
 */
public class PinnboardEntry
{

    private String title;
    private String date;
    private EntryType entryType;
    private String description;

    public PinnboardEntry(String title, String date, EntryType entryType, String description)
    {
        this.title = title;
        this.date = date;
        this.entryType = entryType;
        this.description = description;
    }

}

enum EntryType
{
    DOSE,//Anfall
    ACCIDENT,//Unfall
    EVENT;//Ereignis
}