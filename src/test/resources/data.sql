insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (1, 'martin', 'martin@fastcampus.com', now(), now());

insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (2, 'dennis', 'dennis@fastcampus.com', now(), now());

insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (3, 'sophia', 'sophia@slowcampus.com', now(), now());

insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (4, 'james', 'james@slowcampus.com', now(), now());

-- call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (5, 'martin', 'martin@another.com', now(), now());

insert into publisher(`id`, `name`) values(1, '�н�Ʈķ�۽�');

insert into book(`id`, `name`, `publisher_id`, `deleted`, `status`) values(1, 'JPA �ʰ��� ��Ű��', 1, false, 100);

insert into book(`id`, `name`, `publisher_id`, `deleted`, `status`) values(2, 'Spring', 1, false, 200);

insert into book(`id`, `name`, `publisher_id`, `deleted`, `status`) values(3, 'Spring Security', 1, true, 100);


insert into review(`id`, `title`, `content`, `score`, `user_id`, `book_id`) values(1, '�� �λ��� �ٲ� å', '���Ҿ��', 5.0, 1, 1);

insert into review(`id`, `title`, `content`, `score`, `user_id`, `book_id`) values(2, '�ʹ� ������ �����', '���� ���ο����', 3.0, 2, 2);

insert into comment(`id`, `comment`, `review_id`) values(1, '���Ҿ��', 1);

insert into comment(`id`, `comment`, `review_id`) values(2, '���� �����ϴ�.', 1);

insert into comment(`id`, `comment`, `review_id`) values(3, '�׳� �׷����ϴ�.', 2);
