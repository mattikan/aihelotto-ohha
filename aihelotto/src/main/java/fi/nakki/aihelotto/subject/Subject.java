/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.nakki.aihelotto.subject;

/**
 *
 * @author nakki
 */
public class Subject {

    private String group;
    private String name;
    private String description;

    public Subject(String name, String group, String description) {
        this.group = group;
        this.name = name;
        this.description = description;
    }

    public Subject(String name, String group) {
        this.group = group;
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public String getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        if (this.description != null) {
            return "Name: " + this.name + "\nGroup: " + this.group + "\nDescription: " + this.description;
        }
        return "Name: " + this.name + "\nGroup: " + this.group;
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == this.getClass() && this.toString().equals(obj.toString());
    }

}
