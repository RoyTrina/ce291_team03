**#Technical Diagrams**

 ![Class diagram](https://cseegit.essex.ac.uk/2019_ce291/ce291_team03/blob/master/Final%20Product%20Report/Screenshots/Implementation/classdiagram.png?raw=true "Class Diagram for Student Mark analyser")

Figure 1 – Class diagram for the student mark analyser

**#Technical Description**

We started by getting everyone up to speed on how to use GitLab, with the CMD (Command prompt) and the commands for pushing (uploading) and pulling (downloading) and Jira and preparing the MVP with the relevant technical documentation.

The MVP served as a backbone to the student mark analyser tool. For the MVP we needed the basic of the design done. Examples like reading a file and generating a list of a list, which is an array type String called records, an array list.

The program can split the data into columns and catches the File Not Found Exception, if the file reader cannot find the filename and outputs the &quot;File not found. Try again&quot;.

There is also a general exception caught that is not a File Not Found Exception, for catching exception and optimise code compilation and running.

![code](https://cseegit.essex.ac.uk/2019_ce291/ce291_team03/blob/master/Final%20Product%20Report/Screenshots/Implementation/code.jpg?raw=true "Code")

Figure 2 – Initial code for the analyser, pt. 1

![code 2](https://cseegit.essex.ac.uk/2019_ce291/ce291_team03/blob/master/Final%20Product%20Report/Screenshots/Implementation/code2.jpg?raw=true "Code 2")

Figure 3 – Initial code for the analyser, pt.2

This class is positioned in C:\Users\Trina\IndeaProjects\ce291\_team03\Reference\Analyser.java

![code 3](https://cseegit.essex.ac.uk/2019_ce291/ce291_team03/blob/master/Final%20Product%20Report/Screenshots/Implementation/code3.jpg?raw=true "Code 3")

Figure 4 – General structure

This is the current project structure of the student mark analyser tool.

![contents](https://cseegit.essex.ac.uk/2019_ce291/ce291_team03/blob/master/Final%20Product%20Report/Screenshots/Implementation/contents.png?raw=true "Contents")

Figure 5 – The structure of the code for the student analyser tool

**#Algorithms and Data Structures**

A data structure that has been used in our implementation is the array. An array is a collection of items that are located at contiguous memory locations. An array would have a better time and space complexity, since the data is not used to generate new format of data visualisation, unlike the graph.[1]

Another one is the graph. A graph is a non-linear representation of the data. I would assume that the graph would have a not so good performance against the array, in terms of time and space complexity, mentioned before.

**#Imported Libraries**

In terms of, 3rd party libraries, we used the following:

- JFreeChart – for generating charts (histograms, bar chart and many more)
- ITEXTPDF – for pdf conversion of the data and generating reports
- Hamcrest core – for Junit testing
- Junit – for code testing

**#Known Issues**

Most of the issues were dealt, so the code performance didn&#39;t falter.



**Bibliography**

[1]. GeeksforGeeks. (2020). _Array Data Structure - GeeksforGeeks_. [online] Available at: https://www.geeksforgeeks.org/array-data-structure/ [Accessed 6 Mar. 2020].