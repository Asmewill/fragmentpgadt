package com.tianxin.fragmentpgadt;

/**
 * 作者：created by meixi
 * 邮箱：15913707499@163.com
 * 日期：2019/5/31 17
 */

public class NewsType {

    private String newsTypeId;
    private String newsTypeNm;

    public String getNewsTypeId() {
        return newsTypeId;
    }

    public void setNewsTypeId(String newsTypeId) {
        this.newsTypeId = newsTypeId;
    }

    public String getNewsTypeNm() {
        return newsTypeNm;
    }

    public void setNewsTypeNm(String newsTypeNm) {
        this.newsTypeNm = newsTypeNm;
    }

    @Override
    public boolean equals(Object o){
        if (null == o)
            return false;
        if (!(o instanceof NewsType))
            return false;
        NewsType p = (NewsType)o;
        if (this.newsTypeId.equals(p.getNewsTypeId()))
            return true;
        return false;
    }

}
