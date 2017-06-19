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
        assertTrue(instance.readSubjects().get(1).getDescription().equals("zxcv"));
        assertTrue(instance.readSubjects().get(0).getName().equals("aihe"));
    }

    @Test
    public void testGetAllGroups() {
        SubjectIO instance = new SubjectIO("src/test/resources/testiaiheet.txt");
        instance.readSubjects();
        List<String> compared = new ArrayList<>();
        compared.add("ryhmä");
        compared.add("asdf");
        assertTrue(instance.readGroups().equals(compared));
    }
}
