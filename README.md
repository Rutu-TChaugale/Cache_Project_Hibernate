---

```markdown
# 🚀 Hibernate Caching Project (First & Second Level Cache)

Welcome to the Hibernate Caching Project! This project demonstrates how to use **Hibernate First-Level and Second-Level Cache** to improve performance and reduce database hits while working with a `Student` entity.

---

## 📚 What You’ll Learn

✅ How Hibernate caching works  
✅ Difference between First-Level and Second-Level cache  
✅ How to configure EhCache in a Hibernate project  
✅ Basic CRUD operations with caching effect  

---

## 🛠️ Tech Stack

- 💻 **Java**
- 🗃️ **Hibernate ORM**
- ⚡ **EhCache (Second-Level Cache Provider)**
- 🐬 **MySQL Database**
- 🧰 **Maven / JAR-based dependency**
- 🧑‍💻 **STS or Eclipse IDE**

---

## 🧠 Hibernate Caching Explained

### 🔹 First-Level Cache (Enabled by Default)
- Works **within a single session**
- Once an object is loaded, it's reused in the same session

### 🔹 Second-Level Cache (Manually Enabled)
- Works **across sessions**
- Requires configuration and a cache provider like **EhCache**
- Stores entities to reduce repeated DB queries

```java
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
```
This annotation is added on the entity class to enable second-level caching.

---

## 🏗️ Project Structure

```
com.sit
├── client             // Test class to perform operations
├── configuration      // Hibernate config with cache setup
└── model              // Student entity with caching enabled
```

---

## 💾 Database Setup

1. Create a MySQL database:
   ```
   CREATE DATABASE Cache_project;
   ```
2. Update your DB credentials in `HibernateUtil.java`:
   ```java
   map.put(Environment.USER, "your-username");
   map.put(Environment.PASS, "your-password");
   ```

---

## 🔧 How to Run This Project

1. **Clone the Repository**  
   ```bash
   git clone https://github.com/your-username/hibernate-cache-project.git
   ```

2. **Add Required EhCache JARs**  
   Include EhCache JARs from Hibernate’s `lib/optional/ehcache` directory.

3. **Run the Main Class**  
   Run `Test.java` from `com.sit.client` to test CRUD operations with caching.

---

## 🧪 What Happens in Code

- Save a `Student` entity
- Use first-level cache by accessing the same entity in the same session
- Use second-level cache after clearing session
- Update and delete operations to show how cache responds

---

## 📌 Sample Output

```
------------using 1st object of session--------------
Prithviraj
lallya@gmail.com
Kharigalii
------------------------------
...
```

---

## 💡 Pro Tips

- Use `READ_ONLY` cache strategy only for data that doesn’t change.
- Second-level cache is **sessionFactory-based**, so it's reusable across sessions.
- Don’t forget to clear session (`session.clear()`) when testing second-level cache!

---

⭐ If you find this helpful, give it a star on GitHub and share with others!
```

---

Let me know if you want me to convert this into a real Markdown preview or generate a badge version for GitHub.
