CREATE DATABASE PRO1041_FALL22_IT17324_QLTV;
GO
USE PRO1041_FALL22_IT17324_QLTV;
GO
-- đăng nhập
CREATE TABLE DangNhap
(
  TenTk VARCHAR(50) PRIMARY KEY,
  MatKhau VARCHAR(50) NOT NULL,
  otp varchar(12) not null,
)
GO
-- tác giả
CREATE TABLE TacGia
(
  IDTacGia UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
  MaTacGia varchar(10) not null,
  TenTacGia NVARCHAR(50) not null,
  DiaChi NVARCHAR(50) NOT NULL,
  img varchar(100),
)
GO
-- nhà xuất bản 
CREATE TABLE NhaXuatBan
(
  IDNhaXuatBan UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
  TENNXB NVARCHAR(50) not null,
  DiaChi NVARCHAR(50) NOT NULL,
)
GO


-- loại sách
CREATE TABLE TheLoaiSach
(
  IDTL UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
  TenTL NVARCHAR(50) not null,
)
GO

-- nhà cung cấp
CREATE TABLE NhaCC(
  IdNhaCC UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
  TenNhaCC NVARCHAR(50) not NULL,
  DiaChi NVARCHAR(50),
  SDT VARCHAR(10),
  Email VARCHAR(50),
)

GO
-- sách.
CREATE TABLE Sach
(
  IDSach UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
  MaSach VARCHAR(10) unique not null,
  TenSach NVARCHAR(50) not null,
)
GO

--Thể loại chi tiết
CREATE TABLE TLSACHCT
(
	IdTLSach UNIQUEIDENTIFIER,
	IDSach UNIQUEIDENTIFIER,
	CONSTRAINT FK_LoaiSach FOREIGN KEY(IdTLSach) REFERENCES TheLoaiSach(IDTL),
	CONSTRAINT FK_sach FOREIGN KEY(IDSach) REFERENCES Sach(IDSach),
	CONSTRAINT PK_TLSACHCT PRIMARY KEY(IdTLSach, IDSACH)
)
GO

--Tác giả chi tiết
CREATE TABLE TacGiaCT
(
	IDTacGia UNIQUEIDENTIFIER,
	IDSach UNIQUEIDENTIFIER,
	CONSTRAINT FK_TacGia FOREIGN KEY(IDTacGia) REFERENCES TacGia(IDTacGia),
	CONSTRAINT FK1_sach FOREIGN KEY(IDSach) REFERENCES Sach(IDSach),
	CONSTRAINT PK_TacGiaCT PRIMARY KEY(IDTacGia, IDSach)
)
GO

-- sách chi tiết
CREATE TABLE SachCT(
  IDSachCT UNIQUEIDENTIFIER PRIMARY KEY Default newID(),
  NamXuatBan int DEFAULT NULL,
  img varchar(100) ,
  GiaInTrenSach DECIMAL(20,10) NULL ,
  Seri varchar(50),
  IdSach UNIQUEIDENTIFIER,
  CONSTRAINT FK4_Sach FOREIGN KEY(IdSach) REFERENCES Sach(IDSach),
)
GO

--Nhà xuất bản chi tiết
CREATE TABLE NXBCT
(
	IDNhaXuatBan UNIQUEIDENTIFIER,
	IDSACHCT UNIQUEIDENTIFIER,
	CONSTRAINT FK2_NhaXuatBan FOREIGN KEY(IDNhaXuatBan) REFERENCES NhaXuatBan(IDNhaXuatBan),
	CONSTRAINT FK_SACHCT FOREIGN KEY(IDSACHCT) REFERENCES SachCT(IDSACHCT)
)
GO

--Cuốn sách 
CREATE TABLE CuonSach(
  idCuonSach UNIQUEIDENTIFIER default newid() primary key,
  MACUONSACH INT IDENTITY(1,1),
  IDSachCT UNIQUEIDENTIFIER,
  TinhTrang float,
  TrangThai bit ,
  CONSTRAINT FK1_SachCT FOREIGN KEY(IDSachCT) REFERENCES SachCT(IDSachCT),
) 
GO

