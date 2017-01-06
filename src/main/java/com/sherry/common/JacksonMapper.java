package com.sherry.common;


import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JacksonMapper extends ObjectMapper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final ObjectMapper mapper = new JacksonMapper();

	private JacksonMapper() {
		super();

		// // 允许单引号
		// this.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		// // 字段和值都加引号
		// this.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		// // 数字也加引号
		// this.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);
		// this.configure(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS,
		// true);
		// 空值处理为空串

		// null去掉，仅对bean有效，map list无效
		this.setSerializationInclusion(Include.NON_NULL);
		// map去掉null
		this.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);

		// this.getSerializerProvider().setNullValueSerializer(new
		// JsonSerializer<Object>() {
		// @Override
		// public void serialize(Object value, JsonGenerator jg,
		// SerializerProvider sp) throws IOException, JsonProcessingException {
		// jg.writeString("");
		//
		// }
		// });
	}

	public static ObjectMapper getInstance() {
		return mapper;
	}

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper o = JacksonMapper.getInstance();
		Integer a = 1;
		Integer b = null;
		String c = "1";
		String d = null;
		String e = "";
		Map<Object, Object> map = new HashMap();
		map.put("a", a);
		map.put("b", b);
		map.put("c", c);
		map.put("d", d);
		map.put("e", e);
		System.out.println(o.writeValueAsString(map));

//		PriUserBean priUserBean = new PriUserBean();
//		priUserBean.setAge(3);
//		priUserBean.setCity("city");
//		System.out.println(o.writeValueAsString(priUserBean));
//
//		String priUserBeanJson = "{\"id\":\"\",\"username\":\"\",\"password\":\"\",\"state\":\"\",\"createTime\":\"\",\"realname\":\"\",\"sex\":\"\",\"age\":3,\"email\":\"\",\"phone\":\"\",\"lastLogin\":\"\",\"fkPid\":\"\",\"level\":\"\",\"pic\":\"\",\"treeCode\":\"\",\"wxId\":\"\",\"nickname\":\"\",\"province\":\"\",\"city\":\"city\",\"country\":\"\"}";
//		String priUserBeanJson2 = "{\"id\":null,\"username\":null,\"password\":null,\"state\":null,\"createTime\":null,\"realname\":null,\"sex\":null,\"age\":3,\"email\":null,\"phone\":null,\"lastLogin\":null,\"fkPid\":null,\"level\":null,\"pic\":null,\"treeCode\":null,\"wxId\":null,\"nickname\":null,\"province\":null,\"city\":\"city\",\"country\":null}";
//		PriUserBean priUserBean2 = o.readValue(priUserBeanJson, PriUserBean.class);
//		PriUserBean priUserBean3 = o.readValue(priUserBeanJson2, PriUserBean.class);
//		System.out.println(priUserBean2.getAge());
//		System.out.println(priUserBean3.getAge());

	}

}