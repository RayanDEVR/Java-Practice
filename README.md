# Java Core Mastery --- 200 Exercises

A hands-on Java practice repository documenting my journey from Java fundamentals to object-oriented design, collections, streams, concurrency, and console-based backend-style applications.

> **Status:** All 200 workbook exercises completed and uploaded to this
> repository.

## Overview

I used this workbook to move beyond simply following tutorials and practise solving problems independently. The exercises progress from small syntax and logic tasks to larger applications that combine multiple Core Java concepts.

-   **200 exercises** across 12 learning levels
-   **Beginner → Intermediate → Advanced → Mini Projects → Capstone**
-   Focus on business logic, object-oriented design, validation, collections, exception handling, and backend-oriented problem solving
-   Final capstone: **Online Shopping Backend Simulation**

## What I Practised

-   **Java fundamentals:** 
    program structure, JDK/JRE/JVM, variables, primitive types, operators, type conversion, conditions, and loops
-   **Methods and memory:** 
    parameters, return values, method overloading, references, stack and heap reasoning
-   **Arrays and strings:** 
    multidimensional arrays, arrays of objects, `String` immutability, `StringBuilder`, and `StringBuffer`
-   **Object-oriented programming:** 
    classes, objects, encapsulation, constructors, inheritance, overriding, polymorphism, abstraction, interfaces, packages, access modifiers, and `final`
-   **Object contracts and language features:** 
    `toString()`, `equals()`, `hashCode()`, wrapper classes, boxing/unboxing, enums, annotations, anonymous classes, and lambda expressions
-   **Exceptions and input:** 
    `try`/`catch`, custom exceptions, `throw`, `throws`, `Scanner`, `BufferedReader`, and try-with-resources
-   **Concurrency:** 
    `Thread`, `Runnable`, `sleep()`, `join()`, race conditions, synchronization, and shared-state safety
-   **Collections and functional-style processing:** 
    `List`, `ArrayList`, `Set`, `HashSet`, `TreeSet`, `Map`, `HashMap`, `Comparator`, `Comparable`, `Collections.sort()`, and Stream API operations such as `forEach`, `filter`, `map`, `reduce`, and `sorted`

## Learning Progression

  Level     Exercises Main focus
  ------- ----------- --------------------------------------------------
  1          001--010 Program structure and Java execution
  2          011--030 Variables, types, conversion, and operators
  3          031--050 Decisions and loops
  4          051--065 Methods, overloading, stack, and heap
  5          066--085 Arrays and arrays of objects
  6          086--100 Strings and mutable text builders
  7          101--145 Object-oriented design mastery
  8          146--160 Exceptions, console input, and resource handling
  9          161--170 Threads, race conditions, and synchronization
  10         171--180 Collections, ordering, lambdas, and streams
  11         181--199 Mini applications
  12              200 Online Shopping Backend Simulation capstone

## Selected Applications and Projects

The workbook includes practical exercises and mini applications such as:

-   Student gradebook and invoice/discount engine
-   ATM simulation and multi-account banking system
-   Library management and hospital appointment manager
-   Employee payroll and restaurant ordering systems
-   Movie ticket booking and parking lot manager
-   Hotel reservation, inventory management, and contact book
-   Expense tracker, quiz application, and point-of-sale system
-   Shopping cart domain and authentication/role simulation
-   Thread-safe order counter
-   **Online Shopping Backend Simulation** --- the final capstone

These are practice simulations using the concepts in the workbook; they should not be interpreted as production-ready services.

## Final Capstone --- Online Shopping Backend Simulation

The final exercise brings multiple Core Java concepts together in an in-memory shopping backend. Its intended design includes packages such as `app`, `model`, `service`, `exception`, and `util`, along with domain models, interfaces, enums, collections, validation, custom exceptions, order workflows, reports, and optional concurrency work.

The workbook's target workflows include user registration, product and stock management, cart operations, price calculation, checkout/payment simulation, order-status transitions, cancellation and stock restoration, customer order history, and administrative reports.

## Running the Code

This repository contains many independent practice exercises, so the exact entry-point class and run command depend on the exercise.

