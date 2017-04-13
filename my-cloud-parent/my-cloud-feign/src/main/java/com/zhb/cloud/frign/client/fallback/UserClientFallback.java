package com.zhb.cloud.frign.client.fallback;

import org.springframework.stereotype.Component;

import com.zhb.cloud.core.utils.JsonReturn;
import com.zhb.cloud.core.utils.RetCode;
import com.zhb.cloud.frign.client.UserClient;

/**
 * @Title: UserServiceHystrix.java
 * @Package com.zhb.cloud.frign.service.callback
 * @Description:方法回调处理
 * @author zhb
 * @date 2016年11月4日 上午10:09:18
 * @version V1.0
 */
@Component
public class UserClientFallback implements UserClient {
	@Override
	public JsonReturn selectModelByCondition(int pageNum, int pageSize) {
		JsonReturn jsonReturn = new JsonReturn();
		jsonReturn.setRetcode(RetCode.ERROR_CODE);
		jsonReturn.setRetdata("对不起,feign");
		jsonReturn.setRetmsg("对不起,feign");
		return jsonReturn;
	}

	@Override
	public JsonReturn update(String userId) {
		JsonReturn jsonReturn = new JsonReturn();
		jsonReturn.setRetcode(RetCode.ERROR_CODE);
		jsonReturn.setRetdata("对不起,feign");
		jsonReturn.setRetmsg("对不起,feign");
		return jsonReturn;
	}

}
