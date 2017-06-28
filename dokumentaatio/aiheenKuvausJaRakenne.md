## Aihemäärittely

**Aihe:** Järjestelmä, joka lukee javalabra-aiheita tiedostosta, lajittelee ne kategorioihin ja arpoo käyttäjälle yhden aiheen. Aiheilla on kategoriat, ja käyttäjä saa halutessaan valita aiheen arvottavaksi vain tietystä tai tietyistä kategorioista. Käyttäjä voi myös halutessaan lisätä uusia aiheita, jotka kirjoitetaan tiedostoon.

**Käyttäjät:** Javalabraa aloittavat opiskelijat.

**Käyttäjien toiminnot:**

 - Aiheen arpominen haluamistaan kategorioista
 - Kategorioiden listaus
 - Aiheen lisäys ja tiedostoon kirjoitus

 **Rakenne:** Ohjelmassa on luokka Subject, joka edustaa aihetta. Subjectilla on nimi ja kategoria, ja joillain aiheilla on myös kuvaus.
SubjectIO-luokka käsittelee aiheiden lukemisen ja kirjoittamisen tiedostoon.
SubjectLogic-luokka käsittelee kaiken aiheisiin liittyvän logiikan, ja sen kautta käsitellään myös SubjectIO:lle menevät IO-käskyt.
MainGUI-luokka käsittelee kaiken käyttöliittymähomman, ja sen kautta käyttäjät voivat arpoa aiheita sekä tallentaa uusia aiheita tiedostoon.