1.  Clone or download the repository.
2.  Open the relevant exercise's folder and inspect its source files.
3.  Identify the class containing `public static void main(String[] args)` for that exercise.
4.  Run it using your Java IDE, or compile and run the relevant class from a terminal when the exercise's package structure permits it.

For example, for a simple standalone class with no package declaration:

``` bash
javac Main.java
java Main
```

If an exercise uses packages or multiple source files, compile/run it from the appropriate project root or use the IDE's run configuration.

## Scope and Learning Boundaries

The workbook follows the Java Core teaching scope from the Telusko playlist's Java Introduction through Stream API `map`/`filter`/`reduce`/`sorted` material (playlist videos 1--101, as defined by the workbook). It intentionally does **not** claim to cover every modern Java feature, file read/write handling, JUnit, or Spring Boot itself.

Completing these exercises is a foundation for further backend development---not a claim of professional mastery by itself. My next learning steps include automated testing with JUnit, deeper build-tool practice with Maven, HTTP/REST/JSON, SQL/JDBC, and Spring Boot.

## Complete Exercise Index

The checklist below lists all 200 exercises in workbook order.

### Level 1 --- Program Structure, JDK/JRE/JVM and Execution (Exercises 1--10)

-   [x] **001.** Compile and Run Without an IDE
-   [x] **002.** Explain the Java Execution Pipeline
-   [x] **003.** Repair a Broken Entry Point
-   [x] **004.** Filename and Class-Name Investigation
-   [x] **005.** Complete the Main Method
-   [x] **006.** JDK, JRE or JVM?
-   [x] **007.** Case Sensitivity Lab
-   [x] **008.** Compiler Error Triage
-   [x] **009.** Console Profile Card
-   [x] **010.** Read an Unfamiliar Tiny Program

### Level 2 --- Variables, Types, Literals, Conversion and Operators (Exercises 11--30)

-   [x] **011.** Business Variable Inventory
-   [x] **012.** Primitive Type Showcase
-   [x] **013.** Readable Literals
-   [x] **014.** Character Arithmetic
-   [x] **015.** Boolean Rule Flags
-   [x] **016.** Widening Conversion
-   [x] **017.** Narrowing and Data Loss
-   [x] **018.** Integer Overflow in a Sales Total
-   [x] **019.** Integer Division Trap
-   [x] **020.** Invoice Arithmetic
-   [x] **021.** Compound Assignment and Increment
-   [x] **022.** Operator Precedence Audit
-   [x] **023.** Relational Eligibility Checks
-   [x] **024.** Logical Operator Truth Table
-   [x] **025.** Short-Circuit Safety
-   [x] **026.** Complete a Shopping Calculation
-   [x] **027.** Precision Expectations
-   [x] **028.** Temperature Converter
-   [x] **029.** Employee Gross Pay
-   [x] **030.** Shared Restaurant Bill

### Level 3 --- Decisions and Loops (Exercises 31--50)

-   [x] **031.** Account Balance Classification
-   [x] **032.** Largest Approved Credit Limit
-   [x] **033.** University Grade and Status
-   [x] **034.** Subscription Eligibility
-   [x] **035.** Loan Decision Table
-   [x] **036.** Ternary Shipping Fee
-   [x] **037.** Traditional Switch: Support Department
-   [x] **038.** Enhanced Switch: Plan Price
-   [x] **039.** PIN Retry Loop
-   [x] **040.** Menu That Runs at Least Once
-   [x] **041.** Batch Invoice Numbers
-   [x] **042.** Cinema Seat Map
-   [x] **043.** Which Loop and Why?
-   [x] **044.** Repair an Infinite Loop
-   [x] **045.** Prefix/Postfix Loop Trace
-   [x] **046.** Range Validation Loop
-   [x] **047.** Tiered Discount Engine
-   [x] **048.** Parking Charge Calculator
-   [x] **049.** Utility Billing Bands
-   [x] **050.** Menu-Driven Calculator

### Level 4 --- Methods, Overloading, Stack and Heap (Exercises 51--65)

