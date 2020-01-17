package com.example.speingbootfilemanage.common.annoation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author guoyou
 * @date 2020/1/17 8:37
 * <p>
 * 文件格式验证
 */
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = FileValidator.class)
public @interface ValidFile {

    String DEFAULT_MAXSIZE = "-1";

    /**
     * 支持的文件后缀类型(.doc .xls),默认全部,AliasFor("endWith")
     */
    String[] value() default {};

    /**
     * AliasFor("value")
     */
    String[] endWith() default {};

    /**
     * 文件后缀名是否区分大小写 默认不区分
     */
    boolean ignoreCase() default true;

    /**
     * 上传文件是否允许为空
     * 默认不允许为空
     */
    boolean allowEmpty() default false;

    /**
     * 文件件长度
     * 默认不限制单必须小于srpingboot配置中的值
     * 最小文件大小。值可以使用后缀“MB”或“KB”来表示
     */
    String maxSize() default DEFAULT_MAXSIZE;

    /**
     * 最小文件大小。值可以使用后缀“MB”或“KB”来表示
     */
    String minSize() default DEFAULT_MAXSIZE;

    String message() default "上传文件未通过验证";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
