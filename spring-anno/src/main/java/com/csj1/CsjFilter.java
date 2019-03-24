package com.csj1;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class CsjFilter implements TypeFilter {


    /*
     *metadataReader获取当前正在扫描类的类信息
     *metadataReaderFactory获取到其他类信息
     */
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        //获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前正在扫描的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类路径
        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();
        System.out.println("className = " + className);
        if (!className.contains("Cont")) {

            return true;
        }


        return false;
    }
}
