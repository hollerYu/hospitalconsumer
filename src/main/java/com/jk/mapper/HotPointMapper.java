package com.jk.mapper;

/**
 * @Auther: yjm
 * @Date: 2019/3/5 16:20
 * @Description:
 */
public interface HotPointMapper {

   /* @Select("select count(*) from y_hotspot")
    int queryListTotalCount();*/

   // List<HotPoint> queryHotPoint(HashMap<String, Object> hashMap);
    List queryHotPoint();

    void increatCount(Integer id);

    HotPoint toHotPointMore(Integer id);
}
