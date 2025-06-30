/* Person */
CREATE TABLE corporative.cort_person (
	person_id BIGINT NOT NULL DEFAULT nextval('corporative.cors_person'),
	identity_number VARCHAR(32) NOT NULL,
	first_name VARCHAR(64) NOT NULL,
	second_name VARCHAR(64),
	surname VARCHAR(64) NOT NULL,
	second_surname VARCHAR(64),
	birth_date DATE,
	status VARCHAR(1) NOT NULL DEFAULT 1,
	created_by_user BIGINT NOT NULL,
	created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	last_modified_by_user BIGINT,
	last_modified_date TIMESTAMP,
	created_from_ip VARCHAR(64) NOT NULL DEFAULT '127.0.0.1',
	updated_from_ip VARCHAR(64),
	CONSTRAINT corr_pk_per PRIMARY KEY (person_id)
);

-- user
CREATE TABLE security.sect_user (
	user_id BIGINT DEFAULT nextval('security.secs_user'),
	username VARCHAR(128) NOT NULL,
	status VARCHAR(1) NOT NULL DEFAULT 1,
	created_by_user BIGINT,
	created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	last_modified_by_user BIGINT,
	last_modified_date TIMESTAMP,
	created_from_ip VARCHAR(64) NOT NULL DEFAULT '127.0.0.1',
	updated_from_ip VARCHAR(64),
  constraint sect_pk_use primary key (user_id)
);