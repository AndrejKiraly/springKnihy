# Zadanie 3 - Knihy
B-OOP 2022

Vašou úlohou je naprogramovať aplikačný server v jazyku Java s pomocou frameworku Spring.

Aplikačný server umožňuje správu kníh, ich autorov a ich požičiavania (napr. z knižnice).
Webové rozhranie (API), ako aj objekty, ktoré sa používajú na komunikáciu s vonkajším svetom sú definované v zadaní a musi byť použité na komunikáciu cez webové služby. Mimo webového rozhrania môžete použiť ďalšie objekty podľa vášho návrhu, ak to uznáte za vhodné.

Špecifikáciu webového rozhrania, ktoré má aplikácia poskytovať nájdete tu: https://app.swaggerhub.com/apis-docs/stuba-fei-uim-oop/OOPZadanie3Knihy/1.0.0-oas3

Pokiaľ je v API uvedené, že sa má vrátiť kód 404 a v popise nie je povedané kedy, je ho potrebné vrátiť v prípade, že poskytnuté ID v systéme neexistuje.

### Popis systému

Podrobný popis jednotlivých operácii je uvedený v špecifikácii API.

Systém umožňuje pridávanie a odoberanie kníh z knižnice. Dalej umožnuje úpravu existujúcich knih (aj zmenu autora, autor môže byť len jeden), ako aj navýšenie počtu stavu kníh v knižnici.

Systém umožňuje vytváranie a vymazávanie listov s požičanými knihami. Do listov je možné pridávať a odoberať knihy (vždy v jednom liste môže byt len jedna kniha). Systém ďalej umožnuje požičanie ešte nevypožičaných listov, čo inkrementuje počítadlo požičaných kópií v individuálnych knihách. Do už vypožičaných listov kníh nie je možné pridávať ďalšie knihy.

## Automatizované testy

Projekt obsahuje automatizované testy. Testy sa **NESPÚŠŤAJÚ** automaticky pri git push. Pokiaľ si chcete overiť na koľko vaša implementácia spĺňa testy musíte si ich spustiť sami. Testy sa dajú spustiť 2 spôsobmi:
* cez Maven, spustením _test_ lifecycle-u (bočné menu > maven > _projekt_ > lifecycle > test)
* spustením testov rovno z triedy ktorá ich obsahuje (nachádza sa v src/test/sk/.../oop/assignment3/Assignment3ApplicationTests.java)



# Assignment 3 - Books

B-OOP 2021

Your task is to create an application server using Java with the Spring framework.

The application server enables management of books, authors and lending lists of books (for example like in a library). The web Interface (API), and also the objects that are used to communicate with the outside world are defined in the specification and must be used to communicate through the web services. Outside the web interface you can use any other objects according to your design, if you deem it appropriate.

The web interface specification (API) that the application has to provide can be found here: https://app.swaggerhub.com/apis-docs/stuba-fei-uim-oop/OOPZadanie3Knihy/1.0.0-oas3

If the specification states that a 404 code should be returned, and the description does not say when, it is necessary to return it, if the given ID does not exist in the system.

### System description

A detailed description of each operation is given in the API specification.

The system allows the addition, removal and modification of books in a library, including the change of an author (a book can have only one author), as well as increasing the amount of available books.

The system allows the creation and deletion of lists of lent books. Books can be added and removed from these lists (the same list can contain the same book at most once). The system allows lending of such lists, lending a lists increments lending count for each book on the list. Adding additional books to lists that are already lent out is not allowed.

---------------------------------------------------------------------------------

## Automated tests
The project contains automated tests. Tests **DO NOT** run automatically on git push. If you want to verify how many of your implementations pass the tests, you must run them yourself. Tests can be run in 2 ways:

* using Maven, by launching the test lifecycle (side menu> maven> project> lifecycle> test)
* by running tests directly from the class that contains them (located in src/test/sk/.../oop/assignment3/Assignment3ApplicationTests.java))


