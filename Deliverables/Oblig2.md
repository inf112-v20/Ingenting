# Obligatorisk oppgave 2 

## Deloppgave 1 : Prosjekt og Prosjektstruktur

Vi har blitt enige om at rollene i gruppen fungerer ganske greit, men noen små endringer blir gjort, Ørjan endrer rolle til strateg og Jacob endrer rolle til System arkitekt.

Teamlead: Hjelper med å veilede hva resten av gruppen skal ta seg av og bidrar i laget der det trengs. 

System Arkitekt: Har ansvar for teknisk design av spillet. Gjennomgå og snakke om infrastruktur.

IT-Strateg: Oppdage og viderutvikle sjefens visjon og tar seg av møterefferat og generell dokumentasjon.

UI/Design: Står for å ta seg av designe på brettet og robotene. 

Etter å ha sett tilbake på det som ble gjort i forrige iterasjon ser vi at vi ikke har vært de beste på å konkluderer hva vi skal gjøre og fordele oppgaver, noe vi skulle ha gjort med tanke på at vi skal følger XP metodikken. XP metodikken tillater oss å gjøre store endringer på kort tid.

 Fremover har vi bestemmt oss for å bli flinkere til å gi poeng til oppgavene som skal bli gjort. Vi skal fokuserer mer på å refaktorere koden og legge ting i backloggen. Vi skal gå mot lage mindre og bedrer oppgaver og forholde oss til ting som skal bli gjort med en gang i stedet for ting som skal være ferdig langt i fremtiden. 

Gruppe dynamikken i Ingenting har vært ganske god. Vi har hatt diskusjoner der vi har løst problmer fint og effektivt. Alle har vært flinke og møtt opp som planlagt.

Kommunikasjonen innad i teamet flyter svært bra og vi er flinke til å si hva vi mener. Vi har også ukentlig brief noe som også er en del av XP programmering der vi snakker om hvilke utfordringer den enkelte har møtt på og hvordan de har blitt løst. Vi prøver også å aktivet bruke parprogrammering.

Som nevnt litt lengre opp så skal vi fremover fokusere på å poengtere og fordele oppgaver. Dette gjør vi fordi vi hadde en uoversiktlig start, der noen slet med å finne ut hva de skulle gjøre. 

### Forbedringspunkter
 * Gi poeng til oppgaver
 * Refaktorer kode og følge TDD
 * Selvstendig jobbing
 * Bedre fordeling av oppgaver.
---
## Deloppgave 2: Krav

Denne iterasjonen har vi prioritert bevegelse å få roboten til å bevege seg. Dette har vi valgt å prioritere ettersom at dette er noe som er med i MVP(Det som hører til MVP finner dere på projectboardet med tag MVP). En annen grunn til at vi har prioritert bevegelse er fordi at det kan føre til store endringer i nåværende kode (presentasjon av brett osv).
Dette har det også ført til og vi har endret store deler av nåværende kode for å innføre bevegelse.

Brukerhistoriene har også blitt prioritert i gitt rekkefølge, fordi at roboten skal kunne bevege seg ved å bruke programmeringskort.

Neste iterasjon er planen å innføre nettverk. Grunnen til at vi valgt det er fordi at det kan også kan føre til en del reskriving av kode, og derfor ønsker vi å få gjort det så tidlig så mulig. 

### Brukerhistorie: programerringskort logikk
Vi trenger programmeringskort logikk slik at vi kan bestemme hva trekk roboten skal utføre

**Akseptansekriterier:**
* Roboten utfører aksjonen til kortet
* Forretningslogikken til programmering kortene må stemme i forhold til hva som skjer på brettet

**Arbeidsoppgaver:**
* Få inn forettningslogikken til kortene
* Gjøre kortene tilgjengelig for roboten


### Brukerhistorie: robot
Som spiller trenger jeg en robot, slik at jeg kan bevege den rundt på brettet

**Akseptansekriterier:**
* Roboten skal se ut som en robot
* Den skal være på brettet
* Den skal kunne bevege seg rundt på brettet
* Den skal kunne bevege seg fra x1,y1 til x2,y2

**Arbeidsoppgaver:**
* Finne modell til robot
* Styring av robot ved å bruke programmeringskort som er kodet inn i koden.
* Styring av robot ved hjelp av programmering logikken

---
## Manuell testing
Bevegelse:

Brett:
