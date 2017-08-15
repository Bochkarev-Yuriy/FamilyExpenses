package ru.family.expenses.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.family.expenses.dao.api.PlannedExpenditureDao;
import ru.family.expenses.model.PlannedExpenditure;

@Transactional
@Repository
public class PlannedExpenditureDaoImpl extends AbstractDao<Long, PlannedExpenditure> implements PlannedExpenditureDao {

}
