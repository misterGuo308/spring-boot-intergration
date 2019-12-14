**gy演示swagger文档**


**简介**：<p>演示接口</p>


**HOST**:localhost:8081

**联系人**:gy

**Version**:1.0

**接口路径**：/v2/api-docs


# 不同类型参数设置

## 搜索测试不同类型参数保存

**接口描述**:添加自定义响应

**接口地址**:`/actInteger/getActInteger`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称 | 参数说明 | in   | 是否必须 | 数据类型 | schema |
| -------- | -------- | ---- | -------- | -------- | ------ |
| longName | longName | path | true     | integer  |        |
| path     | 参数     | path | false    | integer  |        |

**响应示例**:

```json
{
	"message": "请求成功",
	"result": {
		"doub1": 0,
		"float1": 0,
		"number": 0,
		"price": 0,
		"sort": 0
	},
	"status": "200"
}
```

**响应参数**:


| 参数名称 | 参数说明   | 类型       | schema     |
| -------- | ---------- | ---------- | ---------- |
| message  | 返回消息   | string     |            |
| result   | 返回数据   | ActInteger | ActInteger |
| status   | 返回状态码 | string     |            |



**schema属性说明**




**ActInteger**

| 参数名称 | 参数说明           | 类型           | schema |
| -------- | ------------------ | -------------- | ------ |
| doub1    | double类型属性     | number(double) |        |
| float1   | float类型属性      | number(float)  |        |
| number   | Long类型           | integer(int64) |        |
| price    | BigDecimal类型属性 | number         |        |
| sort     | int类型            | integer(int32) |        |

**响应状态**:


| 状态码 | 说明                           | schema           |
| ------ | ------------------------------ | ---------------- |
| 200    | OK                             | Resp«ActInteger» |
| 400    | 请求参数没填好                 |                  |
| 404    | 请求路径没有或页面跳转路径不对 |                  |
## 测试不同类型参数保存

**接口描述**:返回值通用包装类

**接口地址**:`/actInteger/save`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"doub1": 0,
	"float1": 0,
	"number": 0,
	"price": 0,
	"sort": 0
}
```


**请求参数**：

| 参数名称   | 参数说明   | in   | 是否必须 | 数据类型   | schema     |
| ---------- | ---------- | ---- | -------- | ---------- | ---------- |
| actInteger | actInteger | body | true     | ActInteger | ActInteger |

**schema属性说明**



**ActInteger**

| 参数名称 | 参数说明           | in   | 是否必须 | 数据类型       | schema |
| -------- | ------------------ | ---- | -------- | -------------- | ------ |
| doub1    | double类型属性     | body | false    | number(double) |        |
| float1   | float类型属性      | body | false    | number(float)  |        |
| number   | Long类型           | body | false    | integer(int64) |        |
| price    | BigDecimal类型属性 | body | false    | number         |        |
| sort     | int类型            | body | false    | integer(int32) |        |

**响应示例**:

```json
{
	"message": "请求成功",
	"result": true,
	"status": "200"
}
```

**响应参数**:


| 参数名称 | 参数说明   | 类型    | schema |
| -------- | ---------- | ------- | ------ |
| message  | 返回消息   | string  |        |
| result   | 返回数据   | boolean |        |
| status   | 返回状态码 | string  |        |





**响应状态**:


| 状态码 | 说明 | schema        |
| ------ | ---- | ------------- |
| 200    | OK   | Resp«boolean» |
# 文件接口
## 上传文件单个文件

**接口描述**:测试文件上传

**接口地址**:`/file/uploadMateria1`


**请求方式**：`POST`


**consumes**:`["multipart/form-data"]`


**produces**:`["*/*"]`



**请求参数**：

| 参数名称 | 参数说明 | in       | 是否必须 | 数据类型 | schema |
| -------- | -------- | -------- | -------- | -------- | ------ |
| file     | 文件     | formData | false    | file     |        |

**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码 | 说明 | schema |
| ------ | ---- | ------ |
| 200    | OK   |        |
## 上传文件多个个文件

**接口描述**:测试文件上传

**接口地址**:`/file/uploadMateria2`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`



**请求参数**：

| 参数名称 | 参数说明 | in       | 是否必须 | 数据类型 | schema |
| -------- | -------- | -------- | -------- | -------- | ------ |
| file     | 文件     | formData | false    | array    | file   |

**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码 | 说明 | schema |
| ------ | ---- | ------ |
| 200    | OK   |        |
# 用户类型接口

