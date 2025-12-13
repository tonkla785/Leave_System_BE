package com.example.Leave_System_BE.DTO;

import com.example.Leave_System_BE.EnumType.TypeLeaveEnum;

public class LeaveBalanceResponseDTO {
    private Long id;
    private Integer leaveYear;
    private Integer remainDay;
    private String userName;
    private TypeLeaveEnum leaveTypeName;

    public LeaveBalanceResponseDTO(Long id, Integer leaveYear, Integer remainDay, String userName, TypeLeaveEnum leaveTypeName) {
        this.id = id;
        this.leaveYear = leaveYear;
        this.remainDay = remainDay;
        this.userName = userName;
        this.leaveTypeName = leaveTypeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
