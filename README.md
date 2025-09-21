# Job Posting and Application Portal                

This Repository URL consists the Source Code of the Project "Job Posting and Application Portal".

### -> Project Description:

● In this Project, I had implemented the backend REST APIs for job to perform CRUD operations.   
READ: GET /api/jobs to get a list of all candidates from the database. <br/>
CREATE: POST /api/candidates to add a new candidate to the database.   
UPDATE: PUT /api/candidates/{id} to modify an existing candidate's data.   
DELETE: DELETE /api/candidates/{id} to remove a candidate.

● I had created a system to store, view, and organize information about the jobs.



### -> Project Outcomes:

● A Front-end: A dedicated Front-end that provides a user interface using modern component framework. 

● A Back-end API: A Backend server that is built to handle requests using REST APIs. 

● A Database: A SQL database that stores the candidate information.



### -> Technology Stack :

● Front-end: React.js 19, BootStrap + CSS, Axios

● Back-end: Java 17 with Spring Boot 3.5.6, Spring Data JPA.

● Database: MySQl Database.

● Build-Tools: Maven(Back-end), npm(Front-end).


### -> Project Setup Instructions:

To Setup this Project, follow the below steps:

● Back-end (Spring Boot):

1. Clone the Repository:
   https://github.com/madhavan2454/assignment-2-job-posting-and-application-portal.git/

2. Configure application.properties:   
   spring.datasource.url=jdbc:mysql://localhost:3306/cms   
spring.datasource.username=root   
spring.datasource.password=yourpassword    
spring.jpa.hibernate.ddl-auto=update

4. Run the Backend:
   Open the code in Visual Studio Code and run the application.  


● Front-end (React.js):

1. Install Node.js from it's official website.
2. Navigate to the frontend folder:   cd /cms-frontend
3. Install dependencies:   npm install
4. Run the frontend:   npm run dev
    

### -> API Overview:
● Candidate REST APIs:
| Method | Endpoint               | Description            |
| ------ | ---------------------- | ---------------------- |
| GET    | `/api/candidates`      | Get all candidates     |
| GET    | `/api/candidates/{id}` | Get candidate by ID    |
| POST   | `/api/candidates`      | Add a new candidate    |
| PUT    | `/api/candidates/{id}` | Update candidate by ID |
| DELETE | `/api/candidates/{id}` | Delete candidate by ID |


<img width="1917" height="1123" alt="image" src="https://github.com/user-attachments/assets/bc6aca47-03ff-4b2f-b53c-17a5483817c5" />


● Job REST APIs:
| Method | Endpoint         | Description              |
| ------ | -----------------| ------------------------ |
| GET    | `/api/jobs`      | Get the list of all Jobs     |
| GET    | `/api/jobs/{id}` | Get a job by ID    |
| POST   | `/api/jobs`      | Add a job post     |
| PUT    | `/api/jobs/{id}` | Update job post by ID |
| DELETE | `/api/jobs/{id}` | Delete job post by ID |

<img width="1919" height="1081" alt="image" src="https://github.com/user-attachments/assets/1e9822ea-c408-47b6-bbef-49e3c72a5de6" />

