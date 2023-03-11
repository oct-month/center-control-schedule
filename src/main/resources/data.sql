-- 测试数据

LOCK TABLES `Soft` WRITE;
INSERT INTO `Soft` VALUES (
    'fake-data-2ebbffbd002e9670e7ae9a707c1b5de75c0fd6e8d79d9d9f696982',
    'v1.0.3',
    2,
    '2023-03-22 11:12:12',
    '博物馆-边缘-客户端',
    'v1.0.3版本,修复了若干bug,增加了播放功能',
    '/api/v1/file/soft/test-bin-2.tar.gz'
);
INSERT INTO `Soft` VALUES (
    'fake-data-1ebbffbd002e9670e7ae9a707c1b5de75c0fd6e8d79d9d9f696982',
    'v1.0.4',
    3,
    '2023-03-20 11:12:12',
    '博物馆-边缘-客户端',
    'v1.0.4版本,修复了若干bug,增加了播放功能',
    '/api/v1/file/soft/test-bin-3.tar.gz'
);
INSERT INTO `Soft` VALUES (
    'fake-data-3ebbffbd002e9670e7ae9a707c1b5de75c0fd6e8d79d9d9f696982',
    'v1.0.1',
    1,
    '2023-03-21 11:12:12',
    '博物馆-边缘-客户端',
    'v1.0.1版本,修复了若干bug,增加了播放功能',
    '/api/v1/file/soft/test-bin-1.tar.gz'
);
UNLOCK TABLES;

LOCK TABLES `User` WRITE;
INSERT INTO `User` VALUES (
    'ad',
    'admin',
    '9ccf3f3ac7e03b6f775bac6417a66952bc421d64c557d3c2ebd953f72a140eb7'
);
INSERT INTO `User` VALUES (
    'user1',
    'normal',
    '9ccf3f3ac7e03b6f775bac6417a66952bc421d64c557d3c2ebd953f72a140eb7'
);
INSERT INTO `User` VALUES (
    'user2',
    'normal',
    '9ecf3f3ac7e03b6f775bac6417a66952bc421d64c557d3c2ebd953f72a140eb7'
);
UNLOCK TABLES;

LOCK TABLES `Device` WRITE;
INSERT INTO `Device` VALUES (
    'fake-data-dd902ec7eb5fe8372d5329d8dcf64bddd3b683fb514b61eb2122a9',
    'fake-data-2ebbffbd002e9670e7ae9a707c1b5de75c0fd6e8d79d9d9f696982',
    'user1',
    '2023-03-22 11:12:12',
    23.3,
    14.4,
    3,
    11.4
);
INSERT INTO `Device` VALUES (
    'fake-data-ed902ec7eb5fe8372d5329d8dcf64bddd3b683fb514b61eb2122a9',
    'fake-data-1ebbffbd002e9670e7ae9a707c1b5de75c0fd6e8d79d9d9f696982',
    'user1',
    '2023-03-20 11:12:12',
    23.3,
    14.4,
    3,
    11.4
);
INSERT INTO `Device` VALUES (
    'fake-data-fd902ec7eb5fe8372d5329d8dcf64bddd3b683fb514b61eb2122a9',
    'fake-data-1ebbffbd002e9670e7ae9a707c1b5de75c0fd6e8d79d9d9f696982',
    'user1',
    '2023-03-21 11:12:12',
    23.3,
    14.4,
    3,
    11.4
);
UNLOCK TABLES;

LOCK TABLES `DeviceReportLog` WRITE;
INSERT INTO `DeviceReportLog` VALUES (
    null,
    'fake-data-dd902ec7eb5fe8372d5329d8dcf64bddd3b683fb514b61eb2122a9',
    'fake-data-2ebbffbd002e9670e7ae9a707c1b5de75c0fd6e8d79d9d9f696982',
    '2023-03-22 11:12:12',
    23.3,
    14.4,
    3,
    11.4
);
INSERT INTO `DeviceReportLog` VALUES (
    null,
    'fake-data-ed902ec7eb5fe8372d5329d8dcf64bddd3b683fb514b61eb2122a9',
    'fake-data-1ebbffbd002e9670e7ae9a707c1b5de75c0fd6e8d79d9d9f696982',
    '2023-03-20 11:12:12',
    23.3,
    14.4,
    3,
    11.4
);
INSERT INTO `DeviceReportLog` VALUES (
    null,
    'fake-data-fd902ec7eb5fe8372d5329d8dcf64bddd3b683fb514b61eb2122a9',
    'fake-data-1ebbffbd002e9670e7ae9a707c1b5de75c0fd6e8d79d9d9f696982',
    '2023-03-21 11:12:12',
    23.3,
    14.4,
    3,
    11.4
);
UNLOCK TABLES;

