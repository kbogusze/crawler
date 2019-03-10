# Web crawler
Simple web crawler application in java.

# To run application:
1. Clone repository from GIT
2. Go inside project folder
3. Run following maven command

```
mvn -q clean compile exec:java -Dexec.mainClass="Application" -Dexec.args="http://wiprodigital.com"
```
where args are array of URLs that we would like to visit

Requirements:
JDK version 8+
Apache Maven version 3+


#Future improvement:
Multithreading implementation to speed crawling process.
Integration with Database to save results
Build application as service with scheduled crawling process
