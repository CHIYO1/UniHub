CREATE DATABASE IF NOT EXISTS UNIHUB;
USE UNIHUB;

CREATE TABLE users (
    account        VARCHAR(50) PRIMARY KEY COMMENT '用户账号（唯一标识符）',
    password       VARCHAR(255) NOT NULL COMMENT '账户的登录密码（哈希存储）',
    role           ENUM('会员', '管理员', '普通用户','商家') NOT NULL COMMENT '用户身份',
    avatar         VARCHAR(255) COMMENT '用户头像 URL',
    bio            TEXT COMMENT '个人简介信息',
    phone          VARCHAR(20) UNIQUE COMMENT '绑定手机号码',
    growth_value   INT DEFAULT 0 COMMENT '成长值（用户活跃度指标）',
		points         INT DEFAULT 0 NOT NULL COMMENT '用户的积分数量',
    settings       JSON COMMENT '个性化设置',
    permissions    JSON COMMENT '权限',
    address        VARCHAR(255) COMMENT '收货地址',
    third_party_bind JSON COMMENT '第三方账号绑定信息'
);

CREATE TABLE resources (
    id          BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '资源的唯一标识符',
    type        VARCHAR(50) NOT NULL COMMENT '资源的类别，如二手书、课程推荐、共享资源等',
    description TEXT COMMENT '资源的详细描述信息',
    merchant_id BIGINT NOT NULL COMMENT '资源所属的 ID',
    price       DECIMAL(10,2) NOT NULL COMMENT '资源的定价，单位：人民币',
    stock       INT NOT NULL COMMENT '资源的库存或可用数量',
    image       VARCHAR(255) COMMENT '资源的展示图片 URL',
    tag         VARCHAR(255) COMMENT '资源的分类标签（如数学、计算机科学）'
);

CREATE TABLE posts (
    id          BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '帖子的唯一标识符',
    title       VARCHAR(255) NOT NULL COMMENT '帖子标题，方便用户浏览',
    author_id   VARCHAR(50) COMMENT '发帖人的 ID',
    created_at  DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '帖子的发布时间',
    content     TEXT NOT NULL COMMENT '帖子的正文内容',
    tag         VARCHAR(255) COMMENT '文章分类标签，如经验分享、求助'
);

CREATE TABLE coupons (
    coupon_id     BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '劵的唯一标识符',
    account     	VARCHAR(50) COMMENT '所属用户的 ID',
    valid_from    DATETIME NOT NULL COMMENT '劵的生效时间',
    valid_until   DATETIME NOT NULL COMMENT '劵的过期时间',
    applicable_scope VARCHAR(255) NOT NULL COMMENT '劵的适用范围（如商品类别、商家等）',
    description   TEXT NOT NULL COMMENT '劵的具体内容描述',
    CONSTRAINT fk_coupon_wallet FOREIGN KEY (account) REFERENCES users(account) ON DELETE CASCADE
);

CREATE TABLE follows (
    follow_id    BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '关注记录的唯一标识符',
    follower_id  VARCHAR(50) COMMENT '关注者用户 ID',
    followed_id  VARCHAR(50) COMMENT '被关注者用户 ID',
    follow_time  DATETIME NOT NULL COMMENT '关注时间',
    CONSTRAINT fk_follow_follower FOREIGN KEY (follower_id) REFERENCES users(account) ON DELETE CASCADE,
    CONSTRAINT fk_follow_followed FOREIGN KEY (followed_id) REFERENCES users(account) ON DELETE CASCADE
);

CREATE TABLE favorites (
    favorite_id  BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '收藏记录的唯一标识符',
    user_id      VARCHAR(50) COMMENT '用户 ID',
    resource_id  BIGINT NOT NULL COMMENT '被收藏的资源 ID',
    favorite_time DATETIME NOT NULL COMMENT '收藏时间',
    CONSTRAINT fk_favorite_user FOREIGN KEY (user_id) REFERENCES users(account) ON DELETE CASCADE,
    CONSTRAINT fk_favorite_resource FOREIGN KEY (resource_id) REFERENCES resources(id) ON DELETE CASCADE
);

CREATE TABLE cart_items (
    cart_id      BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '购物车记录的唯一标识符',
    user_id      VARCHAR(50) COMMENT '用户 ID',
    resource_id  BIGINT NOT NULL COMMENT '加入购物车的资源 ID',
    added_time   DATETIME NOT NULL COMMENT '资源加入购物车的时间',
    CONSTRAINT fk_cart_user FOREIGN KEY (user_id) REFERENCES users(account) ON DELETE CASCADE,
    CONSTRAINT fk_cart_resource FOREIGN KEY (resource_id) REFERENCES resources(id) ON DELETE CASCADE
);

