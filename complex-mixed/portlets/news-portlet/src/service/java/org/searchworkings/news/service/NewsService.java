/**
 * Copyright (c) 2011 Dutchworks All rights reserved.
 */

package org.searchworkings.news.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;

/**
 * The interface for the news remote service.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Dutchworks
 * @see NewsServiceUtil
 * @see org.searchworkings.news.service.base.NewsServiceBaseImpl
 * @see org.searchworkings.news.service.impl.NewsServiceImpl
 * @generated
 */
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class})
public interface NewsService {
}