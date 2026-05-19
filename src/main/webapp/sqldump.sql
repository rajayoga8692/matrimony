CREATE TABLE `ighostel`.`district` (
  `districtid` INT NOT NULL,
  `districtname` VARCHAR(45) NULL,
  `status` VARCHAR(5) NULL,
  PRIMARY KEY (`districtid`));
  
  CREATE TABLE `ighostel`.`caste` (
  `casteid` INT NOT NULL,
  `castename` VARCHAR(45) NULL,
  `status` VARCHAR(45) NULL,
  PRIMARY KEY (`casteid`));
  
  INSERT INTO `ighostel`.`caste` (`casteid`, `castename`, `status`) VALUES ('1', 'Reddiyar', 'A');

  CREATE TABLE `ighostel`.`subcaste` (
  `subcasteid` INT NOT NULL AUTO_INCREMENT,
  `subcastename` VARCHAR(45) NULL,
  `casteid` INT NULL,
  `status` VARCHAR(5) NULL,
  PRIMARY KEY (`subcasteid`));
  
  CREATE TABLE `ighostel`.`membership_plan` (
  `planid` INT NOT NULL AUTO_INCREMENT,
  `planname` VARCHAR(45) NULL,
  `contacts` VARCHAR(45) NULL,
  `amount` INT NULL,
  `status` VARCHAR(5) NULL,
  PRIMARY KEY (`planid`));
  
  CREATE TABLE `ighostel`.`gallery` (
  `galleryid` INT NOT NULL AUTO_INCREMENT,
  `imagename` VARCHAR(1000) NULL,
  `imagepath` VARCHAR(1000) NULL,
  `status` VARCHAR(5) NULL,
  PRIMARY KEY (`galleryid`));


CREATE TABLE `ighostel`.`contactaddress` (
  `contactaddressid` INT NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(500) NULL,
  `city` VARCHAR(45) NULL,
  `phoneno` VARCHAR(45) NULL,
  `pincode` VARCHAR(45) NULL,
  `emailid` VARCHAR(45) NULL,
  `status` VARCHAR(5) NULL,
  PRIMARY KEY (`contactaddressid`));
