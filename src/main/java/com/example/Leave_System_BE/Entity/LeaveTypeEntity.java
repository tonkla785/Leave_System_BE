package com.example.Leave_System_BE.Entity;

import com.example.Leave_System_BE.EnumType.TypeLeaveEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "leave_types")
public class LeaveTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private TypeLeaveEnum typeName;

    @Column(name = "description")
    private String typeDescription;

    @Column(name = "max_days")
    private Integer maxDay;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public TypeLeaveEnum getTypeName() {
        return typeName;
    }

    public void setTypeName(TypeLeaveEnum typeName) {
        this.typeName = typeName;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public Integer getMaxDay() {
        return maxDay;
    }

    public void setMaxDay(Integer maxDay) {
        this.maxDay = maxDay;
    }
}
