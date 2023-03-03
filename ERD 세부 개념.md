# ERD 세부 개념

# ERD(Entity Relationship Diagram: 개체관계도) 작성 이유

- ERD에 핵심은 테이블의 구조를 시각적으로 한 눈에 볼 수 있게 해주기 때문에 이해하기 쉽게 해준다.
- 관계와 관계간의 정보를 나타냄으로써 어떤 테이블 구조로 만들었는지 알 수 있다.
- 또 create문을 작성해주어 따로 작성하지 않아도 되는 장점이 있다.

---

# ERD 구조

> ERD는 실체(Entity), 속성(Attribute), 관계(Relationship)로 구성되어 있다.
> 

## Entity

> Entity는 실체로써 정의 가능한 사물이나 개념을 말한다.
> 

## Relationship

> Entity와 Entity간의 관계를 나타낸다.
> 

<img src="./image.png", height="100x", width="100px"/https://s3-us-west-2.amazonaws.com/secure.notion-static.com/fcadeb9b-2245-41ff-82f2-4fa2ce6e5a84/Untitled.png>

1. 없어도 되고, 하나있어도 되고, 다중도 되는 표시 (아래부터)
2. 없거나 다중만 되는 표시
3. 없거나 하나있어도 되는 표시
4. 하나이거나 다중
5. 오직 한개
6. 다중
7. 한개

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/06d9f6eb-eed6-4c5d-b6fe-4b5b01cedd87/Untitled.png)

- 예를 들어 설명하자면 배달앱의 경우 여러개의 회원주소를 가지고 한개를 메인으로 지정할 수 있다.
- 그럴때 위같이 없어도 되고, 하나있어도 되고, 다중도 되는 표시를 사용한다.
- 처음 가입할때 주소를 입력 안 할 수도 있는 설계를 반영했기에 저렇게 사용한다.
- 처음 가입할때 주소를 입력하는 구조라면 4번에 해당하는 하나이거나 다중 값으로 해주면 된다.

---

## ****기본키(PK), 외래키(FK)****

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/8b7e764f-a5d4-4cc0-847e-6fa8b4416a14/Untitled.png)

```sql
PK(primary key: 기본키)는 학생과 수업의 테이블에서 각 행의 정보들을 식별할 수 있는 정보
(학생코드, 수업코드)를 표현한다. PK는 테이블 행의 여러 정보들 중 행을 식별할 수 있어야 하기 때문에 
비어있으면 안되고(NOT NULL) 중복되어서도 안된다(Unique). 그리고 식별을 할 때 테이블의 정보를 최대한 
빠르게 검색해야 하므로 간단한 정보일 수록 좋다.
```

```sql
FK(foreign key:외래키)는 참조하는 테이블과 참조되는 테이블의 관계를 나타낸다.
그림에서 학생-수업 테이블은 학생테이블과 수업테이블의 관계를 1:N 관계로 나타내기위한 테이블이므로 
학생테이블과 수업테이블을 참조하여 만들어야 한다. 
 그러기 위해서 학생정보를 식별하는 학생코드(PK), 수업정보를 식별하는 수업코드(PK)로 테이블이 구성되며
이렇게 다른 테이블의 정보를 참조하기위한 학생코드와 수업코드는 학생_수업테이블 내에서 FK(외래키)가 된다.
```

```sql
학생과 수업 테이블의 PK가 학생-수업 테이블에서는 FK가 되며
이는 학생-수업테이블은 학생과 수업테이블을 참조하는 테이블이라는 의미를 표현하며,
동시에 학생과 수업테이블은 학생-수업테이블에 의해 참조되는 테이블로 서로의 관계를 알 수 있게 된다.
```

---

## 식별 관계, 비식별 관계

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/93b84391-bb90-489f-95cf-cd7db2c5610f/Untitled.png)

- 관계를 설정할때 식별관계와 비식별관계가 있다.
- 식별관계는 FK(외래키)를 PK(기본키)처럼 객체를 구분하는 값으로 볼것인가 아닌가에 있다.
- 쉽게 설명하면 휴대폰 인증을 할때 이름,통신사,휴대폰번호로 구분하는 것처럼 동일한 값이 있을 수도 있기에 식별관계로 이걸 복합키로 만들어준다.

```java
기본키, 복합키, 인조키 기본키는 그대로 PK 단일이다.
복합키의 경우 PK와 FK의 혼합이다.
인조키 복합키가 복잡하기 때문에 임의의 PK를 만들어 기본키 역할을 한다.
```

---

# ERD 테이블 항목

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c6ae128a-f571-488a-8455-30d0a3631f5f/Untitled.png)

- `논리 테이블명` : 테이블명에 대한 설명 (한글)
- `물리 테이블명` : 실제 테이블명 (영문)
- `논리 필드명` : 필드명에 대한 설명 (한글)
- `물리 필드명` : 실제 필드명 (영문)
- `도메인` : 필드명에 대한 주제를 적는 곳 (이것도 일종의 코멘트와 같다)
- `타입` : int, varchar, date 필드 타입을 써주는 곳
- `NULL 유무` : NULL / NOT NULL 중에 하나
- `기본값` : default 값을 써주는 곳
- `코멘트` : 말 그대로 부가설명이 필요할 경우 써주는 곳이다

---

## ERD 작성 예시

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/531a226a-f8fd-48db-a827-03115c9889f7/Untitled.png)

> 관계를 지정하게 되면 그림상에서 회원 Entity에 있는 Pk가 관계선으로 연결되어있는 다른 게시글 테이블에 Fk로 삽입 되게 된다. 이렇게 삽입된 외래키는 수정이 가능하다.
>
