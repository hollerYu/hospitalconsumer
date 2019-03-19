package com.jk.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jk.bean.*;
import com.jk.service.SpecialisService;
import com.jk.utils.ExportExcel;
import com.jk.utils.HttpClientUtil;
import com.jk.utils.RestClientFactory;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
public class SpecialisController {
    @Resource
    private MongoTemplate mongoTemplate;
    @Resource
    private SpecialisService specialisService;
   //跳转到主页的方法
   @RequestMapping("toIndex")
   public String toIndex(){

       return "index";
   }
   //查询专家
   @ResponseBody
   @RequestMapping("specialist")
   public List<Specialist> specialist(Integer assort){
       Query query = new Query();
       query.addCriteria(Criteria.where("fenlei").is(assort).and("portion").is("1"));
       List<Specialist> specialists = mongoTemplate.find(query, Specialist.class);
       return specialists;
   }
    //查询专家2
    @ResponseBody
    @RequestMapping("specialist2")
    public List<Specialist> specialist2(Integer assort){
        Query query = new Query();
        query.addCriteria(Criteria.where("fenlei").is(assort).and("portion").is("1"));
        List<Specialist> specialists = mongoTemplate.find(query, Specialist.class);

        return specialists;
    }
/*    @ResponseBody
    @RequestMapping("add")
    public String add(){
        Specialist specialist = new Specialist();
        specialist.setName("张一山");
        specialist.setAddress("东北大学医学院");
        specialist.setDataimg("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1681705484,1994333013&fm=26&gp=0.jpg");
        specialist.setFenlei(1);
        specialist.setPortion("2");
        mongoTemplate.insert(specialist);
        return "success";
    }*/
    //查询标题
    @ResponseBody
    @RequestMapping("headline")
    public List<Headline> headline(){
       List<Headline> list =   specialisService.headline();
      return list;
    }
    //模板事例
    @RequestMapping("jk")
    public String jk(Integer id, ModelMap model){
       //System.out.println(id);
       model.addAttribute("id",id);
        return "jk";
    }
    //更多专家
    @RequestMapping("more")
    public String more(Integer fenlei,ModelMap model){
        Query query = new Query();
        query.addCriteria(Criteria.where("fenlei").is(fenlei));
        List<Specialist> specialists = mongoTemplate.find(query, Specialist.class);
        model.addAttribute("specialists1",specialists);
        return "MoreExperts";
    }
    //查询标题
    @ResponseBody
    @RequestMapping("title")
    public List<Condition>  title(){
        List<Condition> list  = specialisService.title();
      return list;
    }
    //增加积分
    @ResponseBody
    @RequestMapping("integraltwo")
    public String integraltwo(Source source){
         specialisService.integraltwo(source);
        return "";
    }
    //文章导出
    @ResponseBody
    @RequestMapping("derive")
    public String derive(Integer id) throws Exception{
        String sheetName="儿童健康文章";
        String titleName="我的文章";
        String[] headers = { "id", "文章名称", "文章图片", "文章内容","文章标题" };
        List<Condition> dataSet = specialisService.selectBookList(id);
       // System.out.println(dataSet);
        String resultUrl="D:\\book.xls";
        String pattern="yyyy-MM-dd";
        new Thread(new Runnable() {
            @Override
            public void run() {
                ExportExcel.exportExcel(sheetName, titleName, headers, dataSet, resultUrl, pattern);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ExportExcel.exportExcel(sheetName, titleName, headers, dataSet, resultUrl, pattern);
            }
        }).start();

      return "success";
    }
    //手机号登录
    @RequestMapping("phoneregister")
    public String register(){

      return "phonelogin";
    }
    //获取验证码
    @ResponseBody
    @RequestMapping("httpclient")
    public User  httpclient(String phone, HttpSession session){
        User user = specialisService.httpclientphone(phone);
        session.setAttribute("user",user);
        Map<String,Object> map = new HashMap();
        int rr =  (int)(Math.random()*899999)+100000;
        session.setAttribute("rr",rr);
        map.put("mobile",phone);
        map.put("tpl_id",124343);
        map.put("tpl_value","%23code%23%3d"+rr);
        map.put("key","9fdda7444b70fb376d76056112d3b773");
        String post = HttpClientUtil.post("http://v.juhe.cn/sms/send", map);
        System.out.println(post);
        return user;
    }
    //对比验证码
    @ResponseBody
    @RequestMapping("logintwo")
    public String logintwo(Integer code,HttpSession session,ModelMap model){
        Integer rr = (Integer)session.getAttribute("rr");
        if(code.equals(rr)){
          return "1";
        }else{
            model.addAttribute("verification","验证码错误，请重新发送");
          return "2";
        }
    }
    //查询用户
    @ResponseBody
    @RequestMapping("selectuser")
    public User  selectuser(HttpSession session){
        User user = (User)session.getAttribute("user");
        return user;
    }
    //es搜索文章
    @RequestMapping("article")
    public String article(String article,ModelMap model) throws IOException {
        //高亮显示设置
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        //设置全部字段高亮
        highlightBuilder.field("*").requireFieldMatch(false);
//      highlightBuilder.field("book_name");
        highlightBuilder.preTags("<span style='color:red'>");
        highlightBuilder.postTags("</span>");
        ///end
        List<JSONObject> list = new ArrayList();
        SearchRequest SearchRequest  = new SearchRequest("test01"); //{}
        SearchSourceBuilder searchsourcebuilder = new SearchSourceBuilder();  //query
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();  //boll
        MatchQueryBuilder sku_mch = QueryBuilders.matchQuery("title", article);
        BoolQueryBuilder must = boolQueryBuilder.must(sku_mch);
        searchsourcebuilder.query(must);
        SearchRequest.source(searchsourcebuilder);
        SearchResponse search = RestClientFactory.getHighLevelClient().search(SearchRequest);
        JSONObject parseObject = JSONObject.parseObject(String.valueOf(search));
        JSONObject hits = parseObject.getJSONObject("hits");
        JSONArray hits1 = hits.getJSONArray("hits");
        for (Object o : hits1) {
            JSONObject parseObject2 = JSONObject.parseObject(String.valueOf(o));
            JSONObject source = parseObject2.getJSONObject("_source");
            list.add(source);
        }
        List list2 = new ArrayList();
        for (JSONObject jsonObject : list) {
            list2.add(jsonObject.getString("id"));
        }
        List<Integer> list3  =specialisService.article(list2);
        model.addAttribute("list3",list3);
        return "esgrabble";
    }
    //查询普通公告
    @ResponseBody
    @RequestMapping("affiche")
    public List<Affiche> affiche(Integer start){
        List<Affiche> list = specialisService.affiche(start);
        System.out.println(list);
        return list;
    }

}
