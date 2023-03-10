package com.zjc.search;

import com.alibaba.fastjson.JSON;
import com.zjc.search.config.GulimallElasticSearchConfig;
import lombok.Data;
import lombok.ToString;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.Avg;
import org.elasticsearch.search.aggregations.metrics.AvgAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import javax.naming.directory.SearchResult;
import java.io.IOException;

@SpringBootTest
class GulimallSearchApplicationTests {

    @Autowired
    private RestHighLevelClient client;

    @Data
    @ToString
    static class Account {
        private int account_number;
        private int balance;
        private String firstname;
        private String lastname;
        private int age;
        private String gender;
        private String address;
        private String employer;
        private String email;
        private String city;
        private String state;
    }

    @Test
    void indexData() throws IOException {
        IndexRequest request = new IndexRequest("users");
        request.id("1");
//        request.source("userName", "zjc", "age", 18, "gender", "男");
        User user = new User();
        user.setUserName("zjc");
        user.setAge(18);
        user.setGender("男");
        String json = JSON.toJSONString(user);
        request.source(json, XContentType.JSON);

        IndexResponse index = client.index(request, GulimallElasticSearchConfig.COMMON_OPTIONS);
        System.out.println(index);
    }

    @Test
    void searchData() throws IOException {
        // 1. 创建索引请求
        SearchRequest searchRequest = new SearchRequest();
        // 指定索引
        searchRequest.indices("bank");
        // 指定DSL、检索条件
        SearchSourceBuilder builder = new SearchSourceBuilder();
        // 1.1 构造检索条件
        builder.query(QueryBuilders.matchQuery("address", "mill"));
//        builder.from(0);
//        builder.size(10);

        // 按照年龄的值分布进行聚合
        TermsAggregationBuilder ageAgg = AggregationBuilders.terms("ageAgg").field("age").size(10);
        // 计算平均薪资
        AvgAggregationBuilder balanceAvg = AggregationBuilders.avg("balanceAvg").field("balance");
        builder.aggregation(ageAgg);
        builder.aggregation(balanceAvg);


        searchRequest.source(builder);
        // 2. 执行检索
        SearchResponse searchResponse = client.search(searchRequest, GulimallElasticSearchConfig.COMMON_OPTIONS);

        // 3. 封装结果
//        System.out.println(searchResponse.toString());
        SearchHits hits = searchResponse.getHits();
        for (SearchHit hit : hits) {
            String string = hit.getSourceAsString();
            Account account = JSON.parseObject(string, Account.class);
            System.out.println(account);
        }

        Aggregations aggregations = searchResponse.getAggregations();
        Terms ageAgg1 = aggregations.get("ageAgg");
        for (Terms.Bucket bucket : ageAgg1.getBuckets()) {
            String keyAsString = bucket.getKeyAsString();
            System.out.println("年龄： " + keyAsString);
        }

        Avg balanceAvg1 = aggregations.get("balanceAvg");
        System.out.println("平均薪资： " + balanceAvg1.getValue());
    }

    @Data
    class User {
        private String userName;
        private int age;
        private String gender;
    }


}