CREATE TABLE footprints (
    footprint_id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '足迹记录的唯一标识符',
    user_id      VARCHAR(50) COMMENT '用户 ID',
    resource_id  BIGINT NOT NULL COMMENT '浏览的资源 ID',
    view_time    DATETIME NOT NULL COMMENT '用户浏览资源的时间',
    CONSTRAINT fk_footprint_user FOREIGN KEY (user_id) REFERENCES users(account) ON DELETE CASCADE,
    CONSTRAINT fk_footprint_resource FOREIGN KEY (resource_id) REFERENCES resources(id) ON DELETE CASCADE
);

CREATE TABLE tasks (
    task_id        BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '任务的唯一标识符',
    start_time     DATETIME NOT NULL COMMENT '任务开始时间',
    duration       INT NOT NULL COMMENT '任务持续时间（单位：小时）',
    target_scope   VARCHAR(255) NOT NULL COMMENT '任务面向范围（如全体用户、特定用户群体）',
    content        TEXT NOT NULL COMMENT '任务内容描述'
);

CREATE TABLE user_tasks (
    task_record_id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '任务记录的唯一标识符',
    user_id        VARCHAR(50) COMMENT '用户 ID',
    task_id        BIGINT NOT NULL COMMENT '任务 ID',
    task_status    ENUM('进行中', '完成', '失败') NOT NULL COMMENT '任务状态',
    status_update_time DATETIME NOT NULL COMMENT '任务状态的更新时间',
    CONSTRAINT fk_user_task_user FOREIGN KEY (user_id) REFERENCES users(account) ON DELETE CASCADE,
    CONSTRAINT fk_user_task FOREIGN KEY (task_id) REFERENCES tasks(task_id) ON DELETE CASCADE
);

CREATE TABLE transactions (
    record_id  BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '交易记录唯一 ID',
    user_id    VARCHAR(50) COMMENT '用户 ID',
    merchant_id VARCHAR(50) COMMENT '商家 ID',
    resource_id BIGINT NOT NULL COMMENT '资源 ID',
    quantity   INT NOT NULL COMMENT '交易数量',
    timestamp  DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '交易时间',
    status     ENUM('已完成', '待支付', '已取消','售后处理') NOT NULL COMMENT '交易状态',
    remarks    TEXT COMMENT '交易备注'
);

CREATE TABLE announcements (
    announcement_id  BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '公告的唯一标识符',
    type            VARCHAR(50) NOT NULL COMMENT '公告类型（如系统公告、活动公告等）',
    publish_time    DATETIME NOT NULL COMMENT '公告发布时间',
    duration        INT DEFAULT 0 NOT NULL COMMENT '公告持续时间（以分钟为单位）',
    publisher       VARCHAR(255) NOT NULL COMMENT '发布方（如系统、管理员等）'
);

CREATE TABLE chat_contents (
    content_id  BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '聊天内容的唯一标识符',
    timestamp   DATETIME NOT NULL COMMENT '消息发送时间',
    message     TEXT NOT NULL COMMENT '聊天内容'
);

CREATE TABLE chat_sessions (
    chat_id    BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '聊天会话的唯一标识符',
    user_a_id  VARCHAR(50) COMMENT '聊天对象 A 的 ID',
    user_b_id  VARCHAR(50) COMMENT '聊天对象 B 的 ID',
    content_id BIGINT NOT NULL COMMENT '关联的聊天内容 ID',
    CONSTRAINT fk_chat_user_a FOREIGN KEY (user_a_id) REFERENCES users(account) ON DELETE CASCADE,
    CONSTRAINT fk_chat_user_b FOREIGN KEY (user_b_id) REFERENCES users(account) ON DELETE CASCADE,
    CONSTRAINT fk_chat_content FOREIGN KEY (content_id) REFERENCES chat_contents(content_id) ON DELETE CASCADE
);

ALTER TABLE transactions
ADD CONSTRAINT fk_transactions_user_a FOREIGN KEY (user_id) REFERENCES users(account) ON DELETE CASCADE,
ADD CONSTRAINT fk_transactions_user_b FOREIGN KEY (merchant_id) REFERENCES users(account) ON DELETE CASCADE;

ALTER TABLE posts
ADD CONSTRAINT fk_posts_user FOREIGN KEY (author_id) REFERENCES users(account) ON DELETE CASCADE;