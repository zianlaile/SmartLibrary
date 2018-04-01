package com.smartlibrary.domain;

import com.smartlibrary.dao.definedContentConvertDao;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Arrays;

public class DefinedPersonAssetSearch implements Serializable {
    @NotNull
    String timeSection;
    @NotNull @DateTimeFormat(pattern = "yyyy/MM/dd")
    String start_time;
    @NotNull @DateTimeFormat(pattern = "yyyy/MM/dd")
    String end_time;

    String birth_start;
    String birth_end;

    String sex;
    String profession;
    String[] professionList;

    @NotNull @Size(max=1,min=0)
    int asset_type;//0-设备，1-馆藏

    @NotNull @Size(max=1,min=0)
    int style; //0-人员，1-资产

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

    public String getBirth_start() {
        return birth_start;
    }

    public void setBirth_start(String birth_start) {
        this.birth_start = birth_start;
    }

    public String getBirth_end() {
        return birth_end;
    }

    public void setBirth_end(String birth_end) {
        this.birth_end = birth_end;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String[] getProfessionList() {
        return professionList;
    }

    public void setProfessionList(String[] professionList) {
        this.professionList = professionList;
    }

    public int getAsset_type() {
        return asset_type;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public void setAsset_type(int asset_type) {
        this.asset_type = asset_type;
    }

    @Override
    public String toString() {
        return "DefinedPersonAssetSearch{" +
                "timeSection='" + timeSection + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", birth_start='" + birth_start + '\'' +
                ", birth_end='" + birth_end + '\'' +
                ", sex='" + sex + '\'' +
                ", profession='" + profession + '\'' +
                ", professionList=" + Arrays.toString(professionList) +
                ", asset_type=" + asset_type +
                ", style=" + style +
                '}';
    }

    public String getSearchContentSubTitle(definedContentConvertDao definedContentConvertDao){
        String title="";
        if(style==0){
            title+="人员 "+getContent(timeSection,"入职时间")+getContent(birth_start+"-"+birth_end,"出生年份")+getContentofSex(sex,"性别")+getContent(profession,"职称");
        }else{
            title+="资产 ";
            if(asset_type==0)
                title+="设备 ";
            else
                title+="馆藏文献 ";
            title+=getContent(timeSection,"购买时间");

        }
        return title.trim();
    }

    private String getContent(String s,String tip){
        if(s!=null&&!s.isEmpty()&&s.trim()!="")
            return tip+":"+s.trim()+" ";
        else
            return "所有"+tip+" ";
    }

    private String getContentofSex(String s,String tip){
        if(s!=null&&!s.isEmpty()&&s.trim()!="")
            return tip+":"+(s.trim().equals("0")?"男":"女")+" ";
        else
            return "所有"+tip+" ";
    }
}
