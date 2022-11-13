# JPA
### 연관관계 매핑

User : 사용자테이블
Answer : 답변테이블
Question : 질문테이블
DELETE_HISTORY : 삭제이력

1. DDL 을 보고 엔티티 작성
```H2
create table answer
(
    id          bigint generated by default as identity,
    contents    clob,
    created_at  timestamp not null,
    deleted     boolean   not null,
    question_id bigint,
    updated_at  timestamp,
    writer_id   bigint,
    primary key (id)
);

create table delete_history
(
    id            bigint generated by default as identity,
    content_id    bigint,
    content_type  varchar(255),
    create_date   timestamp,
    deleted_by_id bigint,
    primary key (id)
);

create table question
(
    id         bigint generated by default as identity,
    contents   clob,
    created_at timestamp    not null,
    deleted    boolean      not null,
    title      varchar(100) not null,
    updated_at timestamp,
    writer_id  bigint,
    primary key (id)
);

create table user
(
    id         bigint generated by default as identity,
    created_at timestamp   not null,
    email      varchar(50),
    name       varchar(20) not null,
    password   varchar(20) not null,
    updated_at timestamp,
    user_id    varchar(20) not null,
    primary key (id)
);

alter table user
    add constraint UK_a3imlf41l37utmxiquukk8ajc unique (user_id)
```

2. DDL 을 보고 연관관계 매핑
```H2
alter table answer
add constraint fk_answer_to_question
foreign key (question_id)
references question;

alter table answer
add constraint fk_answer_writer
foreign key (writer_id)
references user;

alter table delete_history
add constraint fk_delete_history_to_user
foreign key (deleted_by_id)
references user;

alter table question
add constraint fk_question_writer
foreign key (writer_id)
references user;
```

