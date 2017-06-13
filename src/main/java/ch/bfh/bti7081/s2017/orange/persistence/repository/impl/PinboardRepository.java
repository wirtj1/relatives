package ch.bfh.bti7081.s2017.orange.persistence.repository.impl;

import ch.bfh.bti7081.s2017.orange.persistence.entity.PinBoard;
import ch.bfh.bti7081.s2017.orange.persistence.repository.Repository;

/**
 * @author Leandro on 30/5/2017.
 */
public class PinboardRepository extends Repository<PinBoard> {
    private PinBoardEntryRepository pinBoardEntryRepository;

    public PinboardRepository(Class<PinBoard> entityClass) {
        super(entityClass);
        pinBoardEntryRepository = new PinBoardEntryRepository();
    }

    PinboardRepository() {
        super(PinBoard.class);
        pinBoardEntryRepository = new PinBoardEntryRepository();
    }

    @Override
    public PinBoard persist(PinBoard obj) {
        obj.getEntries().stream()
                .filter(entry -> entry.getId() == 0)
                .forEach(entry -> pinBoardEntryRepository.persist(entry));

        super.persist(obj);

        return obj;
    }

    // TODO: delete after merge
    public PinBoard getAllTest() {
        return null;
    }
}
