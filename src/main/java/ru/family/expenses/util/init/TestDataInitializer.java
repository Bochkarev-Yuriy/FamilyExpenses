package ru.family.expenses.util.init;

import org.springframework.beans.factory.annotation.Autowired;
import ru.family.expenses.model.PlannedExpenditure;
import ru.family.expenses.service.api.PlannedExpenditureService;

import java.math.BigDecimal;

public class TestDataInitializer {


    @Autowired
    private PlannedExpenditureService plannedExpenditureService;

    private void init() {
        PlannedExpenditure planned1 = new PlannedExpenditure("GGG", new BigDecimal("2500"));
        PlannedExpenditure planned2 = new PlannedExpenditure("Ремонт афто", new BigDecimal("5000"));
        PlannedExpenditure planned3 = new PlannedExpenditure("Провизия", new BigDecimal("8000"));

        plannedExpenditureService.addPlannedExpenditure(planned1);
        plannedExpenditureService.addPlannedExpenditure(planned2);
        plannedExpenditureService.addPlannedExpenditure(planned3);
    }



}
