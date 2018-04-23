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

output:
```
List of size 20000 sorted in 46ms with 1 thread(s)
List of size 20000 sorted in 49ms with 2 thread(s)
List of size 20000 sorted in 29ms with 3 thread(s)
List of size 20000 sorted in 28ms with 4 thread(s)
List of size 20000 sorted in 35ms with 5 thread(s)
List of size 20000 sorted in 28ms with 6 thread(s)
List of size 20000 sorted in 16ms with 7 thread(s)
List of size 20000 sorted in 30ms with 8 thread(s)
List of size 20000 sorted in 32ms with 9 thread(s)
List of size 20000 sorted in 13ms with 10 thread(s)
...
```

```
Min found in list of size 2000000 in 67ms with 1 thread(s)-2147475616
-2147477641

Min found in list of size 2000000 in 33ms with 2 thread(s)-2147478321
-2147478321
-2147479113

Min found in list of size 2000000 in 29ms with 3 thread(s)-2147481107
-2147481107
-2147481107
-2147481243

Min found in list of size 2000000 in 28ms with 4 thread(s)-2147481666
-2147481666
-2147481666
-2147481666
-2147481666

Min found in list of size 2000000 in 29ms with 5 thread(s)-2147476033
-2147479503
-2147479503
-2147479503
-2147483224
-2147483224

Min found in list of size 2000000 in 37ms with 6 thread(s)-2147478673
-2147480476
-2147483605
-2147483605
-2147483605
-2147483605
-2147483605

Min found in list of size 2000000 in 52ms with 7 thread(s)-2147474991
-2147482532
-2147482532
-2147482532
-2147482532
-2147482532
-2147482532
-2147482532

Min found in list of size 2000000 in 649ms with 8 thread(s)-2147457735
-2147482398
-2147482398
-2147482398
-2147482398
-2147482398
-2147482398
-2147482398
-2147482398

Min found in list of size 2000000 in 33ms with 9 thread(s)-2147426011
-2147482915
-2147482915
-2147482915
-2147482915
-2147482915
-2147482915
-2147482915
-2147482915
-2147482915
...
```

data structures:
Java's Thread class is used to do work asynchronously. 
All the threads are then joined to wait for computation to finish. 
Once the threads are done running, each algorithm extracts the result
for the merge step of the divide and conquer algorithm

d) 
By running the command:
`java Main`
you will see output to view the performance of the algorithm against variable list 
sizes and thread counts

e)
Brian: In this version, I mainly worked on the multithreaded MergeSort algorithm. 
I also wrote up some tests and documentation.

Arbaz: In this version, I mainly worked on the multithreaded sorting.
FindMinimum algorithm. I also wrote up some tests and documentation.
