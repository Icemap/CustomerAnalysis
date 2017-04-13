package com.wqz.pojo;

/**
 * Created by WangQiZhi on 2017/4/14.
 */

public class BoughtPojo
{

    /**
     * id : 1
     * vipId : 1
     * datetime : Apr 13, 2017 10:53:25 PM
     * isBought : 1
     * boughtMoney : 9998
     * boughtList : 戒指，珍珠
     */

    private int id;
    private int vipId;
    private String datetime;
    private int isBought;
    private String boughtMoney;
    private String boughtList;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getVipId()
    {
        return vipId;
    }

    public void setVipId(int vipId)
    {
        this.vipId = vipId;
    }

    public String getDatetime()
    {
        return datetime;
    }

    public void setDatetime(String datetime)
    {
        this.datetime = datetime;
    }

    public int getIsBought()
    {
        return isBought;
    }

    public void setIsBought(int isBought)
    {
        this.isBought = isBought;
    }

    public String getBoughtMoney()
    {
        return boughtMoney;
    }

    public void setBoughtMoney(String boughtMoney)
    {
        this.boughtMoney = boughtMoney;
    }

    public String getBoughtList()
    {
        return boughtList;
    }

    public void setBoughtList(String boughtList)
    {
        this.boughtList = boughtList;
    }
}
