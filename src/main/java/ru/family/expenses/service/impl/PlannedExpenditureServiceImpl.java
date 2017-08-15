package ru.family.expenses.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.family.expenses.dao.api.PlannedExpenditureDao;
import ru.family.expenses.model.PlannedExpenditure;
import ru.family.expenses.service.api.PlannedExpenditureService;

import java.util.List;

@Service
public class PlannedExpenditureServiceImpl implements PlannedExpenditureService {

    private final PlannedExpenditureDao plannedExpenditureDao;

    @Autowired
    public PlannedExpenditureServiceImpl(PlannedExpenditureDao plannedExpenditureDao) {
        this.plannedExpenditureDao = plannedExpenditureDao;
    }

    @Override
    public void addPlannedExpenditure(PlannedExpenditure plannedExpenditure) {
        plannedExpenditureDao.persist(plannedExpenditure);
    }

    @Override
    public void deletePlannedExpenditureById(Long id) {
        plannedExpenditureDao.deleteByKey(id);
    }

    @Override
    public void updatePlannedExpenditure(PlannedExpenditure plannedExpenditure) {
        plannedExpenditureDao.update(plannedExpenditure);
    }

    @Override
    public PlannedExpenditure getPlannedExpenditureById(Long id) {
        return plannedExpenditureDao.getEntityByKey(id);
    }

    @Override
    public List<PlannedExpenditure> getAllPlannedExpenditure() {
        return plannedExpenditureDao.getAllEntity();
    }
}
