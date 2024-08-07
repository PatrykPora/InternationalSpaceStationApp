# InternationalSpaceStationApp
Scenariusz 2 - Międzynarodowa stacja kosmiczna ISS

technologie
- javaFx 
- hibernate
- sqlite
- Okhttp
- Gson
- narzedzia do testowania do ustalenia

Krótki opis systemu
W ramach projektu należy utworzyć aplikację pokazującą informacje o ruchu Międzynarodowej stacji kosmicznej (ISS).



Główne funkcje systemu
Pobieranie danych o ruchu ISS z odpowiedniego serwisu sieciowego
Przetwarzanie pobranych danych po stronie aplikacji
Pobrane dane powinny być zapisywane do bazy danych
Logika domenowa podzielona na warstwy, np. DAO, Serwis
Narzędzia do testowania jednostkowego



Funkcjonalności
Interfejs użytkownika
Użytkownik w ramach widoku konsolowego/graficznego powinien mieć możliwość wybrania jednej z poniższych opcji:



Obliczanie prędkości ISS
Użytkownik powinien dostawać informację o prędkości ISS na podstawie dwóch odczytów, wykorzystując API http://open-notify.org/Open-Notify-API/ISS-Location-Now/. Obliczona prędkość powinna zostać zapisana do bazy danych.



Zwracanie listy nadchodzących przebiegów ISS dla określonej lokalizacji
Użytkownik wybierając tę opcję powinien móc zobaczyć aktualną listę nadchodzących przebiegów ISS dla określonej lokalizacji, wykorzystując API https://web.archive.org/web/20200303060703/http://open-notify.org/Open-Notify-API/ISS-Pass-Times/. Dane powinny być zapisywane do bazy danych. Wprowadzana lokalizacja powinna być walidowana zgodnie z wytycznymi opisanymi w dokumentacji.




Zwracanie liczby osób przebywających w kosmosie w ramach ISS
Użytkownik wybierając tę opcję powinien móc zobaczyć aktualną listę osób przebywających w kosmosie w ramach misji kosmicznej, wykorzystując API http://open-notify.org/Open-Notify-API/People-In-Space/. Dane powinny być zapisywane do bazy danych.




Funkcjonalności opcjonalne
Dane statystyczne
Użytkownik powinien móc obliczać, np.:

średnią prędkość w określonym fragmencie czasu, np. miesiąc, rok. Obliczenia te powinny być oparte o aktualne rekordy z bazy danych
ile razy ISS znajdowało się nad daną lokalizacją w przedziale czasu

liczbę osób przebywających w ramach misji kosmicznej na ISS
Wizualizacja

W ramach interfejsu graficznego zaimplementuj mechanizm wyświetlający aktualną pozycję ISS na mapie świata.

Zapis/odczyt danych
Użytkownik powinien móc zapisać aktualnie zgromadzone dane do pliku w dowolnym formacie, a następnie odtworzyć je zapisując bezpośrednio do bazy danych.

Testy jednostkowe
Implementowane funkcjonalności powinny zostać pokryte testami jednostkowymi zgodnie z powszechnie stosowanymi metodologiami i praktykami.



Dodatkowe wymagania
Program powinien spełniać następujące kryteria:
