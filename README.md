# KSU-Assignment-Graph
CS 5040: Data Structures and Algorithms
Summer 2020
Assignment #7 – Graph Algorithms - 100 points
Submission and Grading Instructions - Please read carefully
Before you submit, check for t he following:
1. Each submission gets one chance for grading.
2. Code that does not meet the assignment specific requirements receives no points.
3. Only complete and correctly working code receives credit. Code that does not compile and run on its own receives no points.
4. No zip files, only individual java files ready to compile and run. No links to share drives. (0 points if class/file naming does not follow the instructions)
5. Java requires that the class name and its file name be the same in order to be able to compile and run the code. Submission must follow file naming instructions outlined below. (0 points if class/file naming does not follow the instructions)
6. Each program file must include a header, as follows: (-20 when missing a header)
// Name: <your Name> // Class: CS 5040 // Term: Summer 2020 // Instructor: Dr. Haddad // Assignment: 7
// IDE: <IDE name>
7. Include reasonable in-line comments in the code to explain the code. Don’t overdo it. See provided code for guidance. (-20 when insufficient in-line code documentation)
8. Use meaningful class names, method names, and variable names in the code. (-20)
9. Running programs must be interactive to allow the user to test the code with different input values (see menu options below). DO NOT hardcode test data. (-20 when hard-coding inputs)
10. Use meaningful prompts when asking the user to enter inputs (e.g., Enter the circle radius: ) and meaning full labels for outputs (e.g., The area of the circle is 4.765). (-20)
11. Space out, organize, and align outputs using separate lines (\n) and tabs (\t) as you see fit and to improve output readability. (-20)
12. Other point deductions may apply to other issues found in the code and its outputs. (point deductions vary)
13. Always test your code with different inputs and make sure you test for special cases, such as removing from an empty queue. (point deductions vary)
14. Include your name in each file (program) name such as: ProgramName_Your_Name (-20)
Reachability_John_Doe
Rename your files as shown above before you start working on the code. Code may not work when renaming files right before uploading your submission.
Assignment Description:
The goal for this assignment is to implement the concept of graph reachability matrix discussed in the slides (see slides 27-30). This assignment focuses on computing Integer reachability matrix as illustrated on slide 30.
To keep the assignment focused, let’s assume that the graph has no more than 5 nodes. This way the program would computer up to 5 matrices (denoted in the slides as A1, A2, A3, A4 and A5).
Write a Java program that reads a connected (un-weighted) graph from the keyboard. Read number of nodes (no more than 5) in the graph, this input value determines the matrices size and number of matrices computed for this inputted graph. Next, read the actual values in the adjacency matrix of the graph (that is, A1 matrix).
Note: Since Java array indices start with 0, you may want to consider numbers the graph node starting with 0, such as Node 0, Node 1, Node 2, etc.
As an intermediate step to validate the computation of the integer matrices, test your code using the simple graph given on slide 29, printout A1, A2, and A3 for this graph and compare your outputs to the matrices shown on slide 30.
Next, computing the reachability matrix, Print out the matrix.
Next, use computed matrices to determine and print out the following information about the inputted graph:
1. In-degree of each node of the graph. Format the output like this (assuming the 3-node graph on slide 30):
Node 1 in-degree is 1
Node 2 in-degree is 2
Node 3 in-degree is 1
2. Out-degree for each node of the graph. Format the output like this (assuming the 3-node graph on slide 30):
Node 1 out-degree is 2
Node 2 out-degree is 1
Node 3 out-degree is 1
3. Total number of loops (also known as self-loops) in the graph. Format the output like this (assuming the 3-node graph on slide 30):
Total number of self-loops is 0
4. Total number of cycles of length N (N is the number of nodes in the inputted graph). Format the output like this (assuming the 3-node graph on slide 30):
Total number of cycles of length 3 edges is 3
5. Total number of paths of length 1-edge. Format the output like this (assuming the 3-node graph on slide 30):
Total number of paths of length 1 edge is 4
6. Total number of paths of length N edges (N is the number of nodes in the inputted graph). Format the output like this (assuming the 3-node graph on slide 30):
Total number of paths of length 3 edges is 7
7. Total number of paths of length 1 to N edges (N is the number of nodes in the inputted graph). Format the output like this (assuming the 3-node graph on slide 30):
Total number of paths of length 1 to 3 edges is 16
8. Total number of cycles length 1 to N edges (N is the number of nodes in the inputted graph). Format the output like this (assuming the 3-node graph on slide 30):
Total number of cycles of length 1 to 3 edges is 5
Include the following menu to allow the user to re-run the program for different graphs. Please DO NOT hard-code test data in your final submission. Selecting option 2 before option 1 should give an error message. Always re-display the menu after an option (other than option 0) is exercised.
---MAIN MENU-------- 0 – Exit Program 1 – Enter Graph Data
2 – Print Outputs
The assignment is very specific and straight forward. It must be implemented as specified following the discussion in the slides. Any deviation from these requirements will not be accepted and receives no points. No exceptions.
Only complete and correct code receives credit. Code must compile and run on its own as received. Using code from outside sources receives NO credit.
Submission:
Please submit your java solutions (separate files) to the assignment submission folder in D2L by the due date (posted in D2L). No late submissions are accepted. No zip files. The code must be correctly running right before being uploaded. Always test your code after each change you make to your code. Test your code thoroughly with different input scenarios, including empty input. The code must adhere to all above stated instructions to be considered for grading.
