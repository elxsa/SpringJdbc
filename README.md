RO: Se creează un proiect Spring Boot (via spring initializr) prin intermediul căruia se realizează operațiile CRUD asupra tabelei "persoane" utilizând Spring Data JDBC. De asemenea, se dezvoltă un proiect Maven în care se adaugă dependențele MySQL Driver și Spring Data JDBC. Odată generată și descărcată, aceasta se va dezarhiva și se va importa în IntelliJ IDEA ca și proiect Maven. 

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

EN: We'll set up a Spring Boot project (via Spring Initializr) to perform CRUD operations on the "persons" table using Spring Data JDBC. Additionally, we'll develop a Maven project, adding dependencies for MySQL Driver and Spring Data JDBC. Once generated and downloaded, this will be unzipped and imported into IntelliJ IDEA as a Maven project.

The database "bd_spring_jdbc" will be created programmatically, as will the "persons" table. These can then be inspected in MySQL Workbench. This programmatically created database will be displayed and the table can be viewed within it.

In the src/main/resources directory, we will create the following: a data.sql file with the relevant content (introducing people with the following characteristics - id, name, and age), and in the application.properties file, configure the database connection parameters and the property spring.sql.init.mode with the value "always" (thus, the data.sql file will execute at every run).

At the first run, the persons table is created and populated so that at subsequent runs, recreating the table is not necessary. For this, the property spring.sql.init.mode is set to "never". If during development you want the "persons" table to be recreated at every run, you can leave the value always for the spring.sql.init.mode property, but add the command "drop table if exists persons" at the beginning of the data.sql file. This ensures that the table is first deleted at every run, then recreated and populated with data.

Next, we will run the program and launch the MySQL Workbench client.

In the subpackage "com.example", the following classes are created: the main program class, the "Person" class, "PersonMapper", and "PersonJdbcDao".

The "PersonMapper" class includes the following content:

- Data retrieved from the database is in tabular form in a ResultSet object;
  
- Records in the ResultSet are navigated using a cursor (initially positioned before the first line);
  
- Methods such as first(), previous(), next(), last(), absolute() allow cursor movement;
  
- Methods getInt(), getString() retrieve the values of fields specified as a parameter from the row indicated by the cursor;
  
- The mapRow() method from the RowMapper interface maps a row from the ResultSet indicated by the rowNumber parameter to a Person object.

The "PersonJdbcDao" class provides basic operations for data manipulation: reading, adding, modifying, deleting, etc.:

- @Repository is a specialized annotation for components that handle data access;
  
- The query() method from the JdbcTemplate class returns a result list, and the queryForObject() method returns a single object;
  
- The update() method from the JdbcTemplate class allows the execution of DML commands: insert, update, delete. The number of rows affected by the command is returned after execution;

The main program class contains the following:

- The CommandLineRunner interface, which the main program class implements, has the run() method that will be automatically called at application start-up, after the application context has been fully initialized;
  
- An instance of "PersonJdbcDao" is automatically injected into the main program class;
  
- The run() method calls methods from the "PersonJdbcDao" class and displays corresponding messages.
