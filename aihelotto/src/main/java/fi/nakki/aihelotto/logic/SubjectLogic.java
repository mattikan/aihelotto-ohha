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
 *
 * @author nakki
 */
public class SubjectLogic {

    private SubjectIO sio;

    public SubjectLogic(SubjectIO sio) {
        this.sio = sio;
    }
    
    public void writeSubjects(List<Subject> subjects) {
        this.sio.writeSubjects(subjects);
    }
    
    public List<String> getGroups() {
        return this.sio.readGroups();
    }

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

    public Subject getRandomSubject(List<String> groups) {
        List<Subject> subjects = this.getSubjectsOfGroups(groups);
        Random rand = new Random();
        Subject randomElement = subjects.get(rand.nextInt(subjects.size()));
        return randomElement;
    }
}
