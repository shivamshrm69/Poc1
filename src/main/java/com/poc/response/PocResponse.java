package com.poc.response;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
@Data
public class PocResponse {
private boolean isSuccess;
private Map<Object,Object> result=new HashMap<Object, Object>();

}
