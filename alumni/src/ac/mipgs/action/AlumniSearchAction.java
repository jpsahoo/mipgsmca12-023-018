package ac.mipgs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import ac.mipgs.factory.ServiceFactory;
import ac.mipgs.service.AlumniSearchService;
import ac.mipgs.vo.SearchResultByName;

public class AlumniSearchAction extends DispatchAction {
	
	public ActionForward searchAlumni(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		AlumniSearchForm searchForm = (AlumniSearchForm) form;
		
		AlumniSearchService service = ServiceFactory.getAlumniSearchService();
		SearchResultByName[] searchResults = service.getSearchResults(searchForm.getAlumniFinder());
		
		searchForm.setSearchResult(searchResults);
		
		return mapping.findForward("success");
	}

}
