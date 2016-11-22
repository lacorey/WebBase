package com.sherry.common.camelbackKey;

import java.util.HashMap;

/**
 * 用于MyBatis返回结果时，将key由下划线转为驼峰形式。这里仅仅声明一种Map类型， 配合
 * {@link com.sherry.common.camelbackKey.CamelbakKeyMapWrapperFactory}使用，
 * 在Mybatis的sql映射中配置： <code>
 *     resultType="com.sherry.common.camelbackKey.CamelbakKeyResultMap"
 * </code> 或者使用别名： <code>
 *     resultType="CamelbakKeyResultMap"
 * </code>
 */
public class CamelbakKeyResultMap<K, V> extends HashMap<K, V> {

}
