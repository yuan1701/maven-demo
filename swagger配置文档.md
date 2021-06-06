
[TOC]

#### SpringBoot接口文档生成工具swagger2的使用

- 1.pom.xml安装依赖

 ```java
   <!--添加swagger依赖-->
    <dependency>
      <groupId>io.springfox</groupId>
      <artifactId>springfox-swagger2</artifactId>
      <version>2.8.0</version>
    </dependency>

    <!--Swagger-UI-->
    <!--访问路径：http://localhost:8080/swagger-ui.html-->
    <dependency>
      <groupId>io.springfox</groupId>
      <artifactId>springfox-swagger-ui</artifactId>
      <version>2.8.0</version>
    </dependency>
 ```

- 2.配置类添加 config/swaggerconfig.java  
  **注意修改basePackage的地址**


```java
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //只有加了ApiOperation注解的类，才生成接口文档
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //web包下的接口，生成接口文档
                .apis(RequestHandlerSelectors.basePackage("com.vun.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Multi Availability Services")
                .description("这是一个测试项目")
                .version("1.0.0")
                .build();
    }
}

```
- 3.在controller类中添加相应的注解

3.1  @Api  用于类；表示标识这个类是swagger的资源
tags–表示说明
value–也是说明，可以使用tags替代
但是tags如果有多个值，会生成多个list

 ```java
 @Api(value = "类别信息",tags={"类别接口-小张先生2333"})```

  3.2 @ApiOperation  用于方法，表示一个http请求的操作
    参数：

    value用于方法描述
    notes用于提示内容
    tags可以重新分组（视情况而用）

 ```java
@ApiOperation(value = "获取用户信息")
```


3.3 @ApiImplicitParam 用于方法 表示单独的请求参数
name–参数ming
value–参数说明
dataType–数据类型
paramType–参数类型
example–举例说明

  ```java
@ApiImplicitParam(name = "param", value = "查询条件", required = true, dataType = "String", paramType = "query")```


 


- 4 接口文档访问： 访问http://localhost:8080/swagger-ui.html