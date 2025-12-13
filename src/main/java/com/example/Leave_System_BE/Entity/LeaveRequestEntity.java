package com.example.Leave_System_BE.Entity;

import com.example.Leave_System_BE.EnumType.StatusEnum;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "leave_requests")
public class LeaveRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEnum leaveStatus;

    @Column(name = "reason")
    private String leaveReason;

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public StatusEnum getLeaveStatus() {
        return leaveStatus;
    }

    public void setLeaveStatus(StatusEnum leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
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
