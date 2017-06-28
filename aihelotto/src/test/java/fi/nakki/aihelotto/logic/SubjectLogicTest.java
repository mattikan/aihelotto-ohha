/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.nakki.aihelotto.logic;

import fi.nakki.aihelotto.io.SubjectIO;
import fi.nakki.aihelotto.io.SubjectIOTest;
import fi.nakki.aihelotto.subject.Subject;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author nakki
 */
public class SubjectLogicTest {

    @Test
    public void testGetSubjectsOfGroup() {
        SubjectIO instance = new SubjectIO("src/test/resources/testiaiheet.txt");
        SubjectLogic sl = new SubjectLogic(instance);
        instance.readSubjects();
        List<Subject> compared = new ArrayList<>();
        Subject s1 = new Subject("qwer", "asdf", "zxcv");
        compared.add(s1);
        List<String> groups = new ArrayList<>();
        groups.add("asdf");
        assertTrue(sl.getSubjectsOfGroups(groups).equals(compared));
    }

    @Test
    public void testGetRandomSubject() {
        SubjectIO instance = new SubjectIO("src/test/resources/testiaiheet.txt");
        SubjectLogic sl = new SubjectLogic(instance);
        instance.readSubjects();
        List<String> groups = new ArrayList<>();
        Subject s = sl.getRandomSubject(groups);
        assertTrue(sl.getSubjectsOfGroups(groups).contains(s));
    }
    
}
