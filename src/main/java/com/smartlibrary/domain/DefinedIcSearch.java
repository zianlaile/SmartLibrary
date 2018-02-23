package com.smartlibrary.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class DefinedIcSearch implements Serializable {
    @NotNull
    String timeSection;
    @NotNull @DateTimeFormat(pattern = "yyyy/MM/dd")
    String start_time;
    @NotNull @DateTimeFormat(pattern = "yyyy/MM/dd")
    String end_time;
    String student_style;
    int ic_type;  //

    @NotNull @Size(max=1,min=0)
    int style;  //0-时长,1-人次

    public String getTimeSection() {
        return timeSection;
    }

    public void setTimeSection(String timeSection) {
        this.timeSection = timeSection;
        this.start_time=timeSection.split("-")[0].trim().replace('/','-');
        this.end_time=timeSection.split("-")[1].trim().replace('/','-');
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getStudent_style() {
        return student_style;
    }

    public void setStudent_style(String student_style) {
        this.student_style = student_style;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public int getIc_type() {
        return ic_type;
    }

    public void setIc_type(int ic_type) {
        this.ic_type = ic_type;
    }

    @Override
    public String toString() {
        return "DefinedIcSearch{" +
                "timeSection='" + timeSection + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", student_style='" + student_style + '\'' +
                ", ic_type=" + ic_type +
                ", style=" + style +
                '}';
    }
}
