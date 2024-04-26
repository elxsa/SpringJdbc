Se creează un proiect Spring Boot (via spring initializr) prin intermediul căruia se realizează operațiile CRUD asupra tabelei "persoane" utilizând Spring Data JDBC. De asemenea, se dezvoltă un proiect Maven în care se adaugă dependențele MySQL Driver și Spring Data JDBC. Odată generată și descărcată, aceasta se va dezarhiva și se va importa în IntelliJ IDEA ca și proiect Maven. 

Baza de date "bd_spring_jdbc" va fi creată prin program, la fel și tabela "persoane". Apoi se vor inspecta în MySQL Workbench. Această baza de date creată prin program va fi ulterior afișată și în aceasta poate fi vizualizată tabela. 

În scr/main/resources vom crea următoarele: data.sql cu conținutul aferent (introducerea de persoane cu următoarele caracteristici - id, nume, respectiv vârstă), în fișierul application.properties se configurează parametrii conexiunii la baza de date și proprietatea spring.sql.init.mode cu valoarea "always" (astfel fișierul data.sql va fi executat la fiecare rulare).

La prima rulare, se creează şi se populează tabela persoane, astfel încât la următoarele rulări nu mai este necesară recrearea tabelei. Pentru aceasta se atribuie proprietății spring.sql.init.mode valoarea "never". În cazul în care se dorește ca pe parcursul dezvoltării tabela "persoane" să fie recreată la fiecare rulare, se poate lasă valoarea always pentru proprietatea spring.sql.init.mode, dar se adaugă la începutul fişierului data.sql comanda: "drop table if exists persoane", iar aceasta va asigura că la fiecare rulare întâi se șterge tabelul, apoi se recreează şi se populează cu date. 

În continuare vom rula programul și vom lansa client-ul MySQL Workbench. 

În subpachetul "com.exemplu" se creează următoarele clase: clasa principala a programului, clasa "Persoana", "PersoanaMapper" și "PersoanaJdbcDao". 

Clasa "PersoanaMapper" este prevăzută cu următorul conținut:

- datele preluate din baza de date se găsesc sub formă tabelară într-un obiect de tip ResultSet;

- parcurgerea înregistrărilor din ResultSet se realizează cu ajutorul cursorului (acesta este poziționat inițial înaintea primei linii);

- metode precum first(), previous(), next(), last(), absolute() permit deplasarea cursorului;

- metodele getInt(), getString() permit obținerea valorilor câmpurilor specificate ca şi parametru de pe rândul indicat de cursor;

- metoda mapRow() din interfaţa RowMapper, mapează un rând din ResultSet indicat de parametrul rowNumber la un obiect de tip Persoana.

Clasa "PersoanaJdbcDao" oferă operațiile de bază pentru manipularea datelor: citire, adăugare, modificare, ștergere, etc:

- @Repository este o adnotaţie specializată pentru componente care se ocupă de accesul la date;

-  metoda query() din clasa JdbcTemplate returnează o listă rezultat, iar metodă queryForObject() returnează un singur obiect;

- metoda update() din clasa JdbcTemplate permite rularea comenzilor DML: insert, update, delete. În urma rulării acestora se returnează numărul de rânduri afectate de comandă;
  Clasa programului principal are următorul conținut:

- interfaţa CommandLineRunner, pe care clasa programului principal o implementează, dispune de metoda run() care va fi apelată automat la pornirea aplicației, după ce contextul aplicației a fost complet inițializat;

- o instanță "PersoanaJdbcDao" este injectată automat în clasa programului principal;

- în metoda run se apelează metodele din clasa "PersoanaJdbcDao" și se afișează mesaje corespunzătoare.
