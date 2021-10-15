-- public.acc_bal definition

-- Drop table

-- DROP TABLE public.acc_bal;

CREATE TABLE public.acc_bal (
	acc_no int4 NOT NULL,
	bal numeric(10, 2) NULL,
	CONSTRAINT acc_bal_bal_check CHECK ((bal >= 0.00)),
	CONSTRAINT acc_bal_pkey PRIMARY KEY (acc_no)
);

UPDATE login SET a_type = 'Active' WHERE user_name = 'umer';

-- public.account definition

-- Drop table

-- DROP TABLE public.account;

CREATE TABLE public.account (
	aid serial4 NOT NULL,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	email varchar(40) NOT NULL,
	zipcode int4 NOT NULL,
	acc_no int4 NULL,
	CONSTRAINT account_pkey PRIMARY KEY (aid),
	CONSTRAINT account_acc_no_fkey FOREIGN KEY (acc_no) REFERENCES public.acc_bal(acc_no)
);


-- public.login definition

-- Drop table

-- DROP TABLE public.login;

CREATE TABLE public.login (
	uid serial4 NOT NULL,
	user_name varchar(50) NOT NULL,
	pwd varchar(256) NOT NULL,
	status varchar(15) NOT NULL,
	a_type varchar(15) NOT NULL,
	aid int4 NOT NULL,
	CONSTRAINT login_pkey PRIMARY KEY (uid),
	CONSTRAINT login_user_name_key UNIQUE (user_name),
	CONSTRAINT login_aid_fkey FOREIGN KEY (aid) REFERENCES public.account(aid)
);


-- public.transction_tb definition

-- Drop table

-- DROP TABLE public.transction_tb;

CREATE TABLE public.transction_tb (
	tid serial4 NOT NULL,
	t_time timestamptz NOT NULL DEFAULT now(),
	t_type varchar(30) NOT NULL,
	uid int4 NOT NULL,
	amount numeric(10, 2) NULL,
	to_accountno int4 NULL,
	acc_no int4 NULL,
	CONSTRAINT transction_tb_amount_check CHECK ((amount >= 0.00)),
	CONSTRAINT transction_tb_pkey PRIMARY KEY (tid),
	CONSTRAINT transction_tb_uid_fkey FOREIGN KEY (uid) REFERENCES public.login(uid)
);


-- public.log_tb definition

-- Drop table

-- DROP TABLE public.log_tb;

CREATE TABLE public.log_tb (
	lid serial4 NOT NULL,
	uid int4 NOT NULL,
	login_time timestamptz NOT NULL DEFAULT now(),
	CONSTRAINT log_tb_pkey PRIMARY KEY (lid),
	CONSTRAINT log_tb_uid_fkey FOREIGN KEY (uid) REFERENCES public.login(uid)
);


CREATE OR REPLACE FUNCTION log_user(users int) RETURNS void AS $$
    BEGIN
      INSERT INTO log_tb (uid,login_time) VALUES (users,now());
    END;
$$ LANGUAGE plpgsql;

SELECT * FROM log_user(6);

