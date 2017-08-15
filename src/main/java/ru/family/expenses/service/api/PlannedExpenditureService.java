package ru.family.expenses.service.api;

import ru.family.expenses.model.PlannedExpenditure;

import java.util.List;

public interface PlannedExpenditureService {

    void addPlannedExpenditure(PlannedExpenditure plannedExpenditure);

    void deletePlannedExpenditureById(Long id);

    void updatePlannedExpenditure(PlannedExpenditure plannedExpenditure);

    PlannedExpenditure getPlannedExpenditureById(Long id);

    List<PlannedExpenditure> getAllPlannedExpenditure();
}
