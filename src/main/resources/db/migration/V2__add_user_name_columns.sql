-- V2__add_user_name_columns.sql
ALTER TABLE users
ADD COLUMN first_name VARCHAR(255) NOT NULL,
ADD COLUMN middle_name VARCHAR(255),
ADD COLUMN last_name VARCHAR(255);