-   [x] **051.** First Reusable Business Method
-   [x] **052.** Parameters Versus Return Values
-   [x] **053.** Invoice Method Pipeline
-   [x] **054.** Overloaded Receipt Printer
-   [x] **055.** Overloaded Delivery Fee
-   [x] **056.** Complete a Validation Utility
-   [x] **057.** Pass-by-Value Investigation
-   [x] **058.** Stack and Heap Object Trace
-   [x] **059.** Refactor a God Method
-   [x] **060.** Reusable Boundary Methods
-   [x] **061.** Authentication Simulation Methods
-   [x] **062.** Payroll Service Functions
-   [x] **063.** Method Naming and Contract Review
-   [x] **064.** Conversion Utility Suite
-   [x] **065.** Order Summary Coordinator

### Level 5 --- Arrays and Arrays of Objects (Exercises 66--85)

-   [x] **066.** Array Defaults and Initialization
-   [x] **067.** Weekly Sales Total
-   [x] **068.** Grade Statistics
-   [x] **069.** Stock Extremes
-   [x] **070.** Find a Product ID
-   [x] **071.** Controlled Array Update
-   [x] **072.** Boundary Failure Investigation
-   [x] **073.** Apply a Price Increase
-   [x] **074.** Branch Sales Matrix
-   [x] **075.** Seat Availability Matrix
-   [x] **076.** Jagged Department Teams
-   [x] **077.** Three-Dimensional Warehouse Snapshot
-   [x] **078.** Enhanced-for Suitability
-   [x] **079.** Product Object Array
-   [x] **080.** Student Results Object Array
-   [x] **081.** Null Slot Failure
-   [x] **082.** Parallel Arrays to Objects
-   [x] **083.** Array Limitation Memo
-   [x] **084.** Monthly Performance Report
-   [x] **085.** Hotel Occupancy Grid

### Level 6 --- Strings, StringBuilder and StringBuffer (Exercises 86--100)

-   [x] **086.** String Pool Reference Trace
-   [x] **087.** Fix Login String Comparison
-   [x] **088.** Immutable Concatenation
-   [x] **089.** Order Reference Builder
-   [x] **090.** Receipt with StringBuffer
-   [x] **091.** Username Construction
-   [x] **092.** Builder Capacity Observation
-   [x] **093.** Insert and Delete a Receipt Marker
-   [x] **094.** StringBuilder Versus StringBuffer
-   [x] **095.** Repeated Concatenation Refactor
-   [x] **096.** String Alias Investigation
-   [x] **097.** Customer Message Composer
-   [x] **098.** Product Label Refactor
-   [x] **099.** Mutable Text Bug Hunt
-   [x] **100.** Text Module Review Challenge

### Level 7 --- Object-Oriented Design Mastery (Exercises 101--145)

-   [x] **101.** Encapsulated Bank Account
-   [x] **102.** Getter/Setter Validation
-   [x] **103.** Using this to Resolve Shadowing
-   [x] **104.** Constructor Invariants
-   [x] **105.** Default Versus Parameterized Construction
-   [x] **106.** Static Company Policy
-   [x] **107.** Static Method Boundaries
-   [x] **108.** Static Initialization Block
-   [x] **109.** Anonymous Object Use
-   [x] **110.** Naming Convention Cleanup
-   [x] **111.** Single Inheritance: Employee Types
-   [x] **112.** Multilevel Inheritance Trace
-   [x] **113.** this() and super() Constructor Chain
-   [x] **114.** Override Payroll Calculation
-   [x] **115.** Package the Domain
-   [x] **116.** Access Modifier Experiment
-   [x] **117.** final Policy Constant and Method
-   [x] **118.** Wrapper and Boxing Lab
-   [x] **119.** Readable Product toString
-   [x] **120.** Value Equality for Product
-   [x] **121.** Runtime Dispatch: Notification Channels
-   [x] **122.** Unsafe Downcast Repair
-   [x] **123.** Is-a or Has-a Review
-   [x] **124.** Multiple Behavior Through Interfaces
-   [x] **125.** Interface-Driven Payment Processor
-   [x] **126.** Abstract Account Template
-   [x] **127.** Abstract Class Versus Interface Decision
-   [x] **128.** Inner Class for Validation Result
-   [x] **129.** Anonymous Class Strategy
-   [x] **130.** Functional Interface Contract
-   [x] **131.** Lambda with Returned Value
-   [x] **132.** Enum Order Status
-   [x] **133.** Enum with Fields and Constructor
-   [x] **134.** Enum State Transition Guard
-   [x] **135.** Annotation Understanding
-   [x] **136.** Object Contract in Hash-Based Collections Preview
-   [x] **137.** Polymorphic Employee Payroll
-   [x] **138.** Interface Segregation Exercise
-   [x] **139.** Package-Level Access Design
-   [x] **140.** final and Immutability Reasoning
-   [x] **141.** Dependency Replacement
-   [x] **142.** Anonymous Inner Class for Override
-   [x] **143.** Complex Domain Model Review
-   [x] **144.** OOP Refactoring: Procedural Checkout
-   [x] **145.** OOP Mastery Design Challenge

