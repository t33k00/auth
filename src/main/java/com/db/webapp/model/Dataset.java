package com.db.webapp.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="g_monthly_json")
public class Dataset {

    
    
    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String time1;
    private String anomalydegc;
    private String lowerconlim;
    private String upperconlim;
    
   
  
    public Dataset(){}


    public String getTime() {
        return this.time1;
    }

    public void setTime(String time1) {
        this.time1 = time1;
    }

    public String getAnomalydeg() {
        return this.anomalydegc;
    }

    public void setAnomalydeg(String anomalydegc) {
        this.anomalydegc = anomalydegc;
    }

    public String getLowerconlim() {
        return this.lowerconlim;
    }

    public void setLowerconlim(String lowerconlim) {
        this.lowerconlim = lowerconlim;
    }

    public String getUpperconlim() {
        return this.upperconlim;
    }

    public void setUpperconlim(String upperconlim) {
        this.upperconlim = upperconlim;
    }

}