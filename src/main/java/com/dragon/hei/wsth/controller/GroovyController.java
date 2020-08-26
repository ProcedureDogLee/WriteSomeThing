package com.dragon.hei.wsth.controller;

import com.dragon.hei.wsth.vo.ResponseVo;
import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: lilong
 **/
@RestController
@RequestMapping("/groovy")
@Slf4j
public class GroovyController {

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping(value = "/omnipotent", method = RequestMethod.POST)
    public ResponseVo<String> groovy(@RequestBody String content){
        try {
            GroovyClassLoader groovyClassLoader = new GroovyClassLoader(this.getClass().getClassLoader());
            CompilerConfiguration compilerConfiguration = new CompilerConfiguration();
            compilerConfiguration.setSourceEncoding("utf-8");

            Binding groovyBinding = new Binding();
            applicationContext.getBeansOfType(Object.class).forEach(groovyBinding::setVariable);

            GroovyShell groovyShell = new GroovyShell(groovyClassLoader, groovyBinding, compilerConfiguration);
            Script script = groovyShell.parse(content);
            return ResponseVo.success(String.valueOf(script.run()));
        } catch (Exception e) {
            log.error("groovy脚本执行失败: {}", e);
            return ResponseVo.fail(e.getMessage());
        }
    }
}
