# Obligatorisk oppgave 4
## Deloppgave 1: Team og prosjekt.

Møterefferat ligger vedlagt i møterefferat.md i Deliveries

Vi var enige om at rollene fungerer fint og at vi ikke har noe behov for å oppdatere rollene. Dette tas jevnlig opp hvert møte for å sjekke at alle er fornøyde med rollene. Vi har holdt oss til 1-2 møter i uken der vi har en brief og diskuterer hvordan den enkelte ligger an med oppgavene som er gitt. 

Når det gjelder prosjekt metodikk så benytter vi oss fremdeles av XP. Vi ser fremgang i prosjektet og forbedringer for hver iterasjon i teamet. Vi har jobbet med forbedringspunktene fra sist iterasjon, og møtene er nå mer organiserte noe som gjør at vi får mye mer ut av de enn det vi gjorde før.
Et problem som vi har som vi også har hatt tidligere er arbeidsfordelingen. Vi jobber med å fordele oppgavene, men nå som vi nærmer oss mål så er det ikke så mange oppgaver å fordele blant laget, og når noen først blir ferdig kan de bli sittende uten oppgaver. 

Hadde vi begynt på nytt så hadde vi planlagt bedre, spesielt når det gjelder nettverk. Dette er egentlig noe vi har tenkt på tidligere, men vi startet litt sent og da var det ganske mye som måtte endres på. Det beste da hadde vært å få startet opp med Nettverk så fort som overhodet mulig.

Gruppedynamikken og kommunikasjonen nå forgeår veldig mye via discord og facebook, der vi tar oss av meste parten av diskusjonen. I retrospektive med tanke på korona kan vi at dette har påvirket ganske mye,
som sagt har vi ikke fått muligheten til å møtes face to face å diskutere på den måten vi gjorde før. Karantenen påvirker også hvordan folk jobber, med at noen jobber best om natten mens andre jobber på dagen.

## Deloppgave 2: Krav
Som forrige gang ligger fremdeles fokuset i nettverk og brukergrensesnitt, siden forrige iterasjon har vi hatt ganske god progresjon på nettverk, men dessverre så mangler en hoved del av MVPen, runde logikken. Hadde vi vist utfallet så hadde vi nok gått for en KUN singleplayer, men dessverre så er det forsent. Det vi ikke har fått til er å sende kortene som spilleren velger, og derfor får vi ikke lagt til rundelogikken ettersom at det er nødvendig.

### Brukerhistorie: Nettverk.
Som spiller vil jeg kunne spille med andre lokalt.

**Akseptansekriterier**
* Det som blir gjort hos en spiller skjer hos den andre også

**Arbeidsoppgaver:**
* Legge til at spilleren skal kunne hoste og connecte.
* Spillernes handlinger skal skje hos alle.

### Brukerhistorie: Samtale.
Som spiller vil jeg kunne snakke med andre jeg spiller med.

**Akseptansekriterier**
* Kunne skrive i en chat
* Det som blir skrevet er synlige for andre spiller i gamet

**Arbeidsoppgaver:**
* Brukerne skal kunne skrive i en chat
* Gjøre det som blir skrevet synlig for andre spillere

### Brukerhistorie: Host.
Som spiller vil jeg ha muligheten til starte et spill som andre kan bli med i.

**Akseptansekriterier**
* Kunne være host for et game
* Det skal være mulig for andre spillere å bli med i gamen som blir hostet

**Arbeidsoppgaver:**
* Legge til muligheten for en spiller å hoste et game på valgt port.
* Spillere skal kunne bli med i spille ut i fra porten som er opprettet.

### Brukerhistorie: Koble til som host
Som spiller vil jeg ha muligheten til å bli med i noen andre sitt spill.

**Akseptansekriterier**
* Være host for spillet.

**Arbeidsoppgaver:**
* Starte en server som host, og kunne motta tilkoblinger ved hjelp av kryonet.

### Brukerhistorie: Koble til som client
Som spiller vil jeg kunne koble til andre.

##Akepstansekriterier**
* Kunne koble til en host.

** Arbeidsoppgaver:**
* Legge til at spilleren skal kunne koble til en annen host.

### Brukerhistorie: Finne hosts 
Som spiller vil jeg se hvilke hosts som er aktive.

**Akseptansekriterer**
* Spilleren skal få opp aktive hosts.

**Arbeidsoppgaver:**
* Legge til kommando som viser hosts i nettverket.

### Brukerhistorie: Sende melding
Som spiller vil jeg kunne sende melding over nettverket til andre spillere.

**Akseptansekriterier**
* Spilleren skal kunde sende en melding i spillet.

**Arbeidsoppgaver:**
* Bruke kryonet til å sende en melding over nettverket. 

### Brukerhistorie: Vegger.
Som spiller skal det ikke være mulig å gå igjennom vegger som blokkerer der jeg vil gå.

**Akseptansekriterier**
* Veggen skal stanse roboton om den går i retning mot veggen.

**Arbeidsoppgaver:**
* Legge til en kollider som stanser roboten om den går i retning mot veggen.
* Visste det er en vegg i nabo cellen som blokkerer inngang for roboten, skal roboten stanses.

### Brukerhistorie: Random Deck of Cards.
Som spiller vil jeg ha programmeringskort, slik at jeg kan programmere roboten min

**Akseptansekriterier**
* spiller skal få tilfeldige programeringskort.

**Arbeidsoppgaver:**
* Generer tilfeldige programmeringskort  som spiller kan bruke.
* Spiller skal kunne se kortene som er generert.

### Brukerhistorie: Conveyor Belts
Roboten skal bli skyvet av beltene.

**Akseptansekriterier**
* Roboten skal bli påvirket av conveyor belts i alle retninger.

**Arbeidsoppgaver:**
* Legge til conveyor belts visuelt.
* Legge til logikk for conveyor belts.


### Brukerhistorie: Laser
Som spiller vil jeg at roboten skal ta skade av laseren på brettet.

**Akseptansekriterier**
* Roboten skal ta skade av laseren som er på brettet.

**Arbeidsoppgaver:**
* Legge til laser på brettet visuelt.
* Legge til logikken for laseren slik at roboten tar skade ved kontakt.