LOCK TABLES `Resource` WRITE;
INSERT INTO `Resource` VALUES (
    'fake-data-a9d0d762c2255a1d00b45e4f00764d528203de6693efd6c0f2659d',
    '三星堆',
    '/api/v1/file/cover/test.jpg',
    '18+',
    '三星堆文化,只因你太美',
    '2023-03-22 11:12:12',
    '/api/v1/file/video/test.mp4'
);
INSERT INTO `Resource` VALUES (
    'fake-data-b9d0d762c2255a1d00b45e4f00764d528203de6693efd6c0f2659d',
    '三星堆2',
    '/api/v1/file/cover/test.jpg',
    '18+',
    '三星堆文化,只因你太美',
    '2023-03-22 11:12:12',
    '/api/v1/file/video/test.mp4'
);
INSERT INTO `Resource` VALUES (
    'fake-data-c9d0d762c2255a1d00b45e4f00764d528203de6693efd6c0f2659d',
    '三星堆3',
    '/api/v1/file/cover/test.jpg',
    '18-',
    '三星堆文化,只因你太美',
    '2023-03-22 11:12:12',
    '/api/v1/file/video/test.mp4'
);
UNLOCK TABLES;

LOCK TABLES `ResourceTagRelate` WRITE;
INSERT INTO `ResourceTagRelate` VALUES (
    'fake-data-a9d0d762c2255a1d00b45e4f00764d528203de6693efd6c0f2659d',
    'sao'
);
INSERT INTO `ResourceTagRelate` VALUES (
    'fake-data-a9d0d762c2255a1d00b45e4f00764d528203de6693efd6c0f2659d',
    '青壮年模式'
);
INSERT INTO `ResourceTagRelate` VALUES (
    'fake-data-b9d0d762c2255a1d00b45e4f00764d528203de6693efd6c0f2659d',
    'sao'
);
INSERT INTO `ResourceTagRelate` VALUES (
    'fake-data-c9d0d762c2255a1d00b45e4f00764d528203de6693efd6c0f2659d',
    'sao'
);
UNLOCK TABLES;

LOCK TABLES `Collection` WRITE;
INSERT INTO `Collection` VALUES (
    'fake-data-590883afef91ee6a8f2c2fc3eb30478435a6fe93c7aed78d01c9db',
    '合集1',
    '/api/v1/file/cover/test.jpg'
);
INSERT INTO `Collection` VALUES (
    'fake-data-690883afef91ee6a8f2c2fc3eb30478435a6fe93c7aed78d01c9db',
    '合集2',
    '/api/v1/file/cover/test.jpg'
);
INSERT INTO `Collection` VALUES (
    'fake-data-790883afef91ee6a8f2c2fc3eb30478435a6fe93c7aed78d01c9db',
    '合集3',
    '/api/v1/file/cover/test.jpg'
);
UNLOCK TABLES;

LOCK TABLES `CollectionTagRelate` WRITE;
INSERT INTO `CollectionTagRelate` VALUES (
    'fake-data-590883afef91ee6a8f2c2fc3eb30478435a6fe93c7aed78d01c9db',
    'sao'
);
INSERT INTO `CollectionTagRelate` VALUES (
    'fake-data-690883afef91ee6a8f2c2fc3eb30478435a6fe93c7aed78d01c9db',
    'sao'
);
INSERT INTO `CollectionTagRelate` VALUES (
    'fake-data-690883afef91ee6a8f2c2fc3eb30478435a6fe93c7aed78d01c9db',
    '青壮年模式'
);
INSERT INTO `CollectionTagRelate` VALUES (
    'fake-data-790883afef91ee6a8f2c2fc3eb30478435a6fe93c7aed78d01c9db',
    'sao'
);
UNLOCK TABLES;

