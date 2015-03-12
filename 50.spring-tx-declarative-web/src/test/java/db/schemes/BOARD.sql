-- -----------------------------------------------------
-- Table 'user'
-- -----------------------------------------------------
DROP TABLE IF EXISTS users;

CREATE  TABLE users (
  seq serial NOT NULL ,
  id VARCHAR(45) NULL,
  pwd VARCHAR(100) NULL,
  name VARCHAR(100) NULL,
  email VARCHAR(100) NULL,
  point INT NULL,
  PRIMARY KEY (seq)
);

-- -----------------------------------------------------
-- Table 'user_point_history'
-- -----------------------------------------------------
DROP TABLE IF EXISTS user_point_history ;

CREATE  TABLE IF NOT EXISTS user_point_history (
  seq serial NOT NULL ,
  user_seq INT NOT NULL ,
  reg_dt timestamp NULL ,
  initial_point INT NULL ,
  amount INT NULL ,
  result_point INT NULL ,
  canceled_yn CHAR(1) NULL DEFAULT 'N' ,
  PRIMARY KEY (seq, user_seq) );

-- -----------------------------------------------------
-- Table 'board'
-- -----------------------------------------------------
DROP TABLE IF EXISTS board ;

CREATE  TABLE IF NOT EXISTS board (
  seq serial NOT NULL ,
  board_type VARCHAR(45) NULL ,
  board_name VARCHAR(45) NULL ,
  PRIMARY KEY (seq) );

-- -----------------------------------------------------
-- Table 'article'
-- -----------------------------------------------------
DROP TABLE IF EXISTS article ;

CREATE  TABLE IF NOT EXISTS article (
  seq serial NOT NULL ,
  board_seq INT NOT NULL ,
  user_seq INT NOT NULL ,
  title VARCHAR(45) NULL ,
  content VARCHAR(45) NULL ,
  reg_dt timestamp NULL ,
  PRIMARY KEY (seq) );

-- -----------------------------------------------------
-- Table 'board_comment'
-- -----------------------------------------------------
DROP TABLE IF EXISTS board_comment ;

CREATE  TABLE IF NOT EXISTS board_comment (
  seq serial NOT NULL ,
  article_seq INT NOT NULL ,
  depth VARCHAR(45) NULL ,
  parent_comment_seq INT NULL ,
  comment VARCHAR(45) NULL ,
  user_seq INT NOT NULL ,
  reg_dt timestamp NOT NULL,
  PRIMARY KEY (seq) );
  
-- -----------------------------------------------------
-- Table 'user_action_history'
-- -----------------------------------------------------
DROP TABLE IF EXISTS user_action_history ;

CREATE  TABLE IF NOT EXISTS user_action_history (
  seq serial NOT NULL ,
  user_seq INT NOT NULL ,
  action_type VARCHAR(45) NULL ,
  action_desc VARCHAR(256) NULL ,
  action_dt timestamp NULL ,
  PRIMARY KEY (seq) );


  
DROP TABLE IF EXISTS point_bank;

CREATE TABLE IF NOT EXISTS point_bank (
	seq serial NOT NULL,
	amount INT NOT NULL,
	PRIMARY KEY (seq)
);