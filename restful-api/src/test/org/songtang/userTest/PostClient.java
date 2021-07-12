package org.songtang.userTest;

import org.songtang.model.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * 模拟rest请求客户端
 *
 * @author: song
 * @Date: Created in 2018/8/14  14:54
 * @Modified By:
 */

public class PostClient extends BaseClient {
    private Logger logger = LoggerFactory.getLogger(PostClient.class);


    /**
     * 演示方法：public <T> T postForObject(String url, @Nullable Object request, Class<T> responseType,
     * 			Object... uriVariables) throws RestClientException
     * 参数意义：
     * url：url地址
     * request：请求实体对象
     * responseType：响应类型
     * uriVariables：url地址参数，如果url地址上没有参数的，这个参数可以不填，的使用和 public <T> T getForObject(String url,
     * Class<T> responseType,Object... uriVariables)相同。
     *
     * 类似方法1：public <T> T postForObject(String url, @Nullable Object request, Class<T> responseType,
     *           Map<String, ?> uriVariables) throws RestClientException
     * 方法和“演示方法”基本相同，使用也相同，不同的是此方法最后一个url参数的传值使用的是Map,因此如果没有url参数的时候直接传
     * 空Map(new HashMap())。
     *
     * 类似方法2：public <T> T postForObject(URI url, @Nullable Object request, Class<T> responseType) throws RestClientException
     * 方法和“演示方法”基本相同，使用也相同，不同的事此方法的url参数是一个URI对象，并且没有最后一个参数，因此如果url有参数的时候，
     * 需要我们直接拼接在url后面。例如：URI uri = new URI("http://localhost:8080/api/demo?name=zhangsan")
     *
     */
    @Test
    public void testPostForObject_one(){
        String url = HOST +"/api-demo/json/user?dept={dept}";
        Object[] arr = new Object[]{"finance"};
        int result = restTemplate.postForObject(url,new User("song",12,"song123"),int.class,arr);
        logger.debug("result:"+result);
    }

    /**
     * 演示方法：public <T> ResponseEntity<T> postForEntity(String url, @Nullable Object request,Class<T> responseType,
     *          Object... uriVariables) throws RestClientException。
     * 参数意义：
     * url：url地址
     * request：请求实体对象
     * responseType：响应类型
     * uriVariables：url地址参数，如果url地址上没有参数的，这个参数可以不填，的使用和 public <T> T postForObject(String url, @Nullable Object request, Class<T> responseType,
     * Object... uriVariables) throws RestClientException相同。
     * 同样，当url中没有参数的时候，最后一个参数uriVariables可以不填。
     *
     * 类似方法1：public <T> ResponseEntity<T> postForEntity(String url, @Nullable Object request,Class<T> responseType,
     *           Map<String, ?> uriVariables) throws RestClientException
     * 方法和“演示方法”基本相同，使用也相同，不同的是此方法最后一个url参数的传值使用的是Map,因此如果没有url参数的时候直接传
     * 空Map(new HashMap())。
     *
     * 类似方法2：public <T> ResponseEntity<T> postForEntity(URI url, @Nullable Object request, Class<T> responseType)throws
     *           RestClientException，
     * 仅仅需要将第一个参数换作URI即可。例如第一个参数为：URI uri = new URI("http://localhost:8080/api/demo");
     */
    @Test
    public void testPostForEntity(){
        String url = HOST +"/api-demo/json/user?dept={dept}";
        Object[] arr = new Object[]{"finance"};
        ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url,new User("song",12,
                        "song123"),
                Integer.class,arr);
        logger.debug("responseEntity:"+responseEntity);
    }

    /**
     * 演示数据传递以form表单的格式进行
     */
    @Test
    public void testPostForm(){
        String url = HOST +"/api-demo/form/user";

        //设置请求数据的格式
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        //封装参数
        MultiValueMap<String, String> params= new LinkedMultiValueMap<>();
        params.add("name", "song");
        params.add("age", "12");
        params.add("password", "song123");

        //封装请求内容
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params,headers);
        ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url,requestEntity,Integer.class);
        logger.debug("responseEntity:"+responseEntity);
    }
}
