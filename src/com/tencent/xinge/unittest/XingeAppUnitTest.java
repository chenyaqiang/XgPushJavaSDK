package com.tencent.xinge.unittest;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Test;

import com.tencent.xinge.XingeApp;

public class XingeAppUnitTest extends XingeApp {
	
	public XingeAppUnitTest()
	{
		super(353, "353_secret_key");
	}

	@Test
	public void testCallRestful() {
		XingeAppUnitTest xgt = new XingeAppUnitTest();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key1", 2);
		JSONObject json = xgt.callRestful("http://10.1.152.139/v1/push/single_device", params);
		assertEquals("{\"err_msg\":\"common param error!\",\"ret_code\":-1}", json.toString());
		json = xgt.callRestful("http://10.1.152.139/v1/push/single_", params);
		assertEquals("{\"err_msg\":\"call restful error\",\"ret_code\":-1}", json.toString());
		json = xgt.callRestful("abc", params);
		assertEquals("{\"err_msg\":\"generateSign error\",\"ret_code\":-1}", json.toString());
	}

}
