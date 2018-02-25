package com.smartlibrary.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class DefinedPrintSearch implements Serializable {
    @NotNull
    String timeSection;
    @NotNull @DateTimeFormat(pattern = "yyyy/MM/dd")
    String start_time;
    @NotNull @DateTimeFormat(pattern = "yyyy/MM/dd")
    String end_time;

    String print_type;

    String print_location;

    String paper_type;

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

    public String getPrint_type() {
        return print_type;
    }

    public void setPrint_type(String print_type) {
        this.print_type = print_type;
    }

    public String getPrint_location() {
        return print_location;
    }

    public void setPrint_location(String print_location) {
        this.print_location = print_location;
    }

    public String getPaper_type() {
        return paper_type;
    }

    public void setPaper_type(String paper_type) {
        this.paper_type = paper_type;
    }

    @Override
    public String toString() {
        return "DefinedPrintSearch{" +
                "timeSection='" + timeSection + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", print_type='" + print_type + '\'' +
                ", print_location='" + print_location + '\'' +
                ", paper_type=" + paper_type +
                '}';
    }

    public String getSearchContentSubTitle(){
        String title=getContent(timeSection)+getContent(print_type)+getContent(print_location)+getContent(paper_type);
        return title.trim();
    }

    private String getContent(String s){
        if(s!=null&&!s.isEmpty()&&s.trim()!="")
            return s.trim()+" ";
        return "";
    }
}
