create database QLBatDongSan
Use QLBatDongSan

create table NhanVien(
	MaNV varchar(10) primary key,
	HotenNV nvarchar(30) not null,
	MatKhau nvarchar(50) not null,
	ChucVu bit not null,
)
create table KhachHang(
	MaKH varchar(10) primary key,
	HotenKH nvarchar(30) not null,
	DiaChi nvarchar(100) not null,
	NgaySinh date not null,
	GioiTinh bit,
)
create table BatDongSan(
	MaBDS varchar(10) primary key,
	DienTich decimal not null,
	DiaChi nvarchar(100) not null,
	Gia float not null,
	Hinh varchar(50),
)
create table HopDong(
	MaHD varchar(10) primary key,
	MaNV varchar(10) foreign key (MaNV) references NhanVien(MaNV),
	MaKH varchar(10) foreign key (MaKH) references KhachHang(MaKH),
	MaBDS varchar(10) foreign key (MaBDS) references BatDongSan(MaBDS),
	NgayLap date not null,
	SoTien float not null,	
)
INSERT INTO KhachHang(MaKH, HotenKH, DiaChi, NgaySinh, GioiTinh) VALUES('KH1', 'Huy', 'Quang Binh', '05/05/1999', '1')
INSERT INTO KhachHang(MaKH, HotenKH, DiaChi, NgaySinh, GioiTinh) VALUES('KH2', 'Phong', 'Quang Nam', '07/07/1999', '1')
INSERT INTO NhanVien (MaNV, HotenNV, MatKhau, ChucVu) VALUES ('NV1', 'Phong', '123456', '1')
INSERT INTO NhanVien (MaNV, HotenNV, MatKhau, ChucVu) VALUES ('NV2', 'Huy', '123456', '1')