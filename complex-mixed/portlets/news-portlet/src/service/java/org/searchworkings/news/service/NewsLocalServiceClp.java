/**
 * Copyright (c) 2011 Dutchworks All rights reserved.
 */

package org.searchworkings.news.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author Dutchworks
 */
public class NewsLocalServiceClp implements NewsLocalService {
    public NewsLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
        _classLoaderProxy = classLoaderProxy;

        _addNewsMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
                "addNews", org.searchworkings.news.model.News.class);

        _createNewsMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
                "createNews", long.class);

        _deleteNewsMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
                "deleteNews", long.class);

        _deleteNewsMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
                "deleteNews", org.searchworkings.news.model.News.class);

        _dynamicQueryMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
                "dynamicQuery",
                com.liferay.portal.kernel.dao.orm.DynamicQuery.class);

        _dynamicQueryMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
                "dynamicQuery",
                com.liferay.portal.kernel.dao.orm.DynamicQuery.class,
                int.class, int.class);

        _dynamicQueryMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
                "dynamicQuery",
                com.liferay.portal.kernel.dao.orm.DynamicQuery.class,
                int.class, int.class,
                com.liferay.portal.kernel.util.OrderByComparator.class);

        _dynamicQueryCountMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
                "dynamicQueryCount",
                com.liferay.portal.kernel.dao.orm.DynamicQuery.class);

        _fetchNewsMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
                "fetchNews", long.class);

        _getNewsMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
                "getNews", long.class);

        _getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
                "getPersistedModel", java.io.Serializable.class);

        _getNewsByUuidAndGroupIdMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
                "getNewsByUuidAndGroupId", java.lang.String.class, long.class);

        _getNewsesMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
                "getNewses", int.class, int.class);

        _getNewsesCountMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
                "getNewsesCount");

        _updateNewsMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
                "updateNews", org.searchworkings.news.model.News.class);

        _updateNewsMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
                "updateNews", org.searchworkings.news.model.News.class,
                boolean.class);

        _getBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
                "getBeanIdentifier");

        _setBeanIdentifierMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
                "setBeanIdentifier", java.lang.String.class);
    }

    public org.searchworkings.news.model.News addNews(
        org.searchworkings.news.model.News news)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_addNewsMethodKey0,
                ClpSerializer.translateInput(news));

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        }
        catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException)t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (org.searchworkings.news.model.News)ClpSerializer.translateOutput(returnObj);
    }

    public org.searchworkings.news.model.News createNews(long newsId) {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_createNewsMethodKey1,
                newsId);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        }
        catch (Throwable t) {
            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (org.searchworkings.news.model.News)ClpSerializer.translateOutput(returnObj);
    }

    public void deleteNews(long newsId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        MethodHandler methodHandler = new MethodHandler(_deleteNewsMethodKey2,
                newsId);

        try {
            _classLoaderProxy.invoke(methodHandler);
        }
        catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException)t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException)t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    public void deleteNews(org.searchworkings.news.model.News news)
        throws com.liferay.portal.kernel.exception.SystemException {
        MethodHandler methodHandler = new MethodHandler(_deleteNewsMethodKey3,
                ClpSerializer.translateInput(news));

        try {
            _classLoaderProxy.invoke(methodHandler);
        }
        catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException)t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey4,
                ClpSerializer.translateInput(dynamicQuery));

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        }
        catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException)t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List)ClpSerializer.translateOutput(returnObj);
    }

    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey5,
                ClpSerializer.translateInput(dynamicQuery), start, end);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        }
        catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException)t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List)ClpSerializer.translateOutput(returnObj);
    }

    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey6,
                ClpSerializer.translateInput(dynamicQuery), start, end,
                ClpSerializer.translateInput(orderByComparator));

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        }
        catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException)t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List)ClpSerializer.translateOutput(returnObj);
    }

    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_dynamicQueryCountMethodKey7,
                ClpSerializer.translateInput(dynamicQuery));

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        }
        catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException)t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Long)returnObj).longValue();
    }

    public org.searchworkings.news.model.News fetchNews(long newsId)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_fetchNewsMethodKey8,
                newsId);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        }
        catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException)t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (org.searchworkings.news.model.News)ClpSerializer.translateOutput(returnObj);
    }

    public org.searchworkings.news.model.News getNews(long newsId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getNewsMethodKey9,
                newsId);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        }
        catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException)t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException)t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (org.searchworkings.news.model.News)ClpSerializer.translateOutput(returnObj);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getPersistedModelMethodKey10,
                ClpSerializer.translateInput(primaryKeyObj));

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        }
        catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException)t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException)t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.liferay.portal.model.PersistedModel)ClpSerializer.translateOutput(returnObj);
    }

    public org.searchworkings.news.model.News getNewsByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getNewsByUuidAndGroupIdMethodKey11,
                ClpSerializer.translateInput(uuid), groupId);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        }
        catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException)t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException)t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (org.searchworkings.news.model.News)ClpSerializer.translateOutput(returnObj);
    }

    public java.util.List<org.searchworkings.news.model.News> getNewses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getNewsesMethodKey12,
                start, end);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        }
        catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException)t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<org.searchworkings.news.model.News>)ClpSerializer.translateOutput(returnObj);
    }

    public int getNewsesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getNewsesCountMethodKey13);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        }
        catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException)t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Integer)returnObj).intValue();
    }

    public org.searchworkings.news.model.News updateNews(
        org.searchworkings.news.model.News news)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_updateNewsMethodKey14,
                ClpSerializer.translateInput(news));

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        }
        catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException)t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (org.searchworkings.news.model.News)ClpSerializer.translateOutput(returnObj);
    }

    public org.searchworkings.news.model.News updateNews(
        org.searchworkings.news.model.News news, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_updateNewsMethodKey15,
                ClpSerializer.translateInput(news), merge);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        }
        catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException)t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (org.searchworkings.news.model.News)ClpSerializer.translateOutput(returnObj);
    }

    public java.lang.String getBeanIdentifier() {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getBeanIdentifierMethodKey16);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        }
        catch (Throwable t) {
            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.lang.String)ClpSerializer.translateOutput(returnObj);
    }

    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        MethodHandler methodHandler = new MethodHandler(_setBeanIdentifierMethodKey17,
                ClpSerializer.translateInput(beanIdentifier));

        try {
            _classLoaderProxy.invoke(methodHandler);
        }
        catch (Throwable t) {
            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            }
            else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    public ClassLoaderProxy getClassLoaderProxy() {
        return _classLoaderProxy;
    }

    private ClassLoaderProxy _classLoaderProxy;
    private MethodKey _addNewsMethodKey0;
    private MethodKey _createNewsMethodKey1;
    private MethodKey _deleteNewsMethodKey2;
    private MethodKey _deleteNewsMethodKey3;
    private MethodKey _dynamicQueryMethodKey4;
    private MethodKey _dynamicQueryMethodKey5;
    private MethodKey _dynamicQueryMethodKey6;
    private MethodKey _dynamicQueryCountMethodKey7;
    private MethodKey _fetchNewsMethodKey8;
    private MethodKey _getNewsMethodKey9;
    private MethodKey _getPersistedModelMethodKey10;
    private MethodKey _getNewsByUuidAndGroupIdMethodKey11;
    private MethodKey _getNewsesMethodKey12;
    private MethodKey _getNewsesCountMethodKey13;
    private MethodKey _updateNewsMethodKey14;
    private MethodKey _updateNewsMethodKey15;
    private MethodKey _getBeanIdentifierMethodKey16;
    private MethodKey _setBeanIdentifierMethodKey17;
}