package com.yzl.study.logindemo.util;

import org.springframework.cglib.beans.BeanCopier;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BeanCopierUti {

    private  static  final Map<String ,BeanCopier> cacheBeanCopier = new ConcurrentHashMap<String ,BeanCopier>();


   public  static  void  copy(Object source ,Object target){

       String key = source.getClass().getName()+target.getClass().getName();
       BeanCopier copier = cacheBeanCopier.get(key);
       if(copier==null){
           copier =BeanCopier.create(source.getClass(),target.getClass(),false);
           cacheBeanCopier.put(key,copier);
       }
       copier.copy(source, target, null);

   }

}
