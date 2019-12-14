

# Spring Boot项目单体架构集成knife4j使用说明

## 官网说明以及用法
官网地址 https://gitee.com/xiaoym/knife4j
knife4j为Java开发者在使用Swagger的时候，能拥有一份简洁、强大的接口文档体验

## 核心功能

该UI增强包主要包括两大核心功能：**文档说明** 和 **在线调试**

- **文档说明**：根据Swagger的规范说明，详细列出接口文档的说明，包括接口地址、类型、请求示例、请求参数、响应示例、响应参数、响应码等信息，使用swagger-bootstrap-ui能根据该文档说明，对该接口的使用情况一目了然。
- **在线调试**：提供在线接口联调的强大功能，自动解析当前接口参数,同时包含表单验证，调用参数可返回接口响应内容、headers、Curl请求命令实例、响应时间、响应状态码等信息，帮助开发者在线调试，而不必通过其他测试工具测试接口是否正确,简介、强大。

## 环境配置

### Maven中引入Jar包
knife4j是在swagger2的基础上进行强的,springboot使用起来非常简单只需要引入`knife4j-spring-boot-starter`的`maven`依赖即可
```xml
        <!--knife4j-->
        <dependency>
            <groupId>com.github.xiaoymin</groupId>
            <artifactId>knife4j-spring-boot-starter</artifactId>
            <version>1.9.6</version>
        </dependency>
```

### 编写Swagger2Config配置文件
`Swagger2Config`配置文件如下：
```java
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUi
private class SwaggerConfiguration  {
    @Value("${swagger.enable}")
    private  Boolean enable;
    @Bean
    public Docket createRestApi() {
        return  new Docket(DocumentationType.SWAGGER_2)
                .enable(enable)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cmcc.jifen.supplier.modules"))
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("商户业务服务集成 Swagger 实例文档")
                .description("服务相关接口 ")
                .termsOfServiceUrl("http://localhost:30000/doc.htm")
                .contact(new Contact("gy","",""))
                .version("1.0")
                .build();
    }
}
```
### shior请求过滤
```java
        //knifej4请求地址配置
        filterChainDefinitionMap.put("/swagger**/**/**", "anon");
        filterChainDefinitionMap.put("/v2/api-docs", "anon");
        filterChainDefinitionMap.put("/v2/api-docs-ext", "anon");
        filterChainDefinitionMap.put("/doc.html", "anon");
        filterChainDefinitionMap.put("/webjars/**","anon");
```
## api实例说明

注释汇总

| 作用范围           | API                |             使用位置        |
| ------------------ | ------------------ |-------------------------|
| 设置接口集描述       | @Api               |        用于controller类上     |
| 设置接口描述         | @ApiOperation      |      用在controller的方法上    |
| 设置响应集   | @ApiResponses      |      用在controller的方法上   |
| 设置响应      | @ApiResponse       |      用在 @ApiResponses里边  |
| 设置请求非对象参数集     | @ApiImplicitParams |      用在controller的方法上 |
| 设置请求非对象参数描述   | @ApiImplicitParam  |用在controller的方法上|
| 设置描述返回对象的意义 | @ApiModel          |         用在返回对象类上         |
| 设置对象属性         | @ApiModelProperty  |     用在出入参数对象的字段上     |
### @Api
注解常用属性说明

| 属性名称       |    作用                                           |
| ------------- | ----------------------------------------------- |
| value         |                                      接口名称 |
| tags           |               如果设置这个值,value的值会被覆盖 |
| position       |           设置Api 顺序 |
| consumes       | 请求的提交内容类型,例如application/json       |
| produces       | 请求响应返回类型,例如application/json       |
### @ApiOperation

注解常用属性说明

| 属性名称          | 作用                                             |
|---------------- | ---------------------------------------------- |
| value             | url的路径值                                    |
| tags              | 如果设置这个值,value的值会被覆盖,这个值将不设置         |
| position          | 如果配置多个Api 想改变显示的顺序位置                  |
| consumes          | 请求的提交内容类型,例如application/json       |
| produces          | 请求响应返回类型,例如application/json        |
| code              | http的状态码 默认 200                             |
### @ApiResponses
当需要设置多个响应信息时,该注解一般与@ApiResponse联合使用
### @ApiResponse
注解常用属性说明

| 属性名称          | 备注                             |
| ---------------- | ------------------------------- |
| code              | http的状态码                     |
| message           | http的状态码描述                             |
| response          | 默认响应类                  |
### @ApiImplicitParams
当接口传入多个参数时,该注解一般与@ApiImplicitParam注解联合使用.
### @ApiImplicitParam
注解常用属性说明

