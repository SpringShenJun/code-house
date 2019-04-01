package com.csj5.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class CsjImportSelector implements ImportSelector {
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        return new String[]{"com.csj5.bean.Mouse", "com.csj5.bean.Tiger"};

    }
}
