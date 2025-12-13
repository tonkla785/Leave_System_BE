package com.example.Leave_System_BE.DTO;

import com.example.Leave_System_BE.EnumType.StatusEnum;
import com.example.Leave_System_BE.EnumType.TypeLeaveEnum;

import java.util.Date;

public class LeaveRequestResponseDTO {
    private Long id;
    private Date startDate;
    private Date endDate;
    private StatusEnum leaveStatus;
    private String leaveReason;
    private String userName;
    private TypeLeaveEnum leaveTypeName;

    public LeaveRequestResponseDTO(Long id, Date startDate, Date endDate, StatusEnum leaveStatus, String leaveReason, String userName, TypeLeaveEnum leaveTypeName) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaveStatus = leaveStatus;
        this.leaveReason = leaveReason;
        this.userName = userName;
        this.leaveTypeName = leaveTypeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public TypeLeaveEnum getLeaveTypeName() {
        return leaveTypeName;
    }

    public void setLeaveTypeName(TypeLeaveEnum leaveTypeName) {
        this.leaveTypeName = leaveTypeName;
    }
}
