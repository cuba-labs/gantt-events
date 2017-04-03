package com.company.demo.entity;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;
import java.util.List;
import com.haulmont.cuba.core.entity.AbstractNotPersistentEntity;

@MetaClass(name = "demo$TaskSpan")
public class TaskSpan extends AbstractNotPersistentEntity {
    private static final long serialVersionUID = 2350551494642402397L;

    @MetaProperty
    protected String category;

    @MetaProperty
    protected List<Segment> segments;

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setSegments(List<Segment> segments) {
        this.segments = segments;
    }

    public List<Segment> getSegments() {
        return segments;
    }


}