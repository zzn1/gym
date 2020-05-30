ALTER TABLE `yp_member`
    CHANGE COLUMN `creat_by` `create_by` varchar(64) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '创建者' AFTER `idcard`,
    ADD COLUMN `beans` int(20) NULL DEFAULT NULL COMMENT '易豆' AFTER `phone`;

ALTER TABLE `yp_card_holder`
    MODIFY COLUMN `remaining_times`  bigint(5) NULL DEFAULT NULL COMMENT '剩余次数' AFTER `carduser`;

ALTER TABLE `yp_rock_hall`
    MODIFY COLUMN `price_v10`  bigint(5) NULL DEFAULT NULL COMMENT '10次卡价格' AFTER `address`,
    MODIFY COLUMN `price_v20`  bigint(5) NULL DEFAULT NULL COMMENT '20次卡价格' AFTER `price_v10`;



