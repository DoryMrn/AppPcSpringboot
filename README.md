<h1>Project Description</h1>
This project is a web application developed in Java using the Spring Boot framework, Thymeleaf, Gradle dependencies, and SQL for data persistence. The application manages an inventory of electronic products in a warehouse, allowing users to view, add, modify, and purchase computers. A data persistence system has been implemented using JDBC to interact with a relational database.
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


<h1>Screenshots</h1>
<a href="https://gyazo.com/19b99a5d1c7266858d7318a5fcdc9cb5"><img src="https://i.gyazo.com/19b99a5d1c7266858d7318a5fcdc9cb5.png" alt="Image from Gyazo" width="1906"/></a>
<br>
<a href="https://gyazo.com/a51e928ec88708b951d1e34ab0f37983"><img src="https://i.gyazo.com/a51e928ec88708b951d1e34ab0f37983.png" alt="Image from Gyazo" width="1919"/></a>
<br>
<a href="https://gyazo.com/31eb664f509dd1c267b7ed5f36e41245"><img src="https://i.gyazo.com/31eb664f509dd1c267b7ed5f36e41245.png" alt="Image from Gyazo" width="1920"/></a>
