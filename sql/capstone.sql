SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for academy
-- ----------------------------
DROP TABLE IF EXISTS `academy`;
CREATE TABLE `academy` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `school_id` int(11) unsigned NOT NULL COMMENT '学校id',
  `name` varchar(255) NOT NULL COMMENT '学院名称',
  `owner` varchar(50) DEFAULT '' COMMENT '院长',
  `crt_time` datetime DEFAULT NULL COMMENT '创建时间',
  `upd_time` datetime DEFAULT NULL COMMENT '更新时间',
  `school_name` varchar(255) DEFAULT '',
  `attr2` varchar(255) DEFAULT '',
  `attr3` varchar(255) DEFAULT '',
  `attr4` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of academy
-- ----------------------------
INSERT INTO `academy` VALUES ('1', '13', '通信工程', '罗院长', null, null, '华南理工大学广州学院', '', '', '');
INSERT INTO `academy` VALUES ('2', '13', '电子信息工程学院', '店院长', null, null, '华南理工大学广州学院', null, null, null);
INSERT INTO `academy` VALUES ('3', '15', '通信工程', '同院长', null, null, '广东工业大学', null, null, null);
INSERT INTO `academy` VALUES ('4', '18', '计算机', 'x院长', null, null, '学校1', null, null, null);

-- ----------------------------
-- Table structure for advice
-- ----------------------------
DROP TABLE IF EXISTS `advice`;
CREATE TABLE `advice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(10000) DEFAULT NULL,
  `crtTime` datetime DEFAULT NULL,
  `updTime` datetime DEFAULT NULL,
  `status` int(1) unsigned DEFAULT '1',
  `notice_order` int(2) DEFAULT NULL,
  `attr1` varchar(255) DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `attr4` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of advice
-- ----------------------------

-- ----------------------------
-- Table structure for artical
-- ----------------------------
DROP TABLE IF EXISTS `artical`;
CREATE TABLE `artical` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `uid` varchar(255) NOT NULL COMMENT '用户id',
  `title` varchar(50) DEFAULT '' COMMENT '文章标题',
  `artical_like` int(11) DEFAULT '0' COMMENT '点赞数',
  `comment_count` int(11) DEFAULT '0' COMMENT '评论数',
  `imgUrl` varchar(50) DEFAULT '' COMMENT '图片',
  `crt_time` datetime DEFAULT NULL COMMENT '创建时间',
  `content` mediumtext,
  `category_id` int(11) DEFAULT NULL COMMENT '分类id',
  `category_name` varchar(255) DEFAULT '' COMMENT '分类名称',
  `uname` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '用户名',
  `status` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of artical
-- ----------------------------
INSERT INTO `artical` VALUES ('39', '201610110008', 'angular从入门到放弃', '0', '1', 'http://106.54.95.152/1577216178284397.jpg', '2019-12-25 03:38:40', '<p><strong>1.如何获取dom节点</strong></p><p>html：&lt;div #wySkider&gt;&lt;/div&gt;</p><p>&nbsp;@ViewChild(\'wySlider\',&nbsp;{&nbsp;static:&nbsp;true&nbsp;})&nbsp;private&nbsp;wySlider:&nbsp;ElementRef;&nbsp; //获取到整个ElementRef</p><p>this.sliderDom&nbsp;=&nbsp;this.wySlider.nativeElement;</p><p><strong>2.如何获取dom的长度/高度</strong></p><p>this.sliderDom.clientHeight</p><p>this.sliderDom.clientWidth</p><p><strong>3.如何获取dom相对视窗的位置</strong></p><p>const rect = this.sliderDom.getBoundingClientRect()</p><p>rect.top;</p><p>rect.left;</p>', null, '', '曾贵花', '1');
INSERT INTO `artical` VALUES ('40', '201610110008', 'rxjs', '1', '1', 'http://106.54.95.152/1577217165215069.jpg', '2019-12-25 03:57:08', '<p>&nbsp; 过滤类</p><table border=\"1\" cellpadding=\"1\" cellspacing=\"1\" 1\"=\"\" rowspan=\"5\"><tbody><tr><td>take</td><td>取流中前n个</td><td colspan=\"1\" rowspan=\"2\"><p>const interval$ = Rx.Observable.interval(100)</p><p>.filter(v=&gt;{v%2==0})&nbsp; //取偶数</p><p>.take(3)&nbsp; //0,2,4</p></td></tr><tr><td>filter</td><td>筛选</td></tr><tr><td>first</td><td><p>取流第一个</p><p>相当于take(1)</p></td><td><p>const interval$ = Rx.Observable.interval(100)</p><p>.filter(v=&gt;{v%2==0})&nbsp;</p><p>.first() //0</p></td></tr><tr><td>last</td><td>取流最后一个</td><td><p>const interval$ = Rx.Observable.interval(4)</p><p>.filter(v=&gt;{v%2==0})&nbsp;</p><p>.larst() //4</p></td></tr><tr><td>skip</td><td>跳过前n个</td><td><p>const interval$ = Rx.Observable.interval(100)</p><p>.filter(v=&gt;{v%2==0})&nbsp;</p><p>.skip(3)&nbsp; //6,8,10...</p></td></tr><tr><td>工作类</td><td>do</td><td>流处理期间对数据进行操作</td><td><p>const interval$ = Rx.Observable.interval(100)</p><p>.do(v=&gt;{console.log(v)})</p><p>.take(2)</p></td></tr><tr><td>变换类</td><td>scan</td><td>循环操作，参数一为上一次操作的结果，参数二为新值内容</td><td><p>const interval$ = Rx.Observable.interval(100)</p><p>.filter(v=&gt;{v%2==0}) //取偶数</p><p>.take(4)</p><p>.scan((x,y)=&gt;{return x+y})&nbsp;</p><p>2(0+2)</p><p>6(2+4)</p><p>12(6+6)</p></td></tr><tr><td>数字类</td><td>reduce</td><td><p><br></p><p>将流计算结果做统一的最后处理并发射</p><p>发射最终值</p><p>同scan但只发送最后一个结果</p></td><td><p>const interval$ = Rx.Observable.interval(100)</p><p>.filter(v=&gt;{v%2==0}) //0,2,4,6,8...</p><p>.take(4)&nbsp;</p><p>.reduce((x,y)=&gt;{return x+y})</p><p>12(6+6)</p></td></tr><tr><td colspan=\"1\" rowspan=\"2\">创建类</td><td>interval</td><td>循环，发射出索引</td><td><p>const interval$ = Rx.Observable.interval(100)</p><p>//0,1,2,3...99</p></td></tr><tr><td>timer</td><td><p>循环，发射出索引</p><p>指定时间启动,指定间隔再启动</p></td><td><p>const timer$ = Rx.Observable.timer(100,200)</p><p>.subscribe(v=&gt;console.log(v))</p><p>0 100ms后发出0</p><p>1 200ms后发出1</p><p>2 200ms后发出2</p><p>...</p></td></tr><tr><td colspan=\"1\" rowspan=\"2\">时间过滤类</td><td>debounce</td><td>只关注大于等于num毫秒间隔的事件内容，参数可为函数</td><td><p>const length$=</p><p>Rx.Observable.fromEvent(length.\'keyup\')</p><p>.pluck(\'target\',\'value\')</p><p>.debounce(()=&gt;{Rx.Observable.interval(300)})</p><p>过滤300ms内keyup事件监听</p></td></tr><tr><td>debounceTime</td><td>只关注大于等于num毫秒间隔的事件内容，参数只为固定毫秒数</td><td><p>const length$=</p><p>Rx.Observable.fromEvent(length.\'keyup\')</p><p>.pluck(\'target\',\'value\')</p><p>.debounceTime(300)</p></td></tr><tr><td colspan=\"1\" rowspan=\"2\">元素过滤类</td><td>distinct</td><td>过滤一样的，保留不一样的</td><td><br></td></tr><tr><td>distinctUtilChanged</td><td>只跟前一个元素比，过滤一样的，保留不一样的</td><td><p>distinctUntilChanged()</p></td></tr><tr><td colspan=\"1\" rowspan=\"3\">合并类</td><td>marge</td><td>按照流运行状态合并</td><td><br></td></tr><tr><td>concat</td><td>将流前后拼接（流1-流2）</td><td><br></td></tr><tr><td>startWith</td><td>设定流发射初始值</td><td><br></td></tr><tr><td colspan=\"1\" rowspan=\"3\">合并类</td><td>combineLatest</td><td>对两个流进行对应处理操作</td><td><br></td></tr><tr><td>withLatestFrom</td><td>基准流改变时进行流操作处理</td><td><br></td></tr><tr><td>zip</td><td>将两流对应位置的元素进行处理操作</td><td><br></td></tr><tr><td><br></td><td><p>takeUntil</p></td><td>当数据流发射出数据时结束流</td><td><br></td></tr></tbody></table>', null, '', '曾贵花', '1');
INSERT INTO `artical` VALUES ('41', '201610110080', 'angular', '1', '1', 'http://106.54.95.152/1577218685616491.jpg', '2019-12-25 04:19:24', '<p><strong>3.如何获取dom相对视窗的位置</strong></p><p>const rect = this.sliderDom.getBoundingClientRect()</p><p>rect.top;</p><p>rect.left;</p><p><strong>4.如何获取视窗的位置</strong></p><p>const win = this.sliderDom.ownerDocument.defaultView; //获取document</p><p>win.pageYOffset</p><p>win.pageXOffset</p><p><strong>5.如何获取dom的left和top</strong></p><p>const rect = this.sliderDom.getBoundingClientRect()</p><p>const win = this.sliderDom.ownerDocument.defaultView;</p><p>rect.left+win.pageXOffset</p><p>rect.top+win.pageYOffset</p>', null, '', '杨尚绵', '1');
INSERT INTO `artical` VALUES ('42', '201610110009', 'angular111', '1', '1', 'http://106.54.95.152/1577221714592838.jpg', '2019-12-25 05:09:18', '<p><strong>1.如何获取dom节点</strong></p><p>html：&lt;div #wySkider&gt;&lt;/div&gt;</p><p>&nbsp;@ViewChild(\'wySlider\',&nbsp;{&nbsp;static:&nbsp;true&nbsp;})&nbsp;private&nbsp;wySlider:&nbsp;ElementRef;&nbsp; //获取到整个ElementRef</p><p>this.sliderDom&nbsp;=&nbsp;this.wySlider.nativeElement;</p><p><strong>2.如何获取dom的长度/高度</strong></p><p>this.sliderDom.clientHeight</p><p>this.sliderDom.clientWidth</p><p><strong>3.如何获取dom相对视窗的位置</strong></p><p>const rect = this.sliderDom.getBoundingClientRect()</p><p>rect.top;</p><p>rect.left;</p><p><strong>4.如何获取视窗的位置</strong></p><p>const win = this.sliderDom.ownerDocument.defaultView; //获取document</p><p>win.pageYOffset</p>', null, '', '萧翰之', '1');

-- ----------------------------
-- Table structure for artical_tag_ref
-- ----------------------------
DROP TABLE IF EXISTS `artical_tag_ref`;
CREATE TABLE `artical_tag_ref` (
  `artical_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  PRIMARY KEY (`artical_id`,`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of artical_tag_ref
-- ----------------------------

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `category_order` int(11) DEFAULT '-1',
  `icon` varchar(255) DEFAULT '',
  `attr3` varchar(255) DEFAULT '',
  `attr4` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('-1', '0', '全部分类', '根节点', '0', '', '', '');
INSERT INTO `category` VALUES ('18', '-1', 'Java', null, '0', 'test', '', '');
INSERT INTO `category` VALUES ('19', '-1', 'web前端', null, '0', 'test', '', '');
INSERT INTO `category` VALUES ('21', '18', 'spring', '最好的框架', '0', '', '', '');

-- ----------------------------
-- Table structure for clazz
-- ----------------------------
DROP TABLE IF EXISTS `clazz`;
CREATE TABLE `clazz` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `school_id` int(11) unsigned DEFAULT NULL COMMENT '学校id',
  `academy_id` int(11) unsigned DEFAULT NULL COMMENT '学院id',
  `major_id` int(11) unsigned DEFAULT NULL COMMENT '专业id',
  `name` varchar(255) NOT NULL COMMENT '班级名称',
  `clazz_teacher` varchar(50) DEFAULT '' COMMENT '班主任',
  `monitor` varchar(50) DEFAULT '' COMMENT '班长',
  `crt_time` datetime DEFAULT NULL COMMENT '创建时间',
  `upd_time` datetime DEFAULT NULL COMMENT '更新时间',
  `school_name` varchar(255) DEFAULT '',
  `academy_name` varchar(255) DEFAULT '',
  `major_name` varchar(255) DEFAULT '',
  `attr4` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clazz
-- ----------------------------
INSERT INTO `clazz` VALUES ('4', '13', '1', '1', '通信二班', '通老师', '通同学', null, null, '华南理工大学广州学院', '通信工程', '通信工程', null);
INSERT INTO `clazz` VALUES ('5', '13', '1', '1', '通信一班', '通2老师', '通2同学', null, null, '华南理工大学广州学院', '通信工程', '通信工程', null);
INSERT INTO `clazz` VALUES ('6', '13', '2', '2', '自动化二班', '自老师', '自同学', null, null, '华南理工大学广州学院', '电子信息工程学院', '自动化', null);
INSERT INTO `clazz` VALUES ('7', '13', '1', '1', '通信三班', '通三老师', '通共同学', null, null, '华南理工大学广州学院', '通信工程', '通信工程', null);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `uid` varchar(255) NOT NULL COMMENT '用户id',
  `artical_id` int(11) NOT NULL COMMENT '文章id',
  `comment_content` varchar(255) DEFAULT '' COMMENT '评论内容',
  `commnet_like` int(11) DEFAULT '0' COMMENT '点赞数',
  `crt_time` datetime DEFAULT NULL,
  `uname` varchar(255) DEFAULT '' COMMENT '用户名',
  `imgUrl` varchar(255) DEFAULT '',
  `attr4` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '201610110008', '26', 'test', '0', '2019-12-22 23:01:19', 'jeniffer', 'http://106.54.95.152/zgh.jpg', '');
INSERT INTO `comment` VALUES ('2', '201610110008', '26', '好东西，收藏了', '0', '2019-12-23 00:02:27', 'jeniffer', 'http://106.54.95.152/zgh.jpg', '');
INSERT INTO `comment` VALUES ('3', '201610110008', '26', '111', '0', '2019-12-23 00:04:24', 'jeniffer', 'http://106.54.95.152/zgh.jpg', '');
INSERT INTO `comment` VALUES ('4', '201610110008', '26', '11', '0', '2019-12-23 00:32:13', 'jeniffer', 'http://106.54.95.152/zgh.jpg', '');
INSERT INTO `comment` VALUES ('5', '201610110008', '26', '22', '0', '2019-12-23 00:34:25', 'jeniffer', 'http://106.54.95.152/zgh.jpg', '');
INSERT INTO `comment` VALUES ('6', '201610110008', '26', '11111', '0', '2019-12-23 00:37:45', 'jeniffer', 'http://106.54.95.152/zgh.jpg', '');
INSERT INTO `comment` VALUES ('7', '201610110008', '26', '11111', '0', '2019-12-23 00:39:29', 'jeniffer', 'http://106.54.95.152/zgh.jpg', '');
INSERT INTO `comment` VALUES ('8', '201610110008', '26', '1111', '0', '2019-12-23 00:40:42', 'jeniffer', 'http://106.54.95.152/zgh.jpg', '');
INSERT INTO `comment` VALUES ('9', '201610110008', '26', '1111', '0', '2019-12-23 00:44:21', 'jeniffer', 'http://106.54.95.152/zgh.jpg', '');
INSERT INTO `comment` VALUES ('10', '201610110008', '26', '65+5', '0', '2019-12-23 00:53:15', 'jeniffer', 'http://106.54.95.152/zgh.jpg', '');
INSERT INTO `comment` VALUES ('11', '201610110008', '26', '11', '0', '2019-12-23 01:02:36', 'jeniffer', 'http://106.54.95.152/zgh.jpg', '');
INSERT INTO `comment` VALUES ('12', '201610110008', '26', '1111', '0', '2019-12-23 01:03:58', 'jeniffer', 'http://106.54.95.152/zgh.jpg', '');
INSERT INTO `comment` VALUES ('13', '201610110008', '26', 'mm', '0', '2019-12-23 01:04:54', 'jeniffer', 'http://106.54.95.152/zgh.jpg', '');
INSERT INTO `comment` VALUES ('14', '201610110008', '26', 'mmjjj', '0', '2019-12-23 01:05:00', 'jeniffer', 'http://106.54.95.152/zgh.jpg', '');
INSERT INTO `comment` VALUES ('15', '201610110008', '26', 'lmoli', '0', '2019-12-23 01:05:12', 'jeniffer', 'http://106.54.95.152/zgh.jpg', '');
INSERT INTO `comment` VALUES ('16', '201610110008', '25', '1234', '0', '2019-12-24 06:22:48', 'jenniffer', 'http://106.54.95.152/zgh.jpg', '');
INSERT INTO `comment` VALUES ('17', '201610110008', '25', 'ggbg', '0', '2019-12-24 06:25:02', 'jenniffer', 'http://106.54.95.152/zgh.jpg', '');
INSERT INTO `comment` VALUES ('18', '201610110008', '25', '1111', '0', '2019-12-24 06:45:02', 'jenniffer', 'http://106.54.95.152/zgh.jpg', '');
INSERT INTO `comment` VALUES ('19', '201610110008', '25', '555', '0', '2019-12-24 06:55:30', 'jenniffer', 'http://106.54.95.152/zgh.jpg', '');
INSERT INTO `comment` VALUES ('20', '201610110008', '25', '111', '0', '2019-12-24 07:07:43', 'jenniffer', 'http://106.54.95.152/zgh.jpg', '');
INSERT INTO `comment` VALUES ('21', '201610110008', '25', 'd', '0', '2019-12-24 07:20:35', 'jenniffer', 'http://106.54.95.152/zgh.jpg', '');
INSERT INTO `comment` VALUES ('22', '201610110008', '39', '这篇文章好', '0', '2019-12-25 03:41:44', '曾贵花', 'http://106.54.95.152/1577214857901178.jpg', '');
INSERT INTO `comment` VALUES ('23', '201610110008', '40', '好文章', '0', '2019-12-25 03:58:57', '曾贵花', 'http://106.54.95.152/1577214857901178.jpg', '');
INSERT INTO `comment` VALUES ('24', '201610110080', '41', '好文章', '0', '2019-12-25 04:20:10', '杨尚绵', 'http://106.54.95.152/default.jpg', '');
INSERT INTO `comment` VALUES ('25', '201610110009', '42', '好文章', '0', '2019-12-25 05:10:56', '萧翰之', 'http://106.54.95.152/1577221557462581.jpg', '');

-- ----------------------------
-- Table structure for import_user
-- ----------------------------
DROP TABLE IF EXISTS `import_user`;
CREATE TABLE `import_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `file_head` varchar(255) NOT NULL COMMENT '文件名前半部分',
  `file_name` varchar(50) DEFAULT '' COMMENT '文件名后半部分',
  `crt_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` int(11) DEFAULT NULL COMMENT '文件状态',
  `file_url` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '文件服务器的url',
  `remark` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of import_user
-- ----------------------------
INSERT INTO `import_user` VALUES ('48', '20191225014155', 'test.xlsx', '2019-12-25 01:42:07', '2', 'http://106.54.95.152/20191225014155test.xlsx', '导入成功');
INSERT INTO `import_user` VALUES ('49', '20191225015127', 'test.xlsx', '2019-12-25 01:51:40', '3', 'http://106.54.95.152/20191225015127test.xlsx', '第1行，第1列，学号已存在');
INSERT INTO `import_user` VALUES ('50', '20191225015732', 'test (1).xlsx', '2019-12-25 01:57:50', '3', 'http://106.54.95.152/20191225015732test (1).xlsx', '第3行，第6列，学院代号不存在');
INSERT INTO `import_user` VALUES ('51', '20191225025428', 'test (1).xlsx', '2019-12-25 02:54:53', '3', 'http://106.54.95.152/20191225025428test (1).xlsx', '第1行，第1列，学号已存在');
INSERT INTO `import_user` VALUES ('53', '20191225041102', 'test.xlsx', '2019-12-25 04:11:26', '2', 'http://106.54.95.152/20191225041102test.xlsx', '导入成功');

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `school_id` int(11) unsigned DEFAULT NULL COMMENT '学校id',
  `academy_id` int(11) unsigned DEFAULT NULL COMMENT '学院id',
  `name` varchar(255) NOT NULL COMMENT '专业名称',
  `major_teacher` varchar(50) DEFAULT NULL COMMENT '专业负责人',
  `crt_time` datetime DEFAULT NULL COMMENT '创建时间',
  `upd_time` datetime DEFAULT NULL COMMENT '更新时间',
  `school_name` varchar(255) DEFAULT NULL,
  `academy_name` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `attr4` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES ('1', '13', '1', '通信工程', '通老师', null, null, '华南理工大学广州学院', '通信工程', null, null);
INSERT INTO `major` VALUES ('2', '13', '2', '自动化', '自老师', null, null, '华南理工大学广州学院', '电子信息工程学院', null, null);
INSERT INTO `major` VALUES ('3', '13', '2', '电子信息工程', '子老师', null, null, '华南理工大学广州学院', '电子信息工程学院', null, null);

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(255) DEFAULT NULL,
  `menu_url` varchar(255) DEFAULT NULL,
  `menu_level` int(11) DEFAULT NULL,
  `menu_icon` varchar(255) DEFAULT NULL,
  `menu_order` int(11) DEFAULT NULL,
  `attr1` varchar(255) DEFAULT '',
  `attr2` varchar(255) DEFAULT '',
  `attr3` varchar(255) DEFAULT '',
  `attr4` varchar(255) DEFAULT '',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------

-- ----------------------------
-- Table structure for school
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '学校名称',
  `owner` varchar(50) DEFAULT '' COMMENT '校长',
  `crt_time` datetime DEFAULT NULL COMMENT '创建时间',
  `upd_time` datetime DEFAULT NULL COMMENT '更新时间',
  `build_time` datetime DEFAULT NULL COMMENT '学校成立时间',
  `school_desc` varchar(255) DEFAULT '' COMMENT '学校描述',
  `website` varchar(255) DEFAULT '' COMMENT '官网',
  `attr4` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school
-- ----------------------------
INSERT INTO `school` VALUES ('13', '华南理工大学广州学院', '华校长', '2019-12-05 11:50:17', '2019-12-05 11:50:17', '2019-12-17 12:00:00', '', 'www.baidu.com', '');
INSERT INTO `school` VALUES ('14', '华南理工大学', '南校长', '2019-12-05 11:50:56', '2019-12-05 11:50:56', '2019-12-18 12:00:00', '', 'www.baidu.com', '');
INSERT INTO `school` VALUES ('15', '广东工业大学', '工校长', null, null, '2019-12-03 12:00:00', '', 'www.baidu.com', '');
INSERT INTO `school` VALUES ('18', '学校1', '校长1', '2019-12-25 02:50:34', null, '2019-12-05 12:00:00', null, 'www.baidu.com', null);

-- ----------------------------
-- Table structure for setting
-- ----------------------------
DROP TABLE IF EXISTS `setting`;
CREATE TABLE `setting` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `word_num` int(11) NOT NULL COMMENT '文章显示字数',
  `word_exceed` varchar(255) NOT NULL COMMENT '超出字数后显示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of setting
-- ----------------------------
INSERT INTO `setting` VALUES ('1', '80', '...');

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `tag_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(50) DEFAULT NULL,
  `tag_description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tag_id`),
  UNIQUE KEY `tag_name` (`tag_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tag
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(255) NOT NULL COMMENT '学号',
  `name` varchar(50) DEFAULT '' COMMENT '书名',
  `passwd` varchar(50) NOT NULL COMMENT '密码',
  `photo` varchar(255) DEFAULT 'http://106.54.95.152/default.jpg' COMMENT '头像',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `school_id` int(11) DEFAULT NULL COMMENT '学校id',
  `academy_id` int(11) DEFAULT NULL COMMENT '学院id',
  `major_id` int(11) DEFAULT NULL COMMENT '专业id',
  `clazz_id` int(11) DEFAULT NULL COMMENT '班级id',
  `school_name` varchar(255) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '学校名称',
  `academy_name` varchar(255) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '学院名称',
  `major_name` varchar(255) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '专业',
  `clazz_name` varchar(255) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '班级',
  `identity` int(11) DEFAULT NULL COMMENT '身份',
  `nick_name` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '昵称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1234567', '陈展翅', '123123', 'http://106.54.95.152/default.jpg', '21', '13', '1', '1', '7', '华南理工大学广州学院', '通信工程', '通信工程', '通信三班', '2', null);
