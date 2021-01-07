package project1

object HiveQueries {
  
    val top10RevisedPages = """
        select * from wiki_events
        where event_entity = 'revision'
        order by page_revision_count desc
        limit 10
    """

    val selectAll = """
        select * from wiki_events
    """

    val top20RevisedDistinctPages = """
        select page_title, MAX(page_revision_count) AS page_revision_count
        from wiki_events
        where event_entity='revision'
        group by page_title
        order by page_revision_count desc
        limit 20
    """

    val oldQuery = """
        select page_title, revision_is_identity_reverted
        from wiki_events
        where event_entity='revision' 
        and page_title='Administrator_intervention_against_vandalism'
    """

    val revisionQuery1 = """
        select COUNT(page_title) AS numRevisions, 
        AVG(CASE WHEN revision_is_identity_reverted=TRUE THEN 1.000 ELSE 0.000 END) AS percentReverted
        from wiki_events
        where event_entity='revision' 
        and page_title='Administrator_intervention_against_vandalism'
        group by page_title
    """

    val revisionQuery2 = """
        select COUNT(page_title) AS numRevisions, 
        AVG(CASE WHEN revision_is_identity_reverted=TRUE THEN 1.000 ELSE 0.000 END) AS percentReverted
        from wiki_events
        where event_entity='revision' 
        and page_title="Administrators'_noticeboard/Incidents"
        group by page_title
    """

    val revisionQuery3 = """
        select COUNT(page_title) AS numRevisions, 
        AVG(CASE WHEN revision_is_identity_reverted=TRUE THEN 1.000 ELSE 0.000 END) AS percentReverted
        from wiki_events
        where event_entity='revision' 
        and page_title='Sandbox'
        group by page_title
    """

    val revisionQuery4 = """
        select COUNT(page_title) AS numRevisions, 
        AVG(CASE WHEN revision_is_identity_reverted=TRUE THEN 1.000 ELSE 0.000 END) AS percentReverted
        from wiki_events
        where event_entity='revision' 
        and page_title='Requests_for_page_protection'
        group by page_title
    """
    
    val revisionQuery5 = """
        select COUNT(page_title) AS numRevisions, 
        AVG(CASE WHEN revision_is_identity_reverted=TRUE THEN 1.000 ELSE 0.000 END) AS percentReverted
        from wiki_events
        where event_entity='revision' 
        and page_title='Reference_desk/Science'
        group by page_title
    """

}