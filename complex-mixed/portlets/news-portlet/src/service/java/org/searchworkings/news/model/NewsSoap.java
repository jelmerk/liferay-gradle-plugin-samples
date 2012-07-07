/**
 * Copyright (c) 2011 Dutchworks All rights reserved.
 */

package org.searchworkings.news.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.searchworkings.news.service.http.NewsServiceSoap}.
 *
 * @author    Dutchworks
 * @see       org.searchworkings.news.service.http.NewsServiceSoap
 * @generated
 */
public class NewsSoap implements Serializable {
    public static NewsSoap toSoapModel(News model) {
        NewsSoap soapModel = new NewsSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setNewsId(model.getNewsId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setStatus(model.getStatus());
        soapModel.setStatusByUserId(model.getStatusByUserId());
        soapModel.setStatusByUserName(model.getStatusByUserName());
        soapModel.setStatusDate(model.getStatusDate());
        soapModel.setTitle(model.getTitle());
        soapModel.setContent(model.getContent());
        soapModel.setDescription(model.getDescription());
        soapModel.setDisplayDate(model.getDisplayDate());

        return soapModel;
    }

    public static NewsSoap[] toSoapModels(News[] models) {
        NewsSoap[] soapModels = new NewsSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static NewsSoap[][] toSoapModels(News[][] models) {
        NewsSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new NewsSoap[models.length][models[0].length];
        }
        else {
            soapModels = new NewsSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static NewsSoap[] toSoapModels(List<News> models) {
        List<NewsSoap> soapModels = new ArrayList<NewsSoap>(models.size());

        for (News model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new NewsSoap[soapModels.size()]);
    }

    public NewsSoap() {
    }

    public long getPrimaryKey() {
        return _newsId;
    }

    public void setPrimaryKey(long pk) {
        setNewsId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getNewsId() {
        return _newsId;
    }

    public void setNewsId(long newsId) {
        _newsId = newsId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public int getStatus() {
        return _status;
    }

    public void setStatus(int status) {
        _status = status;
    }

    public long getStatusByUserId() {
        return _statusByUserId;
    }

    public void setStatusByUserId(long statusByUserId) {
        _statusByUserId = statusByUserId;
    }

    public String getStatusByUserName() {
        return _statusByUserName;
    }

    public void setStatusByUserName(String statusByUserName) {
        _statusByUserName = statusByUserName;
    }

    public Date getStatusDate() {
        return _statusDate;
    }

    public void setStatusDate(Date statusDate) {
        _statusDate = statusDate;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getContent() {
        return _content;
    }

    public void setContent(String content) {
        _content = content;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public Date getDisplayDate() {
        return _displayDate;
    }

    public void setDisplayDate(Date displayDate) {
        _displayDate = displayDate;
    }

    private String _uuid;
    private long _newsId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private int _status;
    private long _statusByUserId;
    private String _statusByUserName;
    private Date _statusDate;
    private String _title;
    private String _content;
    private String _description;
    private Date _displayDate;
}