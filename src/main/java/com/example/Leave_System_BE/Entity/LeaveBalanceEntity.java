package com.example.Leave_System_BE.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "leave_balances")
public class LeaveBalanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "year")
    private Integer leaveYear;

    @Column(name = "remaining_days")
    private Integer remainDay;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leave_type_id", nullable = false)
    private LeaveTypeEntity leaveTypeEntity;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Integer getLeaveYear() {
        return leaveYear;
    }

    public void setLeaveYear(Integer leaveYear) {
        this.leaveYear = leaveYear;
    }

    public Integer getRemainDay() {
        return remainDay;
    }

    public void setRemainDay(Integer remainDay) {
        this.remainDay = remainDay;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public LeaveTypeEntity getLeaveTypeEntity() {
        return leaveTypeEntity;
    }

    public void setLeaveTypeEntity(LeaveTypeEntity leaveTypeEntity) {
        this.leaveTypeEntity = leaveTypeEntity;
    }
}
