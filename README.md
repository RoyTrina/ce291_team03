# Student Marks Analyser - Team 03 README.md

Created by Team Members:

* Arpan Patel
* Klive Comia
* Falah Albinfalah
* Trina Roy
* Mohseenur Bashar
* Ben Brown
* Rakib Siddique

### Prerequisites:

* Access to Java JDK 8 (https://www.oracle.com/java/technologies/javase-jdk8-downloads.html) 
* Access to include Java JDK 8 to PATH for cmd
* Access to ce291_team03 repository (https://cseegit.essex.ac.uk/2019_ce291/ce291_team03)

### External Libaries:

* iText 5.5.13.1 (https://mvnrepository.com/artifact/com.itextpdf/itextpdf/5.5.13.1)
* JFreeChart 1.5.0 (https://mvnrepository.com/artifact/org.jfree/jfreechart/1.5.0)
* JUnit 4.13 (https://mvnrepository.com/artifact/junit/junit/4.13)

### Java Source Files:

* BarChart.java - Has Code to Output Bar Chart Data
* ExportPDF.java - Has Code to Export Data into a PDF
* Histogram.java - Has Code to Output Histogram Data
* Statistics.java - Has Code to Output Mean, Mode, Median Statistics
* Student.java - Includes main(), file loader to parse csv file
* Window.java - Has Code to output parsed csv file into a JTable and many more.

## How to compile and run the code:

* Download Source Code from Repository

![step1](/Final Product Report/Screenshots/Readme/Step1.png)
![step1](/Final Product Report/Screenshots/Readme/Step1Extra.png)

* Open up the "Analyser v2" folder

![step2](/Final Product Report/Screenshots/Readme/Step2.png)

* Keep a note of the directory of the folder, copy and paste it into your clipboard 

![step3](/Final Product Report/Screenshots/Readme/Step3.png)

* Open a command prompt and "cd" into the directory of the "Analyser v2" folder

![step4](/Final Product Report/Screenshots/Readme/Step4.png)

* Upon 'cd'ing the folder, input the following commands below (This will compile the program from command prompt):

`javac -d build -cp ./lib/hamcrest-core-1.3.jar;./lib/itextpdf-5.5.13.jar;./lib/jfreechart-1.5.0.jar;./lib/junit-4.13.jar ./src/*.java`

`cd build`

`jar cvfe StudentMarks.jar Student *.class`

![step5](/Final Product Report/Screenshots/Readme/Step5.png)

* This process should produce a StudentMarks.jar file in "Analyser v2/build/"

![step6](/Final Product Report/Screenshots/Readme/Step6.png)

* Once compiled, you can run StudentMarks.jar and it should run perfectly.

