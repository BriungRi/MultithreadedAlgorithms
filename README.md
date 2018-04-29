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

Design Document:

File Descriptions:

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

Data Structures:

Java's Thread class is used to do work asynchronously. 
All the threads are then joined to wait for computation to finish. 
Once the threads are done running, each algorithm extracts the result
for the merge step of the divide and conquer algorithm.
Merge Sort: Each thread sorts a partition of the original list. In the final step,
each of the sorted lists is merged to sort the original list.
Find Min: Each thread finds the min in a partition of the original list. In the
final step, each of the min values is compared to get the global min

Merge Sort Test Output:
```
Single threaded mergeSort run time: 1117ms
List of size 1000000 sorted in 786ms with 2 thread(s)
List of size 1000000 sorted in 443ms with 3 thread(s)
List of size 1000000 sorted in 419ms with 4 thread(s)
List of size 1000000 sorted in 314ms with 5 thread(s)
List of size 1000000 sorted in 339ms with 6 thread(s)
List of size 1000000 sorted in 343ms with 7 thread(s)
List of size 1000000 sorted in 296ms with 8 thread(s)
List of size 1000000 sorted in 313ms with 9 thread(s)
List of size 1000000 sorted in 323ms with 10 thread(s)
...
```

Find Min Test Output:
```
Single threaded findMin run time: 36ms
Min found in list of size 1000000 in 158ms with 2 thread(s)
Min found in list of size 1000000 in 67ms with 3 thread(s)
Min found in list of size 1000000 in 28ms with 4 thread(s)
Min found in list of size 1000000 in 21ms with 5 thread(s)
Min found in list of size 1000000 in 55ms with 6 thread(s)
Min found in list of size 1000000 in 31ms with 7 thread(s)
Min found in list of size 1000000 in 28ms with 8 thread(s)
Min found in list of size 1000000 in 26ms with 9 thread(s)
Min found in list of size 1000000 in 34ms with 10 thread(s)
...
```

Brian: I mainly worked on the multithreaded MergeSort algorithm. 
I also wrote up some tests and documentation.

Arbaz: I mainly worked on the FindMinimum algorithm. 
I also wrote up some tests and documentation.
