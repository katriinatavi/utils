package org.songtang.RestApiController;

import com.wordnik.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户API
 *
 * @author: song
 * @Date: Created in 2018/8/14  14:54
 * @Modified By:
 */
@RestController
@Api(value = "API of user")
@RequestMapping("/api-demo/")
public class DeleteDemoController {

    private Logger logger = LoggerFactory.getLogger(DeleteDemoController.class);


    /**
     * 删除用户信息
     * @return
     */
    @DeleteMapping("user")
    public int getUser(
            @RequestParam(value = "name",defaultValue = "song")String name,
            @RequestParam("age") int age) {
        logger.debug("name:"+name+",age:"+age);
        return 1;
    }

}
