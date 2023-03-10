set NAMES 'utf8mb4';

-- USE ccs;

-- DROP TABLE IF EXISTS `DeviceReportLog`;
-- DROP TABLE IF EXISTS `Device`;
-- DROP TABLE IF EXISTS `Soft`;
-- DROP TABLE IF EXISTS `ResourceTagRelate`;
-- DROP TABLE IF EXISTS `CollectionTagRelate`;
-- DROP TABLE IF EXISTS `ResourceCollectionRelate`;
-- DROP TABLE IF EXISTS `ResourceThemeRelate`;
-- DROP TABLE IF EXISTS `UserResourceWhiteRelate`;
-- DROP TABLE IF EXISTS `UserResourceBlackRelate`;
-- DROP TABLE IF EXISTS `UserCollectionRelate`;
-- DROP TABLE IF EXISTS `Resource`;
-- DROP TABLE IF EXISTS `Collection`;
-- DROP TABLE IF EXISTS `Theme`;
-- DROP TABLE IF EXISTS `User`;

CREATE TABLE IF NOT EXISTS `Soft` (
  `id` char(64) NOT NULL COMMENT 'id',
  `version` varchar(20) NOT NULL COMMENT '版本号',
  `versionCode` int NOT NULL COMMENT '版本代码',
  `uptime` datetime NOT NULL COMMENT '上传日期',
  `scene` varchar(40) NOT NULL COMMENT '应用场景',
  `desc` text NULL COMMENT '描述',
  `file` varchar(100) NULL COMMENT '下载地址',
  PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci
COMMENT='固件';

CREATE TABLE IF NOT EXISTS `Device` (
  `id` char(64) NOT NULL COMMENT 'id',
  `softId` char(64) NULL COMMENT '固件id',
  `uptime` datetime NOT NULL COMMENT '更新时间',
  `longitude` float NULL COMMENT '经度',
  `latitude` float NULL COMMENT '纬度',
  `clientCount` int NULL COMMENT '连接数',
  `speedCount` float NULL COMMENT '总带宽',
  PRIMARY KEY (`id`),
  CONSTRAINT `D_FK` FOREIGN KEY (`softId`) REFERENCES `Soft` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci
COMMENT='边缘设备';

CREATE TABLE IF NOT EXISTS `DeviceReportLog` (
  `id` int unsigned auto_increment NOT NULL COMMENT 'id',
  `deviceId` char(64) NOT NULL COMMENT '设备id',
  `softId` char(64) NULL COMMENT '固件id',
  `time` datetime NOT NULL COMMENT '汇报时间',
  `longitude` float NULL COMMENT '经度',
  `latitude` float NULL COMMENT '纬度',
  `clientCount` int NULL COMMENT '连接数',
  `speedCount` float NULL COMMENT '总带宽',
  PRIMARY KEY (`id`),
  CONSTRAINT `DRL_FK_1` FOREIGN KEY (`deviceId`) REFERENCES `Device` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `DRL_FK_2` FOREIGN KEY (`softId`) REFERENCES `Soft` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci
COMMENT='边缘设备汇报日志';

-- Device 表定时从 DeviceReportLog 表中同步信息

CREATE TABLE IF NOT EXISTS `Resource` (
  `id` char(64) NOT NULL COMMENT 'id',
  `name` varchar(40) NOT NULL COMMENT '名称',
  `cover` varchar(100) NULL COMMENT '封面图',
  `kind` varchar(20) NULL COMMENT '类型',
  `desc` text NULL COMMENT '描述',
  `uptime` datetime NOT NULL COMMENT '更新时间',
  `file` varchar(100) NOT NULL COMMENT '下载地址',
  PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci
COMMENT='资源列表';

CREATE TABLE IF NOT EXISTS `ResourceTagRelate` (
  `resourceId` char(64) NOT NULL,
  `tag` varchar(40) NOT NULL,
  PRIMARY KEY (`resourceId`, `tag`),
  CONSTRAINT `RT_FK` FOREIGN KEY (`resourceId`) REFERENCES `Resource` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci
COMMENT='资源-标签 关系表';

CREATE TABLE IF NOT EXISTS `Collection` (
  `id` char(64) NOT NULL COMMENT 'id',
  `name` varchar(40) NOT NULL COMMENT '名称',
  `cover` varchar(100) NULL COMMENT '封面图',
  PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci
COMMENT='合集';

CREATE TABLE IF NOT EXISTS `CollectionTagRelate` (
  `collectionId` char(64) NOT NULL,
  `tag` varchar(40) NOT NULL,
  PRIMARY KEY (`collectionId`, `tag`),
  CONSTRAINT `CT_FK` FOREIGN KEY (`collectionId`) REFERENCES `Collection` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci
COMMENT='合集-标签 关系表';

CREATE TABLE IF NOT EXISTS `ResourceCollectionRelate` (
  `resourceId` char(64) NOT NULL,
  `collectionId` char(64) NOT NULL,
  PRIMARY KEY (`resourceId`, `collectionId`),
  CONSTRAINT `RCR_FK_1` FOREIGN KEY (`resourceId`) REFERENCES `Resource` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `RCR_FK_2` FOREIGN KEY (`collectionId`) REFERENCES `Collection` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci
COMMENT='资源-合集 关系表';

CREATE TABLE IF NOT EXISTS `Theme` (
  `id` char(64) NOT NULL COMMENT 'id',
  `name` varchar(40) NOT NULL COMMENT '名称',
  `endTime` datetime NOT NULL COMMENT '结束时间',
  PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci
COMMENT='主题';

CREATE TABLE IF NOT EXISTS `ResourceThemeRelate` (
  `resourceId` char(64) NOT NULL,
  `themeId` char(64) NOT NULL,
  PRIMARY KEY (`resourceId`, `themeId`),
  CONSTRAINT `RTR_FK_1` FOREIGN KEY (`resourceId`) REFERENCES `Resource` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `RTR_FK_2` FOREIGN KEY (`themeId`) REFERENCES `Theme` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci
COMMENT='资源-主题 关系表';

CREATE TABLE IF NOT EXISTS `User` (
  `name` varchar(64) NOT NULL COMMENT '用户名',
  `role` varchar(40) NOT NULL COMMENT '角色/权限',
  `passwd` char(64) NOT NULL COMMENT 'SHA256密码',
  PRIMARY KEY (`name`)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci
COMMENT='边缘用户';

CREATE TABLE IF NOT EXISTS `UserResourceWhiteRelate` (
  `userName` varchar(64) NOT NULL,
  `resourceId` char(64) NOT NULL,
  PRIMARY KEY (`userName`, `resourceId`),
  CONSTRAINT `URWR_FK_1` FOREIGN KEY (`userName`) REFERENCES `User` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `URWR_FK_2` FOREIGN KEY (`resourceId`) REFERENCES `Resource` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci
COMMENT='资源-用户 白名单 关系表';

CREATE TABLE IF NOT EXISTS `UserResourceBlackRelate` (
  `userName` varchar(64) NOT NULL,
  `resourceId` char(64) NOT NULL,
  PRIMARY KEY (`userName`, `resourceId`),
  CONSTRAINT `URBR_FK_1` FOREIGN KEY (`userName`) REFERENCES `User` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `URBR_FK_2` FOREIGN KEY (`resourceId`) REFERENCES `Resource` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci
COMMENT='资源-用户 黑名单 关系表';

CREATE TABLE IF NOT EXISTS `UserCollectionRelate` (
  `userName` varchar(64) NOT NULL,
  `collectionId` char(64) NOT NULL,
  PRIMARY KEY (`userName`, `collectionId`),
  CONSTRAINT `UCR_FK_1` FOREIGN KEY (`userName`) REFERENCES `User` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `UCR_FK_2` FOREIGN KEY (`collectionId`) REFERENCES `Collection` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci
COMMENT='用户-合集 关系表';
