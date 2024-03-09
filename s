warning: LF will be replaced by CRLF in src/main/java/org/ratomidev/Main.java.
The file will have its original line endings in your working directory
[1mdiff --git a/src/main/java/org/ratomidev/Main.java b/src/main/java/org/ratomidev/Main.java[m
[1mindex 4a66e6a..95c003e 100644[m
[1m--- a/src/main/java/org/ratomidev/Main.java[m
[1m+++ b/src/main/java/org/ratomidev/Main.java[m
[36m@@ -1,7 +1,12 @@[m
 package org.ratomidev;[m
[31m-[m
[32m+[m[32mimport java.io.IOException;[m
 public class Main {[m
[31m-    public static void main(String[] args) {[m
[31m-        System.out.println("Hello world!");[m
[32m+[m[32m    public static void main(String[] args)  throws IOException{[m
[32m+[m[32m        BankStatementParser bankStatementParser = new BankStatementCSVParser();[m
[32m+[m[32m        BankStatementAnalyser bankStatementAnalyser = new BankStatementAnalyser();[m
[32m+[m[32m        bankStatementAnalyser.analyse("transactions.csv",[m
[32m+[m[32m                bankStatementParser);[m
[32m+[m[32m        System.out.println("work");[m
[32m+[m
     }[m
 }[m
\ No newline at end of file[m
