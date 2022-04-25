-- mssql
use master;
-- mysql
use root;

CREATE DATABASE employee_directory
-- nếu dùng mysql thì dùng thêm dòng dưới để set tiếng việt
    character set UTF8 collate utf8_vietnamese_ci;
;

use employee_directory;

CREATE TABLE employee(
    -- id int primary key IDENTITY(1,1) -- mssql
    id int primary key auto_increment -- mysql
    ,
    first_name nvarchar(50),
    last_name nvarchar(50),
    email nvarchar(50)
);

insert into employee(first_name, last_name, email) 
values
    (N'John', N'Doe', N'john@gmail.com'),
    (N'David', N'Gueta', N'gueta@gmail.com'),
    (N'Mary', N'Public', N'mary@gmail.com')
;