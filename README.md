## Tutorial by [Google Code Labs](https://github.com/googlecodelabs) 

In May 2017 Google released the Architecture Components libraries. Each library manages and simplifies aspects of data persistence and the UI component lifecycle. Together, the libraries encourage a modular app architecture that results in reduced complexity and less code.

This sample shows how to use the libraries to build a complete basic app that implements the recommended architecture and can be used as a template for further explorations.
## What are the recommended Architecture Components?

To introduce the terminology, here is a short introduction to the Architecture Components and how they work together. 
Note that this codelab focuses on a subset of the components, namely LiveData, ViewModel and Room. 
Each component is explained more as you use it. This diagram shows a basic form of this architecture.


<p align="center"> 
<img src="https://codelabs.developers.google.com/codelabs/android-room-with-a-view/img/3840395bfb3980b8.png" height="400" width="624" >
</p>



__Entity:__ When working with Architecture Components, this is an annotated class that describes a database table.

__SQLite database:__ On the device, data is stored in an SQLite database. For simplicity, additional storage options, such as a web server, are omitted. The Room persistence library creates and maintains this database for you.

__DAO:__ Data access object. A mapping of SQL queries to functions. You used to have to define these painstakingly in your SQLiteOpenHelper class. When you use a DAO, you call the methods, and Room takes care of the rest.

__Room database:__ Database layer on top of SQLite database that takes care of mundane tasks that you used to handle with an SQLiteOpenHelper. Database holder that serves as an access point to the underlying SQLite database. The Room database uses the DAO to issue queries to the SQLite database.

__Repository:__ A class that you create, for example using the WordRepository class. You use the Repository for managing multiple data sources.

__ViewModel:__ Provides data to the UI. Acts as a communication center between the Repository and the UI. Hides where the data originates from the UI. ViewModel instances survive configuration changes.

__LiveData:__ A data holder class that can be observed. Always holds/caches latest version of data. Notifies its observers when the data has changed. LiveData is lifecycle aware. UI components just observe relevant data and don't stop or resume observation. LiveData automatically manages all of this since it's aware of the relevant lifecycle status changes while observing.


In this codelab you build an app that does the following:

* Works with a database to get and save the data, and pre-populates the database with some words.
* Displays all the words in a RecyclerView in MainActivity.
* Opens a second activity when the user taps the + button. When the user enters a word, adds the word to the database and the list.




<img src="https://codelabs.developers.google.com/codelabs/android-room-with-a-view/img/2a518dec65b5b3dd.png" height="344" width="194"/> <img src="https://codelabs.developers.google.com/codelabs/android-room-with-a-view/img/ba2d72cea775f744.png" height="344" width="194"/> <img src="https://codelabs.developers.google.com/codelabs/android-room-with-a-view/img/ee5319926f0482eb.png" height="344" width="194"/>


## RoomWordSample architecture overview
The following diagram shows all the pieces of the app. Each of the enclosing boxes (except for the SQLite database) represents a class that you will create.

<p align="center"> 
<img src="https://codelabs.developers.google.com/codelabs/android-room-with-a-view/img/cc45ecfbf5889f07.png" height="459" width="559" >
</p>

There are a lot of steps to using the Architecture Components and implementing the recommended architecture. The most important thing is to create a mental model of what is going on, and understand how the pieces fit together and how the data flows. As you work through this codelab, don't just copy and paste the code, but try to start building that inner understanding.


