# 中控调度服务 `API`

## 边缘侧向中心汇报

> 边缘侧使用`RabbitMQ`向中心汇报，以维持在线状态。汇报由边缘侧自身定时发起，由中心实时接收。
> 
> 若边缘侧自身状态发生变化，也可即时发起。例如：固件升级、升级完成、维护下线 ...

- 队列名称："edge.report"
- 消息类型：string（包含json数据）

```json
{
    "device": "<deviceId>",
    "time": "<float:UTC时间戳>",
    "longitude": "<经度>",
    "latitude": "<纬度>",
    "clientCount": "<int:连接数>",
    "speedCount": "<float:总带宽MB/s>",
    "soft": {
        "<场景1>": "<版本>",
        "<场景2>": "<版本>",
        ...
    },
    "status": "online/updating/offline"
}
```

> `device/time`字段必须有，其它字段可以没有。若某字段没有，则中心会认为该字段的值与最近一次汇报相同。

> `soft`字段通常只有一个值（即单一场景）


## 中心向边缘侧发布

> 发布由中控发起，由边缘侧接收，发送目标为`RabbitMQ`一般队列。

### 有新的固件

- 队列名称："attention.soft"
- 消息类型：string（包含json数据）

```json
{
    "scene": "<固件场景>",
    "version": "<版本>",
    "uptime": "<float:更新时间UTC>",
    "desc": "<描述>",
    "versionCode": "<int:版本号|越大越新>",
    "file": "<下载地址>"
}
```

> 升级一般是边缘侧的主动行为

### 视频资源有更改

- 队列名称："attention.resource"
- 消息类型：string（包含json数据）

```json
[
    "资源1Id",
    "资源2Id",
    "资源3Id",
    ...
]
```

### 合集有更改

- 队列名称："attention.collection"
- 消息类型：string（包含json数据）

```json
[
    "合集1Id",
    "合集2Id",
    "合集3Id",
    ...
]
```

### 新主题发布、主题有更改

- 队列名称："attention.theme"
- 消息类型：string（包含json数据）
```json
[
    "主题1Id",
    "主题2Id",
    "主题3Id",
    ...
]
```


## 边缘侧业务请求

> 业务请求采用`RESTful`接口规范。

状态码定义：

| 状态码 | 含义 |
| :----: | :---- |
| 200 | `ok` 请求成功 |
| 401 | `unauthorized` deviceId字段缺失或不正确 |
| 403 | `forbidden` 设备注册时邀请码不对 |
| 502 | `bad gateway` 中心服务ban了 |

###	设备注册

POST /api/v1/register

```json
{
    "code": "<邀请码>",
    "longitude": "<经度>",
    "latitude": "<纬度>",
    "soft": {
        "<场景1>": "<版本>",
        "<场景2>": "<版本>",
        ...
    },
    "status": "online/updating/offline"
}
```

> code邀请码为中心设置
> 
> 其余字段可选

响应：

200

```json
{
    "id": "<deviceId>"
}
```

> deviceId同时作为登录凭证

403

```json
{
	"msg": "code wrong"
}
```

> 邀请码错误

###	资源列表获取

GET /api/v1/resource

```json
[
    {
        "id": "<resourceId>",
        "name": "<资源名称>",
        "cover": "<封面图:/api/v1/file/cover/test.png>",
        "kind": "<资源类型>",
        "desc": "<资源详细描述>",
        "uptime": "<float:上一次更新时间UTC>",
        "file": "<资源下载链接:/api/v1/file/video/test.mp4>",
        "tag": ["标签1", "标签2"]
    },
    ...
]
```

GET /api/v1/resource/<resourceId>

```json
{
    "id": "<resourceId>",
    "name": "<资源名称>",
    "cover": "<封面图:/api/v1/file/cover/test.png>",
    "kind": "<资源类型>",
    "desc": "<资源详细描述>",
    "uptime": "<float:上一次更新时间UTC>",
    "file": "<资源下载链接:/api/v1/file/video/test.mp4>",
    "tag": ["标签1", "标签2"]
}
```

###	合集列表获取

GET /api/v1/collection

```json
[
    {
        "id": "<collectionId>",
        "name": "<合集名称>",
        "cover": "合集封面:/api/v1/file/cover/test.png",
        "tag": ["标签1", "标签2"],
        "resource": ["资源1", "资源2"]
    },
    ...
]
```

GET /api/v1/collection/<collectionId>

```json
{
    "id": "<collectionId>",
    "name": "<合集名称>",
    "cover": "合集封面:/api/v1/file/cover/test.png",
    "tag": ["标签1", "标签2"],
    "resource": ["资源1", "资源2"]
}
```

###	主题列表获取

GET /api/v1/theme

```json
[
    {
        "id": "<themeId>",
        "name": "<主题名称>",
        "endTime": "<float:结束时间UTC>",
        "resource": ["资源1", "资源2"]
    },
    ...
]
```

GET /api/v1/theme/<themeId>

```json
{
    "id": "<themeId>",
    "name": "<主题名称>",
    "endTime": "<float:结束时间UTC>",
    "resource": ["资源1", "资源2"]
}
```

###	特定资源下载

GET /api/v1/file/cover/<test.jpg>

二进制图片

GET /api/v1/file/video/<test.mp4>

二进制视频


###	固件最新版本查询

GET /api/v1/soft/<scene>

```json
{
    "id": "<softId>",
    "scene": "<应用场景>",
    "version": "<版本号>",
    "versionCode": "<int:版本代码>",
    "uptime": "<float:上传时间UTC>",
    "desc": "描述",
    "file": "下载链接:/api/v1/file/soft/test.bin"
}
```

### 固件下载

GET /api/v1/file/soft/<文件名>

二进制升级包
