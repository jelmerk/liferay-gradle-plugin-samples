/**
 * Copyright (c) 2011 Dutchworks All rights reserved.
 */

package org.searchworkings.news.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.CompanyPersistence;
import com.liferay.portal.service.persistence.GroupPersistence;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.WorkflowInstanceLinkPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;
import com.liferay.portlet.expando.service.persistence.ExpandoValuePersistence;
import com.liferay.portlet.social.service.persistence.SocialActivityPersistence;

import org.searchworkings.news.NoSuchNewsException;
import org.searchworkings.news.model.News;
import org.searchworkings.news.model.impl.NewsImpl;
import org.searchworkings.news.model.impl.NewsModelImpl;
import org.searchworkings.news.service.persistence.NewsPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the news service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Dutchworks
 * @see NewsPersistence
 * @see NewsUtil
 * @generated
 */
public class NewsPersistenceImpl extends BasePersistenceImpl<News>
    implements NewsPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = NewsImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(NewsModelImpl.ENTITY_CACHE_ENABLED,
            NewsModelImpl.FINDER_CACHE_ENABLED, NewsImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(NewsModelImpl.ENTITY_CACHE_ENABLED,
            NewsModelImpl.FINDER_CACHE_ENABLED, NewsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            NewsModelImpl.UUID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(NewsModelImpl.ENTITY_CACHE_ENABLED,
            NewsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(NewsModelImpl.ENTITY_CACHE_ENABLED,
            NewsModelImpl.FINDER_CACHE_ENABLED, NewsImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() },
            NewsModelImpl.UUID_COLUMN_BITMASK |
            NewsModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(NewsModelImpl.ENTITY_CACHE_ENABLED,
            NewsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(NewsModelImpl.ENTITY_CACHE_ENABLED,
            NewsModelImpl.FINDER_CACHE_ENABLED, NewsImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(NewsModelImpl.ENTITY_CACHE_ENABLED,
            NewsModelImpl.FINDER_CACHE_ENABLED, NewsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
            new String[] { Long.class.getName() },
            NewsModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(NewsModelImpl.ENTITY_CACHE_ENABLED,
            NewsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(NewsModelImpl.ENTITY_CACHE_ENABLED,
            NewsModelImpl.FINDER_CACHE_ENABLED, NewsImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
        new FinderPath(NewsModelImpl.ENTITY_CACHE_ENABLED,
            NewsModelImpl.FINDER_CACHE_ENABLED, NewsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
            new String[] { Long.class.getName() },
            NewsModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(NewsModelImpl.ENTITY_CACHE_ENABLED,
            NewsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NewsModelImpl.ENTITY_CACHE_ENABLED,
            NewsModelImpl.FINDER_CACHE_ENABLED, NewsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NewsModelImpl.ENTITY_CACHE_ENABLED,
            NewsModelImpl.FINDER_CACHE_ENABLED, NewsImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NewsModelImpl.ENTITY_CACHE_ENABLED,
            NewsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

    /**
     * Caches the news in the entity cache if it is enabled.
     *
     * @param news the news
     */
    public void cacheResult(News news) {
        EntityCacheUtil.putResult(NewsModelImpl.ENTITY_CACHE_ENABLED,
            NewsImpl.class, news.getPrimaryKey(), news);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { news.getUuid(), Long.valueOf(news.getGroupId()) },
            news);

        news.resetOriginalValues();
    }

    /**
     * Caches the newses in the entity cache if it is enabled.
     *
     * @param newses the newses
     */
    public void cacheResult(List<News> newses) {
        for (News news : newses) {
            if (EntityCacheUtil.getResult(NewsModelImpl.ENTITY_CACHE_ENABLED,
                        NewsImpl.class, news.getPrimaryKey()) == null) {
                cacheResult(news);
            }
            else {
                news.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all newses.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(NewsImpl.class.getName());
        }

        EntityCacheUtil.clearCache(NewsImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the news.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(News news) {
        EntityCacheUtil.removeResult(NewsModelImpl.ENTITY_CACHE_ENABLED,
            NewsImpl.class, news.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(news);
    }

    @Override
    public void clearCache(List<News> newses) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (News news : newses) {
            EntityCacheUtil.removeResult(NewsModelImpl.ENTITY_CACHE_ENABLED,
                NewsImpl.class, news.getPrimaryKey());

            clearUniqueFindersCache(news);
        }
    }

    protected void clearUniqueFindersCache(News news) {
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { news.getUuid(), Long.valueOf(news.getGroupId()) });
    }

    /**
     * Creates a new news with the primary key. Does not add the news to the database.
     *
     * @param newsId the primary key for the new news
     * @return the new news
     */
    public News create(long newsId) {
        News news = new NewsImpl();

        news.setNew(true);
        news.setPrimaryKey(newsId);

        String uuid = PortalUUIDUtil.generate();

        news.setUuid(uuid);

        return news;
    }

    /**
     * Removes the news with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param newsId the primary key of the news
     * @return the news that was removed
     * @throws org.searchworkings.news.NoSuchNewsException if a news with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public News remove(long newsId) throws NoSuchNewsException, SystemException {
        return remove(Long.valueOf(newsId));
    }

    /**
     * Removes the news with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the news
     * @return the news that was removed
     * @throws org.searchworkings.news.NoSuchNewsException if a news with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public News remove(Serializable primaryKey)
        throws NoSuchNewsException, SystemException {
        Session session = null;

        try {
            session = openSession();

            News news = (News)session.get(NewsImpl.class, primaryKey);

            if (news == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchNewsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(news);
        }
        catch (NoSuchNewsException nsee) {
            throw nsee;
        }
        catch (Exception e) {
            throw processException(e);
        }
        finally {
            closeSession(session);
        }
    }

    @Override
    protected News removeImpl(News news) throws SystemException {
        news = toUnwrappedModel(news);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, news);
        }
        catch (Exception e) {
            throw processException(e);
        }
        finally {
            closeSession(session);
        }

        clearCache(news);

        return news;
    }

    @Override
    public News updateImpl(org.searchworkings.news.model.News news,
        boolean merge) throws SystemException {
        news = toUnwrappedModel(news);

        boolean isNew = news.isNew();

        NewsModelImpl newsModelImpl = (NewsModelImpl)news;

        if (Validator.isNull(news.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            news.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, news, merge);

            news.setNew(false);
        }
        catch (Exception e) {
            throw processException(e);
        }
        finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !NewsModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        else {
            if ((newsModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { newsModelImpl.getOriginalUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { newsModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((newsModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(newsModelImpl.getOriginalCompanyId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);

                args = new Object[] { Long.valueOf(newsModelImpl.getCompanyId()) };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);
            }

            if ((newsModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(newsModelImpl.getOriginalGroupId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);

                args = new Object[] { Long.valueOf(newsModelImpl.getGroupId()) };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);
            }
        }

        EntityCacheUtil.putResult(NewsModelImpl.ENTITY_CACHE_ENABLED,
            NewsImpl.class, news.getPrimaryKey(), news);

        if (isNew) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                new Object[] { news.getUuid(), Long.valueOf(news.getGroupId()) },
                news);
        }
        else {
            if ((newsModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        newsModelImpl.getOriginalUuid(),
                        Long.valueOf(newsModelImpl.getOriginalGroupId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                    new Object[] { news.getUuid(), Long.valueOf(
                            news.getGroupId()) }, news);
            }
        }

        return news;
    }

    protected News toUnwrappedModel(News news) {
        if (news instanceof NewsImpl) {
            return news;
        }

        NewsImpl newsImpl = new NewsImpl();

        newsImpl.setNew(news.isNew());
        newsImpl.setPrimaryKey(news.getPrimaryKey());

        newsImpl.setUuid(news.getUuid());
        newsImpl.setNewsId(news.getNewsId());
        newsImpl.setGroupId(news.getGroupId());
        newsImpl.setCompanyId(news.getCompanyId());
        newsImpl.setUserId(news.getUserId());
        newsImpl.setUserName(news.getUserName());
        newsImpl.setCreateDate(news.getCreateDate());
        newsImpl.setModifiedDate(news.getModifiedDate());
        newsImpl.setStatus(news.getStatus());
        newsImpl.setStatusByUserId(news.getStatusByUserId());
        newsImpl.setStatusByUserName(news.getStatusByUserName());
        newsImpl.setStatusDate(news.getStatusDate());
        newsImpl.setTitle(news.getTitle());
        newsImpl.setContent(news.getContent());
        newsImpl.setDescription(news.getDescription());
        newsImpl.setDisplayDate(news.getDisplayDate());

        return newsImpl;
    }

    /**
     * Returns the news with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the news
     * @return the news
     * @throws com.liferay.portal.NoSuchModelException if a news with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public News findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long)primaryKey).longValue());
    }

    /**
     * Returns the news with the primary key or throws a {@link org.searchworkings.news.NoSuchNewsException} if it could not be found.
     *
     * @param newsId the primary key of the news
     * @return the news
     * @throws org.searchworkings.news.NoSuchNewsException if a news with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public News findByPrimaryKey(long newsId)
        throws NoSuchNewsException, SystemException {
        News news = fetchByPrimaryKey(newsId);

        if (news == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + newsId);
            }

            throw new NoSuchNewsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                newsId);
        }

        return news;
    }

    /**
     * Returns the news with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the news
     * @return the news, or <code>null</code> if a news with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public News fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long)primaryKey).longValue());
    }

    /**
     * Returns the news with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param newsId the primary key of the news
     * @return the news, or <code>null</code> if a news with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public News fetchByPrimaryKey(long newsId) throws SystemException {
        News news = (News)EntityCacheUtil.getResult(NewsModelImpl.ENTITY_CACHE_ENABLED,
                NewsImpl.class, newsId);

        if (news == _nullNews) {
            return null;
        }

        if (news == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                news = (News)session.get(NewsImpl.class, Long.valueOf(newsId));
            }
            catch (Exception e) {
                hasException = true;

                throw processException(e);
            }
            finally {
                if (news != null) {
                    cacheResult(news);
                }
                else if (!hasException) {
                    EntityCacheUtil.putResult(NewsModelImpl.ENTITY_CACHE_ENABLED,
                        NewsImpl.class, newsId, _nullNews);
                }

                closeSession(session);
            }
        }

        return news;
    }

    /**
     * Returns all the newses where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching newses
     * @throws SystemException if a system exception occurred
     */
    public List<News> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the newses where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of newses
     * @param end the upper bound of the range of newses (not inclusive)
     * @return the range of matching newses
     * @throws SystemException if a system exception occurred
     */
    public List<News> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

    /**
     * Returns an ordered range of all the newses where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of newses
     * @param end the upper bound of the range of newses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching newses
     * @throws SystemException if a system exception occurred
     */
    public List<News> findByUuid(String uuid, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid };
        }
        else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid, start, end, orderByComparator };
        }

        List<News> list = (List<News>)FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            }
            else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_NEWS_WHERE);

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            }
            else {
                if (uuid.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_UUID_UUID_3);
                }
                else {
                    query.append(_FINDER_COLUMN_UUID_UUID_2);
                }
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }

            else {
                query.append(NewsModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (uuid != null) {
                    qPos.add(uuid);
                }

                list = (List<News>)QueryUtil.list(q, getDialect(), start, end);
            }
            catch (Exception e) {
                throw processException(e);
            }
            finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                }
                else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first news in the ordered set where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching news
     * @throws org.searchworkings.news.NoSuchNewsException if a matching news could not be found
     * @throws SystemException if a system exception occurred
     */
    public News findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchNewsException, SystemException {
        List<News> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("uuid=");
            msg.append(uuid);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchNewsException(msg.toString());
        }
        else {
            return list.get(0);
        }
    }

    /**
     * Returns the last news in the ordered set where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching news
     * @throws org.searchworkings.news.NoSuchNewsException if a matching news could not be found
     * @throws SystemException if a system exception occurred
     */
    public News findByUuid_Last(String uuid, OrderByComparator orderByComparator)
        throws NoSuchNewsException, SystemException {
        int count = countByUuid(uuid);

        List<News> list = findByUuid(uuid, count - 1, count, orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("uuid=");
            msg.append(uuid);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchNewsException(msg.toString());
        }
        else {
            return list.get(0);
        }
    }

    /**
     * Returns the newses before and after the current news in the ordered set where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param newsId the primary key of the current news
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next news
     * @throws org.searchworkings.news.NoSuchNewsException if a news with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public News[] findByUuid_PrevAndNext(long newsId, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchNewsException, SystemException {
        News news = findByPrimaryKey(newsId);

        Session session = null;

        try {
            session = openSession();

            News[] array = new NewsImpl[3];

            array[0] = getByUuid_PrevAndNext(session, news, uuid,
                    orderByComparator, true);

            array[1] = news;

            array[2] = getByUuid_PrevAndNext(session, news, uuid,
                    orderByComparator, false);

            return array;
        }
        catch (Exception e) {
            throw processException(e);
        }
        finally {
            closeSession(session);
        }
    }

    protected News getByUuid_PrevAndNext(Session session, News news,
        String uuid, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        }
        else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_NEWS_WHERE);

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_UUID_1);
        }
        else {
            if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            }
            else {
                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    }
                    else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                }
                else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    }
                    else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    }
                    else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                }
                else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    }
                    else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        }

        else {
            query.append(NewsModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (uuid != null) {
            qPos.add(uuid);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(news);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<News> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        }
        else {
            return null;
        }
    }

    /**
     * Returns the news where uuid = &#63; and groupId = &#63; or throws a {@link org.searchworkings.news.NoSuchNewsException} if it could not be found.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching news
     * @throws org.searchworkings.news.NoSuchNewsException if a matching news could not be found
     * @throws SystemException if a system exception occurred
     */
    public News findByUUID_G(String uuid, long groupId)
        throws NoSuchNewsException, SystemException {
        News news = fetchByUUID_G(uuid, groupId);

        if (news == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("uuid=");
            msg.append(uuid);

            msg.append(", groupId=");
            msg.append(groupId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchNewsException(msg.toString());
        }

        return news;
    }

    /**
     * Returns the news where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching news, or <code>null</code> if a matching news could not be found
     * @throws SystemException if a system exception occurred
     */
    public News fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        return fetchByUUID_G(uuid, groupId, true);
    }

    /**
     * Returns the news where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching news, or <code>null</code> if a matching news could not be found
     * @throws SystemException if a system exception occurred
     */
    public News fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_NEWS_WHERE);

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_1);
            }
            else {
                if (uuid.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_UUID_G_UUID_3);
                }
                else {
                    query.append(_FINDER_COLUMN_UUID_G_UUID_2);
                }
            }

            query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

            query.append(NewsModelImpl.ORDER_BY_JPQL);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (uuid != null) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

                List<News> list = q.list();

                result = list;

                News news = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                }
                else {
                    news = list.get(0);

                    cacheResult(news);

                    if ((news.getUuid() == null) ||
                            !news.getUuid().equals(uuid) ||
                            (news.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, news);
                    }
                }

                return news;
            }
            catch (Exception e) {
                throw processException(e);
            }
            finally {
                if (result == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs);
                }

                closeSession(session);
            }
        }
        else {
            if (result instanceof List<?>) {
                return null;
            }
            else {
                return (News)result;
            }
        }
    }

    /**
     * Returns all the newses where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the matching newses
     * @throws SystemException if a system exception occurred
     */
    public List<News> findByCompanyId(long companyId) throws SystemException {
        return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the newses where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of newses
     * @param end the upper bound of the range of newses (not inclusive)
     * @return the range of matching newses
     * @throws SystemException if a system exception occurred
     */
    public List<News> findByCompanyId(long companyId, int start, int end)
        throws SystemException {
        return findByCompanyId(companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the newses where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of newses
     * @param end the upper bound of the range of newses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching newses
     * @throws SystemException if a system exception occurred
     */
    public List<News> findByCompanyId(long companyId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
            finderArgs = new Object[] { companyId };
        }
        else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
            finderArgs = new Object[] { companyId, start, end, orderByComparator };
        }

        List<News> list = (List<News>)FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            }
            else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_NEWS_WHERE);

            query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }

            else {
                query.append(NewsModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                list = (List<News>)QueryUtil.list(q, getDialect(), start, end);
            }
            catch (Exception e) {
                throw processException(e);
            }
            finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                }
                else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first news in the ordered set where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching news
     * @throws org.searchworkings.news.NoSuchNewsException if a matching news could not be found
     * @throws SystemException if a system exception occurred
     */
    public News findByCompanyId_First(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchNewsException, SystemException {
        List<News> list = findByCompanyId(companyId, 0, 1, orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("companyId=");
            msg.append(companyId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchNewsException(msg.toString());
        }
        else {
            return list.get(0);
        }
    }

    /**
     * Returns the last news in the ordered set where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching news
     * @throws org.searchworkings.news.NoSuchNewsException if a matching news could not be found
     * @throws SystemException if a system exception occurred
     */
    public News findByCompanyId_Last(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchNewsException, SystemException {
        int count = countByCompanyId(companyId);

        List<News> list = findByCompanyId(companyId, count - 1, count,
                orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("companyId=");
            msg.append(companyId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchNewsException(msg.toString());
        }
        else {
            return list.get(0);
        }
    }

    /**
     * Returns the newses before and after the current news in the ordered set where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param newsId the primary key of the current news
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next news
     * @throws org.searchworkings.news.NoSuchNewsException if a news with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public News[] findByCompanyId_PrevAndNext(long newsId, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchNewsException, SystemException {
        News news = findByPrimaryKey(newsId);

        Session session = null;

        try {
            session = openSession();

            News[] array = new NewsImpl[3];

            array[0] = getByCompanyId_PrevAndNext(session, news, companyId,
                    orderByComparator, true);

            array[1] = news;

            array[2] = getByCompanyId_PrevAndNext(session, news, companyId,
                    orderByComparator, false);

            return array;
        }
        catch (Exception e) {
            throw processException(e);
        }
        finally {
            closeSession(session);
        }
    }

    protected News getByCompanyId_PrevAndNext(Session session, News news,
        long companyId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        }
        else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_NEWS_WHERE);

        query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    }
                    else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                }
                else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    }
                    else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    }
                    else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                }
                else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    }
                    else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        }

        else {
            query.append(NewsModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(news);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<News> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        }
        else {
            return null;
        }
    }

    /**
     * Returns all the newses where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching newses
     * @throws SystemException if a system exception occurred
     */
    public List<News> findByGroupId(long groupId) throws SystemException {
        return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the newses where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of newses
     * @param end the upper bound of the range of newses (not inclusive)
     * @return the range of matching newses
     * @throws SystemException if a system exception occurred
     */
    public List<News> findByGroupId(long groupId, int start, int end)
        throws SystemException {
        return findByGroupId(groupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the newses where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of newses
     * @param end the upper bound of the range of newses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching newses
     * @throws SystemException if a system exception occurred
     */
    public List<News> findByGroupId(long groupId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
            finderArgs = new Object[] { groupId };
        }
        else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
            finderArgs = new Object[] { groupId, start, end, orderByComparator };
        }

        List<News> list = (List<News>)FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            }
            else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_NEWS_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }

            else {
                query.append(NewsModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                list = (List<News>)QueryUtil.list(q, getDialect(), start, end);
            }
            catch (Exception e) {
                throw processException(e);
            }
            finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                }
                else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first news in the ordered set where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching news
     * @throws org.searchworkings.news.NoSuchNewsException if a matching news could not be found
     * @throws SystemException if a system exception occurred
     */
    public News findByGroupId_First(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchNewsException, SystemException {
        List<News> list = findByGroupId(groupId, 0, 1, orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("groupId=");
            msg.append(groupId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchNewsException(msg.toString());
        }
        else {
            return list.get(0);
        }
    }

    /**
     * Returns the last news in the ordered set where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching news
     * @throws org.searchworkings.news.NoSuchNewsException if a matching news could not be found
     * @throws SystemException if a system exception occurred
     */
    public News findByGroupId_Last(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchNewsException, SystemException {
        int count = countByGroupId(groupId);

        List<News> list = findByGroupId(groupId, count - 1, count,
                orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("groupId=");
            msg.append(groupId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchNewsException(msg.toString());
        }
        else {
            return list.get(0);
        }
    }

    /**
     * Returns the newses before and after the current news in the ordered set where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param newsId the primary key of the current news
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next news
     * @throws org.searchworkings.news.NoSuchNewsException if a news with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public News[] findByGroupId_PrevAndNext(long newsId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchNewsException, SystemException {
        News news = findByPrimaryKey(newsId);

        Session session = null;

        try {
            session = openSession();

            News[] array = new NewsImpl[3];

            array[0] = getByGroupId_PrevAndNext(session, news, groupId,
                    orderByComparator, true);

            array[1] = news;

            array[2] = getByGroupId_PrevAndNext(session, news, groupId,
                    orderByComparator, false);

            return array;
        }
        catch (Exception e) {
            throw processException(e);
        }
        finally {
            closeSession(session);
        }
    }

    protected News getByGroupId_PrevAndNext(Session session, News news,
        long groupId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        }
        else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_NEWS_WHERE);

        query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    }
                    else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                }
                else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    }
                    else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    }
                    else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                }
                else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    }
                    else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        }

        else {
            query.append(NewsModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(news);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<News> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        }
        else {
            return null;
        }
    }

    /**
     * Returns all the newses.
     *
     * @return the newses
     * @throws SystemException if a system exception occurred
     */
    public List<News> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the newses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of newses
     * @param end the upper bound of the range of newses (not inclusive)
     * @return the range of newses
     * @throws SystemException if a system exception occurred
     */
    public List<News> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the newses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of newses
     * @param end the upper bound of the range of newses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of newses
     * @throws SystemException if a system exception occurred
     */
    public List<News> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = new Object[] { start, end, orderByComparator };

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        }
        else {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<News> list = (List<News>)FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_NEWS);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            }
            else {
                sql = _SQL_SELECT_NEWS.concat(NewsModelImpl.ORDER_BY_JPQL);
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<News>)QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);
                }
                else {
                    list = (List<News>)QueryUtil.list(q, getDialect(), start,
                            end);
                }
            }
            catch (Exception e) {
                throw processException(e);
            }
            finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                }
                else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the newses where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    public void removeByUuid(String uuid) throws SystemException {
        for (News news : findByUuid(uuid)) {
            remove(news);
        }
    }

    /**
     * Removes the news where uuid = &#63; and groupId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByUUID_G(String uuid, long groupId)
        throws NoSuchNewsException, SystemException {
        News news = findByUUID_G(uuid, groupId);

        remove(news);
    }

    /**
     * Removes all the newses where companyId = &#63; from the database.
     *
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByCompanyId(long companyId) throws SystemException {
        for (News news : findByCompanyId(companyId)) {
            remove(news);
        }
    }

    /**
     * Removes all the newses where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByGroupId(long groupId) throws SystemException {
        for (News news : findByGroupId(groupId)) {
            remove(news);
        }
    }

    /**
     * Removes all the newses from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (News news : findAll()) {
            remove(news);
        }
    }

    /**
     * Returns the number of newses where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching newses
     * @throws SystemException if a system exception occurred
     */
    public int countByUuid(String uuid) throws SystemException {
        Object[] finderArgs = new Object[] { uuid };

        Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_NEWS_WHERE);

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            }
            else {
                if (uuid.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_UUID_UUID_3);
                }
                else {
                    query.append(_FINDER_COLUMN_UUID_UUID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (uuid != null) {
                    qPos.add(uuid);
                }

                count = (Long)q.uniqueResult();
            }
            catch (Exception e) {
                throw processException(e);
            }
            finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of newses where uuid = &#63; and groupId = &#63;.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the number of matching newses
     * @throws SystemException if a system exception occurred
     */
    public int countByUUID_G(String uuid, long groupId)
        throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID_G,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_NEWS_WHERE);

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_1);
            }
            else {
                if (uuid.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_UUID_G_UUID_3);
                }
                else {
                    query.append(_FINDER_COLUMN_UUID_G_UUID_2);
                }
            }

            query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (uuid != null) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

                count = (Long)q.uniqueResult();
            }
            catch (Exception e) {
                throw processException(e);
            }
            finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of newses where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the number of matching newses
     * @throws SystemException if a system exception occurred
     */
    public int countByCompanyId(long companyId) throws SystemException {
        Object[] finderArgs = new Object[] { companyId };

        Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_NEWS_WHERE);

            query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                count = (Long)q.uniqueResult();
            }
            catch (Exception e) {
                throw processException(e);
            }
            finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of newses where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching newses
     * @throws SystemException if a system exception occurred
     */
    public int countByGroupId(long groupId) throws SystemException {
        Object[] finderArgs = new Object[] { groupId };

        Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_NEWS_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                count = (Long)q.uniqueResult();
            }
            catch (Exception e) {
                throw processException(e);
            }
            finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of newses.
     *
     * @return the number of newses
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_NEWS);

                count = (Long)q.uniqueResult();
            }
            catch (Exception e) {
                throw processException(e);
            }
            finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the news persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.org.searchworkings.news.model.News")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<News>> listenersList = new ArrayList<ModelListener<News>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<News>)InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            }
            catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(NewsImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @BeanReference(type = NewsPersistence.class)
    protected NewsPersistence newsPersistence;
    @BeanReference(type = CompanyPersistence.class)
    protected CompanyPersistence companyPersistence;
    @BeanReference(type = GroupPersistence.class)
    protected GroupPersistence groupPersistence;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    @BeanReference(type = WorkflowInstanceLinkPersistence.class)
    protected WorkflowInstanceLinkPersistence workflowInstanceLinkPersistence;
    @BeanReference(type = AssetEntryPersistence.class)
    protected AssetEntryPersistence assetEntryPersistence;
    @BeanReference(type = ExpandoValuePersistence.class)
    protected ExpandoValuePersistence expandoValuePersistence;
    @BeanReference(type = SocialActivityPersistence.class)
    protected SocialActivityPersistence socialActivityPersistence;
    private static final String _SQL_SELECT_NEWS = "SELECT news FROM News news";
    private static final String _SQL_SELECT_NEWS_WHERE = "SELECT news FROM News news WHERE ";
    private static final String _SQL_COUNT_NEWS = "SELECT COUNT(news) FROM News news";
    private static final String _SQL_COUNT_NEWS_WHERE = "SELECT COUNT(news) FROM News news WHERE ";
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "news.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "news.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(news.uuid IS NULL OR news.uuid = ?)";
    private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "news.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "news.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(news.uuid IS NULL OR news.uuid = ?) AND ";
    private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "news.groupId = ?";
    private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "news.companyId = ?";
    private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "news.groupId = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "news.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No News exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No News exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(NewsPersistenceImpl.class);
    private static News _nullNews = new NewsImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<News> toCacheModel() {
                return _nullNewsCacheModel;
            }
        };

    private static CacheModel<News> _nullNewsCacheModel = new CacheModel<News>() {
            public News toEntityModel() {
                return _nullNews;
            }
        };
}