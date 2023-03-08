set NAMES 'utf8mb4';

DROP TABLE IF EXISTS `Soft`;
CREATE TABLE `Soft` (
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

DROP TABLE IF EXISTS `Device`;
CREATE TABLE `Device` (
  `id` char(64) NOT NULL COMMENT 'id',
  `softId` char(64) NOT NULL COMMENT '固件id'
  `time` datetime NOT NULL COMMENT '汇报时间',
  `longitude` float NULL COMMENT '经度',
  `latitude` float NULL COMMENT '纬度',
  `clientCount` int NULL COMMENT '连接数',
  `speedCount` float NULL COMMENT '总带宽',
  PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci
COMMENT='边缘设备';

DROP TABLE IF EXISTS `DeviceReportLog`;
CREATE TABLE `Device` (
  `id` int unsigned auto_increment NOT NULL COMMENT 'id',
  `deviceId` char(64) NOT NULL COMMENT '设备id',
  `softId` char(64) NOT NULL COMMENT '固件id'
  `time` datetime NOT NULL COMMENT '汇报时间',
  `longitude` float NULL COMMENT '经度',
  `latitude` float NULL COMMENT '纬度',
  `clientCount` int NULL COMMENT '连接数',
  `speedCount` float NULL COMMENT '总带宽',
  PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci
COMMENT='边缘设备汇报日志';

-- Device 表定时从 DeviceReportLog 表中同步信息

