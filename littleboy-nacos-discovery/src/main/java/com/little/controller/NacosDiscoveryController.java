package com.little.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.stereotype.Controller;

/**
 * @Comment
 * @Author LiYuan
 * @Date 2020-5-30
 */
@Controller
@RequestMapping("nacos")
public class NacosDiscoveryController {



  @NacosInjected
  private NamingService namingService;

  @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
  private boolean useLocalCache;

  @RequestMapping("/{str}")
  public String helloNacos(@PathVariable String str) {
    return new Date() + "Hello Nacos " + str;
  }

  @RequestMapping("/instance")
  @ResponseBody
  public List<Instance> getInstance(@PathVariable String serviceName) throws NacosException {
    return namingService.getAllInstances(serviceName);
  }

  @RequestMapping(value = "/get", method = GET)
  @ResponseBody
  public boolean get() {
    return useLocalCache;
  }
}
