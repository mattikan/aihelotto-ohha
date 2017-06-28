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
 * This class handles reading the file and writing to it. This class should only
 * be used through SubjectLogic.
 *
 * @author nakki
 */
public class SubjectIO {

    private File f;

    /**
     * Constructor for the class, to which the file path is given as a String.
     *
     * @param file path to file containing all subjects
     */
    public SubjectIO(String file) {
        this.f = new File(file);
    }

    /**
     * This method reads all the subjects from the file, puts them in a List and
     * returns it.
     *
     * @return list of all subjects found in the file
     */
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

    /**
     * This method reads all the groups from the file containing all subjects
     * and returns them as a List of Strings.
     * @return all the groups found in the file given to this instance
     */
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

    /**
     * This method writes all the subjects given to it in the subjects-parameter
     * to the SubjectIO-instance's file.
     * @param subjects 
     */
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
