# Obligatorisk oppgave 3
## Deloppgave 1: Team og prosjekt
Møterefferat ligger vedlagt i møterefferat.md i Deliveries

Rollene i gruppen fungerer veldig fint. En merker at vi er inne i ny tid
nå som korona viruset har kommet. Dette har ført til at vi ikke får møte fysisk,
men vi har tilpasset situasjonen og benytter oss av discord til møter og når det er behov for det. 

Når det gjelder prosjektmetodikk, så benytter vi oss av XP. Dette har fungert bra til nå, og vi ser fremgang i posjektet. Vi har forbedret oss siden sist når det gjelder arbeidsfordeling, og
kortere brukerhistorier. Vi opplever at mer blir gjort og ser mer progresjon i prosjektet.

Det vi kan jobbe mer med videre er følgende: 

Tre forbedringspunkt:
* Møtene våre. Utnytte de best mulig, og planlegge hva som skal gjenomgås.
* Tilbakemelding. At vi gir konstruktiv tilbakemelding til hverandre med eksempler. 
* Kommunikasjon. Nå som vi ikke kan møtes kan det fort gå en hel iterasjon uten noe særlig kommunikasjon. Dette må vi bli flinkere til, evt. ha en brief ukentlig eller noe lignende. 

Målet vårt har hele tiden vært å ta oss av de store oppgavene som kan kreve mye endring av nåværende kode som for eks. brukergrensesnitt og nettverk. Dette har også ført til at vi blir sittende med de samme oppgavene en stund fordi at dette er store utfordringer, og krever tid.
Derfor har vi også laget flere kortere brukerhistorier samtidig så vi forholder oss til en større og mer krevende brukerhistorie.

Kommunikasjonen i laget til nå har vært svært bra. Målet har hele tiden vært at alle skal bli hørt, og kunne bidra. Dette er noe vi føler at vi har oppnådd. 

## Deloppgave 2: Krav
Som nevnt tidligere så har vi prioritert brukergrensesnitt og nettverk. Med nettverk så har målet vært å kunne koble til to spillere. Dette har vi komt godt i gang med, men ikke nok til at vi ønsker å ta det med denne iterasjonen. Derfor har vi fokusert på å få et fungerende brukergrensesnitt som vi kan utvide og bruke sammen med nettverk fremover. Fokuset har også vært å lage korte brukerhistorier 

Vi har også jobbet med andre krav som gir spillet nye funksjoner. Dette er ikke tilfeldige krav, men krav som vi mener er MVP som for eks. å innføre en seiertilstand, legge til flag osv. 


### Brukerhistorie: Visualisere et brukergrensesnitt.
Som spiller trenger jeg et brukergrensesnitt som jeg kan bruke for å påvirke spillet.

**Akseptansekriterier**
* Kunne se et brukergrensesnitt.

### Brukerhistorie: Samhandle med brukergrenesnittet.
Som spiller må jeg kunne samhandle med brukergrensesnittet.

***Akseptansekriterer**
* Kunne samhandle med brukergrensesnittet.

### Brukerhistorie: Bevege roboten ved bruk av brukergrensesnittet.
Som spiller vil jeg kunne bevege roboten ved å bruke brukergrensesnittet.

* Kunne bevege roboten med brukergrensesnittet.
* Få ønsket oppførsel ved å bevege roboten.

### Brukerhistorie: Ha 2 roboter på samme brett.
Brettet skal kunne vise flere roboter.

**Akseptansekriterie**
* Brettet skal ha minst 2 roboter.


### Brukerhistorie: Visualisere flagg på brettet.
Brettet skal ha minst 3 flagg.

**Akseptansekriterier**
* Brettet skal ha visualisere minst tre flagg.


### Brukerhistorie: Samhandle med flagg.
Roboten skal kunne samhandle med flagg som er på brettet og spillet
skal registrere det.

**Akseptansekriterier**
* Spillet skal registrere når roboten har samhandlet med et flagg. 


### Brukerhistorie: Seiertilstand
Spillet skal avslutte når roboten har samhandlet med tre flagg.

* Når roboten har samhandlet med tre flagg skal spillet avsluttes.

### Brukerhistorie: Designe kort
**Akseptansekriterier:**
* Kortene skal se ut som trekk som spilleren kan utføre
* Kortene må skal være behageli å se på

**Arbeidsoppgaver:**
* Bruker adobe color til å finne behaglige farger
* Bruker piskel får å tegne kort slik vi vil ha de

### Brukerhistorie: Bevegelse med taster for å kunne teste spille enklere
**Akseptansekriterier:**
* Bevege spilleren med piltastene

**Arbeidsoppgaver:**
* Implementere keylistening og utføre bevegelsen i den retningen

## Deloppgave 3: Produktleveranse og kodekvalitet

### Testing
* Utfører en manuell test for å sjekke det er mulig å bevege roboten i retningen som vi trykker på piltastene.
trykker jeg venstre piltast roterer roboten seg og beveger seg mot venstre

* Utfører manuell test for å sjekke om roboten beveger seg gjennom riktig rekkefølge av flagg. Metoden checkFlags
viser riktig flagId ifølge vårt TileSet (testet med printing til konsoll). Flag blir ikke markert som besøkt dersom alle
tidligere flagg er besøkt i riktig rekkefølge. Riktig rekkefølger er 1-2-3-4. Først når alle flag er besøkt gir allFlagsVisited true. 
Dette var testet ved å bevege roboten gjennom flaggene manuelt og printing til konsollen.

* For å bevege roboten gjennom brukergrensesnittet støtter den nå en kommando "move1" som beveger roboten et steg frem i den retningen den peker. 

