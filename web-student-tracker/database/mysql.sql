CREATE DATABASE web_student_tracker;
USE web_student_tracker;

CREATE TABLE student (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstName NVARCHAR(50) NULL,
    lastName NVARCHAR(50) NULL,
    email NVARCHAR(100) NULL,
    imageUrl VARCHAR(512) NULL
);

INSERT INTO student (firstName, lastName, email, imageUrl) 
VALUES 
(N'nguyen', N'van a', N'nguyenvana@code.com', 'https://1.bp.blogspot.com/-fJOYWF8sRcc/XqPMUl5F0uI/AAAAAAAAipA/FOrgLq4mcqQ23Lp_hA4_QPcjGym-ez4agCLcBGAsYHQ/s1600/Hinh-anh-dep-nhat-the-gioi%2B%25281%2529.jpg'),
(N'tran', N'thi b', N'tranthib@code.com', 'https://1.bp.blogspot.com/-NGfw-7PTOJg/XqPM2Jsf6LI/AAAAAAAAip8/kZElxP2v0u01zQEp9zrHN_ZQIQydoV2fwCLcBGAsYHQ/s1600/Hinh-anh-dep-nhat-the-gioi%2B%25282%2529.jpg'),
(N'vo', N'minh c', N'vominhc@code.com', 'https://1.bp.blogspot.com/-M41rrKqzCFM/XqPNfdWImgI/AAAAAAAAir4/LC0XVQVwnJsvoVXPtdBrIjCrF3_GWtiegCLcBGAsYHQ/s1600/Hinh-anh-dep-nhat-the-gioi%2B%25284%2529.jpg'),
(N'pham', N'thanh d', N'phamthanhd@code.com', 'https://1.bp.blogspot.com/-Op8PZYErZYk/XqPNBiqclXI/AAAAAAAAiq4/FeP8-r9Kvww5Q6r1ouFmtdLGJGGfWEN3wCLcBGAsYHQ/s1600/Hinh-anh-dep-nhat-the-gioi%2B%25283%2529.jpg'),
(N'phan', N'to e', N'phantoe@code.com', 'https://baoquocte.vn/stores/news_dataimages/dieulinh/012020/29/15/nhung-buc-anh-dep-tuyet-voi-ve-tinh-ban.jpg');
