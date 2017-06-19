package com.wqz.pojo;

/**
 * Created by WangQiZhi on 2017/5/3.
 */

public class AllFacePojo
{
    /**
     * id : 2106
     * pic : http://121.201.110.207/all/1493743289124.jpg
     * mode : face
     * camera_id : 5
     * datetime : 1970-01-18 14:55:43
     */

    private String id;
    private String pic;
    private String mode;
    private String camera_id;
    private String datetime;
    public String last_list;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getPic()
    {
        return pic;
    }

    public void setPic(String pic)
    {
        this.pic = pic;
    }

    public String getMode()
    {
        return mode;
    }

    public void setMode(String mode)
    {
        this.mode = mode;
    }

    public String getCamera_id()
    {
        return camera_id;
    }

    public void setCamera_id(String camera_id)
    {
        this.camera_id = camera_id;
    }

    public String getDatetime()
    {
        return datetime;
    }

    public void setDatetime(String datetime)
    {
        this.datetime = datetime;
    }

}
