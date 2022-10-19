use ssafydb;

drop table product;

create table product
(
	idx int not null auto_increment,
    product_id varchar(7) not null,
    product_name varchar(20) not null,
    product_price int default 0,
    product_desc varchar(2000),
    register_date timestamp	not null default current_timestamp,
	primary key (idx)
);

insert into product (product_id, product_name, product_price, product_desc, register_date)
values ('GS00001', '갤럭시S21', 1150000, '갤럭시S21입니다.', date_add(now(), interval -1 year));

insert into product (product_id, product_name, product_price, product_desc, register_date)
values ('GN00001', '갤럭시노트20', 1570000, '갤럭시노트20입니다.', date_add(now(), interval -5 month));

insert into product (product_id, product_name, product_price, product_desc, register_date)
values ('GZFl003', '갤럭시z플립3', 1320000, '갤럭시z플립3입니다.', date_add(now(), interval -3 day));

insert into product (product_id, product_name, product_price, product_desc, register_date)
values ('GZFo003', '갤럭시폴드3', 1850000, '갤럭시폴드3입니다.', date_add(now(), interval -(5 * 60 + 10) minute));

commit;







select * from product;

insert into product (product_id, product_name, product_price, product_desc) 
values ('smk01', '서민규폰', 9999999, '짱좋은 서민규 폰 입니다');

update product 
set product_price = 98765 
where product_id = 'GZFo003';

delete from product 
where product_id = 'GZFl003';

select product_id, product_name, product_price, product_desc, date_format(register_date, '%y.%m.%d') register_date 
from product 
where product_id = 'GN00001';

select product_id, product_name, product_price, product_desc, date_format(register_date, '%y.%m.%d') register_date 
from product 
where product_price >= 9000;

select product_id, product_name, product_price, product_desc, date_format(register_date, '%y.%m.%d') register_date
from product;
