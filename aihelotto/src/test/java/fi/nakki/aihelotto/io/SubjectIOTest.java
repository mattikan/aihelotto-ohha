/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.nakki.aihelotto.io;

import fi.nakki.aihelotto.subject.Subject;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nakki
 */
public class SubjectIOTest {

    @Test
    public void testReadSubjectsFromFile() {
        SubjectIO instance = new SubjectIO("src/test/resources/testiaiheet.txt");
        instance.readSubjects();
        assertTrue(instance.getSubjects().get(1).getDescription().equals("zxcv"));
        assertTrue(instance.getSubjects().get(0).getName().equals("aihe"));
    }

    @Test
    public void testGetAllGroups() {
        SubjectIO instance = new SubjectIO("src/test/resources/testiaiheet.txt");
        instance.readSubjects();
        List<String> compared = new ArrayList<>();
        compared.add("ryhmä");
        compared.add("asdf");
        assertTrue(instance.getGroups().equals(compared));
    }

    @Test
    public void testGetSubjectsOfGroup() {
        SubjectIO instance = new SubjectIO("src/test/resources/testiaiheet.txt");
        instance.readSubjects();
        List<Subject> compared = new ArrayList<>();
        Subject s1 = new Subject("qwer", "asdf", "zxcv");
        compared.add(s1);
        assertTrue(instance.getSubjectsOfGroup("asdf").equals(compared));
    }

    @Test
    public void testGetRandomSubject() {
        SubjectIO instance = new SubjectIO("src/test/resources/testiaiheet.txt");
        instance.readSubjects();
        Subject s = instance.getRandomSubject(instance.getSubjects());
        assertTrue(instance.getSubjects().contains(s));
    }
}
