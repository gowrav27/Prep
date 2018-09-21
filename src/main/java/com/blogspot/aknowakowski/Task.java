package com.blogspot.aknowakowski;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

@Entity
@Table(name = "tasktable")
public class Task
{
    @Id
    @Column(name = "task_id")
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @Column(name = "java_date")
    @Type(type = "com.blogspot.aknowakowski.CustomEnterpriseTimestampType")
    Date javaDate;

    @Column(name = "java_date2")
    @Type(type = "com.blogspot.aknowakowski.CustomEnterpriseTimestampType")
    Date javaDate2;

    @Column(name = "joda_date")
    LocalDateTime localJodaDate;

    public Task(Long id, String name, String description, Date javaDate, Date javaDate2, LocalDateTime localJodaDate)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.javaDate = javaDate;
        this.javaDate2 = javaDate2;
        this.localJodaDate = localJodaDate;
    }

    public Task()
    {
    }



    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getJavaDate()
    {
        return javaDate;
    }

    public Date getJavaDate2()
    {
        return javaDate2;
    }

    public void setJavaDate(Date javaDate)
    {
        this.javaDate = javaDate;
    }

    public void setJavaDate2(Date javaDate2)
    {
        this.javaDate2 = javaDate2;
    }

    public LocalDateTime getLocalJodaDate()
    {
        return localJodaDate;
    }

    public void setLocalJodaDate(LocalDateTime localJodaDate)
    {
        this.localJodaDate = localJodaDate;
    }
}
