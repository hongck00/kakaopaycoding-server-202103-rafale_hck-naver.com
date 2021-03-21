# 202103-rafale_hck-naver.com

# 부동산/신용 투자 서비스

## 요구사항
#### 1. 전체 투자 상품 조회 기능
1. 상품 모집기간 내의 상품만 조회 되어야 한다.
2. 상품 목록 조회시 아래의 내용이 포함되어야 한다.
   - 상품ID, 상품 제목, 총 모집금액, 현재 모집금액, 투자자 수, 투자모집 상태(모집중, 모집완료), 상품 모집기간
#### 2. 투자하기 기능
1. 사용자 식별, 상품ID, 투자 금액을 입력값으로 받는다.
2. 총 투자 금액이 넘어가면 'sold-out' 상태로 응답 한다.
#### 3. 나의 투자상품 조회 기능
1. 내가 투자한 모든 상품을 조회한다.
2. 나의 투자 상품 조회시 아래의 내용이 포함되어야 한다.
   - 상품ID, 상품 제목, 총 모집금액, 나의 투자금, 투자일시

## 테이블 정의서
### 테이블 이름 : INVEST.PRODUCT_INFO
#### 테이블 설명 : 투자 상품 정보  
|PK|AI|FK|Null|Name|Type|comment|
|:---:|:---:|:---:|:---:|:---|:---:|:---|
|O|O| | |product_id|bigint|상품ID|
| | | | |title|varchar(255)|상품제목|
| | | | |total_investing_amount|bigint|총모집금액|
| | | |O|investing_count|int|
| | | |O|status|int|투자 모집 상태(0:모집완료, 1:모집중, ...)|
| | | |O|started_at|timestamp|투자시작일시|
| | | |O|finished_at|timestamp|투자종료일시|

### 테이블 이름 : INVEST.USER_INFO
#### 테이블 설명 : 사용자 정보
|PK|AI|FK|Null|Name|Type|comment|
|:---:|:---:|:---:|:---:|:---|:---:|:---|
|O|O| | |user_seq|bigint|사용자 번호|
| | | | |user_id|varchar(50)|사용자ID|
| | | | |name|varchar(50)|사용자 이름|

### 테이블 이름 : INVEST.USER_INVEST_INFO
#### 테이블 설명 : 사용자 투자 정보
|PK|AI|FK|Null|Name|Type|comment|
|:---:|:---:|:---:|:---:|:---|:---:|:---|
|O| | | |user_seq  |bigint|사용자 번호|
|O| | | |product_id|bigint|상품ID|
| | | | |invest_amount|bigint|투자금액|
| | | | |reg_dttm|timestamp|최초투자일시|
| | | | |alt_dttm|timestamp|마지막투자일시|