INSERT INTO `user` VALUES ('201610110008', '曾贵花', '123123', 'http://106.54.95.152/1577218041452474.jpg', '21', '13', '1', '1', '4', '华南理工大学广州学院', '通信工程', '通信工程', '通信二班', '1', 'jennifer');
INSERT INTO `user` VALUES ('201610110009', '萧翰之', '123123', 'http://106.54.95.152/1577221557462581.jpg', '23', '13', '1', '1', '4', '华南理工大学广州学院', '通信工程', '通信工程', '通信二班', '1', 'xjiaohanzhi');
INSERT INTO `user` VALUES ('201610110080', '杨尚绵', '123123', 'http://106.54.95.152/1577218911873591.jpg', '22', '13', '1', '1', '4', '华南理工大学广州学院', '通信工程', '通信工程', '通信二班', '1', 'young');
INSERT INTO `user` VALUES ('201610111111', 'test', 'test', 'http://106.54.95.152/1577218214935860.jpg', '21', '13', '1', '1', '4', '华南理工大学广州学院', '通信工程', '通信工程', '通信二班', '1', null);
INSERT INTO `user` VALUES ('201611', 'test', 'test', 'http://106.54.95.152/default.jpg', '21', '13', '1', '1', '7', '华南理工大学广州学院', '通信工程', '通信工程', '通信三班', '1', null);
INSERT INTO `user` VALUES ('201612', 'test2', 'test2', 'http://106.54.95.152/default.jpg', '21', '13', '1', '1', '7', '华南理工大学广州学院', '通信工程', '通信工程', '通信三班', '1', null);
INSERT INTO `user` VALUES ('201613', 'test2', 'test2', 'http://106.54.95.152/default.jpg', '21', '13', '1', '1', '7', '华南理工大学广州学院', '通信工程', '通信工程', '通信三班', '1', null);
INSERT INTO `user` VALUES ('201614', 'test2', 'test2', 'http://106.54.95.152/default.jpg', '21', '13', '1', '1', '7', '华南理工大学广州学院', '通信工程', '通信工程', '通信三班', '1', null);
INSERT INTO `user` VALUES ('201615', 'test2', 'test2', 'http://106.54.95.152/default.jpg', '21', '13', '1', '1', '7', '华南理工大学广州学院', '通信工程', '通信工程', '通信三班', '1', null);
INSERT INTO `user` VALUES ('201616', 'test2', 'test2', 'http://106.54.95.152/default.jpg', '21', '13', '1', '1', '7', '华南理工大学广州学院', '通信工程', '通信工程', '通信三班', '1', null);

