package com.wsh.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
// 默认是Singleton 相当于@Scope("singleton"),单例
@Service
@Scope("prototype") // 声明为prototype,每次获得都会创建一个新的
public class DefaultScopeService {
}
