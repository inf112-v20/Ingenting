# Obligatorisk oppgave 1: Prosjekt RoboRally - oppstart

## Deloppgave 1: Organiser teamet

Grupper medlemmer:
**Ørjan Skårnes**: Tar rollen som proggramerer med en kompotanse på 4 semester som datateknologistudent

**Sigurd Aleksander Sagstad** tar rollen som UI/Design utifra en kompotanse på 4 semester som datateknologistudent og jobbet freelance innen videoproduksjon

**Jakob Snorrason** tar rollen som Software tester denne rollen har blitt valgt ettesom han kan proggramering, han har gått 4 semester som datateknologistudent og har minst skrevet en test før.

**Ayoub Tammaoui** tar rollen som Prosjektleder, han har en kompotanse på 4 semester som datateknologistudent. Han jobber også med webutvikling på kvarteret og har en del fritidsprosjekter

**Marcus Teigene** tar rollen son konsulent, han tar 50% datateknologi og jobber 100% stilling som driftkoordinator i Airlift

Som gruppenavn gikk vi for team Ingenting ettersom vi strevde med å finne navn. Alle på gruppen har forholdvis like erfaringer, ettersom alle studerer inf-emner. Rolllene tildelte vi ut i fra hva som folk følte passet. Dette kan endres underveis i prosjektet visst vi ser noen egner seg bedre som noe annet.

## Deloppgave 2: Oversikt over forventet produkt

Målet med RoboRally er å jobbe oss mot de kravene som kunden stiller. Vi skal ha spillfunksjoner som å oprette spiller, ha en robot som man kan gjøre forskellige operasjoner, muligheten til å interagere med andre objekter på brette. Vi skal også sitte lære oss å visulisere spillet ved hjelp av LibGDX og Tiled

### Første iterasjons krav

* Et brett
* Visualisert i LibGDX

### Senere krav

#### Spiller

Spiller skal kunne:

* Miste liv
* Programmere kort
* Dø
* Annonsere powerdown

#### Robot

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

#### Spill

* Vinne spill
* Avslutte spill
* Velge brett
* Plassere objekt
* Gi ut kort, og fjerne kort.
* Timer når det er en som ikke har programmert kortene.
* Spille en runde

#### Runde

* Består av faser
* velg 5 programeringskort
* Kort blir utført etter hva prioritet de har
* Muligheten for power down
* Samle  inn kort (shuffle)

#### Fase

* 5 faser
* Snu programkort
* 1 programkort per fase
* utføre bevegelse
* ekspressbånd
* aktivering av elementer
* lasere
* registrere flagg

## Deloppgave 3: Velg og tilpass en prosess for laget

Vi har valgt Extreme Programming som vår prosjektmetodikk, med tanke på at vi har god mulighet med å parprogrammere,
sette poeng på oppgavene slik at vi får en oversikt over hvor mange poeng vi kan få til på en iterasjon.
Poeng på oppgavene vil også gi hver person i teamet en oversikt om hvor mye de kan få til på en iterasjon og gjøre det letter å velge oppgaver for iterasjonene fremover.
Vi har fokus på å ha gode og hyppige commits slik at alle får en oversikt over hva som har skjedd.

Oraganiseringen av av prosjektet, planlegger vi å møte 1-2 ganger i uken utenom gruppetimen.
I starten er planen onsdag fra 08:15 og utover. Vi tenker å kjere å ha en jevn oppfølging av prosjektet og sprint på 2 uker.
Som kommunikasjon utenom gruppemøter prøver vi å få dette til på slack og eventult via Discord.

## Deloppgave 4: Kode

* Begynne å jobbe med brukerhistorier for å vise et brett og bevegelse på brettet.

### Brukerhistorie

* Som spiller trenger jeg en visuell representasjon av brettet slik at jeg kan spille og vite hvor forskjellige elementer ligger.

**Akseptansekriterier:**

* Størrelse og antall ruter
* Vise et brett uten elementer
* Vie et brett med elementer
* Grafisk fremsilling av brett

**Arbeidoppgaver:**

* Koble forettningslogikken til libgdx
* Opprett et brett som kan bestå av forskjellige objekter

### Brukerhistorie 2

Som spiller trenger jeg en robot, slik at jeg kan bevege den rundt på brettet

**Akseptansekriterier:**

* Roboten skal se ut som en robot
* Den skal være på brettet
* Den skal kunne bevege seg rundt på brettet
* Den skal kunne bevege seg fra x1,y1 til x2,y2

**Arbeidsoppgaver:**

* Finne modell til robot
* Styring av robot ved hjelp av piltastene

## Oppsummering

Hva gikk bra? Hva fungerte dårlig?

Det er kanskje litt tildlig å vurdere hvordan arbeidsmetoden vår fungerer, men har ikke støtt på noen problemer enda.
I denne iterasjonen brukte vi mesteparten av tiden til å planlegge og kartlegge hva vi skal gjøre fremover.
mot slutten startet vi med kode-delen og vi benyttet oss av par-programmering og delt oppgaver å gjøre hjemme.
Det som fungerte bra i denne sprinten var at vi hadde felles innføring av Libgdx og startet programmeringen på storskjerm,
dette gjorde at alle fikk med seg og forsto det som ble gjort.