## 删除返回包装类

**接口描述**:根据名称进行删除返回通用类型

**接口地址**:`/user/delete`


**请求方式**：`DELETE`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
| name     | 名称     | query | true     | string   |        |

**响应示例**:

```json
{
	"message": "请求成功",
	"result": true,
	"status": "200"
}
```

**响应参数**:


| 参数名称 | 参数说明   | 类型    | schema |
| -------- | ---------- | ------- | ------ |
| message  | 返回消息   | string  |        |
| result   | 返回数据   | boolean |        |
| status   | 返回状态码 | string  |        |





**响应状态**:


| 状态码 | 说明 | schema        |
| ------ | ---- | ------------- |
| 200    | OK   | Resp«boolean» |
## 搜索1

**接口描述**:测试无查询条件返回实体

**接口地址**:`/user/getUser1`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：
暂无



**响应示例**:

```json
{
	"age": 18,
	"createTime": "2019-12-12 1:06:22",
	"name": "张"
}
```

**响应参数**:


| 参数名称   | 参数说明 | 类型              | schema            |
| ---------- | -------- | ----------------- | ----------------- |
| age        | 年龄     | integer(int32)    | integer(int32)    |
| createTime | 创建时间 | string(date-time) | string(date-time) |
| name       | 名称     | string            |                   |





**响应状态**:


| 状态码 | 说明 | schema |
| ------ | ---- | ------ |
| 200    | OK   | User   |
## 搜索多条件返回用户类型

**接口描述**:测试多条件返回用户类型

**接口地址**:`/user/getUser3`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
| age      | 年龄     | query | true     | integer  |        |
| name     | 名称     | query | true     | string   |        |

**响应示例**:

```json
{
	"age": 18,
	"createTime": "2019-12-12 1:06:22",
	"name": "张"
}
```

**响应参数**:


| 参数名称   | 参数说明 | 类型              | schema            |
| ---------- | -------- | ----------------- | ----------------- |
| age        | 年龄     | integer(int32)    | integer(int32)    |
| createTime | 创建时间 | string(date-time) | string(date-time) |
| name       | 名称     | string            |                   |





**响应状态**:


| 状态码 | 说明 | schema |
| ------ | ---- | ------ |
| 200    | OK   | User   |
## 搜索输入数组类型返回通用类型

**接口描述**:测试数组

**接口地址**:`/user/getUser4`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema  |
| -------- | -------- | ----- | -------- | -------- | ------- |
| ages     | 名称     | query | true     | array    | integer |

**响应示例**:

```json
{
	"age": 18,
	"createTime": "2019-12-12 1:06:22",
	"name": "张"
}
```

**响应参数**:


| 参数名称   | 参数说明 | 类型              | schema            |
| ---------- | -------- | ----------------- | ----------------- |
| age        | 年龄     | integer(int32)    | integer(int32)    |
| createTime | 创建时间 | string(date-time) | string(date-time) |
| name       | 名称     | string            |                   |





**响应状态**:


| 状态码 | 说明 | schema |
| ------ | ---- | ------ |
| 200    | OK   | User   |
## 搜索输入非必传参数

**接口描述**:测试非必传

**接口地址**:`/user/getUser5`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
| age      | 名称     | query | false    | integer  |        |

**响应示例**:

```json
{
	"message": "请求成功",
	"result": {
		"age": 18,
		"createTime": "2019-12-12 1:06:22",
		"name": "张"
	},
	"status": "200"
}
```

**响应参数**:


| 参数名称 | 参数说明   | 类型   | schema |
| -------- | ---------- | ------ | ------ |
| message  | 返回消息   | string |        |
| result   | 返回数据   | User   | User   |
| status   | 返回状态码 | string |        |



**schema属性说明**




**User**

| 参数名称   | 参数说明 | 类型              | schema |
| ---------- | -------- | ----------------- | ------ |
| age        | 年龄     | integer(int32)    |        |
| createTime | 创建时间 | string(date-time) |        |
| name       | 名称     | string            |        |

**响应状态**:


| 状态码 | 说明 | schema     |
| ------ | ---- | ---------- |
| 200    | OK   | Resp«User» |
## 搜索测试heand中传值

**接口描述**:测试heand

**接口地址**:`/user/getUser6`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称    | 参数说明    | in     | 是否必须 | 数据类型 | schema |
| ----------- | ----------- | ------ | -------- | -------- | ------ |
| headerparam | headerparam | header | false    | string   |        |

