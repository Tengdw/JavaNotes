package com.tengdw.netty.serialize.impl;

import com.alibaba.fastjson.JSON;
import com.tengdw.netty.serialize.Serializer;
import com.tengdw.netty.serialize.SerializerAlgorithm;

/**
 * @author Tengdw t_dw@qq.com
 * @date 2018/9/29 14:49
 */
public class JSONSerializer implements Serializer {
    @Override
    public byte getSerializerAlogrithm() {
        return SerializerAlgorithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes, clazz);
    }
}
