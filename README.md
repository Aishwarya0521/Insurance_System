
# 🛡️ Insurance Management System

A console-based Insurance Management System built in **Java** using **JDBC** and **MySQL**. This application allows users to manage insurance policies, clients, claims, and payments, following Object-Oriented Programming principles with layered architecture.

---

## 🧰 Technologies Used

- 💻 Java (JDK 8 or above)
- 🗄️ MySQL 5.7/8.0
- 🔌 JDBC (Java Database Connectivity)
- 🧪 MySQL Connector/J (JDBC driver)
- 🧾 SQL
- 🧠 OOP Concepts (Encapsulation, Abstraction, etc.)

---

## 📦 Entity Classes

- **User** → userId, username, password, role
- **Policy** → policyId, policyName, policyType, premium
- **Client** → clientId, clientName, contactInfo, policyId
- **Claim** → claimId, clientId, claimNumber, dateFiled, claimAmount, status, policyId
- **Payment** → paymentId, clientId, paymentDate, paymentAmount

---

## ⚙️ Configuration (`db.properties`)

Place this in `src/db.properties`:

```properties
host=localhost
port=3306
dbname=insurance
username=root
password=1234
```

Make sure this matches your actual MySQL setup.

---

## ▶️ How to Run

### From an IDE (Eclipse/IntelliJ):
1. Add `mysql-connector-j-8.x.xx.jar` to your project build path.
2. Set up your MySQL database as shown above.
3. Run `MainModule.java`.

---

## 🧪 Sample Input (Policy Creation)

```
>>>--- Insurance_System ---<<<

Select the option you want to perform from (1-6)
1. Create policy
2. View policy
3. View all policies
4. Update policy
5. Delete policy
6. Exit

Enter your choice: 1

-- Create new policy --
Enter policyId: 1
Enter policy name: HealthPlus
Enter policy type: Health
Enter premium: Monthly


---

## 🛠️ Future Enhancements

- GUI using JavaFX or Swing
- Web interface using Spring Boot
- Login authentication for roles (admin/client)
- Export reports (CSV, PDF)

---