### Level 8 --- Exceptions, Input and Resource Handling (Exercises 146--160)

-   [x] **146.** Try/Catch Division Repair
-   [x] **147.** Multiple Catch Diagnosis
-   [x] **148.** Exception Hierarchy Map
-   [x] **149.** Throw a Business Rule Failure
-   [x] **150.** Custom InsufficientFundsException
-   [x] **151.** Custom InvalidOrderException
-   [x] **152.** throws and Propagation Chain
-   [x] **153.** Catch, Translate and Preserve Meaning
-   [x] **154.** Scanner Input Validation Loop
-   [x] **155.** BufferedReader Input Program
-   [x] **156.** Input API Comparison
-   [x] **157.** Try-with-Resources Conversion
-   [x] **158.** Failure-Atomic Transfer
-   [x] **159.** Exception Anti-Pattern Review
-   [x] **160.** Robust Console Registration

### Level 9 --- Threads, Runnable and Race-Condition Safety (Exercises 161--170)

-   [x] **161.** Thread start Versus run
-   [x] **162.** Two Concurrent Activities
-   [x] **163.** Runnable-Based Tasks
-   [x] **164.** Lambda Runnable
-   [x] **165.** Sleep and Timing Observation
-   [x] **166.** join for Final Report
-   [x] **167.** Priority Is Not a Contract
-   [x] **168.** Lost Update Counter
-   [x] **169.** Atomic Withdrawal Business Operation
-   [x] **170.** Thread State Observation

### Level 10 --- Collections, Ordering and Stream Processing (Exercises 171--180)

-   [x] **171.** ArrayList Order Ledger
-   [x] **172.** Unique Coupon Codes
-   [x] **173.** Sorted Unique Service Zones
-   [x] **174.** Customer Lookup Map
-   [x] **175.** Choose the Right Collection
-   [x] **176.** Natural Product Ordering
-   [x] **177.** External Ordering with Comparator
-   [x] **178.** forEach Reporting
-   [x] **179.** Filter, Map and Reduce Invoice Values
-   [x] **180.** Sorted Stream Business Report

### Level 11 --- Mini Applications (Exercises 181--199)

-   [x] **181.** Student Gradebook Console
-   [x] **182.** Invoice and Discount Engine
-   [x] **183.** ATM Simulation
-   [x] **184.** Multi-Account Banking System
-   [x] **185.** Library Management Console
-   [x] **186.** Hospital Patient and Appointment Manager
-   [x] **187.** Employee Payroll Application
-   [x] **188.** Restaurant Ordering System
-   [x] **189.** Movie Ticket Booking
-   [x] **190.** Parking Lot Manager
-   [x] **191.** Hotel Reservation Console
-   [x] **192.** Inventory Management System
-   [x] **193.** Contact Book
-   [x] **194.** Expense Tracker
-   [x] **195.** Quiz Application
-   [x] **196.** Simple Point-of-Sale System
-   [x] **197.** Shopping Cart Domain
-   [x] **198.** Authentication and Role Simulation
-   [x] **199.** Thread-Safe Order Counter

### Level 12 --- Final Capstone (Exercises 200--200)

-   [x] **200.** Capstone: Online Shopping Backend Simulation

## Credits

-   Practice scope based on the **Java Core Mastery Workbook for Telusko Playlist Videos 1--101**.
-   Original learning resource: [Telusko Java tutorial playlist](https://youtube.com/playlist?list=PLsyeobzWxl7pe_IiTfNyr55kwJPWbgx5).

------------------------------------------------------------------------

*This repository records my completed practice work and ongoing growth as a Java developer.*
