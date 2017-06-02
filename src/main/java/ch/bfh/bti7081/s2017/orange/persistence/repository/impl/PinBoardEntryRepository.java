package ch.bfh.bti7081.s2017.orange.persistence.repository.impl;

import ch.bfh.bti7081.s2017.orange.persistence.entity.PinBoardEntry;
import ch.bfh.bti7081.s2017.orange.persistence.repository.Repository;

/**
 * @author Leandro on 2/6/2017.
 */


public class PinBoardEntryRepository extends Repository<PinBoardEntry> {
    public PinBoardEntryRepository() {
        super(PinBoardEntry.class);
    }
}