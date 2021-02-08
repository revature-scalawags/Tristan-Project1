# Wikipedia Revision History Analysis

## Project Description

Utilizing the dataset of all Wikipedia revision history during November 2020, I wrote my project to answer the following questions:

- Which Wikipedia pages have had the highest number of revisions since 2001 (top 20)?
- For each of the top 20 pages with the highest number of revisions since 2001, how many of these revisions occurred in November, 2020?
- Of the revisions that occured for each of these top pages in November, 2020, what percentage of them were later reverted?

In order to answer each of these questions, I set up a Hadoop cluster on docker containers. Then, using ```sbt run```, my program loads 
wikipedia data into Hive tables connected to the Hadoop cluster, then performs Hive queries on these tables to compute the answers to 
these questions. All of the queries performed and their descriptions can be found in /src/main/scala/HiveQueries.scala.

The dataset I use in this project can be found through the link below:

https://dumps.wikimedia.org/other/mediawiki_history/2020-11/enwiki/2020-11.enwiki.2020-11.tsv.bz2

This .bz2 file is a 501MB compressed file containing tsv-formatted data of the 
revision history of wikipedia pages during the month of November, 2020. Each
row is an update event in Wikipedia's history. In this project I am only concerned 
with revision events. 

The data contains 70+ columns, notably including event_entity (whether the event is a user, 
page, or revision), page_title (current title of the page the event is associated
with), page_revision_count (number of revisions of the page this event is associated 
with since 2001), and revision_is_identity_reverted (True if this revision event was 
later reverted, False if this revision remained).

## Technologies Used

* HDFS - version 3.2.1
* Hadoop YARN - version 3.2.1
* Hive - version 3.1.2
* Docker Compose - version 1.28.2
* Scala - version 2.11.12
* ScalaTest - version 3.2.2
* sbt - version 1.2.1
* https://github.com/big-data-europe/docker-hive
* Java JDK - version 8 or 11

## Features

List of features ready and TODOs for future development
* Contains Hive queries to analyze Wikipedia revision history in November 2020.
* Connects to HDFS and Hadoop YARN through a cluster of Docker containers on your machine.
* Parses through a tsv-bz2 file containing 501MB of data with over 70 unique fields.
* Contains a CLI for query selection.
* Utilizes sbt for program development, execution and testing.

To-do list:
* Enable functionality for compiling multiple months of Wikipedia revision data for query analysis over longer timeframes.

## Getting Started
   
In order to run this program, you must first set up a docker environment. Clone https://github.com/big-data-europe/docker-hive 
onto your computer and then run ```docker-compose up -d```. This sets up an HDFS cluster on your computer, along with a Hive 
server that you are now able to connect to in order to submit queries. 

Next, download the dataset above (https://dumps.wikimedia.org/other/mediawiki_history/2020-11/enwiki/2020-11.enwiki.2020-11.tsv.bz2) 
and use ```docker cp``` to move it from your computer and onto the active Hive server container in the /opt/bin folder. As long as 
you keep this database running and have correctly transported this data onto the server, you will now be able to run the program.

Finally, execute the following command: ```git clone https://github.com/revature-scalawags/Tristan-Project1.git``` to clone this repository
to your desired location on your machine. 

## Usage

Simply execute ```sbt run``` in the project directory. The program will automatically connect 
to the hive server on your computer, load the dataset into a hive table, and then prompt you to decide which query
they want to perform on the data, given a list of options. The program will take a few minutes to run, and then output
the results of the chosen query to the terminal.

Use ```sbt test``` to run all tests for this program.
