package ch.bfh.bti7081.s2017.orange.persistence.repository.impl;

import ch.bfh.bti7081.s2017.orange.persistence.entity.Medicine;
import ch.bfh.bti7081.s2017.orange.persistence.repository.Repository;

/**
 * Created by Sascha on 30/05/2017.
 */
public class MedicineRepository extends Repository<Medicine> {
    public MedicineRepository(Class<Medicine> entityClass) {
        super(entityClass);
    }
}
