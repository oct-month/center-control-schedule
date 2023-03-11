# 中控调度微服务

## 开发环境

- Spring Boot 2.7.9
- OpenJDK 8
- MySQL 8
- RabbitMQ 3

## 设计文档

<a href="doc/README.md">
  <span>设计文档</span>
</a>

## `API`文档

<a href="doc/API.md">
  <span>API 文档</span>
</a>

## `Insomnia`可导入文件

[Insomnia 官网](https://github.com/Kong/insomnia)

<a href="doc/Insomnia.json">
  <span>Insomnia 文件</span>
</a>

## 编译运行

```sh
mvn clean package -Dmaven.test.skip=true
docker-compose up -d --build
```

[docker 官网](https://www.docker.com/)

[docker-comopse 下载地址](https://github.com/docker/compose/releases)
