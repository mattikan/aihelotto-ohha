/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.nakki.aihelotto.logic;

import fi.nakki.aihelotto.io.SubjectIO;
import fi.nakki.aihelotto.subject.Subject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class handles all the subject-related logic, like grabbing a random one
 * or grabbing all the groups found in the subjects file. SubjectIO is also accessed
 * through this class for reading and writing into and from the file containing all subjects.
 * @author nakki
 */
public class SubjectLogic {

    private SubjectIO sio;

    /**
     * This is a constructor for the class.
     * @param sio A SubjectIO instance which is used for Subject I/O stuff
     */
    public SubjectLogic(SubjectIO sio) {
        this.sio = sio;
    }
    
    /**
     * This method passes the list of subjects given to it onwards to SubjectIO
     * and tells SubjectIO to write them to its file.
     * @param subjects subjects to write to the file
     */
    public void writeSubjects(List<Subject> subjects) {
        this.sio.writeSubjects(subjects);
    }
    
    /**
     * This method gets all the groups found in the subjects file.
     * @return all the groups found in the subjects file
     */
    public List<String> getGroups() {
        return this.sio.readGroups();
    }

    /**
     * This method gets all the subjects that belong to groups found in the List
     * given to it as a parameter.
     * @param groups which groups' subjects should be returned
     * @return subjects found in the groups specified in parameters
     */
    public List<Subject> getSubjectsOfGroups(List<String> groups) {
        if (groups.isEmpty()) {
            return sio.readSubjects();
        }
        List<Subject> subjects = new ArrayList<>();
        for (Subject s : sio.readSubjects()) {
            if (groups.stream().anyMatch((String str) -> str.trim().equals(s.getGroup()))) {
                subjects.add(s);
            }
        }
        return subjects;
    }

    /**
     * This method gets a random subject from all the groups found in the list
     * given to it as a parameter.
     * @param groups which groups' subjects should be returned
     * @return random subject found from the groups specified in parameters
     */
    public Subject getRandomSubject(List<String> groups) {
        List<Subject> subjects = this.getSubjectsOfGroups(groups);
        Random rand = new Random();
        Subject randomElement = subjects.get(rand.nextInt(subjects.size()));
        return randomElement;
    }
}
