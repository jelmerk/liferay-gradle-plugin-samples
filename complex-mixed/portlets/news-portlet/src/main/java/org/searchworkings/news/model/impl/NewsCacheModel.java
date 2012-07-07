/**
 * Copyright (c) 2011 Dutchworks All rights reserved.
 */

package org.searchworkings.news.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.searchworkings.news.model.News;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing News in entity cache.
 *
 * @author Dutchworks
 * @see News
 * @generated
 */
public class NewsCacheModel implements CacheModel<News>, Serializable {
    @Override
    public String toString() {
        StringBundler sb = new StringBundler(33);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", newsId=");
        sb.append(newsId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", status=");
        sb.append(status);
        sb.append(", statusByUserId=");
        sb.append(statusByUserId);
        sb.append(", statusByUserName=");
        sb.append(statusByUserName);
        sb.append(", statusDate=");
        sb.append(statusDate);
        sb.append(", title=");
        sb.append(title);
        sb.append(", content=");
        sb.append(content);
        sb.append(", description=");
        sb.append(description);
        sb.append(", displayDate=");
        sb.append(displayDate);
        sb.append("}");

        return sb.toString();
    }

    public News toEntityModel() {
        NewsImpl newsImpl = new NewsImpl();

        if (uuid == null) {
            newsImpl.setUuid(StringPool.BLANK);
        }
        else {
            newsImpl.setUuid(uuid);
        }

        newsImpl.setNewsId(newsId);
        newsImpl.setGroupId(groupId);
        newsImpl.setCompanyId(companyId);
        newsImpl.setUserId(userId);

        if (userName == null) {
            newsImpl.setUserName(StringPool.BLANK);
        }
        else {
            newsImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            newsImpl.setCreateDate(null);
        }
        else {
            newsImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            newsImpl.setModifiedDate(null);
        }
        else {
            newsImpl.setModifiedDate(new Date(modifiedDate));
        }

        newsImpl.setStatus(status);
        newsImpl.setStatusByUserId(statusByUserId);

        if (statusByUserName == null) {
            newsImpl.setStatusByUserName(StringPool.BLANK);
        }
        else {
            newsImpl.setStatusByUserName(statusByUserName);
        }

        if (statusDate == Long.MIN_VALUE) {
            newsImpl.setStatusDate(null);
        }
        else {
            newsImpl.setStatusDate(new Date(statusDate));
        }

        if (title == null) {
            newsImpl.setTitle(StringPool.BLANK);
        }
        else {
            newsImpl.setTitle(title);
        }

        if (content == null) {
            newsImpl.setContent(StringPool.BLANK);
        }
        else {
            newsImpl.setContent(content);
        }

        if (description == null) {
            newsImpl.setDescription(StringPool.BLANK);
        }
        else {
            newsImpl.setDescription(description);
        }

        if (displayDate == Long.MIN_VALUE) {
            newsImpl.setDisplayDate(null);
        }
        else {
            newsImpl.setDisplayDate(new Date(displayDate));
        }

        newsImpl.resetOriginalValues();

        return newsImpl;
    }

    public String uuid;
    public long newsId;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public int status;
    public long statusByUserId;
    public String statusByUserName;
    public long statusDate;
    public String title;
    public String content;
    public String description;
    public long displayDate;
}