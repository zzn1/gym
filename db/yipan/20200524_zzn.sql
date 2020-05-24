ALTER TABLE `yp_card`
    ADD UNIQUE INDEX `id` (`id`) USING HASH;

ALTER TABLE `yp_bill`
    ADD UNIQUE INDEX `id` (`id`) USING HASH ,
    ADD INDEX `rock_no` (`rock_no`) USING HASH;

ALTER TABLE `yp_card_holder`
    ADD UNIQUE INDEX `id` (`id`) USING HASH ,
    ADD INDEX `openid` (`openid`) USING HASH;

ALTER TABLE `yp_cardtype`
    ADD UNIQUE INDEX `id` (`id`) USING HASH;

ALTER TABLE `yp_member`
    ADD UNIQUE INDEX `id` (`id`) USING HASH ,
    ADD UNIQUE INDEX `openid` (`openid`) USING HASH ,
    ADD UNIQUE INDEX `phone` (`phone`) USING HASH;

ALTER TABLE `yp_rock_hall`
    ADD UNIQUE INDEX `id` (`id`) USING HASH ,
    ADD INDEX `rock_no` (`rock_no`) USING HASH ,
    ADD INDEX `region` (`region`) USING HASH ,
    ADD INDEX `rock_name` (`rock_name`) USING HASH;

ALTER TABLE `yp_sign_in_management`
    ADD UNIQUE INDEX `id` (`id`) USING HASH ,
    ADD INDEX `openid` (`openid`) USING HASH ;

