package ch.bfh.bti7081.s2017.orange.persistence.repository.impl;

import ch.bfh.bti7081.s2017.orange.persistence.entity.Medication;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Person;
import ch.bfh.bti7081.s2017.orange.persistence.repository.Repository;

import java.util.List;

/**
 * Created by Sascha on 30/05/2017.
 */
public class MedicationRepository extends Repository<Medication> {

    public MedicationRepository(Class<Medication> entityClass) {
        super(entityClass);
    }

/*    public List<Medication> getAll()
    {
        return getEm().createQuery("select m from Medication m").getResultList();
    }*/
}