LOCK TABLES `ResourceCollectionRelate` WRITE;
INSERT INTO `ResourceCollectionRelate` VALUES (
    'fake-data-a9d0d762c2255a1d00b45e4f00764d528203de6693efd6c0f2659d',
    'fake-data-690883afef91ee6a8f2c2fc3eb30478435a6fe93c7aed78d01c9db'
);
INSERT INTO `ResourceCollectionRelate` VALUES (
    'fake-data-b9d0d762c2255a1d00b45e4f00764d528203de6693efd6c0f2659d',
    'fake-data-690883afef91ee6a8f2c2fc3eb30478435a6fe93c7aed78d01c9db'
);
INSERT INTO `ResourceCollectionRelate` VALUES (
    'fake-data-c9d0d762c2255a1d00b45e4f00764d528203de6693efd6c0f2659d',
    'fake-data-590883afef91ee6a8f2c2fc3eb30478435a6fe93c7aed78d01c9db'
);
UNLOCK TABLES;

LOCK TABLES `Theme` WRITE;
INSERT INTO `Theme` VALUES (
    'fake-data-e8e48d58e413fc5525ea7513eb4a91b77417a50e460a5c33f51c44',
    '主题1',
    '2023-03-29 11:12:12'
);
INSERT INTO `Theme` VALUES (
    'fake-data-f8e48d58e413fc5525ea7513eb4a91b77417a50e460a5c33f51c44',
    '主题2',
    '2023-03-29 11:12:12'
);
INSERT INTO `Theme` VALUES (
    'fake-data-a8e48d58e413fc5525ea7513eb4a91b77417a50e460a5c33f51c44',
    '主题3',
    '2023-03-29 11:12:12'
);
UNLOCK TABLES;

LOCK TABLES `ResourceThemeRelate` WRITE;
INSERT INTO `ResourceThemeRelate` VALUES (
    'fake-data-a9d0d762c2255a1d00b45e4f00764d528203de6693efd6c0f2659d',
    'fake-data-e8e48d58e413fc5525ea7513eb4a91b77417a50e460a5c33f51c44'
);
INSERT INTO `ResourceThemeRelate` VALUES (
    'fake-data-b9d0d762c2255a1d00b45e4f00764d528203de6693efd6c0f2659d',
    'fake-data-e8e48d58e413fc5525ea7513eb4a91b77417a50e460a5c33f51c44'
);
INSERT INTO `ResourceThemeRelate` VALUES (
    'fake-data-c9d0d762c2255a1d00b45e4f00764d528203de6693efd6c0f2659d',
    'fake-data-e8e48d58e413fc5525ea7513eb4a91b77417a50e460a5c33f51c44'
);
UNLOCK TABLES;

LOCK TABLES `UserResourceWhiteRelate` WRITE;
INSERT INTO `UserResourceWhiteRelate` VALUES (
    'user1',
    'fake-data-c9d0d762c2255a1d00b45e4f00764d528203de6693efd6c0f2659d'
);
INSERT INTO `UserResourceWhiteRelate` VALUES (
    'user2',
    'fake-data-a9d0d762c2255a1d00b45e4f00764d528203de6693efd6c0f2659d'
);
INSERT INTO `UserResourceWhiteRelate` VALUES (
    'user2',
    'fake-data-c9d0d762c2255a1d00b45e4f00764d528203de6693efd6c0f2659d'
);
UNLOCK TABLES;

LOCK TABLES `UserResourceBlackRelate` WRITE;
INSERT INTO `UserResourceBlackRelate` VALUES (
    'user1',
    'fake-data-a9d0d762c2255a1d00b45e4f00764d528203de6693efd6c0f2659d'
);
UNLOCK TABLES;

LOCK TABLES `UserCollectionRelate` WRITE;
INSERT INTO `UserCollectionRelate` VALUES (
    'user1',
    'fake-data-690883afef91ee6a8f2c2fc3eb30478435a6fe93c7aed78d01c9db'
);
UNLOCK TABLES;
