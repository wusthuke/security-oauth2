package org.huke.cxf.security.oauth2.client.web.domain;

import java.io.Serializable;

/**
 * @author huke
 * @create 2017/3/18
 */
public class Photo implements Serializable {

    private static final long serialVersionUID = -5131530103309547141L;

    private int id;

    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
