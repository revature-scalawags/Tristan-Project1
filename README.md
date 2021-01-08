### Tristan Cates' Project1

### Dataset

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

### Questions and Solutions

With the dataset above I wrote my project in order to answer the following questions:

- Which Wikipedia pages have had the highest number of revisions since 2001 (top 20)?
- For each of the top 20 pages with the highest number of revisions since 2001, how many of these revisions occurred in November, 2020?
- Of the revisions that occured for each of these top pages in November, 2020, what percentage of them were later reverted?

In order to answer each of these questions, I set up a Hadoop cluster and loaded the dataset 
above into a hive table. I then performed Hive SELECT queries on this table to compute the 
answers to these questions. All of the queries performed and their descriptions can be found 
in /src/main/scala/HiveQueries.scala.

### Running the program

In order to run this program, you must first set up a docker environment. Clone https://github.com/big-data-europe/docker-hive onto your computer and then run ```docker-compose up -d```. This sets up an HDFS cluster on your computer,
along with a Hive server that you are now able to connect to in order to submit queries. 

Next, download the dataset above and use ```docker cp``` to move it from your computer and onto the active Hive server
container in the /opt/bin folder. As long as you keep this database running and have correctly transported this data
onto the server, you should now be able to run the program.

Now, to run the program, simply use ```sbt run``` in the project directory. The program should automatically connect to
the hive server on your computer, load the dataset into a hive table, and then prompt the user to decide which query
they want to perform on the data, given a list of options. The program will take a few minutes to run, and then output
the results of the given query to the terminal.

### Features
- HDFS
- Hadoop YARN
- Hive
- Scala
- Docker
- https://github.com/big-data-europe/docker-hive
- A CLI for query selection

