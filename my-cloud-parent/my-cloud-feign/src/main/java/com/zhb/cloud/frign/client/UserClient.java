package com.zhb.cloud.frign.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.zhb.cloud.core.utils.JsonReturn;
import com.zhb.cloud.frign.client.fallback.UserClientFallback;
/**
 * @Title: UserService.java
 * @Package com.zhb.cloud.frign.service
 * @Description: feign 对外的客户端,并且指定回调类
 * @author zhb
 * @date 2016年11月18日 下午5:27:03
 * @version V1.0
 */
@FeignClient(value = "my-cloud-server", fallback = UserClientFallback.class)
public interface UserClient {
	/**
	 * @Title: selectModelByCondition
	 * @Description: 分页查询
	 * @param pageNum
	 * @param pageSize
	 *            JsonReturn
	 * @author: zhb
	 * @throws 2016年12月20日下午4:30:25
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/user/userList")
	JsonReturn selectModelByCondition(@RequestParam(value = "pageNum") int pageNum,
			@RequestParam(value = "pageSize") int pageSize);

	@RequestMapping(method = RequestMethod.POST, value = "/user/update/{userId}", consumes = "application/json")
	JsonReturn update(@PathVariable(value = "userId") String userId);

}
