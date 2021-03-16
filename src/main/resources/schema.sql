-- schema 생성
CREATE SCHEMA INVEST;

-- table 생성
CREATE TABLE INVEST.PRODUCT_INFO (
    product_id BIGINT NOT NULL PRIMARY KEY auto_increment, -- 상품 ID
    title VARCHAR(255) NOT NULL, -- 상품 제목
    total_investing_amount BIGINT NOT NULL, -- 총 모집금액
    status INT, -- 투자모집 상태(모집중, 모집완료)
    started_at TIMESTAMP NOT NULL, -- 투자시작 일시
    finished_at TIMESTAMP NOT NULL -- 투자 종료 일시
);

CREATE TABLE INVEST.USER_INFO (
    user_seq BIGINT NOT NULL PRIMARY KEY auto_increment, -- 사용자 순번
    user_id varchar(50) NOT NULL, -- 사용자 아이디
    name varchar(50) NOT NULL -- 사용자 이름
);

CREATE TABLE INVEST.USER_INVEST_INFO (
    user_seq BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    invest_amount BIGINT NOT NULL,
    reg_dttm TIMESTAMP,
    alt_dttm TIMESTAMP
);


