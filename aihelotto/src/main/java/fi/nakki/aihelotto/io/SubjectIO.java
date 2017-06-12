/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.nakki.aihelotto.io;

import java.io.*;
import java.util.*;
import fi.nakki.aihelotto.subject.Subject;

/**
 *
 * @author nakki
 */
public class SubjectIO {
    
    private File f;
    private List<Subject> subjects;
    private List<String> groups;
    
    public SubjectIO(String file) {
        this.f = new File(file);
    }
    
    public void readSubjects() {
        List subjects = new ArrayList<>();
        List groups = new ArrayList<>();
        String line;
        Subject subject;
        BufferedReader buffered;
        try {
            FileReader fileReader = new FileReader(this.f);
            buffered = new BufferedReader(fileReader);
            while ((line = buffered.readLine()) != null) {
                String[] s = line.split(";");
                if (s.length == 3) {
                    subjects.add(new Subject(s[0], s[1], s[2]));
                    if (!groups.contains(s[1])) {
                        groups.add(s[1]);
                    }
                }
            }
            buffered.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.subjects = subjects;
        this.groups = groups;
    }
    
    public void writeSubjects(ArrayList<Subject> subjects) {
        try {
            FileWriter fileWriter = new FileWriter(this.f, true);
            BufferedWriter buffered = new BufferedWriter(fileWriter);
            for (Subject s : subjects) {
                if (this.subjects.contains(s)) {
                    continue;
                }
                buffered.append(s.getName() + ";");
                buffered.append(s.getGroup() + ";");
                buffered.append(s.getDescription());
                buffered.newLine();
            }
            buffered.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public List<String> getGroups() {
        return groups;
    }
    
    public List<Subject> getSubjects() {
        return subjects;
    }
    
    public Subject getRandomSubject(List<Subject> subjects) {
        if (subjects.size() == 0) {
            return null;
        }
        Random rand = new Random();
        Subject randomElement = subjects.get(rand.nextInt(subjects.size()));
        return randomElement;
    }
    
    public List<Subject> getSubjectsOfGroup(String group) {
        List<Subject> subjects = new ArrayList<>();
        for (Subject s : this.getSubjects()) {
            if (s.getGroup().equals(group)) {
                subjects.add(s);
            }
        }
        return subjects;
    }
    
    public List<Subject> getSubjectsOfGroups(List<String> groups) {
        List<Subject> subjects = new ArrayList<>();
        for (Subject s : this.getSubjects()) {
            if (groups.stream().anyMatch(str -> str.trim().equals(s.getGroup()))) {
                subjects.add(s);
            }
        }
        return subjects;
    }
    
    public void printGroups() {
        for (String s : this.getGroups()) {
            System.out.println(s);
        }
    }
    
    public void printSubjects() {
        for (Subject s : this.getSubjects()) {
            System.out.println(s + "\n");
        }
    }
}
