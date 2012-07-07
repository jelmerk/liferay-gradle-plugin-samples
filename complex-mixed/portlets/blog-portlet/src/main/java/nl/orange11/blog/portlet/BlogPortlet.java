package nl.orange11.blog.portlet;

import org.searchworkings.news.service.NewsLocalServiceUtil;
import org.searchworkings.news.service.NewsService;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;

/**
 */
public class BlogPortlet extends GenericPortlet {

    public NewsService getNewsService() {
        return null;
    }

    @Override
    protected void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        NewsLocalServiceUtil.getService();
    }
}
