// CLI: A command line interface that asks the user for a choice of query to perform. 
// Handles invalid inputs.

package project1

object CLI {
    
    def toInt(s: String): Int = {
        try {
            s.toInt
        } catch {
            case e: Exception => -1
        }
    }

    def getUserRequest() : Int = 
    {
        println("\nWhich query would you like to execute with the revision history data of Wikipedia during November, 2020?")
        println("(0) List top 20 pages by revision count (all time #revisions since 2001)")
        println("(1) Compute number of revisions and percent of those which were later reverted (IN THE MONTH OF NOVEMBER, 2020) for the #1 revised page")
        println("(2) Compute number of revisions and percent of those which were later reverted (IN THE MONTH OF NOVEMBER, 2020) for the #2 revised page")
        println("(3) Compute number of revisions and percent of those which were later reverted (IN THE MONTH OF NOVEMBER, 2020) for the #3 revised page")
        println("(4) Compute number of revisions and percent of those which were later reverted (IN THE MONTH OF NOVEMBER, 2020) for the #4 revised page")
        println("(5) Compute number of revisions and percent of those which were later reverted (IN THE MONTH OF NOVEMBER, 2020) for the #5 revised page")  

       
        var userChoice = -1
        var validUserChoice = false
        while (!validUserChoice)
        {
            println("Enter a number (0-5): ")
            var userChoiceString = scala.io.StdIn.readLine()
            userChoice = toInt(userChoiceString)
            if (userChoice >= 0 && userChoice <= 5) {
                validUserChoice = true
            }
            else {
                println("Invalid input. Please enter a number between 0 and 5.")
            }
        }
        userChoice
    }

    def getQueryChoice() : String = 
    {
        val userInt = getUserRequest()
        userInt match {
            case 0 => HiveQueries.top20RevisedDistinctPages
            case 1 => HiveQueries.revisionQuery1
            case 2 => HiveQueries.revisionQuery2
            case 3 => HiveQueries.revisionQuery3
            case 4 => HiveQueries.revisionQuery4
            case 5 => HiveQueries.revisionQuery5
        }
    }
}
