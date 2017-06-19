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
    
    public SubjectIO(String file) {
        this.f = new File(file);
    }
    
    public List<Subject> readSubjects() {
        List subjects = new ArrayList<>();
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
                }
            }
            buffered.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return subjects;
    }
    
    public List<String> readGroups() {
        List groups = new ArrayList<>();
        String line;
        BufferedReader buffered;
        try {
            FileReader fileReader = new FileReader(this.f);
            buffered = new BufferedReader(fileReader);
            while ((line = buffered.readLine()) != null) {
                String[] s = line.split(";");
                if (s.length == 3) {
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
        return groups;
    }
    
    public void writeSubjects(List<Subject> subjects) {
        List<Subject> existingSubjects = this.readSubjects();
        try {
            FileWriter fileWriter = new FileWriter(this.f, true);
            BufferedWriter buffered = new BufferedWriter(fileWriter);
            for (Subject s : subjects) {
                if (existingSubjects.contains(s)) {
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
    
}
