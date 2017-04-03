package com.company.demo.entity;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.cuba.core.entity.AbstractNotPersistentEntity;

@MetaClass(name = "demo$Segment")
public class Segment extends AbstractNotPersistentEntity {
    private static final long serialVersionUID = -6805397973094591173L;

    @MetaProperty
    protected Integer start;

    @MetaProperty
    protected Integer duration;

    @MetaProperty
    protected String color;

    @MetaProperty
    protected String task;

    @MetaProperty
    protected TaskSpan taskSpan;

    public void setTaskSpan(TaskSpan taskSpan) {
        this.taskSpan = taskSpan;
    }

    public TaskSpan getTaskSpan() {
        return taskSpan;
    }


    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getStart() {
        return start;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTask() {
        return task;
    }


}