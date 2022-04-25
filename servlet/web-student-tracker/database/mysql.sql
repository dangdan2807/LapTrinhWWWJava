CREATE DATABASE web_student_tracker;

USE web_student_tracker;

CREATE TABLE Department (
    id INT AUTO_INCREMENT PRIMARY KEY,
    departmentName NVARCHAR(50) NOT NULL
);

CREATE TABLE Class (
    id INT AUTO_INCREMENT PRIMARY KEY,
    className NVARCHAR(50) NOT NULL,
    departmentId INT NOT NULL,
    FOREIGN KEY (departmentId)
        REFERENCES Department (id)
);

CREATE TABLE Student (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstName NVARCHAR(50) NOT NULL,
    lastName NVARCHAR(50) NOT NULL,
    -- 0 là nam, 1 là nữ
    gender bool NOT NULL default(0),
    email NVARCHAR(100) NOT NULL,
    imageUrl NVARCHAR(512) NULL default(N''),
    classId INT NOT NULL,
    foreign key(classId) references Class(id)
);

INSERT INTO Department (departmentName) 
values
(N'Công nghệ thông tin'),
(N'Cơ bản'),
(N'Cơ khí'),
(N'Kế toán')
;

INSERT INTO class (className, departmentId) 
values
(N'DHCNTT15K', 1),
(N'DHCB15A', 2),
(N'DHCK15B', 3),
(N'DKCNTT15H', 1),
(N'DHKT15A', 4)
;

INSERT INTO student (firstName, lastName, gender, email, imageUrl, classId) 
VALUES 
(N'Nguyễn', N'Văn Sang', 0, N'nguyenvansang@code.com', 
N'https://1.bp.blogspot.com/-fJOYWF8sRcc/XqPMUl5F0uI/AAAAAAAAipA/FOrgLq4mcqQ23Lp_hA4_QPcjGym-ez4agCLcBGAsYHQ/s1600/Hinh-anh-dep-nhat-the-gioi%2B%25281%2529.jpg',
1),
(N'Trần', N'Thị Thanh', 1, N'tranthithanh@code.com', 
N'https://1.bp.blogspot.com/-NGfw-7PTOJg/XqPM2Jsf6LI/AAAAAAAAip8/kZElxP2v0u01zQEp9zrHN_ZQIQydoV2fwCLcBGAsYHQ/s1600/Hinh-anh-dep-nhat-the-gioi%2B%25282%2529.jpg',
2),
(N'Võ', N'Minh Quân', 0, N'vominhquan@code.com', 
N'https://1.bp.blogspot.com/-M41rrKqzCFM/XqPNfdWImgI/AAAAAAAAir4/LC0XVQVwnJsvoVXPtdBrIjCrF3_GWtiegCLcBGAsYHQ/s1600/Hinh-anh-dep-nhat-the-gioi%2B%25284%2529.jpg',
3),
(N'Phạm', N'Quốc Lâm', 1, N'phamquoclam@code.com', 
N'https://1.bp.blogspot.com/-Op8PZYErZYk/XqPNBiqclXI/AAAAAAAAiq4/FeP8-r9Kvww5Q6r1ouFmtdLGJGGfWEN3wCLcBGAsYHQ/s1600/Hinh-anh-dep-nhat-the-gioi%2B%25283%2529.jpg'
,4),
(N'Phan', N'Thị Tố Hồng', 1, N'phanthitohong@code.com', 
N'https://baoquocte.vn/stores/news_dataimages/dieulinh/012020/29/15/nhung-buc-anh-dep-tuyet-voi-ve-tinh-ban.jpg',
5),
(N'Nguyễn', N'Thanh Khang', 0, N'nguyenthanhkhang@code.com',
N'https://images.pexels.com/photos/674010/pexels-photo-674010.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940',
2),
(N'Nguyễn', N'Thị Thúy', 1, N'nguyenthithuy@code.com',
N'https://images.pexels.com/photos/326055/pexels-photo-326055.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940',
1),
(N'Nguyễn', N'Duy Tân', 0, N'nguyenduytan@code.com',
N'https://images.pexels.com/photos/1133957/pexels-photo-1133957.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940',
3),
(N'Võ', N'Hoàng', 0, N'vohoang@code.com',
N'https://images.pexels.com/photos/6371048/pexels-photo-6371048.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940',
3)
;
