package ch.bfh.bti7081.s2017.orange.persistence.repository.impl;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.PinboardModel;
import ch.bfh.bti7081.s2017.orange.persistence.entity.*;
import ch.bfh.bti7081.s2017.orange.persistence.repository.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * @author Leandro on 30/5/2017.
 */
public class PinboardRepository extends Repository<PinBoard> {
    private PinBoardEntryRepository pinBoardEntryRepository;

    public PinboardRepository(Class<PinBoard> entityClass) {
        super(entityClass);
        pinBoardEntryRepository = new PinBoardEntryRepository();
    }

    public PinboardRepository() {
        super(PinBoard.class);
        pinBoardEntryRepository = new PinBoardEntryRepository();
    }


    public List<PinBoard> getAll() {
        List<PinBoard> pinBoards = getEm().createQuery("select p from PinBoard p").getResultList();
        return pinBoards;
    }

    @Override
    public PinBoard persist(PinBoard obj) {


        obj.getEntries().stream()
                .filter(entry -> entry.getId() == 0)
                .forEach(entry -> pinBoardEntryRepository.persist(entry));

        super.persist(obj);

        return obj;


    }


    public PinBoard getAllTest() {
        PinboardModel pinboard = new PinboardModel();
        Relative relative = new Relative("John", "Master");
        Patient patient = new Patient("Hans", "Muster");

        try {
            pinboard.addEntry(new PinBoardEntry(Type.ALERT, "Neighbour", "Our neighbour disappeard!", relative,
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.GERMAN).parse("2017-05-20 19:46:47")));

            pinboard.addEntry(new PinBoardEntry(Type.INFORMATION, "Alone", "John was alone yesterday", relative,
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.GERMAN).parse("2017-05-21 15:02:32")));

            pinboard.addEntry(new PinBoardEntry(Type.WARNING, "Not cured", "John seems  not to be cured", patient,
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.GERMAN).parse("2017-05-21 19:46:47")));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return pinboard.getPinboard();
    }
}
