/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.nakki.aihelotto.subject;

/**
 * Each instance of this class represents one possible javalabra-subject. Each
 * subject has a name, a description and a group, which tells you what kind of 
 * subject it is, e.g. game, card game, tool, bot.
 * @author nakki
 */
public class Subject {

    private String group;
    private String name;
    private String description;

    /**
     * This is a constructor for a Subject.
     * @param name name of the subject
     * @param group group of the subject, e.g. game, card game, tool, bot
     * @param description description of the subject
     */
    public Subject(String name, String group, String description) {
        this.group = group;
        this.name = name;
        this.description = description;
    }

    /**
     * This is a constructor for a Subject without a description. It can be used
     * for subjects which don't need much explaining past their names and groups.
     * @param name name of the subject
     * @param group group of the subject, e.g. game, card game, tool, bot
     */
    public Subject(String name, String group) {
        this.group = group;
        this.name = name;
    }

    /**
     * This method returns the description of the subject.
     * @return the description of the subject
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method returns the group of the subject.
     * @return the group of the subject
     */
    public String getGroup() {
        return group;
    }

    /**
     * This method returns the name of the subject.
     * @return the name of the subject
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the description of the subject.
     * @param description new description of the subject
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method sets the group of the subject.
     * @param group new group of the subject
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * This method sets the name of the subject.
     * @param name new name of the subject
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method returns a string representation of the Subject.
     * 
     * For subjects with descriptions:
     * Name: name
     * Group: group
     * Description: description
     * 
     * For subjects without descriptions:
     * Name: name
     * Group: group
     * 
     * @return string representation of the subject
     */
    @Override
    public String toString() {
        if (this.description != null) {
            return "Name: " + this.name + "\nGroup: " + this.group + "\nDescription: " + this.description;
        }
        return "Name: " + this.name + "\nGroup: " + this.group;
    }

    /**
     * This method returns true if both objects are of the same class and their
     * string representations are the same.
     * @param obj object to compare to
     * @return true if string representations and classes of objects are equal, otherwise false
     */
    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == this.getClass() && this.toString().equals(obj.toString());
    }

}
