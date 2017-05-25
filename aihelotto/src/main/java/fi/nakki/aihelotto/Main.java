/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.nakki.aihelotto;

import fi.nakki.aihelotto.io.SubjectIO;

/**
 *
 * @author nakki
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SubjectIO sio;
        /* if (args.length > 0 && args[0] != null && args[0].getClass() == String.class) {
            sio = new SubjectIO(args[0]);
        } else {
            sio = new SubjectIO("aiheet.txt");
        } */
        sio = new SubjectIO("aiheet.txt");
        sio.readSubjects();
        System.out.println("kaikki aiheet");
        sio.printSubjects();
        System.out.println("\nKaikki botit");
        System.out.println(sio.getSubjectsOfGroup("botti") + "\n\n");
        System.out.println("satunnainen aihe: " + sio.getRandomSubject(sio.getSubjects()));
        System.out.println("satunnainen botti: " + sio.getRandomSubject(sio.getSubjectsOfGroup("botti")));
        System.out.println("");
        System.out.println("kaikki ryhmät");
        sio.printGroups();
    }

}
