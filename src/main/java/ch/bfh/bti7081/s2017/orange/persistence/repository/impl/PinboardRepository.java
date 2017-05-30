package ch.bfh.bti7081.s2017.orange.persistence.repository.impl;

import ch.bfh.bti7081.s2017.orange.persistence.entity.PinBoard;
import ch.bfh.bti7081.s2017.orange.persistence.entity.PinBoardEntry;
import ch.bfh.bti7081.s2017.orange.persistence.repository.Repository;

import java.util.List;

/**
 * @author Leandro on 30/5/2017.
 */
public class PinboardRepository extends Repository<PinBoard> {
    private PinBoardEntryRepository pinBoardEntryRepository;

    public PinboardRepository(Class<PinBoard> entityClass) {
        super(entityClass);
        pinBoardEntryRepository = new PinBoardEntryRepository(PinBoardEntry.class);
    }


    protected List<Repository> getAll()
    {
        return getEm().createQuery("select p from PinBoard p").getResultList();
    }

    @Override
    public PinBoard persist(PinBoard obj) {
        obj.getEntries().forEach(entry -> pinBoardEntryRepository.persist(entry));
        return super.persist(obj);
    }



    private class PinBoardEntryRepository extends Repository<PinBoardEntry>
    {
        public PinBoardEntryRepository(Class<PinBoardEntry> entityClass) {
            super(entityClass);
        }
    }
}
