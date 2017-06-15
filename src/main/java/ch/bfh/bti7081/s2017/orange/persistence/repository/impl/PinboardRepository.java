package ch.bfh.bti7081.s2017.orange.persistence.repository.impl;

import ch.bfh.bti7081.s2017.orange.persistence.entity.Patient;
import ch.bfh.bti7081.s2017.orange.persistence.entity.PinBoard;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Relative;
import ch.bfh.bti7081.s2017.orange.persistence.repository.Repository;

import java.util.List;

/**
 * @author Leandro on 30/5/2017.
 */
public class PinboardRepository extends Repository<PinBoard>
{
    private PinBoardEntryRepository pinBoardEntryRepository;

    public PinboardRepository(Class<PinBoard> entityClass)
    {
        super(entityClass);
        pinBoardEntryRepository = new PinBoardEntryRepository();
    }

    public PinboardRepository()
    {
        super(PinBoard.class);
        pinBoardEntryRepository = new PinBoardEntryRepository();
    }


    public List<PinBoard> getAll()
    {
        List<PinBoard> pinBoards = getEm().createQuery("select p from PinBoard p").getResultList();
        return pinBoards;
    }

    public PinBoard getPinboardByRelative(Relative relative)
    {
        PersonRepository repo = new PersonRepository();
        List<Patient> patientsByRelative = repo.getPatientsByRelative(relative);
        Patient patient = patientsByRelative.get(0);

//        patientsByRelative.forEach(p -> pinboard.addEntries(p.getPinboard().getEntries()));
        return patient.getPinboard();
    }

    @Override
    public PinBoard persist(PinBoard obj)
    {
        obj.getEntries().stream()
                .filter(entry -> entry.getId() == 0)
                .forEach(entry -> pinBoardEntryRepository.persist(entry));

        super.persist(obj);

        return obj;
    }


}
