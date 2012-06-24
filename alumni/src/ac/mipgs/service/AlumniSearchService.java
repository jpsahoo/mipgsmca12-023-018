package ac.mipgs.service;

import ac.mipgs.dao.AlumniSearchDao;
import ac.mipgs.dao.Dao;
import ac.mipgs.vo.AlumniFinder;
import ac.mipgs.vo.SearchResultByName;

public class AlumniSearchService {
	
	private static final String SEARCH_TYPE_NAME = "byName";
	private static final String SEARCH_TYPE_PLATFORM = "byPlatform";
	private static final String SEARCH_TYPE_PASSOUT_YEAR = "byPassoutYear";

	public SearchResultByName[] getSearchResults(AlumniFinder finder) throws Exception {
		
		SearchResultByName[] searchResultByName = null;
		try {
			Dao.getDBConnection();
			if (SEARCH_TYPE_NAME.equals(finder.getSearchType())) {
				searchResultByName = AlumniSearchDao.searchByName(finder);
			} else if (SEARCH_TYPE_PLATFORM.equals(finder.getSearchType())) {
				searchResultByName = AlumniSearchDao.searchByPlatform(finder);
			}
			else if (SEARCH_TYPE_PASSOUT_YEAR.equals(finder.getSearchType())) {
				searchResultByName = AlumniSearchDao.searchByPassoutYear(finder);
			}
			
		} catch (Exception e) {
			throw new Exception("Fail to get result");
		}
		return searchResultByName;
	}
}
