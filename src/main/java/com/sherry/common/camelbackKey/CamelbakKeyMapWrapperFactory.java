package com.sherry.common.camelbackKey;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.wrapper.ObjectWrapper;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;

import java.util.Map;

/**
 * 用于转换字段名为驼峰形式的适配工厂
 */
public class CamelbakKeyMapWrapperFactory implements ObjectWrapperFactory {

	@Override
	public boolean hasWrapperFor(Object object) {
		return object instanceof CamelbakKeyResultMap;
	}

	@Override
	public ObjectWrapper getWrapperFor(MetaObject metaObject, Object object) {
		return new CamelbakKeyMapWrapper(metaObject, (Map) object);
	}

}