| 属性         |  作用                                          |
| ------------ |  --------------------------------------------- |
| paramType    | 查询参数类型                                  |
| dataType         | 参数的数据类型 只作为标志说明,并没有实际验证 |
| name          | 接收参数名                                    |
| value          | 接收参数的意义描述                            |
| required        | 参数是否必填true必填 false非必填                 |
|  example         | 设置传入json默认值,建议写上                |

#### dataType取值
属性取值说明

| 取值    | 作用                                          |
| ------ | --------------------------------------------- |
| path   | 以地址的形式提交数据                          |
| query  | 直接跟参数完成自动映射赋值                    |
| body   | 以流的形式提交 仅支持POST                     |
| header | 参数在request headers里边提交                |
| form   | 以form表单的形式提交 仅支持POST               |
#### dataType属性取值
属性取值说明

|  取值         | 对应的java实体                                    |
| ------ 	| --------------------------------------------- |
| byte   	| Byte.class,                   |
| int    	| Short.class,Integer.class                          |
| long   	| Long.class                    |
| double 	| Double.class                     |
| float  	| Float.class                |
| boolean   | Boolean.class               |
| string    | Character.TYPE,String.class,Currency.class,,             |
| date-time | Date.class              |
| date   	| java.sql.Date.class               |
|object     | Object.clas|
|bigdecimal | BigDecimal.class|
|biginteger | BigInteger.class|
|uuid       | UUID.class|
|\__file   | MultipartFile.class|

### @ApiModel 
注解常用属性说明

| 属性          |  作用                                          |
| ------------ |  --------------------------------------------- |
| value        | 设置实体类名称可以不写                            |
| description  | 设置实体类描述建议填写                            |
### @ApiModelProperty 
注解常用属性说明

| 属性          |  作用                                          |
| ------------ |  --------------------------------------------- |
| paramType    | 查询参数类型                                  |
| dataType     | 参数的数据类型 只作为标志说明，并没有实际验证 |
| name          | 接收参数名缺省不写                                    |
| value          | 接收参数的意义描述                            |
| required        | 参数是否必填true必填 false非必填                 |
|  example         | 设置传入json默认值建议写上                |

## 项目中使用示例
测试用户实体类
```java
@ApiModel(description = "用户类描述")
public class User {
    @ApiModelProperty(value = "名称" ,required = true ,example = "张")
    private String name ;
    @ApiModelProperty(value = "年龄",required = true,example = "18")
    private Integer age;
    @ApiModelProperty(value = "创建时间" ,required = true ,example = "2019-12-12 1:06:22")
    private LocalDateTime createTime;
}

```
通用接口返回类
```java
public class Resp<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private final static String SUCCESS_CODE = "200";

    /**
     * 返回状态码
     */
    @ApiModelProperty(required = true, notes = "返回状态码", example = "200")
    private String status;

    /**
     * 返回消息
     */
    @ApiModelProperty(required = true, notes = "返回消息", example = "请求成功")
    private String message;

    /**
     * 返回内容
     */
    @ApiModelProperty(required = true, notes = "返回数据")
    private T result;
```
测试其他数据类型接口返回类
```java
@ApiModel
public class ActInteger {

    @ApiModelProperty(value = "Long类型")
    private Long number;
    @ApiModelProperty(value = "BigDecimal类型属性")
    private BigDecimal price;
    @ApiModelProperty(value = "float类型属性")
    private float float1;
    @ApiModelProperty(value = "double类型属性")
    private double doub1;
    @ApiModelProperty(value = "int类型")
    private int sort;
```
测试用户controller
```java
@RestController
@Api( tags = "用户类型接口")
@RequestMapping("/user")
public class UserController {

    @PostMapping("/save")
    @ApiOperation(value = "新增返回布尔类型", notes = "添加用户信息接口返回boolean类型")
    public Boolean save1(@RequestBody User user) {
        user = new User();
        user.setName("张");
        user.setAge(18);
        user.setCreateTime(LocalDateTime.now());
        return true;
    }
}
```
测试文件controller
```java
@RestController
@Api(tags = "文件接口")
@RequestMapping("file")
public class FileController {

    @PostMapping("/uploadMateria1")
    @ApiOperation(value = "上传文件单个文件", notes = "测试文件上传")
    @ApiImplicitParam(name = "file", value = "文件", paramType = "form", dataType = "__File")
    public void  getFile(@RequestParam("file") MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
    }
}    
```
项目源码地址 https://github.com/misterGuo308/spring-boot-intergration
作者:米斯特郭 
转载请标明出处

