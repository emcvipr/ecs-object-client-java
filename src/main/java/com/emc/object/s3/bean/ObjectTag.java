package com.emc.object.s3.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Tag")
@XmlType(propOrder = {"key", "value"})
public class ObjectTag {

    private String key;
    private String value;

    public ObjectTag() {
    }

    public ObjectTag(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @XmlElement(name = "Key") // todo required = true
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @XmlElement(name = "Value") // todo required = true
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}