-- Phiếu Nhập
CREATE TABLE PhieuNhap(
  IdPhieuNhap UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
  IDSachCT UNIQUEIDENTIFIER,
  MaPhieuNhap VARCHAR(10) unique,
  NgayNhap DATE ,
  TinhTrang bit,
  SoLuongNhap INT ,
  GiaNhap DECIMAL(20,10) ,
  CONSTRAINT FK2_SachCT FOREIGN KEY(IDSachCT) REFERENCES SachCT(IDSachCT)
) 
GO

--Nhà cung cấp chi tiết
CREATE TABLE NHACCCT(
	IdPhieuNhap UNIQUEIDENTIFIER,
	IdNhacc UNIQUEIDENTIFIER,
	Constraint FK_Nhacc FOREIGN KEY(IdNhacc) REFERENCES NhaCC(IdNhacc),
	Constraint FK_PhieuNhap FOREIGN KEY(IdPhieuNhap) REFERENCES PhieuNhap(IdPhieuNhap),
	Constraint PK_NHACCCT primary key(IdPhieuNhap, IdNhacc)
)
GO

--Độc giả
CREATE TABLE DocGia(
  IDDocGia UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(), 
  MaDocGia VARCHAR(10) not null,
  TenDOcGia NVARCHAR(50) not null,
  sdt varchar(10) null,
  Email varchar(100),
  SoCMND VARCHAR(12),
  NgaySinh Date,
  DiaCHi NVARCHAR(100),
  GioiTinh bit,
  img varchar(100),
  trangThai bit
)
GO

-- Phiếu mượn
CREATE TABLE PhieuMuon(
  IDPhieuMuon UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
  MaPhieuMuon varchar(10) unique,
  NgayMuon DATE Not NULL,
  NgayTra DATE Not NULL,
  TinhTrang int,
  IDDocGia UNIQUEIDENTIFIER not null,
  CONSTRAINT FK1_DocGia FOREIGN KEY(IDDocGia) REFERENCES DocGia(IDDocGia),
)
 GO

-- Phiếu mượn chi tiết
CREATE TABLE PhieuMuonCT(
  idPhieuMuonCT UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
  idCuonSach UNIQUEIDENTIFIER,
  MaPhieuMuon VARCHAR(10),
  CONSTRAINT FK1_PhieuMuon FOREIGN KEY(MaPhieuMuon) REFERENCES PhieuMuon(MaPhieuMuon),
  CONSTRAINT FK_CuonSach FOREIGN KEY(idCuonSach) REFERENCES CuonSach(idCuonSach)
)
GO

-- Vi Phạm 
CREATE TABLE ViPham(
  IdViPham UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
  NgayVP DATE not null,
  HinhPhat NVARCHAR(100) ,
  MoTa NVARCHAR(100),
  MaPM VARCHAR(10),
  CONSTRAINT FK_PhieuMuon FOREIGN KEY(MaPM) REFERENCES PhieuMuon(MaPhieuMuon),
)
GO

-- Lỗi vi phạm
CREATE TABLE LoiViPham(
	IDLoiViPham UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(), 
	TenLoi nvarchar(100) not null,
)
GO

--Lỗi vi phạm chi tiết
CREATE TABLE LOIVIPHAMCT(
	IDVIPHAM UNIQUEIDENTIFIER,
	IDLOIVIPHAM UNIQUEIDENTIFIER,
	CONSTRAINT FK_ViPham FOREIGN KEY(IdViPham) REFERENCES ViPham(IdViPham),
	CONSTRAINT FK_LoiViPham FOREIGN KEY(IDLOIVIPHAM) REFERENCES LoiViPham(IDLOIVIPHAM),
)
GO
--proc thêm cuốn sách
create proc addCuonSach
	@soluong int, @idSach UNIQUEIDENTIFIER, @SoBatDau int
	as
	begin
		declare @i int, @tongsach int;
			set @i = @SoBatDau;
			set @tongsach = @i+@soluong;
		while @i< @tongsach
			begin
				set @i = @i +1;
				set IDENTITY_INSERT dbo.cuonsach on
				insert CuonSach(MaCuonSach, IDSachCT, TinhTrang, TrangThai) values(@i, @idSach, 100, 1)
			end
	end
