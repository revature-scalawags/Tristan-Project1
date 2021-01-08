// HiveQueries: Strings of queries which hive will execute through this program to
// analyze the Wikipedia event data inside the wiki_events table.

package project1

object HiveQueries {
  
    // Selects all events from wiki_events; not used in program
    val selectAll = """ 
        select * from wiki_events
    """

    // Finds and lists the top 20 wikipedia pages in order of page_revision_count 
    // from wiki_events
    val top20RevisedDistinctPages = """
        select page_title, MAX(page_revision_count) AS page_revision_count
        from wiki_events
        where event_entity='revision'
        group by page_title
        order by page_revision_count desc
        limit 20
    """

    // Calculates the number of revision events which occured on the number 1 
    // most revised Wikipedia page 'Administrator_intervention_against_vandalism'
    // during the month of November, as well as the percentage (actually decimal 
    // value) of these revision events which were reverted later in the month.
    val revisionQuery1 = """
        select COUNT(page_title) AS numRevisions, 
        AVG(CASE WHEN revision_is_identity_reverted=TRUE THEN 1.000 ELSE 0.000 END) AS percentReverted
        from wiki_events
        where event_entity='revision' 
        and page_title='Administrator_intervention_against_vandalism'
        group by page_title
    """

    // Calculates the number of revision events which occured on the number 2 
    // most revised Wikipedia page "Administrators'_noticeboard/Incidents"
    // during the month of November, as well as the percentage (actually decimal 
    // value) of these revision events which were reverted later in the month.
    val revisionQuery2 = """
        select COUNT(page_title) AS numRevisions, 
        AVG(CASE WHEN revision_is_identity_reverted=TRUE THEN 1.000 ELSE 0.000 END) AS percentReverted
        from wiki_events
        where event_entity='revision' 
        and page_title="Administrators'_noticeboard/Incidents"
        group by page_title
    """

    // Calculates the number of revision events which occured on the number 3
    // most revised Wikipedia page 'Sandbox'
    // during the month of November, as well as the percentage (actually decimal 
    // value) of these revision events which were reverted later in the month.
    val revisionQuery3 = """
        select COUNT(page_title) AS numRevisions, 
        AVG(CASE WHEN revision_is_identity_reverted=TRUE THEN 1.000 ELSE 0.000 END) AS percentReverted
        from wiki_events
        where event_entity='revision' 
        and page_title='Sandbox'
        group by page_title
    """

    // Calculates the number of revision events which occured on the number 4 
    // most revised Wikipedia page 'Requests_for_page_protection'
    // during the month of November, as well as the percentage (actually decimal 
    // value) of these revision events which were reverted later in the month.
    val revisionQuery4 = """
        select COUNT(page_title) AS numRevisions, 
        AVG(CASE WHEN revision_is_identity_reverted=TRUE THEN 1.000 ELSE 0.000 END) AS percentReverted
        from wiki_events
        where event_entity='revision' 
        and page_title='Requests_for_page_protection'
        group by page_title
    """
    
    // Calculates the number of revision events which occured on the number 5 
    // most revised Wikipedia page 'Reference_desk/Science'
    // during the month of November, as well as the percentage (actually decimal 
    // value) of these revision events which were reverted later in the month.
    val revisionQuery5 = """
        select COUNT(page_title) AS numRevisions, 
        AVG(CASE WHEN revision_is_identity_reverted=TRUE THEN 1.000 ELSE 0.000 END) AS percentReverted
        from wiki_events
        where event_entity='revision' 
        and page_title='Reference_desk/Science'
        group by page_title
    """

}