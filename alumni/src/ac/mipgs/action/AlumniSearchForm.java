package ac.mipgs.action;

import ac.mipgs.vo.AlumniFinder;
import ac.mipgs.vo.SearchResultByName;

public class AlumniSearchForm extends AuthenticatingForm {
	
	private AlumniFinder alumniFinder = new AlumniFinder();
	private SearchResultByName[] searchResult = new SearchResultByName[0];
	
	public void setAlumniFinder(AlumniFinder alumniFinder) {
		this.alumniFinder = alumniFinder;
	}
	public AlumniFinder getAlumniFinder() {
		return alumniFinder;
	}
	public void setSearchResult(SearchResultByName[] searchResult) {
		this.searchResult = searchResult;
	}
	public SearchResultByName[] getSearchResult() {
		return searchResult;
	}
}
