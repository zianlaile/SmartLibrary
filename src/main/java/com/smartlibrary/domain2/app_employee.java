package com.smartlibrary.domain2;

/**
 * Created by tt on 2017/9/25.
 */
public class app_employee {
    int  dwAccNo;
    String szPID;
    String szTrueName;
    int   dwSex;
    String dwBirthDate;
    String  dwJobTitle;
    String dwDuty;
    int   dwJobType;
    String szAcademicSubjectCode;
    String dwProfessionalTitle;
    String dwEducation;
    String dwExpertType;
    int dwInlandUduTime;
    int dwInlandOtherTime;
    int dwAbroadUduTime;
    int dwAbroadOtherTime;
    String szMemo;
    int pageSize;//一页多少数据
    int offset; //从第几条数据开始查'

    public int getDwAccNo() {
        return dwAccNo;
    }

    public void setDwAccNo(int dwAccNo) {
        this.dwAccNo = dwAccNo;
    }

    public String getSzPID() {
        return szPID;
    }

    public void setSzPID(String szPID) {
        this.szPID = szPID;
    }

    public String getSzTrueName() {
        return szTrueName;
    }

    public void setSzTrueName(String szTrueName) {
        this.szTrueName = szTrueName;
    }

    public int getDwSex() {
        return dwSex;
    }

    public void setDwSex(int dwSex) {
        this.dwSex = dwSex;
    }

    public String getDwBirthDate() {
        return dwBirthDate;
    }

    public void setDwBirthDate(String dwBirthDate) {
        this.dwBirthDate = dwBirthDate;
    }

    public String getDwJobTitle() {
        return dwJobTitle;
    }

    public void setDwJobTitle(String dwJobTitle) {
        this.dwJobTitle = dwJobTitle;
    }

    public String getDwDuty() {
        return dwDuty;
    }

    public void setDwDuty(String dwDuty) {
        this.dwDuty = dwDuty;
    }

    public int getDwJobType() {
        return dwJobType;
    }

    public void setDwJobType(int dwJobType) {
        this.dwJobType = dwJobType;
    }

    public String getSzAcademicSubjectCode() {
        return szAcademicSubjectCode;
    }

    public void setSzAcademicSubjectCode(String szAcademicSubjectCode) {
        this.szAcademicSubjectCode = szAcademicSubjectCode;
    }

    public String getDwProfessionalTitle() {
        return dwProfessionalTitle;
    }

    public void setDwProfessionalTitle(String dwProfessionalTitle) {
        this.dwProfessionalTitle = dwProfessionalTitle;
    }

    public String getDwEducation() {
        return dwEducation;
    }

    public void setDwEducation(String dwEducation) {
        this.dwEducation = dwEducation;
    }

    public String getDwExpertType() {
        return dwExpertType;
    }

    public void setDwExpertType(String dwExpertType) {
        this.dwExpertType = dwExpertType;
    }

    public int getDwInlandUduTime() {
        return dwInlandUduTime;
    }

    public void setDwInlandUduTime(int dwInlandUduTime) {
        this.dwInlandUduTime = dwInlandUduTime;
    }

    public int getDwInlandOtherTime() {
        return dwInlandOtherTime;
    }

    public void setDwInlandOtherTime(int dwInlandOtherTime) {
        this.dwInlandOtherTime = dwInlandOtherTime;
    }

    public int getDwAbroadUduTime() {
        return dwAbroadUduTime;
    }

    public void setDwAbroadUduTime(int dwAbroadUduTime) {
        this.dwAbroadUduTime = dwAbroadUduTime;
    }

    public int getDwAbroadOtherTime() {
        return dwAbroadOtherTime;
    }

    public void setDwAbroadOtherTime(int dwAbroadOtherTime) {
        this.dwAbroadOtherTime = dwAbroadOtherTime;
    }

    public String getSzMemo() {
        return szMemo;
    }

    public void setSzMemo(String szMemo) {
        this.szMemo = szMemo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
