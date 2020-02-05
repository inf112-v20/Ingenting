# Obligatorisk oppgave 1: Prosjekt RoboRally - oppstart

## Deloppgave 1: Organiser teamet. 
Som gruppenvan gikk vi for ingenting. Alle på gruppen har forholdvis like erfaringer, ettersom alle studerer inf-emner. Rolllene tildelte vi ut i fra hva som folk hadde mest lyst til fra begynnelsen av. Dette kan endres underveis i prosjektet visst vi ser noen egner seg bedre som noe annet.

Navn: Ørjan Skårnes:
⋅⋅⋅Rolle: Programmerer
⋅⋅⋅Kompetanse: 
⋅⋅⋅IT og IT 2
⋅⋅⋅4 semester på Datateknologi


Navn: Sigurd Aleksander Sagstad
Rolle: UI/Design
Kompetanse:
Går 4. sem i Datateknologi- bachelor
Freelance videoproduksjon


Navn:  Jakob Snorrason
⋅⋅⋅Rolle: Software Tester
⋅⋅⋅Kompetanse:
⋅⋅⋅Går 4. semester i datateknologi bachelor på UiB
⋅⋅⋅Kan programmering
⋅⋅⋅Har skrevet minst en test før


Navn: Ayoub Tammaoui
⋅⋅⋅Rolle: Prosjektleder 
⋅⋅⋅Kompetanse:
⋅⋅⋅4 Semester på datateknologi.
⋅⋅⋅Webutvikling på kvarteret og en del fritidsprosjekt.

Navn: Marcus Teigene
⋅⋅⋅Rolle: Konsulent
⋅⋅⋅Kompetanse:
⋅⋅⋅50% student på datateknologi.
⋅⋅⋅100% driftskoordinator i Airlift.


## Deloppgave 2: Oversikt over forventet produkt
Målet med RoboRally er å jobbe oss mot de kravene som kunden stiller. Vi skal ha spillfunksjoner som å oprette spiller, ha en robot som man kan gjøre forskellige operasjoner, muligheten til å interagere med andre objekter på brette. Vi skal også sitte lære oss å visulisere spillet ved hjelp av LibGDX og Tiled

### Første iterasjons krav
* Et brett
* Viisualisert i LibGDX
* En robot som kan beveges 

### Spiller
Spiller skal kunne:
* Miste liv
* Programmere kort
* Dø
* Annonsere powerdown


### Robot
* Gi skade
* Dytte andre roboter
* Ta skade
* Bli dyttet av andre roboter
* Dø
* Reparere
* Powerdown
* Bevege seg
* Brett
* Minst ett element på brettet.
* Vise forventet element.
* Vise forventet størrelse.


### Spill
* Vinne spill
* Avslutte spill
* Velge brett
* Plassere objekt
* Gi ut kort, og fjerne kort.
* Timer når det er en som ikke har programmert kortene.
* Spille en runde

### Runde
* Består av faser
* velg 5 programeringskort
* Kort blir utført etter hva prioritet de har
* Muligheten for power down
* Samle  inn kort (shuffle)

### Fase
* 5 faser
* Snu programkort
* 1 programkort per fase
* utføre bevegelse
* ekspressbånd
* aktivering av elementer
* lasere
* registrere flagg



## Deloppgave 3: Velg og tilpass en prosess for laget 
Vi har valgt Extreme Programming som vår prosjektmetodikk, med tanke på at vi har god mulighet med å parprogrammere, sette poeng på oppgavene slik at vi får en oversikt over hvor mange poeng vi kan få til på en iterasjon. Poeng på oppgavene vil også gi hver person i teamet en oversikt om hvor mye de kan få til på en iterasjon og gjøre det letter å velge oppgaver for iterasjonene fremover. Vi har fokys på å ha gode og hyppige commits alle får en oversikt over hva som har skjedd. 

Oraganiseringen av av prosjektet, planlegger vi å møte 1-2 ganger i uken utenom gruppetimen. i starten blir planen onsdag fra 08:15 og utover. Vi tenker å kjere å ha en jevn oppfølging av prosjektet og sprint på 2 uker.


## Deloppgave 4: Kode
* Begynne å jobbe med brukerhistorier for å vise et brett og plassere en brikke på brettet.

### Brukerhistorie:
* Som spiller trenger jeg en visuell representasjon av brettet slik at jeg kan spille og vite hvor forslkellge elemnter ligger.

Akseptansekriterier:
* Størrelse og antall ruter
* Vise et brett uten elementer
* Vie et brett med elementer
* Grafisk fremsilling av brett

Arbeidoppgaver
* Koble forettningslogikken til libgdx
* Opprett et brett som kan bestå av forskjellige objekter


### Brukerhistorie 2
Som spiller trenger eg en robot, slik at jeg kan bevege den rundt på brettet

Akseptansekriterier:
* En robot
* Roboten skal se ut som en robot
* Den skal være på brettet
* Den skal kunne bevege seg rundt på brettet

Arbeidsoppgaver:
* Finne modell til robot
* Styring av robot ved hjelp av piltastene


## Oppsummering:
Hva gikk bra? Hva fungerte dårlig?


⋅⋅⋅Vurderingskriterier og vekting Innleveringsfrist: 7. februar, klokken 16:00.

For å få oppgaven godkjent må gruppen:
* Opprettet en repo-struktur som beskrevet i deloppgave 1.
* Skrive fornuftige commit meldinger når endringer lastes opp i gruppens repo.
* Laste opp de etterspurte resultatene i repo.
* Laste opp leveransen til github i markdown-format.
