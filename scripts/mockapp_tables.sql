DROP TABLE IF EXISTS `mockapp_city`;

CREATE TABLE `mockapp_city` (
  `city_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL COMMENT '城市名称',
  `province` varchar(32) DEFAULT NULL COMMENT '所属省份',
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `mockapp_person`;

CREATE TABLE `mockapp_person` (
  `person_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL COMMENT '姓名',
  `phone` varchar(32) DEFAULT NULL COMMENT '手机号码',
  `city_id` int(10) unsigned DEFAULT '0',
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
