package com.sherry.common.camelbackKey;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.reflection.wrapper.MapWrapper;

import java.util.Map;

/**
 * 用于转换字段名为驼峰形式的包装器
 */
public class CamelbakKeyMapWrapper extends MapWrapper {
	private Map map;

	public CamelbakKeyMapWrapper(MetaObject metaObject, Map<String, Object> map) {
		super(metaObject, map);
		this.map = map;
	}

	@Override
	public void set(PropertyTokenizer prop, Object value) {
		if (prop.getIndex() != null) {
			Object collection = resolveCollection(prop, map);
			setCollectionValue(prop, collection, value);
		} else {
			map.put(changeUnderlineToCamelBak(prop.getName()), value);
		}
	}

	/**
	 * 将下划线命名方式修改为驼峰命名方式
	 */
	public static String changeUnderlineToCamelBak(String src) {
		if (src == null || src.length() == 0) {
			return "";
		}
		byte[] data = src.getBytes();
		byte[] result = new byte[data.length];
		int position = -1;
		for (int i = 0, l = data.length; i < l; i++) {
			if (data[i] == 95 && i + 1 < l) {
				result[++position] = (byte) (data[++i] - 32);
			} else {
				result[++position] = data[i];
			}
		}
		if (position == -1) {
			return src;
		}
		return new String(result, 0, position + 1);
	}
}