**响应示例**:

```json
{
	"message": "请求成功",
	"result": {
		"age": 18,
		"createTime": "2019-12-12 1:06:22",
		"name": "张"
	},
	"status": "200"
}
```

**响应参数**:


| 参数名称 | 参数说明   | 类型   | schema |
| -------- | ---------- | ------ | ------ |
| message  | 返回消息   | string |        |
| result   | 返回数据   | User   | User   |
| status   | 返回状态码 | string |        |



**schema属性说明**




**User**

| 参数名称   | 参数说明 | 类型              | schema |
| ---------- | -------- | ----------------- | ------ |
| age        | 年龄     | integer(int32)    |        |
| createTime | 创建时间 | string(date-time) |        |
| name       | 名称     | string            |        |

**响应状态**:


| 状态码 | 说明 | schema     |
| ------ | ---- | ---------- |
| 200    | OK   | Resp«User» |
## 搜索设置路径中传值

**接口描述**:测试heand

**接口地址**:`/user/getUser7/{path}`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称 | 参数说明 | in   | 是否必须 | 数据类型 | schema |
| -------- | -------- | ---- | -------- | -------- | ------ |
| path     | 参数     | path | false    | string   |        |

**响应示例**:

```json
{
	"message": "请求成功",
	"result": {
		"age": 18,
		"createTime": "2019-12-12 1:06:22",
		"name": "张"
	},
	"status": "200"
}
```

**响应参数**:


| 参数名称 | 参数说明   | 类型   | schema |
| -------- | ---------- | ------ | ------ |
| message  | 返回消息   | string |        |
| result   | 返回数据   | User   | User   |
| status   | 返回状态码 | string |        |



**schema属性说明**




**User**

| 参数名称   | 参数说明 | 类型              | schema |
| ---------- | -------- | ----------------- | ------ |
| age        | 年龄     | integer(int32)    |        |
| createTime | 创建时间 | string(date-time) |        |
| name       | 名称     | string            |        |

**响应状态**:


| 状态码 | 说明 | schema     |
| ------ | ---- | ---------- |
| 200    | OK   | Resp«User» |
## 新增返回布尔类型

**接口描述**:添加用户信息接口返回boolean类型

**接口地址**:`/user/save`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"age": 18,
	"createTime": "2019-12-12 1:06:22",
	"name": "张"
}
```


**请求参数**：

| 参数名称 | 参数说明 | in   | 是否必须 | 数据类型 | schema |
| -------- | -------- | ---- | -------- | -------- | ------ |
| user     | user     | body | true     | User     | User   |

**schema属性说明**



**User**

| 参数名称   | 参数说明 | in   | 是否必须 | 数据类型          | schema |
| ---------- | -------- | ---- | -------- | ----------------- | ------ |
| age        | 年龄     | body | true     | integer(int32)    |        |
| createTime | 创建时间 | body | true     | string(date-time) |        |
| name       | 名称     | body | true     | string            |        |

**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码 | 说明 | schema |
| ------ | ---- | ------ |
| 200    | OK   |        |
## 修改返回通用包装类

**接口描述**:添加用户信息接口返回通用类型

**接口地址**:`/user/update`


**请求方式**：`PUT`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"age": 18,
	"createTime": "2019-12-12 1:06:22",
	"name": "张"
}
```


**请求参数**：

| 参数名称 | 参数说明 | in   | 是否必须 | 数据类型 | schema |
| -------- | -------- | ---- | -------- | -------- | ------ |
| user     | user     | body | true     | User     | User   |

**schema属性说明**



**User**

| 参数名称   | 参数说明 | in   | 是否必须 | 数据类型          | schema |
| ---------- | -------- | ---- | -------- | ----------------- | ------ |
| age        | 年龄     | body | true     | integer(int32)    |        |
| createTime | 创建时间 | body | true     | string(date-time) |        |
| name       | 名称     | body | true     | string            |        |

**响应示例**:

```json
{
	"message": "请求成功",
	"result": true,
	"status": "200"
}
```

**响应参数**:


| 参数名称 | 参数说明   | 类型    | schema |
| -------- | ---------- | ------- | ------ |
| message  | 返回消息   | string  |        |
| result   | 返回数据   | boolean |        |
| status   | 返回状态码 | string  |        |





**响应状态**:


| 状态码 | 说明 | schema        |
| ------ | ---- | ------------- |
| 200    | OK   | Resp«boolean» |
