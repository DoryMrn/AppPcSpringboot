<h1>Project Description</h1>
This project is a web application developed in Java using the Spring Boot framework, thymeleaf, Gradle dependencies, and SQL for data persistence. The application manages an inventory of electronic products in a warehouse, allowing users to view, add, modify, and purchase computers. A data persistence system has been implemented using JDBC to interact with a relational database.
<h2>Main Features:</h2>
    1. Inventory Display:<br>
        ◦ Users can view the complete list of products available in the warehouse.<br>       
    2. Adding New Computers:<br>
        ◦ Administrators can add new products specifying brand, type, model, description, available quantity, image URL, and price.<br>          
    3. Computer Purchase:<br>
        ◦ Users can select desired computers and purchase them. The system automatically calculates the total order price and sends a confirmation email to the user.<br>      
    4. Email Sending:<br>
        ◦ It's possible to send emails using a dedicated form, specifying recipient, subject, and message body.<br>       
    5. Computer Order Viewing:<br>
        ◦ Administrators can view the list of computer orders placed, including details of individual orders.<br>
<h2>Project Structure:</h2>
<h3>The project is organized into various classes and packages:</h3>
    • MyController: Contains methods to handle HTTP requests and interact with the model.<br>
    • Services: Includes services for email sending (EmailService), as well as for interacting with the database for computers (pcJDBCTemp) and orders (pcOrdJDBCTemp).<br>
    • Views: HTML pages are organized within the resources/templates directory.<br>
<h3>Installation Instructions:</h3>
    1. Clone the repository.<br>
    2. Configure the database server and modify access credentials in the application.properties file.<br>
    3. Compile and run the application using an IDE compatible with Spring Boot.<br>
For further details on usage and development of the project, refer to the documentation and source code.<br>
<br>

<h1>Descrizione del Progetto</h1>
Questo progetto è un'applicazione web sviluppata in Java utilizzando il framework Spring Boot, thymeleaf, le dipendenze di Gradle e il database dei dati di SQL. L'applicazione gestisce un inventario di prodotti di elettronica in un magazzino, consentendo agli utenti di visualizzare, aggiungere, modificare e acquistare computer. È stato implementato un sistema di persistenza dei dati tramite JDBC per interagire con un database relazionale.
<h2>Funzionalità Principali:</h2>
    1. Visualizzazione dell'Inventario:<br>
        ◦ Gli utenti possono visualizzare l'elenco completo dei prodotti disponibili nel magazzino. <br>       
    2. Aggiunta di Nuovi Computer:<br>
        ◦ Gli amministratori possono aggiungere nuovi prodotti specificando marca, tipologia, modello, descrizione, quantità disponibile, URL dell'immagine e prezzo. <br>          
    3. Acquisto di Computer:<br>
        ◦ Gli utenti possono selezionare i computer desiderati e acquistarli. Il sistema calcola automaticamente il prezzo totale dell'ordine e invia una email di conferma all'utente.  <br>      
    4. Invio di Email:<br>
        ◦ È possibile inviare email utilizzando un modulo dedicato, specificando destinatario, oggetto e corpo del messaggio. <br>       
    5. Visualizzazione degli Ordini di Computer:<br>
        ◦ Gli amministratori possono visualizzare l'elenco degli ordini di computer effettuati, inclusi i dettagli dei singoli ordini. <br>
<h2>Struttura del Progetto:</h2>
<h3>Il progetto è organizzato in diverse classi e pacchetti:</h3>
    • MyController: Contiene i metodi per gestire le richieste HTTP e interagire con il modello.<br>
    • Servizi: Sono presenti servizi per l'invio di email (EmailService), nonché per l'interazione con il database per i computer (pcJDBCTemp) e gli ordini (pcOrdJDBCTemp).<br>
    • Viste: Le pagine HTML sono organizzate all'interno della directory resources/templates.<br>
<h3>Istruzioni per l'Installazione:</h3>
    1. Clona il repository.<br>
    2. Configura il server di database e modifica le credenziali di accesso nel file application.properties.<br>
    3. Compila e avvia l'applicazione utilizzando un IDE compatibile con Spring Boot.<br>
Per ulteriori dettagli sull'utilizzo e lo sviluppo del progetto, consulta la documentazione e il codice sorgente.<br>
<br>


<h1>Screenshots</h1>
<a href="https://gyazo.com/19b99a5d1c7266858d7318a5fcdc9cb5"><img src="https://i.gyazo.com/19b99a5d1c7266858d7318a5fcdc9cb5.png" alt="Image from Gyazo" width="1906"/></a>
<br>
<a href="https://gyazo.com/a51e928ec88708b951d1e34ab0f37983"><img src="https://i.gyazo.com/a51e928ec88708b951d1e34ab0f37983.png" alt="Image from Gyazo" width="1919"/></a>
<br>
<a href="https://gyazo.com/31eb664f509dd1c267b7ed5f36e41245"><img src="https://i.gyazo.com/31eb664f509dd1c267b7ed5f36e41245.png" alt="Image from Gyazo" width="1920"/></a>
