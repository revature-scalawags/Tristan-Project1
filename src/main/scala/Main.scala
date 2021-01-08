// Tristan Cates' Project1 at Revature
// See README.md for more info
// Main project functionality below:

package project1
import java.sql._
import com.typesafe.scalalogging.LazyLogging

object Main extends App with LazyLogging{
  
  var con : Connection = _
  try {
    // Establishing connection with the hive_server docker container
    val connectionString = "jdbc:hive2://localhost:10000/default"
    Class.forName("org.apache.hive.jdbc.HiveDriver")
    con = DriverManager.getConnection(connectionString, "", "")
    val dropTableStatement = con.createStatement()
    dropTableStatement.execute("DROP TABLE IF EXISTS wiki_events")
    val createTableStatement = con.createStatement();

    // Creating table and loading in data from the 501MB tsv file on Wikipedia 
    // revision event history during November, 2020
    createTableStatement.execute(createTableString.s)
    val loadDataStatement = con.createStatement()
    loadDataStatement.execute("LOAD DATA LOCAL INPATH './2020-11.enwiki.2020-11.tsv.bz2' OVERWRITE INTO TABLE wiki_events")
    
    val selectStatement = con.createStatement()
    val query = CLI.getQueryChoice()
    println("Hive query generated.")
    println("Querying the database... (can take up to 6 minutes, possibly much less with a good computer)\n")
    var resultSet = selectStatement.executeQuery(query)
    

    if (query == HiveQueries.top20RevisedDistinctPages){
      while(resultSet.next){
        val pageTitle = resultSet.getString("page_title")
        val revisionCount = resultSet.getInt("page_revision_count")
        println(pageTitle + " " + revisionCount.toString)
      }
    }
    else { // All other queries have the same logic after the data is retrieved, hence the 'else'
      var percentReverted = 0.toFloat
      var numRevisions = 0
      while(resultSet.next){
        numRevisions = resultSet.getInt("numRevisions")
        percentReverted = resultSet.getFloat("percentReverted")*100
      }
      println("Number of revisions: " + numRevisions.toString)
      println("Percent of revisions that were reverted: " + percentReverted.toString)
    }

    val dropTableStatement2 = con.createStatement()
    dropTableStatement2.execute("DROP TABLE IF EXISTS wiki_events")
  } 
  catch {
    case e: Exception => e.printStackTrace()
  }
  con.close()
}