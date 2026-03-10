# Java Web Scraper (Simple ETL Pipeline)

This project is a custom, lightweight ETL (Extract, Transform, Load) pipeline written in core Java. It automates web data extraction, transforms the raw data into Java objects, and exports it to flat files for further analysis.

## ⚙️ How it works (The ETL Process)
1. **Extract:** The program connects to `http://quotes.toscrape.com/` and fetches the HTML structure using the Jsoup library.
2. **Transform:** It extracts raw text (quotes and authors) using CSS selectors and maps them into a dedicated `Quote` object, leveraging Object-Oriented Programming (OOP) principles.
3. **Load:** It formats the compiled list of objects and writes them to a `cytaty.csv` file using the OpenCSV library.

## 🛠️ Technologies Used
* **Java** (Core Java, Collections, OOP)
* **Jsoup** (HTML parsing and web scraping)
* **OpenCSV** (I/O stream handling and CSV formatting)

## 🚀 How to Run
To run this project locally, ensure you have the necessary dependencies (`.jar` files or Maven/Gradle configuration) for **Jsoup** and **OpenCSV** included in your project build. 
Upon compiling and executing the `Main` class, the program will generate a `cytaty.csv` file in the root directory, ready to be imported into Excel, Python, or a database.