-- ----------------------------
-- Table structure for user_collection
-- ----------------------------
DROP TABLE IF EXISTS `user_collection`;
CREATE TABLE `user_collection` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `uid` varchar(255) NOT NULL COMMENT '用户id',
  `aid` int(11) NOT NULL COMMENT '文章id',
  `crt_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_collection
-- ----------------------------

-- ----------------------------
-- Table structure for user_focus
-- ----------------------------
DROP TABLE IF EXISTS `user_focus`;
CREATE TABLE `user_focus` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `uid` varchar(255) NOT NULL COMMENT '用户id',
  `fid` varchar(255) NOT NULL COMMENT '被关注用户id',
  `crt_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_focus
-- ----------------------------
INSERT INTO `user_focus` VALUES ('32', '201610110080', '201610110008', '2019-12-25 04:20:45');
INSERT INTO `user_focus` VALUES ('33', '201610110009', '201610110008', '2019-12-25 05:07:17');
INSERT INTO `user_focus` VALUES ('34', '201610110009', '201610110080', '2019-12-25 05:11:45');

-- ----------------------------
-- Table structure for user_like_ref
-- ----------------------------
DROP TABLE IF EXISTS `user_like_ref`;
CREATE TABLE `user_like_ref` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `uid` varchar(255) NOT NULL COMMENT '用户id',
  `aid` int(11) NOT NULL COMMENT '文章id',
  `crt_time` datetime DEFAULT NULL COMMENT '点赞时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_like_ref
-- ----------------------------
INSERT INTO `user_like_ref` VALUES ('37', '201610110008', '40', '2019-12-25 03:59:57');
INSERT INTO `user_like_ref` VALUES ('38', '201610110080', '41', '2019-12-25 04:20:32');
INSERT INTO `user_like_ref` VALUES ('39', '201610110009', '42', '2019-12-25 05:12:25');
