package ru.family.expenses.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "planned_expenditure")
public class PlannedExpenditure {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 2, max = 30)
    @Column(name = "description", length = 30, nullable = false)
    private String description;

    @NotNull
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    public PlannedExpenditure() {

    }

    public PlannedExpenditure(String description, BigDecimal price) {
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PlannedExpenditure{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
