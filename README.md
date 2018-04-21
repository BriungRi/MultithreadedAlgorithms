# MultithreadedAlgorithms

----

Getting started:
```
git clone https://github.com/BriungRi/MultithreadedAlgorithms.git
cd MultithreadedAlgorithms/src/
javac Main.java
java Main
```

----

Beta Version Requirements:

a) 
sorting package:
In here, you will find a MergeSort class and MergeSortWorker class. The MergeSort class contains a method that will
sort a randomly generated list with a specified size and thread count. Then, the MergeSort class will divide up the
generated list into roughly equal partitions and give each partition to a MergeSortWorker to sort using the Java built-in
sort algorithm. Finally, the MergeSort class will perform the merge step on all of the sorted partitions. To check the
validity of the sorted list (rather than printing out the list), a sort check is made on the list before printing output.

utils package:
In here contains a single ListUtils class. This class contains static methods to generate a random list, partition a list,
merge sorted lists, and check if a list is sorted. Some of these methods are unit tested in the test directory under the
same package.

d) 
By running the command:
`java Main`
you will see output to view the performance of the algorithm against variable list sizes and thread counts

e)
Brian: In this version, I mainly worked on the multithreaded MergeSort algorithm. I also wrote up some tests and documentation.
Arbaz: In this version, I mainly worked on the multithreaded FindMinimum algorithm. I also wrote up some tests and documentation.
