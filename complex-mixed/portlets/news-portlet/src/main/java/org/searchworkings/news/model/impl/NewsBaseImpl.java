/**
 * Copyright (c) 2011 Dutchworks All rights reserved.
 */

package org.searchworkings.news.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import org.searchworkings.news.model.News;
import org.searchworkings.news.service.NewsLocalServiceUtil;

/**
 * The extended model base implementation for the News service. Represents a row in the &quot;NW_News&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link NewsImpl}.
 * </p>
 *
 * @author Dutchworks
 * @see NewsImpl
 * @see org.searchworkings.news.model.News
 * @generated
 */
public abstract class NewsBaseImpl extends NewsModelImpl implements News {
    public void persist() throws SystemException {
        if (this.isNew()) {
            NewsLocalServiceUtil.addNews(this);
        }
        else {
            NewsLocalServiceUtil.updateNews(this);
        }
    }
}