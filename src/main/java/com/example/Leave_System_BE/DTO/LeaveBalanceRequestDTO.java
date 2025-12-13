package com.example.Leave_System_BE.DTO;

import jakarta.validation.constraints.NotNull;

public class LeaveBalanceRequestDTO {

    @NotNull(message = "userId is required")
    private Long userId;

    @NotNull(message = "leaveTypeId is required")
    private Long leaveTypeId;

    @NotNull(message = "year is required")
    private Integer year;

    @NotNull(message = "remainDay is required")
    private Integer remainDay;

    public Integer getRemainDay() {
        return remainDay;
    }

    public void setRemainDay(Integer remainDay) {
        this.remainDay = remainDay;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(Long leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }
}
